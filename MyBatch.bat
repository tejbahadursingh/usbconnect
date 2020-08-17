@echo off
cls
wmic logicaldisk get description,name
set /p drive="select secure drive name: "
echo %drive%
rem javac -cp json-20200518.jar PerformOperation.java
java -cp json-20200518.jar PerformOperation.java %drive%: %1 %2 %3
set /p exitkey="press enter key to exit: "
exit