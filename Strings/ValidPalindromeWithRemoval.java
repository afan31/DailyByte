import java.util.Scanner;

class ValidPalindromeWithRemoval {

  private boolean findPalindrome(String str) {
    char[] characters = str.toCharArray();
    int n = characters.length;
    int frontPointer = 0;
    int backPointer = n - 1;
    int k = 0;
    for (int i = 0; i < n / 2; i++) {
      if (characters[frontPointer] != characters[backPointer]) {
        k += 1;
        frontPointer++;
      }
      if (k > 1) {
        return false;
      }
      frontPointer++;
      backPointer--;
    }
    return true;
  }

  public static void main(String[] args) {
    ValidPalindromeWithRemoval vp = new ValidPalindromeWithRemoval();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    boolean ans = vp.findPalindrome(str);
    System.out.println(ans);
    sc.close();
  }
}