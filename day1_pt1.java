import java.io.*;
import java.util.Scanner;

/**
 * day1
 */
public class day1_pt1 {
	public static void main(String args[]) throws Exception {
		File file = new File("inputs\\day1.txt");
		Scanner sc = new Scanner(file);

		int total = 0;
		String line = "";

		while (sc.hasNextLine()) {
			line = sc.nextLine();
			int i = 0;
			String nums = "";
			while (i < line.length()) {
				if (Character.isDigit(line.charAt(i))) {
					nums += Character.toString(line.charAt(i));
				}

				i++;
			}
			if (nums.length() == 1) {
				nums = Character.toString(nums.charAt(0)) + Character.toString(nums.charAt(0));
			} else {
				nums = Character.toString(nums.charAt(0)) + Character.toString(nums.charAt(nums.length() - 1));
			}

			total += Integer.parseInt(nums);
		}
		System.out.println(total);
		sc.close();
	}
}
