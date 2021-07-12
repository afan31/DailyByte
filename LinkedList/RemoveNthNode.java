import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

class RemoveNthNode {

  Node head;

  public void addNodeAtEnd(RemoveNthNode rn, int d) {
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

  public void printList(RemoveNthNode rn) {
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

  public void removeNthNode(int n, RemoveNthNode rn) {
    if (rn.head == null) {
      System.out.println("Enter a non-empty list");
      return;
    }
    Node curr = rn.head;
    int count = 0;
    while (curr != null) {
      count++;
      curr = curr.next;
    }
    int diff = count - n;
    if (diff < 0) {
      System.out.println("Enter a number lesser than the length of list");
      return;
    }
    curr = rn.head;
    int k = 1;
    while (k != diff) {
      curr = curr.next;
      k++;
    }
    Node temp_node = curr.next;
    curr.next = temp_node.next;
    return;
  }

  public static void main(String[] args) {
    RemoveNthNode rn = new RemoveNthNode();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter linked list length");
    int n = sc.nextInt();
    System.out.println("Enter linked list items");
    for (int i = 0; i < n; i++) {
      int d = sc.nextInt();
      rn.addNodeAtEnd(rn, d);
    }
    rn.printList(rn);
    System.out.print("Enter Nth from last node position: ");
    int p = sc.nextInt();
    rn.removeNthNode(p, rn);
    rn.printList(rn);
    sc.close();
  }
}