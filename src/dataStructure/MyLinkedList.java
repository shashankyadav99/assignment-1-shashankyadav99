package dataStructure;

import node.Node;

public class MyLinkedList<node extends Comparable<node>> {
    private Node<node> head;
    private Node<node> trav;

    public Node<node> getHead() {
        return head;
    }

    public void setHead(Node<node> head) {
        this.head = head;
    }

    public Node<node> getTrav() {
        return trav;
    }

    public void setTrav(Node<node> trav) {
        this.trav = trav;
    }

    public void insert(Node<node> node) {
        if (getHead() == null)
            setHead(node);
        else {
            Node<node> temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(node);
        }
    }


}