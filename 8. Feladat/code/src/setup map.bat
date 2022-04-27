@echo off
copy nul temp.txt
java Main < map.txt > temp.txt
fc temp.txt mapbuild_output.txt
pause
del temp.txt