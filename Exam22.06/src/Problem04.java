import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Problem04 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		Pattern regexCard = Pattern.compile("[\\dAJQK]+");
		Matcher matchCard = regexCard.matcher(input);
		
		Pattern regexSuit = Pattern.compile("[DSCH]");
		Matcher matchSuit = regexSuit.matcher(input);
		
		
		HashMap<Integer, String> cardValues = new HashMap<>();
		cardValues.put(1, "1");
		cardValues.put(2, "2");
		cardValues.put(3, "3");
		cardValues.put(4, "4");
		cardValues.put(5, "5");
		cardValues.put(6, "6");
		cardValues.put(7, "7");
		cardValues.put(8, "8");
		cardValues.put(9, "9");
		cardValues.put(10, "10");
		cardValues.put(11, "J");
		cardValues.put(12, "Q");
		cardValues.put(13, "K");
		cardValues.put(14, "A");
		
		ArrayList<Integer> cards = new ArrayList<>();
		ArrayList<String> suits = new ArrayList<>();
		
		while (matchCard.find()) {
			if (matchCard.group().equals("J")) {
				cards.add(11);
			} else if (matchCard.group().equals("Q")) {
				cards.add(12);
			} else if (matchCard.group().equals("K")) {
				cards.add(13);
			} else if (matchCard.group().equals("A")) {
				cards.add(14);
			} else {
				cards.add(Integer.parseInt(matchCard.group()));

			}
		}
		
		while (matchSuit.find()) {
			suits.add(matchSuit.group());
		}
		
		ArrayList<Integer> clubs = new ArrayList<>();
		ArrayList<Integer> hearts = new ArrayList<>();
		ArrayList<Integer> diamonds = new ArrayList<>();
		ArrayList<Integer> spades = new ArrayList<>();
		
		
		for (int i = 0; i < cards.size(); i++) {
			if ((suits.get(i)).equals("C")) {
				clubs.add(cards.get(i));
			}else if ((suits.get(i)).equals("H")) {
				hearts.add(cards.get(i));
			}else if ((suits.get(i)).equals("D")) {
				diamonds.add(cards.get(i));
			}else if ((suits.get(i)).equals("S")) {
				spades.add(cards.get(i));
			}
		}
		
		Collections.sort(diamonds);
		Collections.sort(hearts);
		Collections.sort(spades);
		Collections.sort(clubs);
		boolean diamondFlush = false;
		
		for (int i = 4; i < diamonds.size(); i++) {
			if (diamonds.get(i) == (diamonds.get(i-1)+1) &&
				diamonds.get(i-1) == (diamonds.get(i-2)+1) &&
				diamonds.get(i-2) == (diamonds.get(i-3)+1) &&
				diamonds.get(i-3) == (diamonds.get(i-4)+1)) {
							
				
				System.out.println("["+cardValues.get(diamonds.get(i-4))+"D"+", "+cardValues.get(diamonds.get(i-3))+"D"+", "
				+cardValues.get(diamonds.get(i-2))+"D"+", "+cardValues.get(diamonds.get(i-1))+"D"+", "+cardValues.get(diamonds.get(i))+"D"+"]");
				diamondFlush = true;
			}
		}
		
		boolean clubsFlush = false;
		for (int i = 4; i < clubs.size(); i++) {
			if (clubs.get(i) == (clubs.get(i-1)+1) &&
				clubs.get(i-1) == (clubs.get(i-2)+1) &&
				clubs.get(i-2) == (clubs.get(i-3)+1) &&
				clubs.get(i-3) == (clubs.get(i-4)+1)) {
				
				System.out.println("["+cardValues.get(clubs.get(i-4))+"C"+", "+cardValues.get(clubs.get(i-3))+"C"+", "
				+cardValues.get(clubs.get(i-2))+"C"+", "+cardValues.get(clubs.get(i-1))+"C"+", "+cardValues.get(clubs.get(i))+"C"+"]");
				clubsFlush = true;
			}
		}
		
		boolean spadesFlush = false;
		for (int i = 4; i < spades.size(); i++) {
			if (spades.get(i) == (spades.get(i-1)+1) &&
				spades.get(i-1) == (spades.get(i-2)+1) &&
				spades.get(i-2) == (spades.get(i-3)+1) &&
				spades.get(i-3) == (spades.get(i-4)+1)) {
				
				System.out.println("["+cardValues.get(spades.get(i-4))+"S"+", "+cardValues.get(spades.get(i-3))+"S"+", "
				+cardValues.get(spades.get(i-2))+"S"+", "+cardValues.get(spades.get(i-1))+"S"+", "+cardValues.get(spades.get(i))+"S"+"]");
				spadesFlush = true;
			}
		}
		
		boolean heartsFlush = false;
		for (int i = 4; i < hearts.size(); i++) {
			if (hearts.get(i) == (hearts.get(i-1)+1) &&
				hearts.get(i-1) == (hearts.get(i-2)+1) &&
				hearts.get(i-2) == (hearts.get(i-3)+1) &&
				hearts.get(i-3) == (hearts.get(i-4)+1)) {
				
				System.out.println("["+cardValues.get(hearts.get(i-4))+"H"+", "+cardValues.get(hearts.get(i-3))+"H"+", "
				+cardValues.get(hearts.get(i-2))+"H"+", "+cardValues.get(hearts.get(i-1))+"H"+", "+cardValues.get(hearts.get(i))+"H"+"]");
				heartsFlush = true;
			}
		}
		
		if (!diamondFlush && !heartsFlush && !spadesFlush && !clubsFlush) {
			System.out.println("No Straight Flushes");
		}
		
	}

}
