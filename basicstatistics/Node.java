package hus.oop.basicstatistics;

public class Node {
    public Number payload;
    public Node next;

    public Node(Number payload) {
        /* TODO */
        this.payload = payload;
    }

    public Node(Number payload, Node next) {
        /* TODO */
        this.payload = payload;
        this.next = next;
    }

    public void setPayload(Number payload) {
        this.payload = payload;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Number getPayload() {
        return payload;
    }

    public Node getNext() {
        return next;
    }
}
