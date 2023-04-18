public class Nod <K, V> {
    public K key;
    public V value;
    Nod<K,V> next;

    public Nod(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public  K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
