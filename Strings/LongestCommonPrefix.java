import java.util.Scanner;

class LongestCommonPrefix {

  private String findLongestPrefix(String[] strArray) {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    for (char c : strArray[0].toCharArray()) {
      for (int i = 1; i < strArray.length; i++) {
        if (index >= strArray[i].length() || c != strArray[i].charAt(index)) {
          return sb.toString();
        }
      }
      index++;
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    LongestCommonPrefix lcp = new LongestCommonPrefix();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in array:");
    String n = sc.nextLine();
    int sLen = Integer.valueOf(n);
    String[] strArray = new String[sLen];
    System.out.println("Enter array elements:");
    for (int i = 0; i < sLen; i++) {
      System.out.println(i);
      strArray[i] = sc.nextLine();
    }
    String ans = lcp.findLongestPrefix(strArray);
    System.out.println("Longest common prefix for the given string array is: " + ans);
    sc.close();
  }
}