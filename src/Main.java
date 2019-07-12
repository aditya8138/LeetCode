import easy.ReverseLinkedList_206;


public class Main {

    public static void main(String[] args) {
        ReverseLinkedList_206 revList = new ReverseLinkedList_206();
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        revList.reverseList(node);
    }
}
