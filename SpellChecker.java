
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		if (str.isEmpty()) {
			return "";
		}
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		if (word2.length() == 0) {
			return word1.length();
		}
		if (word1.length() == 0) {
			return word2.length();
		}
		if (word1.charAt(0) == word2.charAt(0)) {
			return levenshtein(tail(word1), tail(word2));
		}
		return 1 + Math.min(
				   Math.min(
					levenshtein(tail(word1), word2),
					levenshtein(word1, tail(word2))),
					levenshtein(tail(word1), tail(word2)));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here
		int length = dictionary.length;
		for (int i = 0; i < length; i++) {
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int length = dictionary.length;
		int minDistance = levenshtein(word, dictionary[0]);
		String similarWord = "";
		for (int i = 0; i < length; i++) {
			if (levenshtein(word, dictionary[i]) <= minDistance) {
				minDistance = levenshtein(word, dictionary[i]);
				similarWord = dictionary[i];
			}
		}
		if (minDistance > threshold) {
			return word;
		}
		return similarWord;
	}

}
