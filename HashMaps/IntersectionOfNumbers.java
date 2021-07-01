import java.util.HashMap;
import java.util.Scanner;

class IntersectionOfNumbers {
  private void findIntersection(int[] a, int[] b) {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i = 0; i < a.length; i++) {
      if (hm.containsKey(a[i])) {
        int count = hm.get(a[i]);
        count += 1;
        hm.put(a[i], count);
      } else {
        hm.put(a[i], 1);
      }
    }
    int[] ans = new int[b.length];
    int k = 0;
    for (int i = 0; i < b.length; i++) {
      if (hm.containsKey(b[i])) {
        if (hm.get(b[i]) != 0) {
          ans[k] = b[i];
          k++;
          int count = hm.get(b[i]);
          count -= 1;
          hm.put(b[i], count);
        }
      }
    }
    System.out.println("Intersection elements of the arrays are: ");
    System.out.print("[");
    for (int i = 0; i < k; i++) {
      System.out.print(ans[i]);
      if (i != k - 1) {
        System.out.print(",");
      } else {
        System.out.println("]");
      }
    }
  }

  public static void main(String[] args) {
    IntersectionOfNumbers in = new IntersectionOfNumbers();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter length of 1st number array");
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Enter length of 2nd number array");
    int m = sc.nextInt();
    int[] arr2 = new int[m];
    for (int j = 0; j < m; j++) {
      arr2[j] = sc.nextInt();
    }
    sc.close();
    in.findIntersection(arr, arr2);
  }
}