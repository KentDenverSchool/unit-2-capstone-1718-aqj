import java.*;
import java.util.ArrayList;

public class FirstTask<Key extends Comparable<Key>, Value> {
    private ArrayList<Value>[] a;
    private int size;
    private int m;

    public FirstTask() {

        m = 2147483647;
        a = new ArrayList[m];
    }

    //add an key-value pair to the dictionary

    void put(Key key, Value value) {
        int Hashedkey = hashKey(key);
        a[Hashedkey].add(value);
        size++;
    }

    //get the value associated with a given key
    Value get(Key key) {
        int hashKey = hashKey(key);
        return a[hashKey].get(0);
    }

    //remove a key-value pair and return its value
    Value remove(Key key) {
        int hashedKey = hashKey(key);
        a[hashedKey] = new ArrayList<Value>();
        size--;
    }

    //returns true if the dictionary is empty
    boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else return false;
    }


    //returns the number of key-value pairs in the dictionary
    int size() {
        return size;
    }


    int hashKey(Key key) {

        String stringKey = key.toString();
        int hashedStringKey = stringKey.hashCode();

        return (hashedStringKey % m);
    }

    // TASK 2: THE SECOND COMING OF CHRIST
    
    public void resize(int newM){
        m = newM;
        ArrayList<Value>[] aCopy = new ArrayList[m];

        for (int i = 0; i < a.length; i++) {
            int newI =

        }
    }

}

