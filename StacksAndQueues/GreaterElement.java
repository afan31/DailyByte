import java.util.HashMap;
import java.util.Scanner;

class CustomStack {
  private int top;
  private int capacity;
  private int[] arr;

  CustomStack(int d) {
    top = -1;
    capacity = d;
    arr = new int[d];
  }

  public void push(int c) {
    if (isFull()) {
      System.out.println("Stack is full!");
      System.exit(1);
    } else {
      arr[++top] = c;
    }
  }

  public boolean isFull() {
    return top == capacity - 1;
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty!");
      return -1;
    } else {
      int d = arr[top--];
      return d;
    }
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public int peek() {
    if (top != -1) {
      return arr[top];
    } else {
      return ' ';
    }
  }
}

class GreaterElement {

  private void findNextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    CustomStack cs = new CustomStack(nums2.length);
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums2.length; i++) {
      while (!cs.isEmpty() && nums2[i] > cs.peek()) {
        hm.put(cs.pop(), nums2[i]);
      }
      cs.push(nums2[i]);
    }
    while (!cs.isEmpty()) {
      hm.put(cs.pop(), -1);
    }
    for (int i = 0; i < nums1.length; i++) {
      result[i] = hm.get(nums1[i]);
    }
    System.out.println("Resultant array is:");
    System.out.print("[");
    for (int i = 0; i < result.length; i++) {
      if (i == result.length - 1) {
        System.out.print(result[i]);
      } else {
        System.out.print(result[i] + ",");
      }
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter length of num1 array:");
    int n = sc.nextInt();
    int[] nums1 = new int[n];
    System.out.println("Enter elemets of num1 array:");
    for (int i = 0; i < n; i++) {
      nums1[i] = sc.nextInt();
    }
    System.out.println("Enter length of num2 array:");
    int m = sc.nextInt();
    int[] nums2 = new int[m];
    System.out.println("Enter elemets of num1 array:");
    for (int i = 0; i < m; i++) {
      nums2[i] = sc.nextInt();
    }
    GreaterElement ge = new GreaterElement();
    ge.findNextGreaterElement(nums1, nums2);
    sc.close();
  }

}