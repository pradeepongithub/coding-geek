public class StackWithLinkList<T> {

    private Node head;

    public StackWithLinkList(T item) {
        head = new Node(item);
    }

    public static void main(String[] args) {

        StackWithLinkList<Integer> ll = new StackWithLinkList(10);
        ll.viewLL();
        System.out.println("Push : ");
        ll.push(15);
        ll.push(5);
        ll.push(7);
        ll.push(24);
        ll.viewLL();
        System.out.println("Pop : " + ll.pop());
        ll.viewLL();
    }

    private void viewLL() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Node Item: " + temp.getValue());
            System.out.println("Node next Item: " + temp.getNext());
            temp = temp.getNext();
        }
    }

    private void push(T item) {
        Node node = new Node(item);
        node.setNext(head);
        head = node;
    }

    private T pop() {
        Node node = head;
        if (node.getNext() != null) {
            node = head;
            head = node.getNext();
            return (T) node.getValue();
        }
        return null;
    }

}
