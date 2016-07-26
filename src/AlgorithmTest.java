import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import org.omg.PortableServer.POA;


public class AlgorithmTest {

	public static void main(String[] args) {
		//XCubic();
		//Rectangle();
		//Watch();
		//SmallLargeEqual();
		//Range();
		//SortingThreeNumbers();
		//CircleInARectangle();
		//PrintTestCases();
		//SwappingTwoNumbers();
		//HowManyDivisors();
		//ABProblem();
		//Circle();
		//SimpleCalculator();
		//MinMaxAndSum();
		//PrintAPectangle();
		//PrintAFrame();
		//PrintAChessboard();
		//StructuredProgramming();
		//ReversingNumbers();
		//FindingMissingCards();
		//OfficialHouse();
		//MatrixVectorMultiplication();
		//Grading();
		HowManyWays();
	}
	
	public static void HowManyWays(){
		Scanner scanner = new Scanner(System.in);
		ArrayList<Point> list = new ArrayList<Point>();
		while(true){
			int n = scanner.nextInt();
			int x = scanner.nextInt();
			if((n == 0) && (x == 0)){
				break;
			}
			list.add(new Point(n, x));
		}
		for(Point p : list){
			int count = 0;
			for(int i = 1; i <= p.x; i++){
				for(int j = i+1; j <= p.x; j++){
					for(int k = j+1; k <= p.x; k++){
						if(p.y == (i+j+k)){
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void Grading() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> grades = new ArrayList<Integer>();
		
		while (true) {
			int m = scanner.nextInt();
			int f = scanner.nextInt();
			int r = scanner.nextInt();
			
			if ((m == -1) && (f == -1) && (r == -1)) {
				break;
			}
			
			grades.add(m);
			grades.add(f);
			grades.add(r);
		}
		
		while (!grades.isEmpty()) {
			int sum = grades.get(0) + grades.get(1);
			if ((grades.get(0) == -1) || (grades.get(1) == -1)) {
				System.out.println("F");
			}else if (sum >= 80) {
				System.out.println("A");
			}else if ((sum >= 65) && (sum < 80)) {
				System.out.println("B");
			}else if ((sum >= 50) && (sum < 65)) {
				System.out.println("C");
			}else if ((sum >= 30) && (sum < 50)) {
				if (grades.get(2) >= 50) {
					System.out.println("C");
				}else {
					System.out.println("D");
				}
			}else if (sum < 30) {
				System.out.println("F");
			}
			
			for (int i = 0; i < 3; i++) {
				grades.remove(0);
			}
		}
	}
	
	public static void MatrixVectorMultiplication() {
		Scanner scanner = new Scanner(System.in);
		// n, mを入力
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] aMatrix = new int[n][m];
		int[] bMatrix = new int[m];
		
		// n x mの配列を入力
		for (int i = 0; i < aMatrix.length; i++) {
			for (int j = 0; j < aMatrix[i].length; j++) {
				aMatrix[i][j] = scanner.nextInt();
			}
		}
		
		// m x 1の配列を入力
		for (int i = 0; i < bMatrix.length; i++) {
			bMatrix[i] = scanner.nextInt();
		}
		
		// 計算結果を出力
		int[] sum = new int[n];
		for (int i = 0; i < aMatrix.length; i++) {
			for (int j = 0; j < aMatrix[i].length; j++) {
				sum[i] += aMatrix[i][j] * bMatrix[j];
			}
		}
		for (int i : sum) {
			System.out.println(i);
		}
	}
	
	public static void OfficialHouse() {
		Scanner scanner = new Scanner(System.in);
		//[棟][階][部屋]の配列を作成する
		int[][][] rooms = new int[4][3][10];
		//部屋の入居者の情報を入力
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int building = scanner.nextInt();
			int floor = scanner.nextInt();
			int room = scanner.nextInt();
			rooms[building-1][floor-1][room-1] = scanner.nextInt();
		}
		//部屋の入居状況を出力する
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				for (int k = 0; k < rooms[i][j].length; k++) {
					System.out.print(rooms[i][j][k] + " ");
				}
				System.out.println();
			}
			if (i < rooms.length-1) {
				System.out.println("####################");
			}
		}
	}
	
	public static void FindingMissingCards() {
		Scanner scanner = new Scanner(System.in);
		//入力された数だけのカードを作る
		int n = scanner.nextInt();
		ArrayList<Card> myCard = new ArrayList<Card>();
		for(int i = 0; i < n; i++){
			String mark = scanner.next();
			int number = scanner.nextInt();
			scanner.nextLine();
			myCard.add(new Card(mark, number));
		}
		//Cardのマークを保存してる配列
		String[] mark = { "S", "H", "C", "D" };
		//持っているカードをチェックして、無いカードを出力
		for (Card c : myCard) {
			//マークのループ
			for (int i = 0; i < 4; i++) {
				//数字のループ
				for (int j = 1; j <= 13; j++) {
					Card card = new Card(mark[i], j);
					if (!myCard.contains(card)) {
						System.out.println(card.toString());
					}
				}
			}
		}
	}
	
	public static void ReversingNumbers() {
		Scanner scanner = new Scanner(System.in);
		//配列を作る
		int n = scanner.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = scanner.nextInt(); 
		}
		//配列の中身を入れ替える
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length-(i+1)];
			array[array.length-(i+1)] = temp;
		}
		//配列を出力する
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length-1){
				System.out.print(" ");
			}
		}
	}
	
	public static void StructuredProgramming() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 1; i <= n; i++){
			if ((i % 3) == 0) {
				System.out.print(" " + i);
			}else if ((i % 10) == 3) {
				System.out.print(" " + i);
			}
		}
	}
	
	public static void PrintAChessboard() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Point> aList = new ArrayList<Point>();
		//H,Wに0,0が入力されるまでH,Wを入力
		int H = 1, W = 1;
		while ((H != 0) || (W != 0)) {
			H = scanner.nextInt();
			W = scanner.nextInt();
			aList.add(new Point(H, W));
		}
		//ループで奇数なら#、偶数なら.を出力
		for (Point p : aList) {
			for(int i = 0; i < p.x; i++){
				for(int j = 0; j < p.y; j++){
					if (((i+j) % 2) == 0) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void PrintAFrame() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Point> aList = new ArrayList<Point>();
		//H,Wに0,0が入力されるまでH,Wを入力
		int H = 1, W = 1;
		while ((H != 0) || (W != 0)) {
			H = scanner.nextInt();
			W = scanner.nextInt();
			aList.add(new Point(H, W));
		}
		//ループで四角の端を#で中を.で出力
		for (Point p : aList) {
			for(int i = 0; i < p.x; i++){
				for(int j = 0; j < p.y; j++){
					if ((i == 0) || (i == p.x-1)||
							(j == 0) || (j == p.y-1)) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void PrintAPectangle() {
		Scanner scanner = new Scanner(System.in);
		//H,Wどっちも0が入力されるまで、ループで長方形のH,Wを入力
		ArrayList<Integer> array = new ArrayList<Integer>();
		int H = 1,W = 1;
		while ((H != 0) || (W != 0)) {
			H = scanner.nextInt();
			W = scanner.nextInt();
			array.add(H);
			array.add(W);
		}
		//ループで#を出力する
		for(int i = 0; i < array.size(); i+=2){
			for(int j = 0; j < array.get(i); j++){
				for(int k = 0; k < array.get(i+1); k++){
					System.out.print("#");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void MinMaxAndSum() {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		//配列の数を入力
		int arrayNum = scanner.nextInt();
		int sum = 0;
		//配列の数だけ数字を入力
		for(int i = 0; i < arrayNum; i++){
			list.add(scanner.nextInt());
		}
		//配列をソートする
		Collections.sort(list);
		//合計を計算する
		for(int i : list){
			sum += i;
		}
		//最小値、最大値、合計値を出力
		System.out.println(list.pollFirst() + " " + list.pollLast() + " " + sum);
	}
	
	public static void SimpleCalculator() {
		Scanner scanner = new Scanner(System.in);
		
		int a = 0;
		String op = "";
		int b = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//計算式を入力する
		//演算子が?じゃないかチェック
		//?だったら終了、?じゃなかったら計算
		while(!op.equals("?")){
			try {
				a = scanner.nextInt();
				op = scanner.next();
				b = scanner.nextInt();
				scanner.nextLine();
			} catch (java.util.InputMismatchException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			switch (op) {
			case "+":
				result.add(a + b);
				break;
			case "-":
				result.add(a - b);
				break;
			case "*":
				result.add(a * b);
				break;
			case "/":
				result.add(a / b);
				break;
			default:
				break;
			}
		}
		//計算結果を出力する
		for(int r : result){
			System.out.println(r);
		}
	}
	
	public static void Circle() {
		Scanner scanner = new Scanner(System.in);
		
		//円の半径rを入力する
		int r = scanner.nextInt();
		
		//円の面積＝半径×半径×3.14
		double men = r * r * Math.PI;
		
		//円の円周の長さ＝2×半径×3.14
		double syu = 2 * r * Math.PI;
		
		//面積と円周の長さを出力
		System.out.println(men + " " + syu);
	}
	
	public static void ABProblem() {
		Scanner scanner = new Scanner(System.in);
		//数字を入力する
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		//数字を計算して出力する
		int d = a / b;
		int r = a % b;
		double f = (double)a / (double)b;
		
		System.out.print(d + " " + r + " ");
		System.out.printf("%.6f", f);
	}
	
	public static void HowManyDivisors() {
		Scanner scanner = new Scanner(System.in);
		//数字を入力する
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		//aからｂまでループして、cを割って残りが０ならカウントする
		int count = 0;
		for(int i = a; i <= b; ++i){
			if ((c % i) == 0) {
				count++;
			}
		}
		//カウントを出力する
		System.out.println(count);
	}
	
	public static void SwappingTwoNumbers() {
		Scanner scanner = new Scanner(System.in);
		
		//数字を保存する配列宣言
		LinkedList<Integer> pairNum = new LinkedList<Integer>();
		
		//ループで数字を入力
		int x;
		int y;
		do {
			x = scanner.nextInt();
			y = scanner.nextInt();
			pairNum.add(x);
			pairNum.add(y);
		} while ((x != 0) || (y != 0));
		
		//ループで2つずつ数字を取り出して、比べて出力する
		while(!pairNum.isEmpty()){
			x = pairNum.poll();
			y = pairNum.poll();
			if ((x == 0) && (y == 0)) {
				break;
			}
			if(x > y){
				System.out.println(y + " " + x);
			}else{
				System.out.println(x + " " + y);
			}
		}
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
