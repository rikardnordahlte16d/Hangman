import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Hangman hangman = new Hangman();
		
		while(true) {
			char c = scanner.nextLine().toLowerCase().charAt(0);
			hangman.guessCharacter(c);
		}
	}
}
