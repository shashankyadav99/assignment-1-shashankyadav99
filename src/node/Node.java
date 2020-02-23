package node;

public class Node<node> {
    private node data;
    private Node<node> next;

    public node getData() {
        return data;
    }

    public void setData(node data) {
        this.data = data;
    }

    public Node<node> getNext() {
        return next;
    }

    public void setNext(Node<node> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}