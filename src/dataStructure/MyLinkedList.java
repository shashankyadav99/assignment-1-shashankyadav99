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

    public Node<node> delete() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return null;
        }
        Node<node> temp = getHead();
        setHead(getHead().getNext());
        return temp;
    }

    public Node<node> delete(int i) {
        Node<node> deletedNode;
        Node<node> temp = getHead();
        if (isEmpty()) {
            System.out.println("Underflow");
            return temp;
        }
        if (i == 1) {
            deletedNode = getHead();
            setHead(null);
        } else {
            for (int j = 1; j < i - 1; j++)
                temp = temp.getNext();
            deletedNode = temp.getNext();
            temp.setNext(temp.getNext().getNext());
        }
        return deletedNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node<node> getObject() {
        Node<node> temp;

        if (getTrav() == null && getHead() == null) {
            System.out.println("List is Empty.");
            return null;
        } else if (getTrav() == null) {
            setTrav(getHead());
            return null;
        }
        temp = getTrav();
        setTrav(getTrav().getNext());
        return temp;
    }

    public void sort() {
        Node<node> pass1 = getHead();
        Node<node> pass2 = getHead().getNext();

        while (pass1 != null) {
            while (pass2 != null) {
                if (pass1.getData().compareTo(pass2.getData()) > 0) {
                    node temp = pass1.getData();
                    pass1.setData(pass2.getData());
                    pass2.setData(temp);
                }
                pass2 = pass2.getNext();
            }
            pass1 = pass1.getNext();
        }
    }
}