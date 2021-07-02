import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

class UncommonWords {
  private void findUncommonWords(String a, String b) {
    HashSet<String> set = new HashSet<String>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    String[] firstSentenceWords = a.split(" ");
    String[] secondSentenceWords = b.split(" ");
    for (String c : firstSentenceWords) {
      if (map.containsKey(c)) {
        int count = map.get(c);
        count = count + 1;
        map.put(c, count);
      } else {
        map.put(c, 1);
      }
    }
    for (String d : secondSentenceWords) {
      if (map.containsKey(d)) {
        int count = map.get(d);
        if (count == 1) {
          map.remove(d);
        } else {
          count -= 1;
          map.put(d, count);
        }
      } else {
        map.put(d, 1);
      }
    }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      set.add(entry.getKey());
    }
    System.out.println(set);
  }

  public static void main(String[] args) {
    UncommonWords u = new UncommonWords();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first sentence:");
    String a = sc.nextLine();
    System.out.println("Enter second sentence:");
    String b = sc.nextLine();
    u.findUncommonWords(a, b);
    sc.close();
  }

}