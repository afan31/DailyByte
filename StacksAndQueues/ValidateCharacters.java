import java.util.Scanner;

class ValidateCharacters {
  private int top;
  private int capacity;
  private char[] arr;

  ValidateCharacters(int size) {
    arr = new char[size];
    capacity = size;
    top = -1;
  }

  public void push(char x) {
    if (isFull()) {
      System.out.println("Stack is full!");
      System.exit(1);
    } else {
      System.out.println("Inserting -> " + x);
      arr[++top] = x;
    }
  }

  public char pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      System.exit(1);
    }
    System.out.println("Removing top element from stack");
    return arr[top--];
  }

  public boolean isEmpty() {
    if (top == -1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isFull() {
    if (top == capacity - 1) {
      return true;
    } else {
      return false;
    }
  }

  public char peek() {
    return arr[top];
  }

  public boolean verifyChar(char x, char y) {
    switch (y) {
      case '{':
        return x == '}';
      case '(':
        return x == ')';
      case '[':
        return x == ']';
      default:
        return false;
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter input string");
    String inp = sc.nextLine();
    char[] chars = inp.toCharArray();
    ValidateCharacters vc = new ValidateCharacters(chars.length);
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
        vc.push(chars[i]);
      } else {
        char x = chars[i];
        char y = vc.pop();
        boolean ans = vc.verifyChar(x, y);
        if (!ans) {
          System.out.println("Characters are not valid");
          return;
        }
      }
    }
    System.out.println("Characters are valid");
  }

}