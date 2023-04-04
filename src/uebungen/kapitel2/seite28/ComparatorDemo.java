package uebungen.kapitel2.seite28;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
	public static void main(String[] args) {
		String[] array = new String[] {"Z", "f", "a", "X", "d", "M", "b", "K", "C", "v"};
		for (String s : array) System.out.println("Unsortiert: " + s);
		
//		sortWithComparator(array);
		sortWithLambda(array);
		
		for (String s : array) System.out.println("Sortiert: " + s);
	}
	
	private static void sortWithComparator(String[] array) {
		Arrays.sort(array, new Comparator<String>() {
			public int compare(String o1, String o2) {
				// bspw. durch Umwandlung in Großbuchstaben
				String s1 = o1.toUpperCase();
				String s2 = o2.toUpperCase();
				return s1.compareTo(s2);
			}
		});
	}
	
	private static void sortWithLambda(String[] array) {
		Arrays.sort(array, (o1, o2) -> {
			String s1 = o1.toUpperCase();
			String s2 = o2.toUpperCase();
			return s1.compareTo(s2);
		});
	}
}
