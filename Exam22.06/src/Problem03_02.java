import java.util.Scanner;
import java.util.TreeMap;


public class Problem03_02 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.nextLine();
		scan.nextLine();
		TreeMap<Integer, TreeMap<String, Double>> exam = new TreeMap<>();
		
		
		while(true){
			String input = scan.nextLine();
			if (input.contains("-") ) {
				break;
			}	
			String[] info = input.split("[\\s|]+");
			
			int score = Integer.parseInt(info[2]);
			String name = info[0]+" "+info[1];
			double grade = Double.parseDouble(info[3]);
			
			if (!exam.containsKey(score)) {
				exam.put(score, new TreeMap<>());
			}
			exam.get(score).put(name, grade);
			
		}
		
		for (int score : exam.keySet()) {
			System.out.print(score + " -> ");
			System.out.print(exam.get(score).keySet() + ";");
			double sum = 0;
			int count = 0;
			for (String student : exam.get(score).keySet()) {
				sum += exam.get(score).get(student);
				count++;
			}
			
			double average = sum / count;
			System.out.printf(" avg=%.2f", average);
			System.out.println();
		}
		

	}

}
