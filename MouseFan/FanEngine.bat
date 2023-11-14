@echo off
javac game/Ball.java game/Controller.java game/Engine.java game/Goal.java game/Level.java game/View.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Engine...
	java game.Engine	
)
pause

