public class MyHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16; // Number of buckets
    private Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new Entry[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];

        // Check if key already exists
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // Update value
                return;
            }
            head = head.next;
        }

        // Insert new entry at head
        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry<K, V> node = buckets[i];
            while (node != null) {
                System.out.print("[" + node.key + "=" + node.value + "] -> ");
                node = node.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("lemon", 40); // Possible collision

        System.out.println("Get banana: " + map.get("banana"));
        map.printMap();

        map.remove("banana");
        System.out.println("After removing banana:");
        map.printMap();
    }
}
