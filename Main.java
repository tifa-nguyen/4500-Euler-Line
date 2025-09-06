/* Program Title:			HW1 - Throwing Darts for the Digits of Pi
 * Program filename:		Main.java
 * Program Language: 		Java (JavaSE-1.8)
 * IDE:						Eclipse IDE for Java Developers - 2019-12
 * 							Version: 2020-03 (4.15.0)
 * External files used:		N/A
 * External files created:	N/A
 * Programmer:				Tiffany Nguyen
 * Programmer Email:		trrxz5@mail.missouri.edu
 * Course Info:				CMPSCI 4500, Section 001
 * Date Completed:			January 26, 2021
 * Date Submitted:			January 26, 2021
 * Program Explanation:		This program will estimate the value of pi based on the number of
 * 							virtual darts thrown at a circle. The program asks the user how many darts
 * 							they would like to throw. The program will then run a loop to "throw" a dart
 * 							at a randomly generated point and determine if the dart hit inside the circle
 * 							or not. Once the loop has completely "thrown" each dart, it will estimate the
 * 							value of Pi based on how many darts landed inside the circle out of the total
 * 							number of darts.
 * Resources Used:			Stack Overflow: How to randomly generate a number between -1 and 1
 * 								https://stackoverflow.com/questions/28683397/generate-random-number-between-1-and-1
 * 								This resource was used to help confirm how to shift the generated range of Math.random()
 * 								to include a negative number as the minimum value.
 * 							GeeksforGeeks: Find if a point lies inside a Circle
 * 								https://www.geeksforgeeks.org/find-if-a-point-lies-inside-or-on-circle/
 * 								This resource was used to help check on the algorithm to compare the randomly generated
 * 								position of the virtual dart and the points within the boundaries of the circle.
 */

import java.util.Scanner;
public class Main {

	// This is the main function of the program that asks for the user's input and performs all calculations.
	public static void main(String[] args) {
		int N = -1;		// This variable is used to store the user's input of how many darts to throw.
		double radius = 1;	// This variable is used to set the radius of the dart board's circle.
		double circlex = 0;	// This variable is used to store the X coordinate of the circle.
		double circley = 0;	// This variable is used to store the Y coordinate of the circle.
		double insidecount = 0;	// This variable is used to count how many darts hit inside of the circle.
		Scanner input = new Scanner(System.in);	// This scanner is used to receive user input for the program.
		
		System.out.println("Pi is a never-ending irrational number that never settles into a permanently repeating pattern.");
		System.out.println("There are many different ways to generate the digits of pi, but this program will help demonstrate\n"
		        + "one quirky method by randomly throwing virtual darts at a circle and estimating the value of pi based on\n"
		        + "how many of the the darts hit within a circle with a radius of 1 unit.\n");
		System.out.println("Once all of the darts have been thrown, we can calculate a ratio by taking the number of darts that hit\n"
				+ "within the circle, divide it by the total number of darts thrown, and then multiply that ratio by 4 to\n"
				+ "estimate the value of pi.\n");
		System.out.println("Lets see it work!\n");
		
		// This loop will ask the user how many darts to throw.
		// If the input is invalid/out of range, it will provide an error message and prompt the user for input again.
		while (true) {
			System.out.print("Please enter the number of darts to throw (1 - 1000000): ");
			N = input.nextInt();

			// If the input is not valid number within the range, the loop will display an error message.
			// If the input is valid, it will break the loop and proceed to the next block of code.
			if (N < 1 || N > 1000000) {
				System.out.println("That is not a valid number!");
			}
			else {
				break;
			}
		}
		
		// This loop will iterate for every single dart the user has declared.
		// The loop will generate a random X and Y coordinate for the dart and determine if the dart hit within the circle.
		for (int i = 0; i < N; i++) {
			double tempx = Math.random() * 2 - 1;	// This variable randomly generates a temporary X value between -1 and 1 for the dart's throw.
			double tempy = Math.random() * 2 - 1;	// This variable randomly generates a temporary Y value between -1 and 1 for the dart's throw.
			double comparex = tempx - circlex;	// This variable determines the distance of the dart's X value from the circle's center X value.
			double comparey = tempy - circley;	// This variable determines the distance of the dart's Y value from the circle's center Y value.
			
			// This loop will determine if the dart hit within the circle's boundary. If it did, it will increment the dart counter.
			if (comparex * comparex + comparey * comparey <= radius * radius) {
				insidecount++;
			}
		}
		
		double estpi = (insidecount / N) * 4;	// This variable will estimate the value of pi based on the darts that hit within the circle.
		System.out.println(N + " darts thrown! The estimated value of pi is " + estpi);
		
		input.close();
	}
}