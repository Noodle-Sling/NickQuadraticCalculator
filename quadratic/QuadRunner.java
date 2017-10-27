package quadratic;
import java.util.Scanner;

public class QuadRunner {

	public static void main(String[] args) {
		int numberOfStartFails = 0;
		Scanner sc = new Scanner(System.in);
		String input = "";
		System.out.println("Welcome to the Quadratic Calculator! COPYRIGHT NICK POULOS 2017.\nThis program can find a quadratic function's real or complex roots, plus its discriminant and axis of symmetry.\n\nType \"start\" to begin.");
		while (!input.equals("start")) {
			input = sc.nextLine().toLowerCase();
			if (input.equals("start")) {
			System.out.println("Enter the coefficients of your quadratic funtion Ax^2 + Bx + C in decimal form one after another.");
			printSolution();
			}
			else {
			numberOfStartFails++;
			if (numberOfStartFails == 3) System.out.println("You're a little slow, aren't you?");
			if (numberOfStartFails == 5) System.out.println("So you can type \"start\" by pressing on the corresponding keys on your keyboard.");
			if (numberOfStartFails == 7) System.out.println("Try it with me: \"S -- T -- A -- R -- T.\"");
			if (numberOfStartFails == 10) System.out.println("You're not just doing this for more sarcastic messages, I hope.");
			if (numberOfStartFails == 15) System.out.println("Because this is the last easter egg. Congratulations. Now for the love of god type \"start\".");
			if (numberOfStartFails == 20) {
				System.out.println("Alright, that's it, we're done here. You're either slow or obstinant, and either way I haven't the time. Goodbye (forever hopefully).");
				sc.close();
				return;
			}
			System.out.println("Type \"start\" to begin.");
			}
		}
		while (!input.equals("quit")) {
			System.out.println("To calculate another, type \"again,\" or to quit, type \"quit.\"");
			input = sc.nextLine().toLowerCase();
			if (input.equals("again")) printSolution();
			if (input.equals("quit")) {
				System.out.println("Bye bye.");
				sc.close();
				return;
			}
		}
	}

	static double[] getCoefficients() {
		Scanner sc = new Scanner(System.in);
		String input = "";
		double[] nums = new double[3];
		int varAsk = 0;
		while (varAsk < 3) {
		switch (varAsk) {
		case 0:
			System.out.println("A?");
				input = sc.nextLine();
				if (catchInput(input)) {
					if (Double.valueOf(input) == 0) {
					System.out.println("You entered zero for A, but the leading coefficient must have a nonzero value. A has been recorded as one.");
					nums[0] = 1;
					}
					else nums[0] = Double.valueOf(input);
					varAsk++;
				}
				else System.out.println("Please enter a numerical value in decimal form.");
			break;
		case 1:
			System.out.println("B?");
				input = sc.nextLine();
				if (catchInput(input)) {
				nums[1] = Double.valueOf(input);
				varAsk++;
				}
				else System.out.println("Please enter a numerical value in decimal form.");
			break;
		case 2:
			System.out.println("C?");
				input = sc.nextLine();
				if (catchInput(input)) {
				nums[2] = Double.valueOf(input);
				varAsk++;
				}
				else System.out.println("Please enter a numerical value in decimal form.");
			break;		
	}
}
		return nums;
}
	
	static void printSolution() {
		double[] coefficients = getCoefficients();
		Quadratic expression = new Quadratic(coefficients);
		System.out.println(coSwitch(expression.a, 0) + coSwitch(expression.b, 1) + coSwitch(expression.c, 2) + " = 0" + yourMom(coefficients));
		System.out.println("DISCRIMINANT: " + expression.discr + "\nThere " + checkDiscr(expression.discr)[2] + " " + checkDiscr(expression.discr)[0] + " real root" + checkDiscr(expression.discr)[1] + ".");
		if (expression.isCalculable()) System.out.println("ROOTS: x = " + expression.calculateRoots()[0] + (expression.calculateRoots()[0] != expression.calculateRoots()[1] ? ", x = " + expression.calculateRoots()[1] : ""));
		else System.out.println("COMPLEX ROOTS: x = " + expression.printComplexRoots());
		System.out.println("AXIS OF SYMMETRY on x = " + expression.axOfSim + "\n");
	}
	
	static String coSwitch(double a, int b) {
		if (b == 0) {
			if (a != 1) return a + "x^2";
			else return "x^2";
		}
		if (b == 1) {
			if (a != 0 && a != 1) {
				if (a < 0) return " - " + Math.abs(a) + "x";
				else return " + " + a + "x";
			}
			else if (a == 0) return "";
			else return " + x";
		}
		else if (b == 2) {
			if (a != 0) {
				if (a < 0) return " - " + Math.abs(a);
				else return " + " + a;
			}
			else return "";
		}
		return "";
	}
	
	static String[] checkDiscr(double discr) {
		String[] discrStringBits = {"", "", ""};
		if (discr > 0) {
			discrStringBits[0] = "two";
			discrStringBits[1] = "s";
			discrStringBits[2] = "are";
		}
		else if (discr == 0) {
			discrStringBits[0] = "one";
			discrStringBits[1] = "";
			discrStringBits[2] = "is";
		}
		else {
			discrStringBits[0] = "zero";
			discrStringBits[1] = "s";
			discrStringBits[2] = "are";
		}
		return discrStringBits;
	}
	
	static Boolean catchInput(String input) {
		int value = 0;
		Boolean oneDec = true;
		if (input.length() > 0) {
			for (int i = 0; i < input.length(); i++) {
				if (input.substring(i, i+1).equals("0") ||
				input.substring(i, i+1).equals("1") ||
				input.substring(i, i+1).equals("2") ||
				input.substring(i, i+1).equals("3") ||
				input.substring(i, i+1).equals("4") ||
				input.substring(i, i+1).equals("5") ||
				input.substring(i, i+1).equals("6") ||
				input.substring(i, i+1).equals("7") ||
				input.substring(i, i+1).equals("8") ||
				input.substring(i, i+1).equals("9")) value++;
				if (oneDec && i != input.length()-1 && input.substring(i, i+1).equals(".")) {
					value++;
					oneDec = false;
				}
			}
		}
			else return false;
		if (input.substring(0,1).equals("-")) value++;
		if (value == input.length()) return true;
		else return false;
	}
	
	static String yourMom(double[] coefficients) {
		if ((coefficients[0] == 69 || coefficients[0] == -69) && (coefficients[1] == 69 || coefficients[1] == -69) && (coefficients[2] == 69 || coefficients[2] == -69)) return ". Is your mom using this calculator?\n";
		else return "\n";
	}
}
