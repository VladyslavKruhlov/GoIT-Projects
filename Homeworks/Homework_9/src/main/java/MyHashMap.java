
class MyHashMap<K, V> {
    private int length = 16;
    public Nod <K, V>[] table;
    int size = 0;


    public MyHashMap() {
        table = new Nod[length];
    }

    public int indexOfElement (Object key) {
        return key.hashCode() % (table.length - 1);
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    //      МЕТОД PUT

    public void put(K key, V value) {
        changeSize();
        addToTable(table, key, value);

    }
    private void changeSize() {
        if (size / table.length > 1) {
            resize(2 * table.length);
        }
    }
    public void resize(int newCapacity) {
        if (newCapacity >= 0) {
            Nod<K, V>[] newTable = new Nod[newCapacity];
            for (Nod head : table) {
                Nod<K, V> current = head;
                while (current != null) {
                    addToTable(newTable, current.key, current.value);
                    current = current.next;
                }
            }
            table = newTable;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addToTable(Nod<K, V>[] map, K key, V value) {
        Nod<K, V> newNod = new Nod<>(key, value);
        int index = indexOfElement(key);
        if (map[index] == null) {
            map[index] = newNod;
        } else {
            Nod<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                }
                current = current.next;
            }
            current.value = value;
        }
        size++;
    }

//    public void put(K key, V value) {
//        index =
//
//        if (table == null) {
//            table = new Nod[size];
//            if (index == -1)
//                index = key.hashCode() % size;
//        }
//
//        if (length <= size && index >= 0) {
//
//            Nod<K, V> firstTable = new Nod<>(key, value);
//            Nod<K, V> secondTable = table[index];
//
//            if (table[index] == null) {
//                table[index] = firstTable; //finding an empty bucket
//                length++;
//            } else while (secondTable != null) {
//                if (secondTable.getKey().equals(key)) {
//                    secondTable.next = firstTable;  //replace object
//                    table[index] = secondTable.next;
//                    break;
//                } else {
//                    secondTable.next = firstTable; //keep a reference to the next object
//                    break;
//                }
//            }
//        } else {
//            size *= 2;
//            Nod<K, V>[] newTable = new Nod[size];
//            for (int i = 0; i < size / 2; i++) {
//                if (table[i] == null) {
//                    table = newTable;
//                    put(key, value);
//                } else
//                    newTable[i] = table[i];
//            }
//            table = newTable;
//            put(key, value);
//        }
//    }


    //      МЕТОД GET


//    public V get(K key) {
//        V value = null;
//        index = indexOfElement(key);;
//        Nod<K, V> secondTable = table[index];
//        while (secondTable != null) {
//            if (secondTable.getKey().equals(key)) {
//                value = secondTable.getValue();
//                secondTable = secondTable.next;
//            }
//        }
//        return value;
//    }

    public V get(K key) {
        int index = indexOfElement(key);
        Nod<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    //      МЕТОД REMOVE

    public void remove(K key) {
        int index = indexOfElement(key);
        Nod<K, V> current = table[index];
        if (current != null) {
            if (current.key.equals(key)) {
                table[index] = current.next;
                size--;
            }
            while (current.next != null) {
                if (current.next.key.equals(key)) {
                    current.next = current.next.next;
                    size--;
                }
                current = current.next;
            }
        }
    }

    //      МЕТОД SIZE

    public int size() {
        return size;
    }

    //      МЕТОД CLEAR

    public Nod<K, V>[] clear() {
        size = 0;
        return table = null;
    }
}