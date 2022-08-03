import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean game_replay = true;		// To replay the game 
		int number = 1;					// For the user's name in the second game
		while (game_replay == true) {
			Stack fruitStack = new Stack(15);	// For fruit stack
			Stack index = new Stack(15);		// For index of fruit stack
			reading("D://fruits.txt", fruitStack, index);
			int x = 5; 		// For the user to change the stack length
			int default_x = x;
			int ix1 = 0;
			int ix2 = 0;
			Stack stack1 = new Stack(x);
			Stack index1 = new Stack(x);
			Stack stack2 = new Stack(x);
			Stack index2 = new Stack(x);
			Random r = new Random();
			boolean flag;
			System.out.println("	********  MATCHING PAIRS ********\n");
			Stack tempfruit = new Stack(15);
			Stack tempfruit2= new Stack(15);
			Stack tempindex = new Stack(15);
			
			System.out.print("Fruit Stack : ");
			while(!fruitStack.ýsEmpty()) {
				tempfruit2.push(fruitStack.pop());
			}
			while(!tempfruit2.ýsEmpty()) {
				System.out.print(tempfruit2.peek()+"  ");	// Print the fruit stack on the screen
				fruitStack.push(tempfruit2.pop());
			}
			System.out.println("\n-----\t-----\t-----\t-----\t-----\t-----\t-----");
			
			///	To randomly throw fruit into stack1
			int y;
			while (x > 0) {
				flag = false;
				y = r.nextInt(default_x); // 
				while (!fruitStack.ýsEmpty()) {
					if ((Integer) index.peek() == y) {
						stack1.push(fruitStack.pop());
						index1.push(ix1);
						index.pop();
						flag = true;
						ix1++;
					} else {
						tempfruit.push(fruitStack.pop());
						tempindex.push(index.pop());
					}
				}
				while (!tempfruit.ýsEmpty()) {
					fruitStack.push(tempfruit.pop());
					index.push(tempindex.pop());
				}
				if (flag == true) {
					x--;
				}
			}
			x = default_x;
			Stack tempstack1 = new Stack(x);
			Stack tempstack11 = new Stack(x);
			Stack tempindex1 = new Stack(x);
			Stack tempindex11 = new Stack(x);
			while (!stack1.ýsEmpty()) {
				Object a = stack1.pop();
				Object b = index1.pop();
				tempstack1.push(a);
				tempstack11.push(a);
				tempindex1.push(b);
				tempindex11.push(b);
			}
			while (!tempstack1.ýsEmpty()) {
				stack1.push(tempstack1.pop());
				index1.push(tempindex1.pop());
			}
			///	Placing fruit from stack1 to stack2
			int m = x;
			while (m > 0) {
				flag = false;
				y = r.nextInt(x);
				while (!stack1.ýsEmpty()) {
					if ((Integer) index1.peek() == y) {
						stack2.push(stack1.pop());
						index2.push(ix2);
						index1.pop();
						flag = true;
						ix2++;
					} else {
						tempstack1.push(stack1.pop());
						tempindex1.push(index1.pop());
					}
				}
				while (!tempstack1.ýsEmpty()) {
					stack1.push(tempstack1.pop());
					index1.push(tempindex1.pop());
				}
				if (flag == true) {
					m--;
				}
			}
			/// To restore the stack1
			while (!tempstack11.ýsEmpty()) {
				stack1.push(tempstack11.pop());
				index1.push(tempindex11.pop());
			}
			///	For the calculation of points
			int point = 0;
			int step = 1;
			while (!stack1.ýsEmpty()) {
				Object s1 = null, s2 = null;
				int r_stack1 = r.nextInt(stack1.size()) + 1;	// Random number for stack1
				int r_stack2 = r.nextInt(stack2.size()) + 1;	// Random number for stack2
				while (!stack1.ýsEmpty()) {
					if (stack1.size() == r_stack1) {
						s1 = stack1.peek();
						break;
					} else {
						tempstack1.push(stack1.pop());
					}
				}
				while (!tempstack1.ýsEmpty()) {
					stack1.push(tempstack1.pop());
				}
				while (!stack1.ýsEmpty()) {
					tempstack1.push(stack1.pop());
				}
				System.out.print("Stack 1 : ");
				while (!tempstack1.ýsEmpty()) {
					stack1.push(tempstack1.pop());
					System.out.print(stack1.peek() + "   ");	// Printing stack1 elements 
				}
				System.out.println("\n");
				while (!stack2.ýsEmpty()) {
					if (stack2.size() == r_stack2) {
						s2 = stack2.peek();
						break;
					} else {
						tempstack11.push(stack2.pop());
					}
				}
				while (!tempstack11.ýsEmpty()) {
					stack2.push(tempstack11.pop());
				}
				while (!stack2.ýsEmpty()) {
					tempstack11.push(stack2.pop());
				}
				System.out.print("Stack 2 : ");
				while (!tempstack11.ýsEmpty()) {
					stack2.push(tempstack11.pop());
					System.out.print(stack2.peek() + "   ");	// Printing stack2 elements 
				}
				if (s1.equals(s2)) {	// Control of fruits
					while (!stack1.ýsEmpty()) {
						if (stack1.peek().equals(s1)) {
							stack1.pop();
							break;
						} else {
							tempstack1.push(stack1.pop());
						}
					}
					while (!tempstack1.ýsEmpty()) {
						stack1.push(tempstack1.pop());
					}

					while (!stack2.ýsEmpty()) {
						if (stack2.peek().equals(s2)) {
							stack2.pop();
							break;
						} else {
							tempstack11.push(stack2.pop());
						}
					}
					while (!tempstack11.ýsEmpty()) {
						stack2.push(tempstack11.pop());
					}
					point += 20;
				} else {
					point += -1;
				}
				//System.out.println("\tScore : " + point);
				System.out.println("\n\nRandomly generated numbers: " + r_stack1 + "\t" + r_stack2+"\t\t\tStep : "+step+"\tScore : "+point
						+ "\n-----\t-----\t-----\t-----\t-----\t-----\t-----");
				step++;
			}
			System.out.println("Stack1 : \n");
			System.out.println("Stack2 : ");
			System.out.println("\nThe Final Score : " + point);
			System.out.println("The Game is Over.");

			/// For High Score Table
			System.out.println();
			Stack scores = new Stack(20);
			Stack scores_index = new Stack(20);
			reading("D:\\highscoretable.txt", scores, scores_index);
			System.out.println("	******* HIGH SCORE TABLE *******");
			Stack scores_temp = new Stack(20);
			int ö = 0;
			while (!scores.ýsEmpty()) {
				if ((scores.size() - 1) % 2 == 1) {
					ö = Integer.parseInt((String) scores.peek());
					if (ö >= point) {
						break;
					} else {
						scores_temp.push(scores.pop());
					}
				} else {
					scores_temp.push(scores.pop());
				}
			}
			String n = Integer.toString(number);	/// For name difference if user wants to play more than once
			if (!scores.ýsFul()) {					/// If the user's score is not in the top scores
				scores.push("You" + n);
				scores.push(Integer.toString(point));
			}
			while (!scores.ýsFul()) {	/// To add the remaining scores after the user score to the stack
				scores.push(scores_temp.pop());
			}
			Stack scores_temp2 = new Stack(20);

			while (!scores.ýsEmpty()) {
				scores_temp2.push(scores.pop());
			}
			/// To write the current scores to the high score file
			File file = new File("D:\\highscoretable.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			while (!scores_temp2.ýsEmpty()) {
				if ((scores_temp2.size() - 1) % 2 == 1) {
					Object empty = scores_temp2.pop();
					scores.push(empty);
					bWriter.write((String) empty);
				} else {
					Object empty = scores_temp2.pop();
					scores.push(empty);
					bWriter.write((String) empty);
				}
				bWriter.newLine();
			}
			bWriter.close();
			
			/// To print the scores on the screen
			while (!scores.ýsEmpty()) {
				scores_temp2.push(scores.pop());
			}
			while (!scores_temp2.ýsEmpty()) {

				if ((scores_temp2.size() - 1) % 2 == 1) {
					System.out.print(scores_temp2.peek() + "\t");
					scores.push(scores_temp2.pop());
				} else {
					System.out.println(scores_temp2.peek());
					scores.push(scores_temp2.pop());
				}
			}
			/// Only to ask if the user wants to play the game again
			Scanner scan = new Scanner(System.in);
			System.out.println("\nDo you want to continue for the new game? (Please enter 'Yes' or 'No')");
			String receive = scan.next();
			if (receive.equalsIgnoreCase("yes")) {
				game_replay = true;
				number++;
			} else if (receive.equalsIgnoreCase("no")) {
				System.out.println("<<<The game is closed>>>");
				game_replay = false;
			}
		}
	}
	public static void reading(String file_name, Stack a, Stack b) throws IOException {		/// Method for reading from file
		int ix = 0;
		File dosya = new File(file_name);
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(dosya), "UTF8"));
			String satir;
			while ((satir = inputStream.readLine()) != null) {
				a.push(satir);
				b.push(ix);
				ix++;
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}
