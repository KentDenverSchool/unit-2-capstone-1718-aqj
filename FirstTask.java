/**
 * Name: 8N
 * Lab Name: FirstTask
 * Lab purpose: The goal of FirstTask is to create a program that
 * Date: 10/9/17
 * Collaborators: None
 */


public class FirstTask<Key extends Comparable<Key>, Value> {

    private int m = 2147483647;
    private Value[] hashspace;

    public FirstTask(){
        hashspace = new Value[m];

    }

    //add an key-value pair to the dictionary
    void put(Key key, Value value){

        int hashedKey = hashKey(key);

        if(hashspace[hashedKey] != null){

            System.out.println("Value for " + key + " was overridden. Previous value was " + hashspace[hashedKey]);

        }

        hashspace[hashedKey] = value;

    }

    //get the value associated with a given key
    Value get(Key key){

        Value returnValue;
        int hashedKey = hashKey(key);
        returnValue = hashspace[hashedKey];

        return returnValue;


    }

    //remove a key-value pair and return its value
    Value remove(Key key){

        int hashedKey = hashKey(key);

        if(hashspace[hashedKey] != null){
            Value removedKey = hashspace[hashedKey];

            hashspace[hashedKey] = null;

            return removedKey;

        }
        else{

            return  null;
        }

    }

    //returns true if the dictionary is empty
    boolean isEmpty(){

        boolean sizeIsZero = true;

        for (Value curr : hashspace){
            if (curr != null){
                sizeIsZero = false;
                break;
            }
        }

        return sizeIsZero;
    }

    //returns the number of key-value pairs in the dictionary
    int size(){

        int sizeOf = 0;

        for(Value curr : hashspace){
            if (curr != null){
                sizeOf ++;
            }

        }

        return sizeOf;
    }

    int hashKey(Key key){

        String stringKey = key.toString();
        int hashedStringKey = stringKey.hashCode();

        return (hashedStringKey % m);

    }

}
