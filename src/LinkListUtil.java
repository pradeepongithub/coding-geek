public class LinkListUtil<T> {

    public Node<T> addAtFirst(Node<T> head, T item) {
        Node node = new Node(item);
        node.setNext(head);
        head = node;
        return head;
    }

    public Node<T> getNodeByPositionFromStart(Node<T> head, int pos) {
        int current = 1;
        while (head != null) {
            if (pos == current) {
                return head;
            }
            head = head.getNext();
            current++;
        }
        return null;
    }

    public Node<T> removeAtFirst(Node<T> head) {
        return head.getNext() != null ? head.getNext() : null;
    }

    public void printLL(Node<T> head) {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println("value: " + temp.getValue() + " next : " + temp.getNext());
            temp = temp.getNext();
        }
    }

    public int getNodeCount(Node<T> head){
        int nodeCount = 0;
        Node<T> temp = head;
        while (temp!=null){
            nodeCount++;
            temp = temp.getNext();
        }
        return nodeCount;
    }
}
