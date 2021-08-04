import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class RecentCounter {
  Queue<Integer> queue;

  public RecentCounter() {
    queue = new LinkedList<Integer>();
  }

  private int ping(int t) {
    queue.add(t);
    while (queue.peek() < (t - 3000)) {
      queue.remove();
    }
    return queue.size();
  }

  public static void main(String[] args) {
    RecentCounter rc = new RecentCounter();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter current timestamp in milliseconds:");
    int t = sc.nextInt();
    int numOfCalls = rc.ping(t);
    System.out.println("Number of calls made within the last 3 seconds:");
    System.out.println(numOfCalls);
    sc.close();
  }

}