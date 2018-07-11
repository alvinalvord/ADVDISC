@echo off

REM Compile everything and run
javac -Xlint:all -Xdiags:verbose -d bin ^
src/vector/*.java ^
src/*.java

cd bin
java Driver
cd ..
