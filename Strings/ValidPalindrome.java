import java.util.Scanner;

class ValidPalindrome {

  public boolean isPalindrome(String str) {
    if (str == null) {
      return false;
    }
    str = str.replaceAll("[^A-Za-z]+", "");
    if (str == "" || str.length() == 1) {
      return true;
    }
    char[] characters = str.toCharArray();
    int n = characters.length;
    int frontPointer = 0;
    int backPointer = n - 1;
    for (int i = 0; i < n / 2; i++) {
      char a = characters[frontPointer];
      char b = characters[backPointer];
      if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
        return false;
      } else {
        frontPointer += 1;
        backPointer -= 1;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    ValidPalindrome vp = new ValidPalindrome();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    boolean ans = vp.isPalindrome(str);
    System.out.println(ans);
    sc.close();
  }
}