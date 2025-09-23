#!/bin/bash

#This is the POSIX ANALYZER
echo "=== POSIX Text Log Analyzer ==="
echo "   Analyzing file: notes.txt   "
echo "==============================="
echo ""

#Add search function #can test grep (for search)
echo "1. Searching for line containing 'error':"
grep -in error notes.txt
echo ""  #This is the space for next function.

#Add Statistics Function #can test wc (word count)
echo "2. File Statistics:"
echo "Total lines: $(wc -l < notes.txt)"   #$() this is command substitution
echo "Total words: $(wc -w < notes.txt)"   #$() in another word, print the outcome of the command
echo "Total characters: $(wc -c < notes.txt)"  #$() count characters
echo ""

#Add Filter Function (if delete sort -n the sequence will sorted with char a-z)
echo "3. Filter word freqency analysis:"
cut -d' ' -f1 notes.txt | sort | uniq -c | sort -n
echo ""



