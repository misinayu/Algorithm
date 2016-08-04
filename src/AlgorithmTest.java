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
		//HowManyWays();
		//Spreadsheet();
		//MatrixMultiplication();
		//TogglingCases();
		//SumOfNumbers();
		//CountingCharacters();
		//Ring();
		//FindingAWord();
		//Shuffle();
		//CardGame();
		//Transformation();
		Distance();
	}
	
	public static void Distance() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Point> points = new ArrayList<Point>();
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		points.add(new Point(x1, y1));
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		points.add(new Point(x2, y2));
		
		int x = 0, y = 0;
		for (Point p : points) {
			if(((p.x > 0) && (p.y > 0)) ||
					((p.x < 0) && (p.y < 0))){
				x -= p.x;
				y -= p.y;
			}else{
				x += p.x;
				y += p.y;
			}
		}
		
		double distance = Math.sqrt(Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2));
		System.out.println(distance);
	}
	
	public static void Transformation() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char[] strChar = str.toCharArray();
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			int a = 0;
			int b = 0;
			String order = scanner.next();
			
			switch (order) {
			case "print":
				a = scanner.nextInt();
				b = scanner.nextInt();
				for (int j = a; j <= b; j++) {
					System.out.print(strChar[j]);
				}
				System.out.println();
				break;
				
			case "reverse":
				a = scanner.nextInt();
				b = scanner.nextInt();
				int kijyun = (a+b)/2;
				while(a <= kijyun){
					char temp = strChar[a];
					strChar[a] = strChar[b];
					strChar[b] = temp;
					a++;
					b--;
				}
				break;
				
			case "replace":
				a = scanner.nextInt();
				b = scanner.nextInt();
				String temp = scanner.nextLine();
				char[] tempChar = temp.toCharArray();
				for (int j = a; j <= b; j++) {
					strChar[a] = tempChar[j];
					a++;
				}
				break;
				
			default:
				System.out.println("入力ミスじゃな！");
				break;
			}
		}
	}
	
	public static void CardGame() {
		Scanner scanner = new Scanner(System.in);
		int taro = 0;
		int hanako = 0;
		
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String taroStr = scanner.next();
			String hanakoStr = scanner.next();
			scanner.nextLine();
			
			for (int k = 0; k < taroStr.length(); k++) {
				if(hanakoStr.isEmpty()){ break; }
				if(taroStr.charAt(k) > hanakoStr.charAt(k)){
					taro += 3;
					break;
				}else if(taroStr.charAt(k) == hanakoStr.charAt(k)){
					if(k == taroStr.length()-1){
						taro++;
						hanako++;
					}
				}else if(taroStr.charAt(k) < hanakoStr.charAt(k)){
					hanako += 3;
					break;
				}
			}
		}
		
		System.out.println(taro + " " + hanako);
	}
	
	public static void Shuffle() {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Character> strChar = new LinkedList<Character>();
		
		String str = scanner.nextLine();
		int m = scanner.nextInt();
		
		for (int i = 0; i < str.length(); i++) {
			strChar.add(str.charAt(i));
		}
		
		for (int i = 0; i < m; i++) {
			int h = scanner.nextInt();
			for (int j = 0; j < h; j++) {
				strChar.add(strChar.poll());
			}
		}
		
		for (Character character : strChar) {
			System.out.print(character);
		}
	}
	
	public static void FindingAWord() {
		Scanner scanner = new Scanner(System.in);
		String strT = new String();
		String strEND = "END_OF_TEXT";
		int count = 0;
		
		String strW = scanner.next();
		scanner.nextLine();
		
		while(true){
			String input = scanner.nextLine();
			if(input.equals(strEND)){ break; }
			strT += input;
		}
		
		if(!strT.contains(strW)){
			System.out.println(count);
			return;
		}
		
		for (int i = 0; i < strT.length(); i++) {
			if(strT.charAt(i) == strW.charAt(0)){
				int k = i;
				for (int j = 0; j < strW.length(); j++) {
					if(strT.charAt(k) != strW.charAt(j)){
						break;
					}
					
					if(j == strW.length()-1){
						count++;
					}
					
					k++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static void Ring() {
		Scanner scanner = new Scanner(System.in);
		boolean result = false;
		String strS = scanner.nextLine();
		String strP = scanner.nextLine();
		
		//回転しないで文字列Sの中に文字列Pが入っているか検査
		if(strS.contains(strP)){
			System.out.println("YES");
			return;
		}
		
		//文字列Sが回転した状態で文字列Pが入っているか検査
		for (int i = 0; i < strS.length(); i++) {
			if(result){ break; } //trueなら入っているので、もう検査しなくて良い
			
			if(strS.charAt(i) == strP.charAt(0)){
				int k = i; //文字列Sの検査を始める最初のとこ
				for (int j = 0; j < strP.length(); j++) {
					if(k >= strS.length()){
						k = 0;
					}
					
					if(strS.charAt(k) != strP.charAt(j)){
						break;
					}
					
					if(j == strP.length()-1){
						result = true;
					}
					
					k++;
				}
			}
		}
		
		//結果を出力
		if(result){
			System.out.println("YES");
		}else{
			System.out.println("No");
		}
	}
	
	public static void CountingCharacters() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int[] count = new int[26];
		//文字の数を計算
		for (int i = 0; i < str.length(); i++) {
			char n = str.charAt(i);
			n = Character.toLowerCase(n);
			if(n != ' '){
				count[n - 97]+=1;
			}
		}
		//文字の数を出力
		for (int i = 0; i < count.length; i++) {
			System.out.println(('a'+i) + " : " + count[i]);
		}
	}
	
	public static void SumOfNumbers() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		//0が入力されるまで数字を入力
		while(true){
			System.out.println("Please input number(under 10000)>>>");
			int n = scanner.nextInt();
			if(n == 0){ break; }
			if(n / 10000 != 0){ break; }
			
			list.add(n);
		}
		
		for (int i : list) {
			int thousand = i / 1000;
			int hundred = (i % 1000) / 100;
			int ten = ((i % 1000) % 100) / 10;
			int one = ((i % 1000) % 100) % 10;
			int sum = thousand + hundred + ten + one;
			System.out.println(sum);
		}
	}
	
	public static void TogglingCases() {
		Scanner scanner = new Scanner(System.in);
		//文字列を入力
		String str = new String();
		str = scanner.nextLine();
		char[] charArray = str.toCharArray();
		
		//大文字を小文字に、小文字を大文字に
		for (int i = 0; i < charArray.length; i++) {
			if(Character.isUpperCase(charArray[i])){
				charArray[i] = Character.toLowerCase(charArray[i]);
			}else {
				charArray[i] = Character.toUpperCase(charArray[i]);
			}
		}
		
		//文字列を出力
		String strResult = String.valueOf(charArray);
		System.out.println(strResult);
	}
	
	public static void MatrixMultiplication() {
		Scanner scanner = new Scanner(System.in);
		//配列A(n x m), 配列B(m x l)の大きさを入力
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int l = scanner.nextInt();
		
		int[][] arrayA = new int[n][m];
		int[][] arrayB = new int[m][l];
		int[][] arrayResult = new int[n][l];
		
		//配列A, 配列Bのの中身を入力
		for (int i = 0; i < arrayA.length; i++) {
			for (int j = 0; j < arrayA[i].length; j++) {
				arrayA[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < arrayB.length; i++) {
			for (int j = 0; j < arrayB[i].length; j++) {
				arrayB[i][j] = scanner.nextInt();
			}
		}
		
		//配列A x 配列Bを計算
		for (int i = 0; i < arrayResult.length; i++) {
			for (int j = 0; j < arrayResult[i].length; j++) {
				for (int k = 0; k < m; k++) {
					arrayResult[i][j] += arrayA[i][k] * arrayB[k][j];
				} 
			}
		}
		
		//計算結果の配列を出力する
		for (int i = 0; i < arrayResult.length; i++) {
			for (int j = 0; j < arrayResult[i].length; j++) {
				System.out.print(arrayResult[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void Spreadsheet() {
		Scanner scanner = new Scanner(System.in);
		//表の大きさを入力
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		
		//表の中身を入力
		int[][] array = new int[r+1][c+1];
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				array[i][j] = scanner.nextInt();
			}
		}
		
		//表の行を計算
		for(int i = 0; i < r; i++){
			int sum = 0;
			for(int j = 0; j < c; j++){
				sum += array[i][j];
			}
			array[i][c] = sum;
		}
		
		//表の行を計算
		for(int i = 0; i < c; i++){
			int sum = 0;
			for(int j = 0; j < r; j++){
				sum += array[j][i];
			}
			array[r][i] = sum;
		}
		
		//すべての合計を計算
		for(int i = 0; i < r; i++){
			array[r][c] += array[i][c];
		}
		
		//表の中身を出力
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
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
