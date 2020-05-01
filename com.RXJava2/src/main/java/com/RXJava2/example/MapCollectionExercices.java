package com.RXJava2.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapCollectionExercices {
	
	private String url;

	public MapCollectionExercices(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static void main(String[] args) {
		List<MapCollectionExercices> list = new ArrayList<MapCollectionExercices>();
	    list.add(new MapCollectionExercices("https://www.vogella.com/"));
	    list.add(new MapCollectionExercices("http://www.google.com"));
	    list.add(new MapCollectionExercices("http://www.heise.de"));
	    list.forEach(s -> System.out.println(s.toString()));
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
		
//		Map<String, Integer> map = createMap();
//		map.put("Android", 1 + map.getOrDefault("Android", 0));
//		
//		// write to command line
//		map.forEach((k, v) -> System.out.printf("%s %s%n", k, v));
		
//		Integer calculatedValue = map.computeIfAbsent("Java", it -> 6);
//		System.out.println(calculatedValue);
		
		// write to command line
//		map.keySet().forEach(key -> System.out.println(key + " " + map.get(key)));
		
		// Create a new ArrayList with the Arrays.asList helper method
//		List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
		// alternative can could reuse the integer comparator
        // Collections.sort(list, Integer::);
//		Collections.sort(list, (o1, o2) -> (o1 > o2 ? 1 : (o1 == o2 ? 0 : -1)));
		// Print each element to the console
//		list.forEach(System.out::println);
		
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
	
	@Override
	public String toString() {
		return "MapCollectionExercices [url=" + url + "]";
	}

	private static Map<String, Integer> createMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Eclipse IDE", 0);
		map.put("Eclipse RCP", 0);
		map.put("Git", 0);
		map.put("Groovy", 0);
		return map;
	}

}
