import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

class MergeLinkedLists {
  Node head;

  private MergeLinkedLists insertAtEnd(MergeLinkedLists ml, int n) {
    Node node = new Node(n);

    if (ml.head == null) {
      ml.head = node;
      return ml;
    }
    Node curr = ml.head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = node;
    return ml;
  }

  private void printLinkedList(MergeLinkedLists ml) {
    if (ml.head == null) {
      System.out.println("");
    }
    System.out.print("Linked list: [ ");
    Node curr = ml.head;
    while (curr != null) {
      System.out.print(curr.data);
      if (curr.next != null) {
        System.out.print(" , ");
      }
      curr = curr.next;
    }
    System.out.println(" ]");
  }

  private Node mergeLists(MergeLinkedLists ml1, MergeLinkedLists ml2) {
    Node curr1 = ml1.head;
    Node curr2 = ml2.head;
    Node dummy = new Node(-1);
    head = dummy;
    while (curr1 != null && curr2 != null) {
      if (curr1.data < curr2.data) {
        dummy.next = curr1;
        curr1 = curr1.next;
      } else {
        dummy.next = curr2;
        curr2 = curr2.next;
      }
      dummy = dummy.next;
    }
    if (curr1 != null) {
      dummy.next = curr1;
    } else {
      dummy.next = curr2;
    }
    head = head.next;
    return head;
  }

  public static void main(String[] args) {
    MergeLinkedLists ml = new MergeLinkedLists();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter length of first list-> ");
    int len1 = sc.nextInt();
    System.out.println("Enter first list: ");
    for (int i = 0; i < len1; i++) {
      int n = sc.nextInt();
      ml.insertAtEnd(ml, n);
    }
    ml.printLinkedList(ml);
    MergeLinkedLists ml2 = new MergeLinkedLists();
    System.out.print("Enter length of second list-> ");
    int len2 = sc.nextInt();
    for (int i = 0; i < len2; i++) {
      int n = sc.nextInt();
      ml2.insertAtEnd(ml2, n);
    }
    ml2.printLinkedList(ml2);
    MergeLinkedLists ml3 = new MergeLinkedLists();
    ml3.mergeLists(ml, ml2);
    System.out.println("Merged Linked List:");
    ml3.printLinkedList(ml3);
    sc.close();
  };
}