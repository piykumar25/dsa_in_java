public class Key_6_LinkedListDeleteNode {

    public static void main(String[] args) {
        Key_6_LinkedListDeleteNode linkedList = new Key_6_LinkedListDeleteNode();

        Node head = new Node(0);
        linkedList.addNode(head, 2);
        linkedList.addNode(head, 1);
        linkedList.addNode(head, 3);
        linkedList.addNode(head, 1);
        linkedList.addNode(head, 5);

        System.out.println("Linked List: ");
        linkedList.printLinkedList(head);
        Node newHead = linkedList.linkedListDeleteNode(head, 1);
        System.out.println("Linked List after deletion of node value: " + 1);
        linkedList.printLinkedList(newHead);

    }

    // Time Complexity: O(n), Space Complexity: O(1)
    public Node linkedListDeleteNode(Node head, int rmv) {
        if (head == null) {
            return null;
        }
        if (head.data == rmv) {
            head = head.next;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == rmv) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public void addNode(Node head, int data) {

        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    private void printLinkedList(Node head) {

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
