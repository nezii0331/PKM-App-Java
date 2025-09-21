
*Files and catalog paths
1. pwd  // Print/point which doc(show the current path)
2. ls -l  // Show file's info details(rwx)
3. mkdir dirname-Create a directory
4. cd dirname-Enter the directory
5. touch filename.txt-Create an empty file
6. echo "hello world" > filename.txt-Write txt into a file(overwrites)
7. cat filename.txt-display the content of a file 


*Authorize(rwx)
- r = read (read)
- w = write (write)
- x = execute (execute/enter)

usually use with:
1. ls -l //Check file permissions(e.g. -rw-r--r--)
2. chmod 600 filename.txt //Only owner can write and read, group/others no authorize
3. chmod 644 filename.txt //Owner read and write, group/others only read(common for text/config files)
4. chmod 755 filename.sh //Owner read write execute, group/others read and execute (common for scripts)
5. chmod u-r filename.txt //Remove the owner's read permission
6. chmod +x filename.sh // Add execute permission to a file

**experiment
- no r -> can't cat file (cannot read what is the file)
- no x -> can't ./filename.sh or cd catalog

*Environment variable
1. echo $HOME  // show user's catalog (/home/negi)
2. echo $PATH  // system find the order to search paths
3. echo TESTVAR="FranLearning"
4. echo $TESTVAR  // print self define variable

- " " -> open the variables
- ' ' -> not open the variables

= echo "$HOME" (/home/negi)
= echo '$HOME' $HOME

*Piping and filter
1. ls -l | grep .java // filter the file that include .java
2. ls -1 | wc -l // count current files
3. cat /etc/passwd | grep bash //find out login shell which is bash
4. cat /etc/passwd | cut -d: -f1 //only show user's name block
5. ls -l/etc | less //path read long output
Note: The pipe | passes the standard output of the left command to the standard input of the right command.


*Shell and script(.sh)
.sh = write the 'command' comment in to file and let it automatic execute
-A shell script is a text file that contains a series of commands.
-By writing commands into a script, you can automate repetitive tasks.

like:
#!/bin/bash
echo "run ok"
add -> $(whomi) comment inside then it could execute those script

execute:
chmod +x filename.sh //add execute authorize
./filename.sh //execute the script
