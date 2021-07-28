import java.util.Scanner;

class Stack {
  private int top;
  private int capacity;
  private int[] arr;

  Stack(int size) {
    arr = new int[size];
    capacity = size;
    top = -1; // use index 0 to start
  }

  public void push(int x) {
    if (isFull()) {
      System.out.println("Overflow\nProgram Terminated");
      System.exit(1);
    }
    System.out.println("Inserting -> " + x);
    arr[++top] = x;
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("STACK EMPTY");
      System.exit(1);
    }
    System.out.println("Removing top element from stack");
    return arr[top--];
  }

  public boolean isFull() {
    if (top == capacity - 1) {
      return true;
    }
    return false;
  }

  public boolean isEmpty() {
    if (top == -1) {
      return true;
    }
    return false;
  }

  public int size() {
    return top + 1;
  }

  public void printStack() {
    for (int i = 0; i <= top; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of stack");
    int n = sc.nextInt();
    Stack st = new Stack(n);
    for (int i = 0; i < n; i++) {
      System.out.println("Enter stack items");
      int x = sc.nextInt();
      st.push(x);
    }
    System.out.println("Printing elements of stack:");
    st.printStack();
    st.pop();
    st.pop();
    System.out.println("Printing elements of stack after pop");
    st.printStack();
    sc.close();
  }

}