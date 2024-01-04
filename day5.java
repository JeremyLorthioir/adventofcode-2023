import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * day5
 */
public class day5 {
	public static void main(String args[]) throws Exception {
		List<String> lines = AocInputs.InputAsList("inputs/day5.txt");

		String[] seeds = lines.get(0).substring(7).split("\\s+");

		for (String seed : seeds) {
			System.out.println(seed);
		}
		System.out.println("Part 1:");
		System.out.println("Part 2:");
	}
}