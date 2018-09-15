import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * @author Hunter DeBlase
 * CSC243 Fall 2018 Assignment 1
 *
 */
public class RetirementCalculator {
	
	public static final double INTRATE = .05;

	public static void main(String[] args) {
		double savings = getSavings();
		int years = getYears();
		double total = calcTotal(savings, years);
		printTotal(total, years);

	}
	
	/**
	 * gets input for savings and checks if the input is valid
	 * @return yearly savings
	 */
	public static double getSavings() {
		Scanner savingsInput = new Scanner(System.in);
		double savingsIn = 0;
		while(true) {
			System.out.println("Please enter the amount you can save yearly.");
			try {
				savingsIn = Double.parseDouble(savingsInput.next());
				checkPositive((int) Math.ceil(savingsIn));
				break;
			}
			catch(NumberFormatException ignore) {
				System.out.println("Invalid input.");
			}
			catch(InvalidPositiveException ex1) {
				System.out.println(ex1.getMessage());
			}
		}
		return savingsIn;
	}
	
	/**
	 * gets input for number of years until retirement and checks for valid numbers
	 * @return number of years
	 */
	public static int getYears() {
		Scanner yearInput = new Scanner(System.in);
		int years = 0;
		while(true) {
			System.out.println("Please enter number of years until retirement");
			try {
				years = Integer.parseInt(yearInput.next());
				checkPositive(years);
				break;
			}
			catch(NumberFormatException ignore) {
				System.out.println("Invalid input.");
			}
			catch(InvalidPositiveException ex1) {
				System.out.println(ex1.getMessage());
			}
		}
		return years;
	}
	
	/**
	 * checks if an integer passed in is <= 0
	 * @param check an integer to be checked
	 * @throws InvalidPositiveException if integer is <= 0
	 */
	public static void checkPositive(int check) throws InvalidPositiveException{
		if(check <= 0) {
			throw new InvalidPositiveException("Input must be above 0.");
		}
	}
	
	/**
	 * calculates the total amount saved after a time period
	 * @param savings the amount added each year
	 * @param years the number of years until retirement
	 * @return total amount saved at retirement
	 */
	public static double calcTotal(double savings, int years) {
		double interest = savings*((Math.pow(1+INTRATE,years+1)-(1+INTRATE))/INTRATE);
		return interest;
	}
	
	/**
	 * prints total
	 * @param total the total amount after a number of years
	 * @param years the number of years until retirement
	 */
	public static void printTotal(double total, int years) {
		final DecimalFormat df2 = new DecimalFormat(".##");
		System.out.println("Total amount saved after " + years + " is $" + df2.format(total));
	}

}
