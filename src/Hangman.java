import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	private static String word;
	private static String guessedWord;
	private static int counter;
	private static ArrayList<Character> guessedLetters = new ArrayList<Character>();
	
	public Hangman() {
		generateWord();
	}
	
	public static void guessCharacter(char arg) {
		if(guessedWord.contains(String.valueOf(arg))) return;
		for(char c : guessedLetters) if(c == arg) return;
		if(word.toLowerCase().contains(String.valueOf(arg))) {
		
			char[] ch = guessedWord.toCharArray();
			for(int i=0; i < ch.length; i++) {
				if(word.charAt(i) == arg) {
					ch[i] = arg;
				}
			}
			
			guessedWord = String.valueOf(ch);
			System.out.println("RÄTT!");
		
		} else {
			writeMan();
		}
		
		writeLine();
		System.out.println(guessedWord);
		if(!guessedWord.contains(String.valueOf("-"))) {
			System.out.println("Du vann!");
			generateWord();
		}
		guessedLetters.add(arg);
	}
	
	public static void generateWord() {
		counter = 0;
		guessedWord = "";
		guessedLetters = new ArrayList<Character>();
		ArrayList<String> words = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File("ord.txt"));
			while(scanner.hasNext()) words.add(scanner.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		word = words.get(new Random().nextInt(words.size())); 
		for(int i=0; i < word.length(); i++) guessedWord += "-";
		System.out.println("Ord genererat");
		System.out.println(guessedWord);
		
	}
	
	private static void writeMan() {
		counter++;
		if(counter < 7) {
			System.out.println("FEL!");
		}
		if (counter == 1) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (counter == 2) {
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (counter == 3) {
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (counter == 4) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (counter == 5) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (counter == 6) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		
		if (counter == 7) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("Du förlora! ordet var " + word);
			generateWord();
		}
	}
	private static void writeLine() {
		System.out.println("________________________________________________\n");
	}
}
