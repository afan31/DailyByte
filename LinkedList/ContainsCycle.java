import java.util.Scanner;
import java.lang.Math;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

class ContainsCycle {
  Node head;
  Node last;

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
    last = curr.next;
    return;
  }

  public void makeCircular() {
    last.next = head;
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

  public boolean isCyclePresent() {
    if (head == null) {
      return false;
    }
    Node slow = head;
    Node fast = head;
    while (true) {
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return false;
      }
      if (fast == null || slow == null) {
        return false;
      }
      if (fast.data == slow.data) {
        return true;
      }
    }
  }

  public static void main(String[] args) {
    ContainsCycle cc = new ContainsCycle();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter linked list length");
    int n = sc.nextInt();
    System.out.println("Enter linked list items");
    for (int i = 0; i < n; i++) {
      int d = sc.nextInt();
      cc.addNodeAtEnd(d);
    }
    cc.printList();
    cc.makeCircular();
    boolean ans = cc.isCyclePresent();
    System.out.println(ans);
    sc.close();
  }
}