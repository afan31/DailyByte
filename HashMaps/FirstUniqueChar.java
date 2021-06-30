import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class FirstUniqueChar {

  private int findIndex(String a) {
    LinkedHashMap<Character, Boolean> map = new LinkedHashMap<Character, Boolean>();
    char[] characters = a.toCharArray();
    for (int i = 0; i < characters.length; i++) {
      if (map.containsKey(characters[i])) {
        map.put(characters[i], false);
      } else {
        map.put(characters[i], true);
      }
    }

    for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
      if (entry.getValue() == true) {
        char c = entry.getKey();
        return a.indexOf(c);
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    FirstUniqueChar fc = new FirstUniqueChar();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string");
    String inp = sc.nextLine();
    int ans = fc.findIndex(inp);
    System.out.println("First unique character is at index: " + String.valueOf(ans));
    sc.close();
  }
}