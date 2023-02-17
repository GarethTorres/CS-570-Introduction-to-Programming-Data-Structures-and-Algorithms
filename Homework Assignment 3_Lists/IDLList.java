/* Guizhi Xu */
/* CWID: 20008770 */

import java.util.ArrayList;

public class IDLList<E> {
    /**
     * Number of data in the list
     * The index in the list
     * List head and tail
     */
    private int size;
    private ArrayList<Node<E>> indices;
    private Node<E> head;
    private Node<E> tail;

    /**
     * Create an empty double-linked list
     */
    private static class Node<E> {
        /**
         * The data value.
         * The link to the next and previous node.
         */
        E data;
        Node<E> next = null;
        Node<E> prev = null;

        /**
         * Construct a node with the given data value.
         * 
         * @param elem The data value
         */
        private Node(E elem) {
            this.data = elem;
        }

        /**
         * adds elem at position index (counting from wherever head is). It uses the
         * index for fast access.
         * 
         * @param elem The data value
         * @param prev The next and previous node
         */
        private Node(E elem, Node<E> prev, Node<E> next) {
            this.next = next;
            this.prev = prev;
            this.data = elem;
        }
    }

    /** Creates an empty IDLList. */
    public IDLList() {
        head = null;
        tail = null;
        size = 0;
        indices = new ArrayList<Node<E>>();
    }

    /**
     * Adds elem at position index(counting from wherever head is). It uses the
     * index for fast access.
     * 
     * @param index The position that elem be added to.
     * @param elem  The data to be added to.
     */
    public boolean add(int index, E elem) {
        /* Only take index that is vaild */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        /* call method:add(elem) When it added an element at the head */
        if (index == 0) {
            add(elem);
            return true;
        } else {
            /* Find the position before the new element added */
            Node<E> formerNode = head;
            for (int i = 0; i < index - 1; i++) {
                formerNode = formerNode.next;
            }
            /* Add the new node at the index */
            formerNode.next = new Node<E>(elem, formerNode, formerNode.next);
            formerNode.next.prev = formerNode.next;
            /* Updata the indices */
            indices.add(index, formerNode.next);
            size++;
            return true;
        }

    }

    /**
     * add elem at position index (counting from wherever head is). It uses the
     * index for fast access
     * 
     * @param elem
     */
    public boolean add(E elem) {
        if (head != null) {
            head = new Node<E>(elem, null, head);
            head.next.prev = head;
            size++;
            indices.add(0, head);
            return true;
        } else
        /* Update head and tail when the IDLList empty */
        {
            head = new Node<E>(elem);
            tail = head;
            size++;
            indices.add(0, head);
            return true;
        }
    }

    /**
     * add elem as the new last element of the list (i.e. at the tail).
     *
     * @param elem
     */
    public boolean append(E elem) {
        /* If IDLList is empty. */
        if (tail == null) {
            head = new Node<E>(elem);
            tail = head;
            size++;
            indices.add(0, head);
            return true;
        } else
        /* Append a new node at the tail */
        {
            tail = new Node<E>(elem, tail, null);
            tail.prev.next = tail;
            size++;
            indices.add(size - 1, tail);
        }
        return true;
    }

    /**
     * Returns the object at position index from the head. It uses the index for
     * fast access. Indexing starts from 0, thus get(0) returns the
     * head element of the list.
     * 
     * @param index The position that the data will be returned
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        return indices.get(index).data;
    }

    /* Return the object at head */
    public E getHead() {
        return head.data;
    }

    /* Return the object at tail */
    public E getLast() {
        return tail.data;
    }

    /* Return list size */
    public int size() {
        return size;
    }

    /* Remove and return the element at the head */
    public E remove() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
            head.prev = null;
        }
        /* Return data on head or return null if IDLList empty */
        if (temp != null) {
            indices.remove(0);
            size--;
            return temp.data;
        } else
            return null;
    }

    /* Remove and return the element at the tail */
    public E removeLast() {
        Node<E> temp = tail;
        if (tail != null) {
            tail = tail.prev;
            tail.next = null;
        }
        /* Return data at tail or return null if IDLList empty */
        if (temp != null) {
            indices.remove(size - 1);
            size--;
            return temp.data;
        }
        return null;
    }

    /**
     * Removes and returns the element at the index.
     * Use the index for fast access.
     * 
     * @param index The position that will be removed
     */
    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            return remove();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> temp = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            indices.remove(index);
            size--;
            return temp.data;
        } else {
            return null;
        }

    }

    /**
     * Return false if elem was not in the list, or remove the first occurrence of
     * elem and return true
     * 
     * @param elem The data value to be removed
     */
    public boolean remove(E elem) {
        for (int i = 0; i < size; i++) {
            if (elem == indices.get(i).data) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Present a string representation of the list
     *
     * @return
     */

    public String toString() {
        System.out.println("Output list below：");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(indices.get(i).data);
        }
        System.out.println(result.toString());
        return result.toString();
    }

}