import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class JewelsAndStones {

  private int findCommonCount(String jewels, String stones) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    char[] jewelChars = jewels.toCharArray();
    for (int i = 0; i < jewelChars.length; i++) {
      map.put(jewelChars[i], i);
    }
    char[] stoneChars = stones.toCharArray();
    int count = 0;
    for (int i = 0; i < stoneChars.length; i++) {
      if (map.containsKey(stoneChars[i])) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    JewelsAndStones js = new JewelsAndStones();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter jewels:");
    String jewels = sc.nextLine();
    System.out.println("Enter stones:");
    String stones = sc.nextLine();
    int ans = js.findCommonCount(jewels, stones);
    System.out.println(ans);
    sc.close();

  }
}