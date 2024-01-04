import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * day4
 */
public class day4 {
	public static void main(String args[]) throws Exception {
		List<String> lines = AocInputs.InputAsList("inputs/day4.txt");
		int total = 0, totalCards = 0;

		for (int i = 0; i < lines.size(); i++) {
			int matchingNumbers = 0;

			String[] cardNumbers = lines.get(i).split(":");
			String[] splitNumbers = cardNumbers[1].split("\\|");

			String[] scratchedArray = splitNumbers[0].trim().split("\\s+");
			String[] winningArray = splitNumbers[1].trim().split("\\s+");

			List<Integer> winningNumbers = new ArrayList<>();

			for (String s : winningArray) {
				winningNumbers.add(Integer.parseInt(s));
			}

			for (String num : scratchedArray) {
				if (winningNumbers.contains(Integer.parseInt(num))) {
					matchingNumbers++;
					totalCards += scratch(i, lines);
				}
			}

			total += Math.pow(2, matchingNumbers - 1);
		}

		System.out.println("Part 1:" + total);
		System.out.println("Part 2:" + totalCards);
	}

	static int scratch(int currentCardIndex, List<String> cards) {
		int matchingNumbers = 0;

		String[] cardNumbers = cards.get(currentCardIndex).split(":");
		String[] splitNumbers = cardNumbers[1].split("\\|");

		String[] scratchedArray = splitNumbers[0].trim().split("\\s+");
		String[] winningArray = splitNumbers[1].trim().split("\\s+");

		List<Integer> winningNumbers = new ArrayList<>();

		for (String s : winningArray) {
			winningNumbers.add(Integer.parseInt(s));
		}

		for (String num : scratchedArray) {
			if (winningNumbers.contains(Integer.parseInt(num))) {
				if (currentCardIndex + matchingNumbers <= cards.size()) {
					matchingNumbers++;
					matchingNumbers += scratch(currentCardIndex + matchingNumbers, cards);
				}
			}
		}

		return matchingNumbers;
	}
}
