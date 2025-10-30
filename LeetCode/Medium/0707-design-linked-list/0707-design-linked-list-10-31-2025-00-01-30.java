class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val) {
            this(val, null);
        }
    }

    private Node head = null;
    private Node tail = null;
    private int current_size = 0;


    public int get(int index) {
        if (index < 0 || index >= current_size) return -1;

        Node temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        return temp.val;
    }

   
    public void addAtHead(int val) {
        Node newNode = new Node(val, head);
        head = newNode;
        if (tail == null) tail = newNode;
        current_size++;
    }

   
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail != null) tail.next = newNode;
        tail = newNode;
        if (head == null) head = newNode;
        current_size++;
    }

 
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > current_size) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == current_size) {
            addAtTail(val);
            return;
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i++) prev = prev.next;
        Node newNode = new Node(val, prev.next);
        prev.next = newNode;
        current_size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= current_size) return;

        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next;
            prev.next = prev.next.next;
            if (index == current_size - 1) tail = prev;
        }
        current_size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */