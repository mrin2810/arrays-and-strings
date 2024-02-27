import java.util.*;

public class UniqueStringCharacters {

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    private static boolean isUniqueCharactersBasic(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch: str.toCharArray()) {
            if (map.containsKey(ch)) {
                return false;
            }
            map.put(ch, 1);
        }
        return true;
    }

    private static boolean isUnique(String str) {
        boolean[] map = new boolean[128];
        Arrays.fill(map, false);
        for (int i = 0; i < str.length(); i++) {
            if (map[str.charAt(i)]) {
                return false;
            }
            map[str.charAt(i)] = true;
        }
        return true;
    }

    private static boolean isUniqueBit(String str) {
        return true;
    }

    /**
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     */
    private static boolean isUniqueCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(ch.equals('*')){
                return false;
            }
            str = str.replace(ch, '*');
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strArr = {"Unique", "Reuses", "Boolean"};
        for (String str: strArr) {
            boolean answer = UniqueStringCharacters.isUniqueCharactersBasic(str);
            boolean answer2 = UniqueStringCharacters.isUniqueCharacter(str);
            boolean answer3 = UniqueStringCharacters.isUnique(str);
            System.out.println("Answer is " + answer + " " + answer2 + " " + answer3);
        }
    }
}