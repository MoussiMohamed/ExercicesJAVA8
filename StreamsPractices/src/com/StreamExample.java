package com;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
	
	public static void main(String args[]) {
		List<String> strings = Arrays.asList("girafe", "chameau", "chat", "poisson", "cachalot");

	       strings.stream()
	               // filtrage

	               .filter(x -> x.contains("cha"))
	               // mapping : reformatage des chaînes de caractères

	               .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
	               // tri par ordre alphabétique

	               .sorted()
	               // Outputs:

	               // Cachalot

	               // Chameau

	               // Chat

	               .forEach( System.out::println );
	}

}
