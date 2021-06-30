import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TwoSum {
  private boolean findSum(int[] arr, int k) {
    // arr = [4,2,6,5,2]
    // k = 4
    // arr = [1,3,8,2]
    // k = 10
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        return true;
      }
      map.put(k - arr[i], i);
    }
    return false;
  }

  public static void main(String[] args) {
    TwoSum ts = new TwoSum();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of elements in array");
    int n = sc.nextInt();
    int[] inputArr = new int[n];
    for (int i = 0; i < n; i++) {
      int order = i + 1;
      System.out.println("Enter number: " + order);
      inputArr[i] = sc.nextInt();
    }
    System.out.println("Enter value for k: ");
    int k = sc.nextInt();
    boolean ans = ts.findSum(inputArr, k);
    System.out.println(ans);
    sc.close();
  }
}