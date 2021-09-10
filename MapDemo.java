package com.racloop.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    private static void hashMapDemo(){
        System.out.println("\ninside hashMapDemo");
        Map<String ,Integer> map1 = new HashMap<>();
        map1.put("gaurav",25);
        map1.put("saurav",24);
        map1.put("anita",28);
        map1.put("priya",null);
        System.out.println(map1);

        map1.put("priya",76);
        System.out.println(map1);
        System.out.println("Map1.containsKey : " +map1.containsKey("gaurav"));
        System.out.println("gaurav's age : "+ map1.get("gaurav"));
        System.out.println("iterating in the hashMap using keySet....");
        Set<String> names = map1.keySet();
        for(String name : names){
            System.out.println("name is : "+name+ "  age is :"+map1.get(name));
        }

        Map<String , Map<String, Object>> userProfile = new HashMap<>();
        Map<String,Object> profile = new HashMap<>();
        profile.put("age" ,25);

        profile.put("dept" ,"cs");

        profile.put("city" ,"new york");
        userProfile.put("john",profile);


        profile = new HashMap<>();
        profile.put("age" ,28);

        profile.put("dept" ,"cs");
        profile.put("ststuts","single");
        profile.put("ststuts","single");

        profile.put("city" ,"new york");
        userProfile.put("shiva",profile);
        System.out.println(userProfile);
    }
    public static void main(String [] ars){
        hashMapDemo();
    }
}
