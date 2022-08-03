# Stack Application
- Java program for the card game: “Matching Pairs”.
- It is a game that requires finding identical pairs.
- In other words, it is a game where the user needs to match pairs of tiles.
- Tiles should include fruit words such as apple, orange, kiwi, banana, etc.
## The Beginning of the Game
- There is a text file (fruits.txt) that includes maximum 15 fruits. Read the file and insert them in a fruitStack.
- There are two stacks with x in size. The second stack contains the matches of tiles in the first stack.
- The default value of x is 5. If the user wants a different size, he/she can change the value of x in the source code.
- The game boards (stacks) should be randomly filled with distinct pairs. You should randomly select x fruits from fruitStack to fill game
boards. Each element in the stacks should be different from the others. For example, a stack doesn’t contain two orange fruits.
## Game Playing
- Playing is very simple - the computer turns over two tiles randomly, one tile from the first stack and one tile from the second stack. If
they are identical, the program deletes them from the game boards (stacks), if not, it tries again.
## The End Of The Game
- When all pairs are identified (when all tiles are deleted from the game boards (stacks)), the game will be over.
The program must display all steps until the game is over.
## Scoring
- Each time the computer makes a successful match, the score should be increased by 20 points.
- If the computer fails to match, the score should be decreased by 1 point.
## High Score Table
- Read the file “D:\\highscoretable.txt”.
- The high-score-table contains the top-10 game scores in descending order.
- The high-score-table must be read from the text file and inserted into the high-score-stack(s).
- If he/she gets a score within the top-10 results, he/she must be inserted into the high-score stack(s).
- If the same score exists in the table, the new score should be inserted to the next of them.
- At the end of the game, the new score table should be written to the same file.
## Samples Txt (HighScore and Fruit)
![fruit](https://user-images.githubusercontent.com/109742155/182620481-c0730fe4-bde8-4434-b843-ef8e64066054.png)
![highscore](https://user-images.githubusercontent.com/109742155/182620695-ed679994-6d68-4487-8b58-e7151ec4f39b.png)
## Sample Output
![Ekran görüntüsü 2022-08-03 163343](https://user-images.githubusercontent.com/109742155/182620995-5346779c-9960-4ba0-8053-a97c0df572ec.png)
![Ekran görüntüsü 2022-08-03 163355](https://user-images.githubusercontent.com/109742155/182621075-f6f20664-bad0-4c8f-ba16-750fc67be923.png)
