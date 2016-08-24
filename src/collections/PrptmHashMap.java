package collections;


public class PrptmHashMap<K, V> {

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE / 2;
    static final int DEFAULT_INITIAL_CAPACITY = 16;

    int capacity;
    int size = 0;
    int threshold;
    Node<K,V>[] table;
    final float loadFactor;

    public PrptmHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        table = new Node[capacity];
    }

    public PrptmHashMap(int capacity) {
        this.capacity = capacity;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        table = new Node[capacity];
    }

    public PrptmHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        table = new Node[capacity];
    }

    public void put(K key, V value){
        Node<K,V> node = new Node<>(key,value,null);
        check(node);
        checkCapacity();
        int i = index(node.hash);
        if (table[i]==null){
            table[i]=node;
            ++size;
        } else {
            if (table[i].key==null){
                table[i]=node;
                ++size;
            } else {
                Node<K,V> temp = table[i];
                while(temp.next != null){
                    temp=temp.next;
                }
                temp.next = node;
                ++size;
            }
        }
    }

    public V get(K key) {
        int i = index(hash(key));
        if (table[i] != null){
            if (table[i].key == key) return table[i].value;
            else if (table[i].next != null) table[i] = table[i].next;
        }
    }

    private void checkCapacity(){
        if (size > capacity * loadFactor) increase();
    }

    private void increase(){
        Node<K,V> temp[] = new Node[table.length*2];
        System.arraycopy(table,0,temp,0,table.length);
        table = temp;
        capacity*=2;
    }

    private void check(Node<K,V> node){
        int i = index(node.hash);
        if (table[i]!=null){
            Node<K,V> temp = table[i];
            while (temp != null){
                if (temp.key!=node.key) temp = temp.next;
                else {
                    --size;
                    temp.key = null;
                    temp.value = null;
                    break;
                }
            }
        }
    }

    int hash(Object obj){
        int h;
        return (obj == null) ? 0 : (h = obj.hashCode()) ^ (h>>>16);
    }

    int index(int hash){
        return hash & (table.length - 1);
    }

    class Node <K, V>{
        int hash;
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value, Node<K,V> next){
            this.hash = hash(key);
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) o;

            if (!key.equals(node.key)) return false;
            return value != null ? value.equals(node.value) : node.value == null;

        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
