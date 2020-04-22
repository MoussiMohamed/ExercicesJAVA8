package com.RXJava2.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapCollectionExercices {

	public static void main(String args[]) {
		
		// Objects are also Strings
//		Map<String, String> map = new HashMap<>();
//		fillData(map);

		// write to command line
		// map.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));

		// convert keys to array
//		String[] strings = keysAsArray(map);
//		for (String string : strings) {
//			System.out.println(string);
//		}
//		// convert keys to list
//		List<String> list = keysAsList(map);
//		for (String string : list) {
//			System.out.println(string);
//		}
		
		Map<String, Integer> map = createMap();
//		map.put("Android", 1 + map.getOrDefault("Android", 0));
//		
//		// write to command line
//		map.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
		
		Integer calculatedValue = map.computeIfAbsent("Java", it -> 6);
		System.out.println(calculatedValue);
		
		// write to command line
		map.keySet().forEach(key -> System.out.println(key + " " + map.get(key)));
		
	}
	
//	private static String[] keysAsArray(Map<String, String> map) {
//		return map.keySet().toArray(new String[map.keySet().size()]);
//	}
//	
//	// assumes the key is of type String
//	private static List<String> keysAsList(Map<String, String> map){
//		List<String> list = new ArrayList<String>(map.keySet());
//		return list;
//	}

//	private static void fillData(Map<String, String> map) {
//		map.put("Android", "Mobile");
//		map.put("Eclipse IDE", "Java");
//		map.put("Eclipse RCP", "Java");
//		map.put("Git", "Version control system");
//	}
	
	private static Map<String, Integer> createMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Eclipse IDE", 0);
		map.put("Eclipse RCP", 0);
		map.put("Git", 0);
		map.put("Groovy", 0);
		return map;
	}

}
