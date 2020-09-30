import java.util.Arrays;

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
        /*System.out.println("node count: " + lu.getNodeCount(ll.head));

        int nodeCount = lu.getNodeCount(ll.head);
        Node temp = lu.getNodeByPositionFromStart(ll.head, nodeCount - 3 + 1);// kth node = 3 from end means: n-k+1 node from start
        System.out.println("Get 3rd node from the end of LL : " + temp.toString());

        System.out.println("displayLL in Reverse : ");
        displayLLFromEnd(ll.head);
        ll.head = null;
        ll.head = lu.addAtFirst(ll.head, 200);
        ll.head = lu.addAtFirst(ll.head, 100);*/
        //checkEvenOrOddWith2xPointer(ll.head);
        //checkEvenOrOddLLWithMod(ll.head);
        //System.out.println("swapAdjacent : ");
        swapAdjacent(ll.head);
        //swapAdjacentArray(new int[]{20,4,12,10,5,40,60});

    }

    private static void displayLLFromEnd(Node head) {
        //Recursion
        if (head == null) {
            return;
        }
        displayLLFromEnd(head.getNext());
        System.out.println(head.getValue());
    }

    private static void checkEvenOrOddWith2xPointer(Node head) {
        if (head == null) {
            return;
        }
        while (head != null && head.getNext() != null) {
            head = head.getNext().getNext();
        }
        if (head == null) {
            System.out.println("Even");
            return;
        }
        System.out.println("Odd:");
    }

    private static void checkEvenOrOddLLWithMod(Node head) {
        if (head == null) {
            return;
        }
        int count = 0;
        while (head != null) {
            head = head.getNext();
            count++;
        }
        if (count % 2 == 0) {
            System.out.println("Even");
            return;
        }
        System.out.println("Odd:");
    }

    private static void swapAdjacent(Node head){
        Node p=null,q=null,r=null;
       while(head !=null && head.getNext()!=null){
           p=head;
           q=head.getNext();
           p.setNext(q.getNext());
           q.setNext(p);
           r=q;
           head =q;
           head=head.getNext().getNext();
       }
       System.out.println("p==>" +r);
    }

    private static void swapAdj(int...a){
        int k =1, temp = a[0];
        for(int i=0;i<a.length-1;i+=2,k+=2){
            temp=a[i];
            a[i]=a[k];
            a[k]=temp;
        }
        System.out.println(Arrays.toString(a));
    }
    private static void rotateByKTimes(int k, int...nums){


    }

}