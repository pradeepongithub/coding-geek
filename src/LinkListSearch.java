public class LinkListSearch<T> {

    public Node head;

    LinkListSearch(T value) {
        head = new Node(value);
    }

    public static void main(String[] args) {
        LinkListSearch ll = new LinkListSearch(10);
        LinkListUtil lu = new LinkListUtil();
        ll.head = lu.addAtFirst(ll.head, 20);
        ll.head = lu.addAtFirst(ll.head, 2);
        ll.head = lu.addAtFirst(ll.head, 5);
        ll.head = lu.addAtFirst(ll.head, 30);
        ll.head = lu.addAtFirst(ll.head, 15);

        System.out.println("View LL: ");
        lu.printLL(ll.head);
        System.out.println("node count: " + lu.getNodeCount(ll.head));

        int nodeCount = lu.getNodeCount(ll.head);
        Node temp = lu.getNodeByPositionFromStart(ll.head, nodeCount - 3 + 1);// kth node from end means: n-k+1 node from start
        System.out.println("Get 3rd node from the end of LL : " + temp.toString());

    }
}