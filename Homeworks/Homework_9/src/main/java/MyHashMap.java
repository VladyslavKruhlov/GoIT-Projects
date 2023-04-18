import java.util.Arrays;

class MyHashMap<K, V> {
    private int size = 5;
    int length = 0;
    int index = 0;
    Nod<K, V>[] table;

    MyHashMap() {
        table = new Nod[size];
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Nod<K, V> secondTable = table[size];
        if (this == obj)
            return true;
        else if (obj == null || obj.getClass() != getClass())
            return false;
        MyHashMap<K, V> myHashMap = (MyHashMap<K, V>) obj;
        return secondTable.getKey() == myHashMap && secondTable.getValue() == myHashMap;
    }

    public void put(K key, V value) {
        index = key.hashCode() % size - 1;

        if (table == null) {
            table = new Nod[size];
            if (index == -1)
                index = key.hashCode() % size;
        }

        if (length <= size && index >= 0) {

            Nod<K, V> firstTable = new Nod<>(key, value);
            Nod<K, V> secondTable = table[index];

            if (table[index] == null) {
                table[index] = firstTable; //finding an empty bucket
                length++;
            } else while (secondTable != null) {
                if (secondTable.getKey().equals(key)) {
                    secondTable.next = firstTable;  //replace object
                    table[index] = secondTable.next;
                    break;
                } else {
                    secondTable.next = firstTable; //keep a reference to the next object
                    break;
                }
            }
        } else {
            size *= 2;
            Nod<K, V>[] newTable = new Nod[size];
            for (int i = 0; i < size / 2; i++) {
                if (table[i] == null) {
                    table = newTable;
                    put(key, value);
                } else
                    newTable[i] = table[i];
            }
            table = newTable;
            put(key, value);
        }
    }

    public V get(K key) {
        V value = null;
        index = key.hashCode() % size - 1;
        Nod<K, V> secondTable = table[index];
        while (secondTable != null) {
            if (secondTable.getKey().equals(key)) {
                value = secondTable.getValue();
                secondTable = secondTable.next;
            }
        }
        return value;
    }

    public Object remove(K key) {
        Nod<K, V> removeTable = null;
        index = key.hashCode() % size - 1;
        Nod<K, V> secondTable = table[index];
        if (secondTable.getKey().equals(key)) {
            removeTable = table[index];
            table[index] = null;
        }
        length--;
        return removeTable.getKey() + "=" + removeTable.getValue();
    }

    public int size() {
        return length;
    }

    public Nod<K, V>[] clear() {
        length = 0;
        return table = null;
    }
}