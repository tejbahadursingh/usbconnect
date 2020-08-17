@echo off & setlocal enabledelayedexpansion

:begin
call :getRemovableDrives drives

if %drives.length% equ 0 (
    echo No removable drives found.
    set /p exitkey="press enter key to exit: "
    exit
)

set choices=
echo Removable drives:
echo;
for /L %%I in (0, 1, %drives.ubound%) do (
    set "choices=!choices!%%I"
    echo(%%I^) !drives[%%I].caption! (!drives[%%I].volumename!^)
)
echo(X^) exit
set "choices=%choices%x"
echo;
choice /C %choices% /N /M "Press a number (or X to quit): "
set /a choice = %ERRORLEVEL% - 1

if not defined drives[%choice%].caption exit /b 0

echo You chose !drives[%choice%].caption! (!drives[%choice%].volumename!^)
javac PerformOperation.java
java PerformOperation !drives[%choice%].caption! %1 %2 %3
goto :begin

goto :EOF

rem // populates arrayname, arrayname.length, and arrayname.ubound
:getRemovableDrives <arrayname>
rem // unset array if exists
for /f "delims==" %%I in ('2^>NUL set %~1') do set "%%~I="
setlocal enabledelayedexpansion

set /a %~1.length = 0, %~1.ubound = -1

rem // note: nested for /f loops convert UCS-2 encoded WMI results to ANSI
for /f "skip=2 delims=" %%# in (
    'wmic logicaldisk where "DriveType <> 3" get caption^,volumename /format:csv'
) do for /f "tokens=2,3 delims=," %%I in ("%%~#") do (
    set "%~1[!%~1.length!].caption=%%~I"
    set "%~1[!%~1.length!].volumename=%%~J"
    set /a %~1.ubound = %~1.length, %~1.length += 1
)

rem // Trick to make private variables public
for /F "delims=" %%I in ('set %~1') do (
    if defined %~1.ubound endlocal
    set "%%~I"
)
exit /b