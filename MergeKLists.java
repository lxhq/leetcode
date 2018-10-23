import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

public class MergeKLists {
  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists.size() == 0 || lists == null)
      return null;

    PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });

    for (int i = 0; i < lists.size(); i++) {
      ListNode node = lists.get(i);
      while(node != null) {
        pq.add(node);
        node = node.next;
      }
    }

    ListNode ln = pq.poll();
    ListNode node = ln;
    while (!pq.isEmpty()) {
      node.next = pq.poll();
      node = node.next;
    }
    return ln;
  }

  public static void main(String[] args) {
    ListNode[] lists = {null, null, new ListNode(1)};
    MergeKLists mkl = new MergeKLists();
    //mkl.mergeKLists(lists);


  }

}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
