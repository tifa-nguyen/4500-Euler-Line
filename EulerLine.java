import java.util.InputMismatchException;
import java.util.Scanner;

/* Program Title:			HW2 - Confirming the Euler Line
 * Program filename:		EulerLine.java
 * Program Language: 		Java (JavaSE-1.8)
 * IDE:						Eclipse IDE for Java Developers - 2019-12
 * 							Version: 2020-03 (4.15.0)
 * External files used:		N/A
 * External files created:	N/A
 * Programmer:				Ash Thomas; Tiffany Nguyen
 * Programmer Email:		; trrxz5@mail.missouri.edu
 * Course Info:				CMPSCI 4500, Section 001
 * Date Completed:			, 2021
 * Date Submitted:			, 2021
 * Program Explanation:		This program will estimate the value of pi based on the number of
 * 							virtual darts thrown at a circle. The program asks the user how many darts
 * 							they would like to throw. The program will then run a loop to "throw" a dart
 * 							at a randomly generated point and determine if the dart hit inside the circle
 * 							or not. Once the loop has completely "thrown" each dart, it will estimate the
 * 							value of Pi based on how many darts landed inside the circle out of the total
 * 							number of darts.
 * Resources Used:			
 */

public class EulerLine {

	static Scanner input = new Scanner(System.in);	// This scanner is used to receive user input for the program.
	
	public static void main(String[] args) {
		int numPoints= 3;	// This variable sets the size of the array for how many points are needed.
		int numPointValues = 2;	// This variable sets the size of the array for the number of values per point.
		float [][] pointsMatrix = new float[numPoints][numPointValues];	// This array will store the x and y coordinates of each point.
		
		System.out.println("[Short description of program]");
		
		// This loop will set which Cartesian point the user is inputting values for.
		for (int i = 0; i < numPoints; i++) {
			System.out.println("Enter the coordinates for Point " + (i + 1) + ".");
			// This loop will set the user's input for either the X or Y coordinate.
			for (int j = 0; j < numPointValues; j++) {
				if (j == 0) {
					System.out.print("X Coordinate: ");
				}
				if (j == 1) {
					System.out.print("Y Coordinate: ");
				}
				pointsMatrix[i][j] = userInput(j);	// This user's input is validated by a function before being assigned to the array.
			}
		}
		
		// This is a test loop to print the X, Y coordinates of each point.
		for (int i = 0; i < numPoints; i++) {
			System.out.println("Point " + (i + 1) + ": (" + pointsMatrix[i][0] + ", " + pointsMatrix[i][1] + ")");
		}
		
		input.close();
	}
	
	public static float userInput(int coord) {	// Validate if user input was a valid number.
		while (true) {
			try {
				return input.nextFloat();
			}
			catch (InputMismatchException e) {
				input.next();
				if (coord == 0) {
					System.out.println("ERROR: Input is not a valid number.");
					System.out.print("X Coordinate: ");
				}
				if (coord == 1) {
					System.out.println("ERROR: Input is not a valid number.");
					System.out.print("Y Coordinate: ");
				}
			}
		}
	}
}