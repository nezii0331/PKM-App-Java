# Linux System Administration - Week 1

## Files and Directory Operations

1. `pwd` - Print/point which directory (show the current path)
2. `ls -l` - Show file's info details (permissions, size, date)
3. `mkdir dirname` - Create a directory
4. `cd dirname` - Enter the directory
5. `touch filename.txt` - Create an empty file
6. `echo "hello world" > filename.txt` - Write text into a file (overwrites)
7. `cat filename.txt` - Display the content of a file

### Examples
```bash
mkdir myproject
cd myproject
touch README.txt
echo "Hello World" > README.txt
cat README.txt
```

---

## File Permissions (rwx)

- **r** = read (read)
- **w** = write (write)
- **x** = execute (execute/enter directory)

### Usually used with:
1. `ls -l` - Check file permissions (e.g. -rw-r--r--)
2. `chmod 600 filename.txt` - Only owner can read and write, group/others no access
3. `chmod 644 filename.txt` - Owner read and write, group/others only read (common for text/config files)
4. `chmod 755 filename.sh` - Owner read write execute, group/others read and execute (common for scripts)
5. `chmod u-r filename.txt` - Remove the owner's read permission
6. `chmod +x filename.sh` - Add execute permission to a file

### Experiments
- **no r** → can't `cat` file (cannot read what is the file)
- **no x** → can't `./filename.sh` or `cd` directory

---

## Environment Variables

1. `echo $HOME` - Show user's home directory (/home/negi)
2. `echo $PATH` - System find the order to search paths
3. `TESTVAR="FranLearning"` - Set a custom variable
4. `echo $TESTVAR` - Print self defined variable

### Variable Expansion
- `" "` → open the variables
- `' '` → not open the variables

### Examples
```bash
echo "$HOME"    # Output: /home/negi
echo '$HOME'    # Output: $HOME
```

---

## Piping and Filtering

1. `ls -l | grep .java` - Filter the files that include .java
2. `ls -1 | wc -l` - Count current files
3. `cat /etc/passwd | grep bash` - Find out login shell which is bash
4. `cat /etc/passwd | cut -d: -f1` - Only show user's name block
5. `ls -l /etc | less` - Page read long output

**Note:** The pipe `|` passes the standard output of the left command to the standard input of the right command.

---

## Shell Scripts (.sh)

Shell scripts are text files that contain a series of commands. By writing commands into a script, you can automate repetitive tasks.

### Basic Script Example
```bash
#!/bin/bash
echo "run ok"
echo "Current user: $(whoami)"
echo "Current directory: $(pwd)"
```

### How to Execute Scripts
1. `chmod +x filename.sh` - Add execute permission
2. `./filename.sh` - Execute the script

### Complete Example
```bash
# Create script
touch myscript.sh

# Add content (edit with nano/vim)
nano myscript.sh

# Make executable
chmod +x myscript.sh

# Run script
./myscript.sh
```