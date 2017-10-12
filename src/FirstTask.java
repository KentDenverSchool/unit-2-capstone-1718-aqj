import java.*;
import java.util.ArrayList;

public class FirstTask<Key extends Comparable<Key>, Value> {
    private ArrayList<Value>[] a;
    private int size;
    private int m;
    public FirstTask(){
        m = 2147483647;
        a = new ArrayList[m];
    }
    //add an key-value pair to the dictionary
    void put(Key key, Value value){
size++;
    }
  //get the value associated with a given key
    Value get(Key key){

    }

    //remove a key-value pair and return its value
    Value remove(Key key){
size--;
    }

    //returns true if the dictionary is empty
    boolean isEmpty(){
if (size() == 0){
    return true;
}else return false;
    }

    //returns the number of key-value pairs in the dictionary
    int size(){
    return size;
}
