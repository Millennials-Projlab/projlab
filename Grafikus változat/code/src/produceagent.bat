@echo off
copy nul temp.txt
java Main < produceagent.txt > temp.txt
fc temp.txt produceagent_output.txt
pause
del temp.txt