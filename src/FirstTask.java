import java.*;
import java.util.ArrayList;

public class FirstTask<Key extends Comparable<Key>, Value> {

    private ArrayList<Value>[] a;
    private int m;
    public FirstTask(){
        m = 2147483647;
        a = new ArrayList[m];
    }
    //add an key-value pair to the dictionary
    void put(Key key, Value value){

    }
  //get the value associated with a given key
    Value get(Key key){

    }

    //remove a key-value pair and return its value
    Value remove(Key key){

    }

    //returns true if the dictionary is empty
    boolean isEmpty(){

    }

    //returns the number of key-value pairs in the dictionary
    int size(){

        
    }
}
