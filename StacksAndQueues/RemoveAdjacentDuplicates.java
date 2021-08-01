import java.util.Scanner;

class RemoveAdjacentDuplicates {
  private int top;
  private int capacity;
  private char[] arr;

  RemoveAdjacentDuplicates(int d) {
    arr = new char[d];
    top = -1;
    capacity = d;
  }

  private void push(char c) {
    if (isFull()) {
      System.out.println("Stack is full!");
      System.exit(1);
    } else {
      char topChar = peek();
      if (topChar == c) {
        pop();
      } else {
        arr[++top] = c;
      }
    }
  }

  private boolean isFull() {
    return top == capacity - 1;
  }

  private void pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty!");
      System.exit(1);
    } else {
      top--;
    }
  }

  private boolean isEmpty() {
    return top == -1;
  }

  private char peek() {
    if (top != -1) {
      return arr[top];
    } else {
      return ' ';
    }
  }

  private String printResultantString() {
    char[] ans = new char[top + 1];
    for (int i = 0; i <= top; i++) {
      ans[i] = arr[i];
    }
    String res = String.valueOf(ans);
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter string to be evaluated:");
    String str = sc.nextLine();
    char[] chars = str.toCharArray();
    int str_len = chars.length;
    RemoveAdjacentDuplicates rd = new RemoveAdjacentDuplicates(str_len);
    for (int i = 0; i < str_len; i++) {
      rd.push(chars[i]);
    }
    System.out.println("Resultant string:");
    String evaluatedStr = rd.printResultantString();
    System.out.println(evaluatedStr);
    sc.close();
  }
}