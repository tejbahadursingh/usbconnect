cls
wmic logicaldisk get description,name
@echo off
set /p drive="select secure drive name: "
echo %drive%
javac PerformOperation.java
java PerformOperation %drive%: 12345
set /p exitkey="press enter key to exit: "
exit