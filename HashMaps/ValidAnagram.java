import java.util.HashMap;
import java.util.Scanner;

class ValidAnagram {

  private boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    char[] chars = a.toCharArray();
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    for (int i = 0; i < chars.length; i++) {
      if (map.containsKey(chars[i])) {
        int count = map.get(chars[i]);
        count += 1;
        map.put(chars[i], count);
      } else {
        map.put(chars[i], 1);
      }
    }

    for (int i = 0; i < b.length(); i++) {
      if (map.containsKey(b.charAt(i))) {
        int count = map.get(chars[i]);
        count -= 1;
        map.put(chars[i], count);
      } else {
        return false;
      }
    }

    for (Integer val : map.values()) {
      if (val != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first word: ");
    String a = sc.nextLine();
    System.out.println("Enter second word: ");
    String b = sc.nextLine();
    ValidAnagram va = new ValidAnagram();
    boolean ans = va.isAnagram(a, b);
    System.out.println(ans);
    sc.close();
  }
}