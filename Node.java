public class Node {
    public int val;
    private Node next;

    public Node (int data) {
        this.val = data;
        this.next = null;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Node getNext(){
        return this.next;
    }
}