import java.util.*;

public class MorseCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selection = " ";

        while (selection != "e") {
            pMenu();
            selection = scanner.nextLine();

            switch (selection) {
                case "t":
                    EngToMor();
                    break;
                case "m":
                    MorToEng();
                    break;
                case "e":
                    System.out.println("Thanks for using this program!");
                    return;
                default:
                    System.out.println("***Invalid Option***");
                    System.out.println("Please enter a valid option: ");
                    continue;
            }
        }
    }

    public static void pMenu() {
        System.out.println(" ");
        System.out.println("Hello, this program allows you to translate text to morse code or translate morse code to text.\n");
        System.out.println("Please, select one of the below options");
        System.out.println("*** Enter 't' for encoding text");
        System.out.println("*** Enter 'm' for decoding morse code");
        System.out.println("*** Enter 'e' to exit the program");
    }

    public static void EngToMor() {
        char[] alp = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"};

        System.out.println("Please enter a phrase: ");
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();
        phrase = phrase.toLowerCase();
        boolean valInput = true;

        StringBuilder mCode = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            char letter = phrase.charAt(i);
            if (letter == ' ') {
                mCode.append("   ");
            } else {
                boolean found = false;
                for (int j = 0; j < alp.length; j++) {
                    if (letter == alp[j]) {
                        mCode.append(morse[j]).append(" ");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("invalid input\n");
                    valInput = false;
                    break;
                }
            }
        }
        if (valInput) {
            System.out.println("Morse Code:");
            System.out.println(mCode.toString());
        }

    }

    public static void MorToEng() {
        char[] alp = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"};

        System.out.println("Please enter a morse code: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();

        StringBuilder eng = new StringBuilder();

        String[] words = code.split("   ");

        boolean valInput = true;

        for (String word : words) {
            String[] letters = word.split(" ");

            for (String letter : letters) {
                boolean found = false;
                for (int i = 0; i < morse.length; i++) {
                    if (letter.equals(morse[i])) {
                        eng.append(alp[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("invalid input\n");
                    valInput = false;
                    break;
                }
            }
            eng.append(" ");
        }

        if (valInput) {
            System.out.println("Normal Text:");
            System.out.println(eng.toString().toUpperCase());
        }
    }

}


