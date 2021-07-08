import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

class LinkedList {

  Node head;

  public LinkedList insertAtEnd(LinkedList ll, int n) {
    Node node = new Node(n);
    if (ll.head == null) {
      ll.head = node;
      return ll;
    } else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = node;
    }
    return ll;
  }

  public LinkedList insertAtBeginnning(LinkedList ll, int n) {
    Node node = new Node(n);
    if (ll.head == null) {
      ll.head = node;
      return ll;
    } else {
      node.next = ll.head;
      ll.head = node;
      return ll;
    }
  }

  public void printLinkedList(LinkedList ll) {
    System.out.print("Linked List: ");
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + ",");
      curr = curr.next;
    }
  }

  public LinkedList deleteByKey(int key, LinkedList ll) {
    // Case 1: The key is at the head of the list
    // Case 2: The key is somewhere in the list
    // Case 3: The key is not in the list
    Node curr = head;
    // Case 1
    if (curr != null && curr.data == key) {
      System.out.println("Key found in the start of the list!");
      ll.head = curr.next;
      return ll;
    } else { // Case 2
      Node prev = curr;
      while (curr.data != key && curr.next != null) {
        prev = curr;
        curr = curr.next;
      }
      // Case 3
      if (curr.data == key) {
        if (curr.next != null) {
          prev.next = curr.next;
        } else {
          prev.next = null; // delete the last element
        }
        return ll;
      } else {
        System.out.println("Key not found in list!");
        return ll;
      }
    }
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 10 numbers for your linked list: ");
    for (int i = 0; i < 10; i++) {
      int n = sc.nextInt();
      ll.insertAtEnd(ll, n);
    }
    ll.printLinkedList(ll);
    System.out.println();
    System.out.println("Enter number you want to delete:");
    int p = sc.nextInt();
    ll.deleteByKey(p, ll);
    System.out.println("Linked List after deleting number: ");
    ll.printLinkedList(ll);
    System.out.println();
    System.out.println("Enter a number to be added at the beginning of your linked list: ");
    int q = sc.nextInt();
    ll.insertAtBeginnning(ll, q);
    ll.printLinkedList(ll);
    System.out.println();
    sc.close();
  }
}