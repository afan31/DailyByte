import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SpotTheDifference {

  private char findDifference(String s, String t) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        int count = map.get(c);
        count = count + 1;
        map.put(c, count);
      } else {
        map.put(c, 1);
      }
    }

    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (map.containsKey(c)) {
        int count = map.get(c);
        count = count - 1;
        map.put(c, count);
      } else {
        map.put(c, -1);
      }
    }

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() == -1) {
        return entry.getKey();
      }
    }
    return ' ';
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first string");
    String s = sc.nextLine();
    System.out.println("Enter second string");
    String t = sc.nextLine();
    SpotTheDifference sd = new SpotTheDifference();
    char ans = sd.findDifference(s, t);
    System.out.println("Difference is: " + ans);
    sc.close();
  }
}