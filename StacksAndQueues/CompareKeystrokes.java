import java.util.Scanner;

class CompareKeystrokes {
  private int top;
  private int capacity;
  private char[] arr;

  CompareKeystrokes(int d) {
    arr = new char[d];
    capacity = d;
    top = -1;
  }

  private void push(char c) {
    if (isFull()) {
      System.out.println("Stack is full!");
      System.exit(1);
    }
    arr[++top] = c;
  }

  private boolean isFull() {
    return top == capacity - 1;
  }

  private void printStack() {
    for (int i = 0; i <= top; i++) {
      System.out.println(arr[i]);
    }
  }

  private char pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty!");
      System.exit(1);
    }
    char c = arr[top--];
    return c;
  }

  private boolean isEmpty() {
    return top == -1;
  }

  private int size() {
    return top;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first string");
    String a = sc.nextLine();
    char[] chars_a = a.toCharArray();
    int n = chars_a.length;
    CompareKeystrokes ck = new CompareKeystrokes(n);
    for (int i = 0; i < n; i++) {
      if (chars_a[i] == '#') {
        ck.pop();
      } else {
        ck.push(chars_a[i]);
      }
    }
    System.out.println("Print stack for first string");
    ck.printStack();
    System.out.println("Enter second string");
    String b = sc.nextLine();
    CompareKeystrokes ckn = new CompareKeystrokes(n);
    char[] chars_b = b.toCharArray();
    int p = chars_b.length;
    for (int i = 0; i < p; i++) {
      if (chars_b[i] == '#') {
        ckn.pop();
      } else {
        ckn.push(chars_b[i]);
      }
    }
    System.out.println("Print stack for second string");
    ckn.printStack();
    boolean ans = true;
    if (ck.size() != ckn.size()) {
      ans = false;
    } else {
      for (int i = 0; i < ck.size(); i++) {
        char c = ck.pop();
        char d = ckn.pop();
        if (c != d) {
          ans = false;
          break;
        }
      }
    }
    System.out.println(ans);
    sc.close();
  }
}