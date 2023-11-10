@echo off
javac Ball.java Controller.java Engine.java Goal.java Level.java View.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Engine...
	java Engine	
)
pause

