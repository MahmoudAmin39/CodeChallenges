import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    static boolean areStringsAnagram(String first, String second) {
        if (first.length() != second.length()) { return false; }

        char[] firstStringCharsArray = first.toUpperCase().toCharArray();
        char[] secondStringCharsArray = second.toUpperCase().toCharArray();

        Arrays.sort(firstStringCharsArray);
        Arrays.sort(secondStringCharsArray);

        for (int i = 0; i < first.length(); i++) {
            if (Character.toLowerCase(firstStringCharsArray[i]) !=
                    Character.toLowerCase(secondStringCharsArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputStringsSplit = sc.nextLine().split("/");
        boolean isAnagram = areStringsAnagram(inputStringsSplit[0], inputStringsSplit[1]);
        if (isAnagram) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }
}
