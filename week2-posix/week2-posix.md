# POSIX Text Processing Tools - Week 2

## Basic Commands

### echo
- **Purpose**: Print text to terminal
- **Usage**: `echo "Hello World"`
- **Example**: `echo "=== POSIX Text Log Analyzer ==="`

### grep (Grab Repeat)
- **Purpose**: Search and filter lines containing specific text
- **Usage**: `grep -in pattern filename`
- **Parameters**:
  - `-i`: ignore case (for example: N and n)
  - `-n`: show line numbers
- **Example**: `grep -in error notes.txt`

### wc (Word Count)
- **Purpose**: Count lines, words, and characters
- **Usage**: `wc -l filename` (lines), `wc -w filename` (words), `wc -c filename` (characters)
- **Redirection**: `wc -l < filename` (no filename in output)
- **Example**: `$(wc -l < notes.txt)` for clean output

### cut (Cut Up Text)
- **Purpose**: Extract specific fields from lines
- **Usage**: `cut -d'delimiter' -f field_number filename`
- **Parameters**:
  - `-d' '`: use space as delimiter
  - `-f1`: extract first field
- **Example**: `cut -d' ' -f1 notes.txt`

### sed (Search Edit Delete)
- **Purpose**: Stream editor for text substitution
- **Usage**: `sed 's/old/new/g' filename`
- **Parameters**:
  - `s`: substitute
  - `g`: global replacement
- **Example**: `sed 's/fail/warning/g' notes.txt`

### awk (Advanced Word Killer) handling
- **Purpose**: Pattern scanning and data processing
- **Usage**: `awk 'pattern { action }' filename`
- **Built-in Variables**:
  - `NR`: Number of Records (line number)
  - `NF`: Number of Fields (word count per line)
- **Example**: `awk '{print "Line " NR ": " NF " words"}' notes.txt`

## Command Combinations

### Pipeline
- **Purpose**: Connect multiple commands
- **Usage**: `command1 | command2 | command3`
- **Example**: `cut -d' ' -f1 notes.txt | sort | uniq -c`

### Redirection
- **Input**: `< filename` (read from file)
- **Output**: `> filename` (write to file)
- **Append**: `>> filename` (append to file)
- **Error**: `2> filename` (redirect errors)

## Learning Notes

### Key Concepts
1. **Redirection**: Use `<` to avoid filename in output
2. **Pipeline**: Connect commands with `|`
3. **Command Substitution**: Use `$()` to embed command results
4. **Sorting**: Use `sort -nr` for numeric reverse sorting

### Common Patterns
- **Search**: `grep -in pattern file`
- **Count**: `wc -l < file`
- **Extract**: `cut -d' ' -f1 file`
- **Replace**: `sed 's/old/new/g' file`
- **Process**: `awk '{print NR ": " NF}' file`

### Command Combinations
- **Search + Sort + Count**: `grep -in pattern file | sort | uniq -c`
- **Extract + Sort + Count**: `cut -d' ' -f1 file | sort | uniq -c`
- **Edit + Search**: `sed 's/old/new/g' file | grep pattern`

### Memory Tips
- **wc** = Word Count (計算)
- **grep** = Grab Repeat (抓取)
- **sed** = Search Edit Delete (編輯)
- **awk** = Advanced Word Killer (處理)
- **cut** = Cut Up Text (切割)
