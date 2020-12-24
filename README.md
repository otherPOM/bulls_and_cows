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
   
## Stage 3
In this stage, your program should generate a pseudo-random number of a given length with unique digits and print it. If the length is greater than 10, the program should print a message containing the word `Error`. The secret code may contain any digits from 0 to 9 but only once. Secret code shouldn't start with a digit 0: for the first digit of the secret code, use digits from 1 to 9.

Don't delete your previous work, just move your code to a separate method. You will need it in the future stages.

## Stage 4
In this stage, your program should:

1. Ask for the length of the secret code and then generate the code.
2. Wait for the user input.
3. Grade the guessing attempt in bulls and cows.
4. If the secret code has been guessed, the program stops; otherwise, return to the second step.

## Stage 5
In this stage, rewrite the secret code generator using a suitable Java method.

## Stage 6
In this step, your program should:

1. Ask for the length of the secret code.
2. Ask for the range of possible characters in the secret code.
3. Generate a secret code using numbers and characters. This time, you should also print the secret code using `*` characters and print which characters were used to generate the secret code.
4. Function as a fully playable game.
