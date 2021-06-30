import java.util.Scanner;
import java.lang.StringBuilder;

class AddBinary {
  private String add(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int sum = 0;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      sum = carry;
      if (i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        sum += b.charAt(j--) - '0';
      }

      sb.append(sum % 2);
      carry = sum / 2;
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    AddBinary ab = new AddBinary();
    Scanner sc = new Scanner(System.in);
    String a = sc.nextLine();
    String b = sc.nextLine();
    String ans = ab.add(a, b);
    System.out.println(ans);
    sc.close();

  }
}