public class NodeTwoLinks<T> {
    private T data;
    private NodeTwoLinks<T> next;
    private NodeTwoLinks<T> prev;

    public NodeTwoLinks(T data, NodeTwoLinks<T> next, NodeTwoLinks<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeTwoLinks<T> getNext() {
        return next;
    }

    public void setNext(NodeTwoLinks<T> next) {
        this.next = next;
    }

    public NodeTwoLinks<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeTwoLinks<T> prev) {
        this.prev = prev;
    }

}