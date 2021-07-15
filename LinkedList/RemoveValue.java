import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

class RemoveValue {
  Node head;

  public void addNodeAtEnd(RemoveValue rn, int d) {
    Node node = new Node(d);
    if (rn.head == null) {
      rn.head = node;
      return;
    }
    Node curr = rn.head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = node;
    return;
  }

  public void printList(RemoveValue rn) {
    if (rn.head == null) {
      System.out.println("");
      return;
    }
    Node curr = rn.head;
    System.out.print("Linked List: [");
    while (curr != null) {
      System.out.print(curr.data);
      if (curr.next != null) {
        System.out.print(",");
      }
      curr = curr.next;
    }
    System.out.println("]");
    return;
  }

  public void removeValue(RemoveValue rv, int val) {
    while (rv.head != null && rv.head.data == val) {
      rv.head = rv.head.next;
    }
    Node curr = rv.head;
    while (curr != null) {
      if (curr.next != null && curr.next.data == val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
  }

  public static void main(String[] args) {
    RemoveValue rv = new RemoveValue();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter linked list length");
    int n = sc.nextInt();
    System.out.println("Enter linked list items");
    for (int i = 0; i < n; i++) {
      int d = sc.nextInt();
      rv.addNodeAtEnd(rv, d);
    }
    rv.printList(rv);
    System.out.print("Enter value to be removed: ");
    int p = sc.nextInt();
    rv.removeValue(rv, p);
    rv.printList(rv);
  }
}