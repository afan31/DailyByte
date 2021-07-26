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

class MiddleElement {
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

  public int findMiddleElement() {
    if (head == null) {
      return -1;
    }
    Node curr = head;
    int c = 0;
    while (curr != null) {
      c++;
      curr = curr.next;
    }
    double middleIndex = Math.ceil(c / 2);

    Node dummy = new Node(-1);
    dummy.next = head;
    while (middleIndex >= 0) {
      dummy = dummy.next;
      middleIndex--;
    }
    return dummy.data;
  }

  public static void main(String[] args) {
    MiddleElement me = new MiddleElement();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter linked list length");
    int n = sc.nextInt();
    System.out.println("Enter elements of linked list");
    for (int i = 0; i < n; i++) {
      int d = sc.nextInt();
      me.addNodeAtEnd(d);
    }
    me.printList();
    int ans = me.findMiddleElement();
    System.out.println("Middle Element: " + Integer.valueOf(ans));
    sc.close();

  }
}