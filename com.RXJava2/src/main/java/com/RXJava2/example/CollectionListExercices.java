package com.RXJava2.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionListExercices {

	public static void main(String[] args) {
		
		System.out.println("Sorting with natural order");
		List<String> l1 = createList();
//		l1.sort(null);
//		l1.forEach(System.out::println);
//		
//		System.out.println("Sorting with a lamba expression for the comparison");
//        List<String> l2 = createList();
//        l2.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
//        l2.forEach(System.out::println);
//        
//        System.out.println("Sorting with a method references");
//        List<String> l3 = createList();
//        l3.sort(String::compareToIgnoreCase);
//        l3.forEach(System.out::println);
        
        // remove all items which contains "x"
        l1.removeIf(s -> s.toLowerCase().contains("x"));
        l1.forEach(s -> System.out.println(s));

	}
	
	private static List<String>  createList() {
		List<String> anotherList = new ArrayList<>();
        anotherList.addAll(Arrays.asList("iPhone", "Ubuntu", "Android",
        "Mac OS X"));
        return anotherList;
    }

}
