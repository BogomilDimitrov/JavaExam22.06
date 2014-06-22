import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem01 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();
		ArrayList<String> words = new ArrayList<>();

		Pattern regex = Pattern.compile("[a-zA-Z]+");
		Matcher match = regex.matcher(input);

		while (match.find()) {
			words.add(match.group());
		}

		HashSet<String> output = new HashSet<>();

		for (int a = 0; a < words.size(); a++) {
			for (int b = 0; b < words.size(); b++) {
				for (int c = 0; c < words.size(); c++) {
					if (a != b && b != c && a != c) {
						if ((words.get(a) + words.get(b)).equals(words.get(c))) {
							output.add(words.get(a) + "|" + words.get(b) + "="
									+ words.get(c));
						}
					}
				}
			}
		}

		if (output.isEmpty()) {
			System.out.println("No");
		} else {

			for (String string : output) {
				System.out.println(string);
			}
		}
	}
}
