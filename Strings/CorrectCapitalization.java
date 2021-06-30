import java.util.Scanner;

class CorrectCapitalization {

  public boolean isCapitalized(String str) {
    if (str.isEmpty() || str == null) {
      return false;
    }
    char[] characters = str.toCharArray();
    int allCapsCount = 0;
    boolean firstCap = false;
    for (int i = 0; i < characters.length; i++) {
      if (i == 0) {
        int firstAscii = (int) characters[i];
        if (firstAscii >= 65 && firstAscii <= 90) {
          firstCap = true;
          allCapsCount += 1;
        }
      } else {
        int asciiVal = (int) characters[i];
        if (asciiVal >= 65 && asciiVal <= 90) {
          allCapsCount += 1;
        }
      }
    }
    if ((allCapsCount == characters.length) || (firstCap == true && allCapsCount == 1) || (allCapsCount == 0)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    CorrectCapitalization cc = new CorrectCapitalization();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    boolean ans = cc.isCapitalized(str);
    System.out.println(ans);
    sc.close();
  }
}