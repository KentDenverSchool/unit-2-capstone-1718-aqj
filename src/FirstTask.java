import java.*;
import java.util.ArrayList;

public class FirstTask<Key extends Comparable<Key>, Value> {
    private ArrayList<ArrayList>[] a;
    private int size;
    private int m;

    public FirstTask(){

        m = 2147483647;
        a = new ArrayList[m];
    }

    //add an key-value pair to the dictionary

    void put(Key key, Value value){
        ArrayList<ArrayList> b = new ArrayList<>();
        ArrayList val = new ArrayList();
        boolean toF = false;
        int Hashedkey = hashKey(key);
        if (a[Hashedkey]== null){
            a[Hashedkey] = b;
        }
        for (int i = 0; i <a[Hashedkey].size() ; i++) {
            if (((Comparable) a[Hashedkey].get(i).get(0)).compareTo(key) == 0){
                a[Hashedkey].remove(i);
                val.add(key);
                val.add(value);
                a[Hashedkey].add(val);
                size++;
                toF= true;
                break;
            }
        }
        if(!toF)
        {
            val.add(key);
            val.add(value);
            a[Hashedkey].add(val);
            size++;
        }
    }

    //get the value associated with a given key
    Value get(Key key){
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


    int hashKey(Key key){

        String stringKey = key.toString();
        int hashedStringKey = stringKey.hashCode();

        return (hashedStringKey % m);
    }
    
}