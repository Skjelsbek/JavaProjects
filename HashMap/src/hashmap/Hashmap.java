package hashmap;

public class Hashmap<TKey, TValue> {

    Node<TKey, TValue>[] array;

    public Hashmap(int size) {
        array = new Node[size];
    }

    public void insert(TKey key, TValue data) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] == null) {
            array[arrayIndex] = new Node(key, data);
        } else {
            array[arrayIndex].insert(key, data);
        }
    }

    public TValue get(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            return array[arrayIndex].get(key).data;
        }
        return null;
    }

    private int getIndex(TKey key) {
        return (Math.abs(key.hashCode()) % array.length);
    }

    public void delete(TKey key) {
        int arrayIndex = getIndex(key);
        if (array[arrayIndex] != null) {
            if (array[arrayIndex].key == key) {
                if (array[arrayIndex].nextNode == null) {
                    array[arrayIndex] = null;
                } else {
                    array[arrayIndex] = array[arrayIndex].nextNode;
                }
            } else if (array[arrayIndex].nextNode != null) {
                array[arrayIndex].delete(key);
            } else {
                System.out.println("There's no such key to be found!");
            }
        }
    }
    
    @Override
    public String toString() {
        String s = "Hashmap:\n";
        for(int i=0; i<array.length; i++){
            if (array[i] != null){
                s += i + ": " + array[i].toString();
            }
            s += (s.charAt(s.length()-1) == '\n')?"":"\n";
        }
        return s;
    }
}
