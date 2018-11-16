public class DoublyLinkedList<T> {
    private NodeTwoLinks<T> head;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        int count = this.size;
        if (size < count){
            for (int i = size; i < count; i++) {
                delNode(i);
                return;
            }
        }
        for (int i = count; i < size; i++) {
            addToTail(null);
        }
    }

    public DoublyLinkedList() {
        head = new NodeTwoLinks(null, null, null);
        head.setNext(head);
        head.setPrev(head);
    }


    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }


    public boolean addToTail(T element) {
        NodeTwoLinks<T> last = head.getPrev();
        NodeTwoLinks<T> newNode = new NodeTwoLinks(element, head, head.getPrev());
        newNode.getPrev().setNext(newNode);
        newNode.getNext().setPrev(newNode);
        size++;
        return true;
    }


    public boolean addNode(int index, T element) {
        if (index == size) {
            addToTail(element);
            return true;
        }
        int count = 0;
        NodeTwoLinks<T> t = head;
        while (t.getNext() != head) {
            if (count == index) {
                NodeTwoLinks<T> n = new NodeTwoLinks(element, t.getNext(), t);
                t.getNext().setPrev(n);
                t.setNext(n);
            }
            t = t.getNext();
            count++;
        }
        return true;
    }


    public T get(int index) {
        int count = 0;
        NodeTwoLinks<T> t = head;
        while (t.getNext() != head) {
            if (count == index) {
                return t.getNext().getData();
            }
            t = t.getNext();
            count++;
        }
        return null;
    }


    public boolean delNode(int index) {
        int count = 0;
        NodeTwoLinks<T> t = head;
        while (t.getNext() != head) {
            if (count == index) {
                t.setNext(t.getNext().getNext());
                t.getNext().getNext().setPrev(t);
                size--;
            }
            t = t.getNext();
            count++;
        }
        return true;
    }


    public void setNode(int index, T element) {
        NodeTwoLinks<T> n = head;
        int count = 0;
        if (index == 0) {
            NodeTwoLinks<T> n1 = new NodeTwoLinks(element, n.getNext().getNext(), n);
            n.getNext().getNext().setPrev(n1);
            head.setNext(n1);
            return;
        }
        while (n.getNext() != head) {
            if (count == index) {
                NodeTwoLinks<T> n1 = new NodeTwoLinks(element, n.getNext().getNext(), n);
                n.getNext().getNext().setPrev(n1);
                n.setNext(n1);
                return;
            }
            n = n.getNext();
            count++;
        }
    }
}