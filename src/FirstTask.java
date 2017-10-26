import java.*;
import java.security.Key;
import java.util.ArrayList;

public class FirstTask<Key extends Comparable<Key>, Value> {
    private ArrayList<ArrayList>[] a;
    private int size;
    private int m;

    public FirstTask() {
        m = 10;
        a = new ArrayList[m];
    }

    //add an key-value pair to the dictionary


    void put(Key key, Value value){
        // task 4
        if ((double)size()/m >= .8){
            resize(m * 2);
        }
        // end task 4
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

        String returnValue = null;
        int numOfValues = 0;
        int hashedKey = hashKey(key);


        for (ArrayList curr : a[hashedKey]) {
            if (curr.get(0).equals(key)){
                returnValue = curr.get(1).toString();
            }

        }
        return returnValue;
    }

    //remove a key-value pair and return its value
    Value remove(Key key) {
        int hashedKey = hashKey(key);
        Value v = null;

        for(int i = 0; i < a[hashedKey].size(); i ++){
            if (key != a[hashedKey].get(i).get(0)){
                return null;
            }
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
            if(a[i] != null) {
                for (int j = 0; j < a[i].size(); j++) {
                    // Key newKey = (Key) a[i].get(j).get(0);
                    int newHash = hashKey((Key) a[i].get(j).get(0));
                    ArrayList shell = a[i].get(j);
                    // Value newValue = (Value) a[i].get(j).get(1);
                    // int index = hashKey(newKey);
                    if (aCopy[newHash] == null) {
                        aCopy[newHash] = new ArrayList<>();
                    }
                    aCopy[newHash].add(shell);
                }
            }
        }
        a = aCopy;

    }

    public static void main(String[] args) {
        FirstTask<String, String> a = new FirstTask<>();
        System.out.println("Empty: " + a.isEmpty());
        a.put("key1" , "hey");
        a.put("key2" , "there");
        a.put("key3" , "Delila");
        System.out.println("Empty: " + a.isEmpty());
        System.out.println("Size: (should be 3)" + a.size());
        a.put("key4" , "Whats it like in New York City");
        a.put("key5" , "But girl tonight you look so pretty");
        a.put("key6" , "Yes you do");
        a.put("key7" , "Time Square cant shine as bright as you");
        a.put("key8" , "oh yes its true");
        System.out.println("Size: (should be 8)" + a.size());
        a.put("key1", "hi");
        System.out.println(a.get("key1"));
        System.out.println(a.get("key2"));
        System.out.println(a.get("key3"));
        System.out.println(a.get("key4"));
        System.out.println(a.get("key5"));
        System.out.println(a.get("key6"));
        System.out.println(a.get("key7"));
        System.out.println(a.get("key8"));
        a.remove("key4");
        System.out.println(a.get("key1"));
        System.out.println(a.get("key2"));
        System.out.println(a.get("key3"));
        System.out.println(a.get("key4"));
        System.out.println(a.get("key5"));
        System.out.println(a.get("key6"));
        System.out.println(a.get("key7"));
        System.out.println(a.get("key8"));
// testing resize 
        System.out.println(a.m);

    }
}


