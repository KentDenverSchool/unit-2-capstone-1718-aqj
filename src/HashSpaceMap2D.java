/**
 * Name: 8N
 * Lab Name: HashSpaceMap2D
 * Lab purpose: The goal of HashSpaceMap2D is to create a program that
 * Date: 10/9/17
 * Collaborators: None
 */

import java.util.ArrayList;

public class HashSpaceMap2D<Key extends Comparable<Key>, Value> {


    private int m = 7;  //2147483647
    private int size;

    private ArrayList<ArrayList>[] hashspace;

    public HashSpaceMap2D(){

        hashspace = new ArrayList[m];
        size = 0;

    }

    //add an key-value pair to the dictionary
    public void put(Key key, Value value){

        int hashedKey = hashKey(key);


        if(hashspace[hashedKey] == null){
            hashspace[hashedKey] = new ArrayList<>();
        }

        if(get(key) != null) {
            for (int i = 0; i < hashspace[hashedKey].size(); i++) {
                if(hashspace[hashedKey].get(i).get(0).equals(key)){
                    hashspace[hashedKey].get(i).set(1, value);
                    break;
                }

            }
        }

        else{
            ArrayList kv = new ArrayList();
            kv.add(key);
            kv.add(value);
            hashspace[hashedKey].add(kv);
            size++;
        }





        if((1.0*this.size())/m >= .8){
            this.resize(m*2);
        }


    }

    //get the value associated with a given key
    public String get(Key key) {

        String returnValue = null;
        int numOfValues = 0;
        int hashedKey = hashKey(key);


        for (ArrayList curr : hashspace[hashedKey]) {
            if(curr.get(0).equals(key)){
                returnValue = curr.get(1).toString();
                break;
            }
        }


        return returnValue;


    }

    //remove a key-values pair and return its value
    public String remove(Key key){

        String returnString = null;

        int hashedKey = hashKey(key);
        int whichList = 0;

        if(hashspace[hashedKey] != null){
            for (ArrayList curr : hashspace[hashedKey]) {
                if (curr.get(0).equals(key)){
                    returnString = curr.get(1).toString();
                    break;
                }
                whichList++;
            }
        }

        hashspace[hashedKey].remove(whichList);

        size--;

        return returnString;

    }

    //returns true if the dictionary is empty
    public boolean isEmpty(){

        boolean sizeIsZero = true;

        sizeIsZero = size == 0;

        return sizeIsZero;
    }

    //returns the number of key-value pairs in the dictionary
    public int size(){
        return size;
    }

    private int hashKey(Object key){

        String stringKey = key.toString();
        int hashedStringKey = stringKey.hashCode();

        return (hashedStringKey % m);

    }

    //Updates m to the new value. Rehashes all keys
    public void resize(int newM){

        changeM(newM);

        ArrayList<ArrayList>[] newHashspace = new ArrayList[newM];
        int newSize = 0;

        for(int i = 0; i < hashspace.length; i++){
            if(hashspace[i] != null){

                for (int j = 0; j < hashspace[i].size(); j++) {

                    int newI = hashKey(hashspace[i].get(j).get(0));

                    if(newI <= newM){

                        if(newHashspace[newI] == null){
                            newHashspace[newI] = new ArrayList<>();
                        }

                        ArrayList kv = hashspace[i].get(j);
                        newHashspace[newI].add(kv);
                        newSize++;


                    }

                }
            }

        }
        System.out.println(m);// checks if resize activates
        size = newSize;
        hashspace = newHashspace;

    }

    //Changes the int m and throws an exception if it is too large
    private void changeM(int newM){

        try {
            m = newM;
        }
        catch(NumberFormatException e){
            System.err.println("Integer too large: " + e.getMessage());
        }

    }

    public static void main(String[] args) {

        HashSpaceMap2D<String, String> test = new HashSpaceMap2D<>();

        System.out.println("Is Empty: " + test.isEmpty());
        System.out.println("Size: " + test.size());

        test.put("hash1", "value1");
        test.put("hash2", "value1");
        test.put("hash3", "value1");

        System.out.println("Is Empty: " + test.isEmpty());
        System.out.println("Size: " + test.size());

        System.out.println("Hash1 values: " + test.get("hash1"));
        test.put("hash1", "value2");
        System.out.println("Hash1 values: " + test.get("hash1"));

        System.out.println("Is Empty: " + test.isEmpty());
        System.out.println("Size: " + test.size());


        System.out.println("Hash1 value removed: " + test.remove("hash1"));
        System.out.println("Hash1 values: " + test.get("hash1"));

        test.put("hash4", "value1");
        test.put("hash5", "value1");
        test.put("hash6", "value1");
        test.put("hash7", "value1");




    }





//    |Operation              |ArrayDictionary|BinarySearchTree|HashingDictionary|
//    |-----------------------|---------------|----------------|-----------------|
//    |Get a value given a key|O(n)           |O(n)            |O(n)             |
//    |Insert a key-value pair|O(n)           |O(n)            |O(n)             |
//    |Remove a key-value pair|O(n)           |O(n)            |O(n)             |



}
