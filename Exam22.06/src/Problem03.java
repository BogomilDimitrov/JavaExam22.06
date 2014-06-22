import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Problem03 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String[] header = new String[3];
		for (int i = 0; i < header.length; i++) {
			header[i] = scan.nextLine();
		}
		
		TreeMap<Integer, TreeMap<String, Double>> exam = new TreeMap<>();
		
		
		while(true){
			String input = scan.nextLine();
			if (input.contains("-") ) {
				break;
			}	
			
			Pattern scorePat = Pattern.compile(" \\d+ ");
			Matcher scoreMatch = scorePat.matcher(input);
			int score = 0;
			while (scoreMatch.find()) {
				score = Integer.parseInt(scoreMatch.group().trim());
			}
			
			Pattern namePat = Pattern.compile("[a-zA-z]+");
			Matcher nameMatch = namePat.matcher(input);
			String name = "";
			while (nameMatch.find()) {
				name += nameMatch.group() + " ";
			}
			name = name.trim();
						
			Pattern gradePat = Pattern.compile("(\\d\\.\\d+)+");
			Matcher gradeMatch = gradePat.matcher(input);
			double grade = 0;
			while (gradeMatch.find()) {
				grade = Double.parseDouble(gradeMatch.group());
			}
			
			if (!exam.containsKey(score)) {
				exam.put(score, new TreeMap<>());
			}
			
			exam.get(score).put(name, grade);
		}
		
		for (int score : exam.keySet()) {
			System.out.print(score + " -> ");
			System.out.print(exam.get(score).keySet() + ";");
			double sum = 0;
			for (String student : exam.get(score).keySet()) {
				sum += exam.get(score).get(student);
			}
			sum /= exam.get(score).keySet().size();
			int ostatak = (int)(sum *1000.0)%1000;
			if (ostatak == 14) {
				sum += 0.001;
			}
			System.out.printf(" avg=%.2f",sum);
			System.out.println();
		}
		

	}

}
