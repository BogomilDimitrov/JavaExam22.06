import java.util.Scanner;


public class Problem02 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int Cx = 0;
		int Cy = 0;
		int r = 0;
		int n = 0;		
		
		String[] centerPoints = scan.nextLine().split(" ");
				
		Cx = Integer.parseInt(centerPoints[0]);
		Cy = Integer.parseInt(centerPoints[1]);

		r = Integer.parseInt(scan.nextLine());
		n = Integer.parseInt(scan.nextLine());
		
		int[] dartX = new int[n];
		int[] dartY = new int[n];
		
		for (int i = 0; i < n; i++) {
			dartX[i] = scan.nextInt();
			dartY[i] = scan.nextInt();
		}
		
		
		for (int i = 0; i < n; i++) {
			boolean firstRect = dartX[i] >= Cx-r && dartX[i] <= (Cx-r+(r/2)) && dartY[i] >= (Cy-r+(r/2)) && dartY[i] <= (Cy+r-(r/2));
			boolean secondRect = dartX[i] >= (Cx-r+(r/2)) && dartX[i] <= (Cx+r-(r/2)) && dartY[i] >= Cy-r && dartY[i] <= Cy+r;
			boolean thirdRect = dartX[i] >= (Cx+r-(r/2)) && dartX[i] <= Cx+r && dartY[i] >= (Cy-r+(r/2)) && dartY[i] <= (Cy+r-(r/2));
			
			boolean hit = firstRect||secondRect||thirdRect;
			
			if (hit) {
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}

}
