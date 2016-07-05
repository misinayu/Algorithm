import java.util.ArrayList;
import java.util.Scanner;


public class AlgorithmTest {

	public static void main(String[] args) {
		//XCubic();
		//Rectangle();
		//Watch();
		//SmallLargeEqual();
		//Range();
		//SortingThreeNumbers();
		//CircleInARectangle();
		PrintTestCases();
	}
	
	public static void PrintTestCases() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> cases = new ArrayList<Integer>();
		int input;
		do {
			input = scanner.nextInt();
			cases.add(input);
		} while (input != 0);
		
		for(int i = 0; i < cases.size(); ++i){
			System.out.println("Case " + (i+1) + ": " + cases.get(i));
		}
	}
	
	public static void CircleInARectangle() {
		Scanner scanner = new Scanner(System.in);
		int[] rectanglePoint = new int[2]; // W, H
		int[] centerPoint = new int[3]; // x, y, r
		
		rectanglePoint[0] = scanner.nextInt();
		rectanglePoint[1] = scanner.nextInt();
		centerPoint[0] = scanner.nextInt();
		centerPoint[1] = scanner.nextInt();
		centerPoint[2] = scanner.nextInt();
		
		int[] edgePoint = new int[4];
		
		// x + r
		edgePoint[0] = centerPoint[0] + centerPoint[2];
		// x - r
		edgePoint[1] = centerPoint[0] - centerPoint[2];
		// y + r
		edgePoint[2] = centerPoint[1] + centerPoint[2];
		// y - r
		edgePoint[3] = centerPoint[1] + centerPoint[2];
		
		for(int i = 0; i < edgePoint.length; ++i){
			if((i % 2) == 0){
				if((0 >= edgePoint[i]) || (edgePoint[i] >= rectanglePoint[1])){
					System.out.println("No");
					return;
				}
			}else {
				if((0 >= edgePoint[i]) || (edgePoint[i] >= rectanglePoint[0])){
					System.out.println("No");
					return;
				}
			}
		}
		System.out.println("Yes");
		
	}
	
	public static void SortingThreeNumbers() {
		Scanner scanner = new Scanner(System.in);
		int[] inputNum = new int[3];
		for(int i = 0; i < inputNum.length; ++i){
			inputNum[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < inputNum.length; ++i){
			int tempNum = i;
			for(int j = i+1; j < inputNum.length; ++j){
				if (inputNum[i] > inputNum[j]) {
					tempNum = j;
				}
			}
			int temp = inputNum[i];
			inputNum[i] = inputNum[tempNum];
			inputNum[tempNum] = temp;
		}
		
		for(int i = 0; i < inputNum.length; ++i){
			System.out.print(inputNum[i] + " ");
		}
	}
	
	public static void Range() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		if((a < b) && (b < c)){
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	public static void SmallLargeEqual() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		if (a > b) {
			System.out.println(a + " > " + b);
		}else if (a == b) {
			System.out.println(a + " = " + b);
		}else {
			System.out.println(a + " < " + b);
		}
	}
	
	public static void Watch() {
		Scanner scanner = new Scanner(System.in);
		int S = scanner.nextInt();
		
		if((0 > S) || (S > 86400)){
			return;
		}
		
		int hour = S / 3600;
		int min = (S % 3600) / 60;
		int sec = (S % 3600) % 60;
		System.out.println(hour + " : " + min + " : " + sec);
	}
	
	public static void XCubic() {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.println(Math.pow(x, 3));
	}
	
	public static void Rectangle() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(a*b + " " + (a*2 + b*2));
	}
}
