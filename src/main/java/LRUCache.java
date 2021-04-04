import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> map;
    DoublyLinkedList cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoublyLinkedList();
    }

    public void put(int key, int val) {
        Node newNode = new Node(key, val);
        if (map.containsKey(key)) {
            // delete the last element in the doubly linked list with the same key
            cache.delete(map.get(key));
            // update it with the new node
            map.put(key, newNode);
            // insert the new node as the most recently used node
            cache.prepend(newNode);
        } else {
            // handle the case when capacity is reached
            if (map.size() >= capacity) {
                // remove the LRU and remove it from the map
                int lastKey = cache.deleteLast();
                map.remove(lastKey);
            }
            // add the new node as the most recently used element
            cache.prepend(newNode);
            map.put(key, newNode);
        }
    }


    public int get(int key) {
        if (!this.map.containsKey(key)) return -1;
        int val = this.map.get(key).val;
        // reuse implementation from put to mark for more recently used
        this.put(key, val);
        return val;
    }
}


class DoublyLinkedList {
    /*
    head: most-recently used
    tail: LRU
     */
    Node head, tail;
    public DoublyLinkedList() {
        // dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        // setup dummy nodes
        head.next = tail;
        tail.prev = head;
    }

    public void prepend(Node node) {
        // setup next and prev for the new node
        node.next = head.next;
        node.prev = head;

        // update next in head and prev in head.next
        head.next.prev = node;
        head.next = node;
    }

    public int delete(Node node) {
        int key = node.key;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return key;
    }

    public int deleteLast() {
        if (head.next == tail) return -1;
        return this.delete(tail.prev);
    }
}

class Node {
    public int key, val;
    public Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
