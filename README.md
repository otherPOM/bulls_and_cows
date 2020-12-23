# Bulls and Cows https://hyperskill.org/projects/53

## Stage 1
In this stage, your program should:

* Print a predefined game log that contains at least two turns.
* The output to be graded is a 4-digit code consisting of unique digits.
* The last line of your output contains a secret number.

## Stage 2
In this stage, your goal is to write the core part of the game: the grader.

1. Your program should take a 4-digit number as an input.
2. Use a predefined 4-digit code and grade the answer that was input. You can do it digit by digit.
The grade is considered correct if it contains number-and-word pairs (like `X bulls and Y cows`) that give the correct information. If the answer doesn't contain any bulls and cows, you should output `None`.
   
