package HashMap;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class BasicOfHashMap {
    public static void main(String[] args) {

        // storing person's name and his roll;

        Map<String, Integer> hp = new HashMap<>();

        // adding element
        String s = "dsfihihf";
        int a = 3289;
        hp.put(s,a);
        hp.put("Ravi" , 22088726);
        hp.put("Rishav", 22829);
        hp.put("Rohit", 402249);
        hp.put("Shubham", 8238946);
        System.out.println(hp.get("Ravi"));
        System.out.println(hp.get("Raj"));

        hp.put("Ravi", 233131); // for changing the value of a key;
        System.out.println(hp.get("Ravi"));

        hp.remove("Shubham");  // removes as well as return the value against that key
        System.out.println(hp);

        System.out.println(hp.containsKey("Ravi"));  //return boolean

        hp.putIfAbsent("Raj",30443); // add elements if not present;
        System.out.println(hp);

        System.out.println(hp.keySet());  // gives all the keys;
        System.out.println(hp.values());  // gives all the values;
        System.out.println(hp.entrySet()); // gives all the entries;

        // for tranversing the hashmap

        for(String key : hp.keySet()){
            System.out.printf("Name is %s and his roll is %d\n",key,hp.get(key));
        }
        System.out.println();
        for(Map.Entry<String , Integer> e : hp.entrySet() ){
            System.out.println("Name is "+e.getKey()+" and his roll is "+e.getValue());
        }
        System.out.println();
        // simple way to traverse

        for(var x:hp.entrySet()){
            System.out.println("Name is "+x.getKey()+" and his roll is "+x.getValue());
        }

        

    }
}
