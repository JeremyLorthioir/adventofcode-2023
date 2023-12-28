import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * day2
 */
public class day2 {
	public static void main(String args[]) throws Exception {
		File file = new File("inputs/day2.txt");
		Scanner sc = new Scanner(file);

		int total = 0, totalPower = 0;
		String[] line;

		while (sc.hasNextLine()) {
			line = sc.nextLine().split(":");
			if (isValidGame(line[1])) {
				String gameId = line[0].substring(5);
				total += Integer.parseInt(gameId);
			}

			totalPower += powerOfCubes(line[1]);
		}

		System.out.println("Part 1:" + total);
		System.out.println("Part 2:" + totalPower);

		sc.close();
	}

	static boolean isValidGame(String game) {
		int red = 12, green = 13, blue = 14;

		for (String cubes : game.split("[,;]")) {
			String[] cube = cubes.trim().split("\s");

			if (cube[1].contains("red")) {
				if (Integer.parseInt(cube[0]) > red) {
					return false;
				}
			}
			if (cube[1].contains("green")) {
				if (Integer.parseInt(cube[0]) > green) {
					return false;
				}
			}
			if (cube[1].contains("blue")) {
				if (Integer.parseInt(cube[0]) > blue) {
					return false;
				}
			}
		}

		return true;
	}

	static int powerOfCubes(String game) {
		List<Integer> red = new ArrayList<>(), green = new ArrayList<>(), blue = new ArrayList<>();

		for (String cubes : game.split("[,;]")) {
			String[] cube = cubes.trim().split("\s");

			if (cube[1].contains("red")) {
				red.add(Integer.parseInt(cube[0]));
			}
			if (cube[1].contains("green")) {
				green.add(Integer.parseInt(cube[0]));
			}
			if (cube[1].contains("blue")) {
				blue.add(Integer.parseInt(cube[0]));
			}
		}

		return Collections.max(red) * Collections.max(green) * Collections.max(blue);
	}
}
