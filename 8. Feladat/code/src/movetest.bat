@echo off
copy nul temp.txt
java Main < virologist_moves.txt > temp.txt
fc temp.txt virologist_moves_output.txt
pause
del temp.txt