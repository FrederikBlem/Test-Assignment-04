# Test-Assignment-04
The fourth assignment of the Test subject.<br>
[Assignment doc converted to PDF.](https://github.com/FrederikBlem/Test-Assignment-04/blob/main/assignment-04.pdf)

## 1 Mockito Powerups
Answer the following questions about Mockito. Use code examples in your 
explanations.

* How do you verify that a mock was called?
* How do you verify that a mock was NOT called?
* How do you specify how many times a mock should have been called?
* How do you verify that a mock was called with specific arguments?
* How do you use a predicate to verify the properties of the arguments given to a 
call to the mock?

## 2 At Least One
Using TDD, make at least one of the following three tasks, A, B or C. Whatever you 
choose, include coverage report (e.g. Jacoco) and mutation testing (e.g. PITest), and 
static analysis (e.g. Findbugs, PMD, CheckStyle).

### C: Tic-tac-toe: Make a tic-tac-toe game using TDD. 
<b><u>Requirements:</u></b><br>
<b>It should play against the human player. If you already had the Data Science course, you can try to make an AI with 
Minimax. Otherwise, simply have the AI make random moves – but the checks for 
win/loss, and the correct game flow (turn taking, handling human error of giving 
incorrect placement, etc.) must be implemented.</b>

The code for this game was made strictly following TDD and frankly became very messy.
The half-baked attempt at ordering the tests with 'regions' also did not help sufficiently.
That said, while the game is missing some input exception handling because I did not find a way to sufficiently simulate wrong input, 
it does run when getting the expected input.<br>
[Tests.](https://github.com/FrederikBlem/Test-Assignment-04/blob/main/TicTacToe/src/test/java/dk/fb/test/tictactoe/TicTacToeApplicationTests.java)<br>
[Classes.](https://github.com/FrederikBlem/Test-Assignment-04/tree/main/TicTacToe/src/main/java/dk/fb/test/tictactoe).

Still TODO: coverage report, mutation testing and static analysis.
