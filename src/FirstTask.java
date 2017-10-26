import java.*;
import java.util.ArrayList;

public class FirstTask<Key extends Comparable<Key>, Value> {
    private ArrayList<ArrayList>[] a;
    private int size;
    private int m;

    public FirstTask() {

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
     public String get(Key key) {

        String returnValue = "";
        int numOfValues = 0;
        int hashedKey = hashKey(key);


        for (ArrayList curr : a[hashedKey]) {

            if (numOfValues == 0) {
                returnValue = curr.get(1).toString();
                numOfValues++;
            }
            else {
                returnValue = returnValue + ", " + curr.get(1).toString();
            }

        }
        return returnValue;
    }

    //remove a key-value pair and return its value
    Value remove(Key key) {
        int hashedKey = hashKey(key);
        Value v = null;
        for(int i = 0; i < a[hashedKey].size(); i ++){
            if (a[hashedKey].get(i).get(0).equals(key) ){
                v = (Value)a[hashedKey].get(i).get(1);
                a[hashedKey].get(i).remove(0);
            }
        }
        size--;
        return v;
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
// goes through every key and value IN ALL EXISTENCE and .hash's every key. Moves K,V pair to new place
    public void resize(int newM){
        m = newM;
        ArrayList<ArrayList>[] aCopy = new ArrayList[m];
//


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].size(); j++){
                // Key newKey = (Key) a[i].get(j).get(0);
                int newHash =  hashKey((Key) a[i].get(j).get(0));
                ArrayList shell = a[i].get(j);
                // Value newValue = (Value) a[i].get(j).get(1);
                // int index = hashKey(newKey);
                if (aCopy[newHash] == null){
                    aCopy[newHash] = new ArrayList<>();
                }
                aCopy[newHash].add(shell);
            }
        }
        a = aCopy;
    }

}

