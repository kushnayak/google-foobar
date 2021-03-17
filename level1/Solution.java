import java.util.Arrays;
import java.util.HashMap;

public class challenge1 {

    public static String solution(String s) {
        final String[][] braille = {
                {"a", "100000"},
                {"b", "110000"},
                {"c", "100100"},
                {"d", "100110"},
                {"e", "100010"},
                {"f", "110100"},
                {"g", "110110"},
                {"h", "110010"},
                {"i", "010100"},
                {"j", "010110"},
                {"k", "101000"},
                {"l", "111000"},
                {"m", "101100"},
                {"n", "101110"},
                {"o", "101010"},
                {"p", "111100"},
                {"q", "111110"},
                {"r", "111010"},
                {"s", "011100"},
                {"t", "011110"},
                {"u", "101001"},
                {"v", "111001"},
                {"w", "010111"},
                {"x", "101101"},
                {"y", "101111"},
                {"z", "101011"}
        };
        final String capital = "000001";
        final String space = "000000";

        HashMap<Character, String> map = new HashMap<>();
        for (String[] code : braille)
            map.put(code[0].charAt(0), code[1]);

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                ans.append(space);
            } else {
                if(Character.isUpperCase(c)) {
                    ans.append(capital);
                    ans.append(map.get(Character.toLowerCase(c)));
                } else {
                    ans.append(map.get(c));
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word: ");
        String ans = challenge1.solution(sc.nextLine());
        System.out.println("Enter intended sol: ");
        String sol = new Scanner(System.in).nextLine();
        System.out.println(ans.equals(sol));

    }
}
