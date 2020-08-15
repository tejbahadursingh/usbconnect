@echo off
cls
wmic logicaldisk get description,name
set /p drive="select secure drive name: "
echo %drive%
javac PerformOperation.java
java PerformOperation %drive%: %1
set /p exitkey="press enter key to exit: "
exit