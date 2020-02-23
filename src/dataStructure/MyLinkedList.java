package dataStructure;

import node.Node;

public class MyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> trav;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> node) {
        head = node;
        trav = head;
    }   //setter for head

    public Node<T> getTrav() {
        return trav;
    }                //Getter for iter

    public void setTrav(Node<T> trav) {
        this.trav = trav;
    }  //Setter for iter

    //method to insert new node
    public void insert(Node<T> node) {
        if (getHead() == null) {
            setHead(node);
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    //method to delete node from beginning
    public Node<T> delete() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return null;
        }
        Node<T> temp = getHead();
        setHead(getHead().getNext());
        return temp;
    }

    //method to delete node at particular position
    public Node<T> delete(int i) {
        Node<T> deletedNode;
        Node<T> temp = getHead();
        if (isEmpty()) {
            System.out.println("Underflow");
            return temp;
        }
        if (i == 1) {
            deletedNode = getHead();
            setHead(null);
        } else {
            for (int j = 1; j < i - 1; j++) {
                temp = temp.getNext();
            }
            deletedNode = temp.getNext();
            temp.setNext(temp.getNext().getNext());
        }
        return deletedNode;
    }

    //Helper method to check if linked list is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    //Method to fetch object one by one
    public Node<T> getObject() {

        Node<T> temp;

        if (getTrav() == null && getHead() == null) {
            System.out.println("List is empty");
            return null;
        } else if (getTrav() == null) {
            setTrav(getHead());
            return null;
        }
        temp = getTrav();
        setTrav(getTrav().getNext());
        return temp;
    }

    //Method to sort linked list
    public void sort() {
        Node<T> pass1 = getHead();
        Node<T> pass2 = getHead().getNext();

        while (pass1 != null) {
            while (pass2 != null) {
                if (pass1.getData().compareTo(pass2.getData()) > 0) {
                    T temp = pass1.getData();
                    pass1.setData(pass2.getData());
                    pass2.setData(temp);
                }
                pass2 = pass2.getNext();
            }
            pass1 = pass1.getNext();
        }
    }
}