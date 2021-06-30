import java.util.Scanner;

class VacuumCleanerRoute {

  private boolean isValidRoute(String str) {
    if (str.isEmpty() || str == null || str.length() == 1) {
      return false;
    }
    char[] characters = str.toCharArray();
    int countLeft = 0;
    int countRight = 0;
    int countUp = 0;
    int countDown = 0;
    for (int i = 0; i < characters.length; i++) {
      switch (characters[i]) {
        case 'L':
          countLeft += 1;
          break;
        case 'R':
          countRight += 1;
          break;
        case 'U':
          countUp += 1;
          break;
        case 'D':
          countDown += 1;
          break;
        default:
          return false;
      }
    }
    if ((countLeft == countRight) && (countUp == countDown)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    VacuumCleanerRoute vc = new VacuumCleanerRoute();
    String str = sc.nextLine();
    boolean ans = vc.isValidRoute(str);
    System.out.println(ans);
    sc.close();
  }
}