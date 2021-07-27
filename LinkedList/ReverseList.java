import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

class ReverseList {
  Node head;

  public void addNodeAtEnd(int d) {
    if (head == null) {
      head = new Node(d);
      return;
    }
    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = new Node(d);
    return;
  }

  public void printList() {
    if (head == null) {
      System.out.println("Empty List");
    }
    Node curr = head;
    System.out.print("[");
    while (curr != null) {
      System.out.print(curr.data);
      if (curr.next != null) {
        System.out.print(",");
      }
      curr = curr.next;
    }
    System.out.println("]");
  }

  public Node reverseList() {
    Node previous = null;
    while (head != null) {
      Node next = head.next;
      head.next = previous;
      previous = head;
      head = next;
    }
    return previous;
  }

  public void printListInReverse(Node prev) {
    if (prev == null) {
      System.out.println("Empty List");
    }
    Node curr = prev;
    System.out.print("[");
    while (curr != null) {
      System.out.print(curr.data);
      if (curr.next != null) {
        System.out.print(",");
      }
      curr = curr.next;
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    ReverseList rl = new ReverseList();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter linked list length");
    int n = sc.nextInt();
    System.out.println("Enter linked list items");
    for (int i = 0; i < n; i++) {
      int d = sc.nextInt();
      rl.addNodeAtEnd(d);
    }
    rl.printList();
    Node prev = rl.reverseList();
    System.out.println("Reversed elements in linked list");
    rl.printListInReverse(prev);
    sc.close();
  }
}