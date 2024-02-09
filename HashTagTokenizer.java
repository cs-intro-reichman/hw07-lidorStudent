

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) {
		// Your code here
		int length = dictionary.length;
		for (int i = 0; i < length; i++) {
			if (word.equals(dictionary[i])) {
				return true;
			}
		}
		return false;
		
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		hashtag = hashtag.toLowerCase();
		String subString = "";

        for (int i = 1; i <= N; i++) {
			subString = hashtag.substring(0, i);
			if (existInDictionary(subString, dictionary)) {
				System.out.println(subString);
				breakHashTag(hashtag.substring(i), dictionary);
				break;
			}
        }
    }

}
