import java.util.Scanner;

class ReverseString {

  public String reverse(String inp) {
    if (inp == "" || inp == null || inp.length() == 1) {
      return inp;
    }

    String[] words = inp.split(" ");
    String res = "";
    for (int i = words.length - 1; i >= 0; i--) {
      res = res.concat(reverseWord(words[i]));
      res = res.concat(" ");
    }
    return res;
  }

  public String reverseWord(String ans) {
    char[] characters = ans.toCharArray();
    int n = characters.length;
    char[] temp = new char[n];
    int k = n;
    for (int i = 0; i < n; i++) {
      temp[k - 1] = characters[i];
      k -= 1;
      if (k < 0) {
        break;
      }
    }
    return new String(temp);
  }

  public static void main(String[] args) {
    ReverseString rs = new ReverseString();
    Scanner sn = new Scanner(System.in);
    String str = sn.nextLine();
    String ans = rs.reverse(str);
    System.out.println(ans);
    sn.close();
  }

}
