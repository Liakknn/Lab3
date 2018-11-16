public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        for (int i = 0; i <size ; i++) {
            addToTail(null);
        }
    }

    public LinkedList() {
        head = new Node<T>(null, null);
        head.setNext(head);
    }


    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }


    public boolean addToTail(T element) {
        Node<T> last = head.getNext();
        while (last.getNext() != head) {
            last = last.getNext();
        }
        Node<T> newNode = new Node<T>(element, head);
        last.setNext(newNode);
        size++;
        return true;
    }


    public boolean addToHead(T element) {
        Node<T> a = new Node<T>(element, head.getNext());
        head.setNext(a);
        size++;
        return true;
    }


    public boolean addNode(int index, T element) {
        if (index < 0 | index > size) {
            return false;
        }
        Node<T> t = head;
        Node<T> n1 = new Node<T>(element, null);
        int count = 0;
        if (index == 0) {
            addToHead(element);
            return true;
        }
        if (index == size) {
            addToTail(element);
            return true;
        }
        while (t.getNext() != head) {
            if (count == index) {
                n1.setNext(t.getNext());
                t.setNext(n1);
                size++;
            }
            t = t.getNext();
            count++;
        }
        return true;
    }

    public void setNode(int index, T element) {
        Node<T> n = head;
        Node<T> n1 = new Node<T>(element, null);
        int count = 0;
        if (index == 0) {
            n1.setNext(n.getNext().getNext());
            head.setNext(n1);
        }
        while (n.getNext() != head) {
            if (count == index) {
                n1.setNext(n.getNext().getNext());
                n.setNext(n1);
                return;
            }
            n = n.getNext();
            count++;
        }
    }


    public boolean delNode(int index) {
        if (index < 0 | index > size) {
            return false;
        }
        Node<T> n = head;
        int count = 0;
        if (index == 0) {
            head.setNext(n.getNext().getNext());
            size--;
            return true;
        }
        while (n.getNext() != head) {
            if (count == index) {
                n.setNext(n.getNext().getNext());
                size--;
            }
            n = n.getNext();
            count++;
        }
        return true;
    }


    public void print() {
        Node<T> t = head.getNext();
        while (t != head) {
            System.out.println(t.getData() + "");
            t = t.getNext();
        }
    }



    public Node<T> get(int index) {
        int count = 0;
        Node<T> t = head;
        while (t.getNext() != head) {
            if (count == index) {
                return t.getNext();
            }
            t = t.getNext();
            count++;
        }
        return null;
    }
}
