public class NameGenerator {

	static String[] vowelChunks = new String[25];
	
	public static void main(String[] args) {
		System.out.println(getVowel());
	}

	public static String getVowel() {
		String result = "";
		int count = 0;
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				vowelChunks[count] = 'a' + i + "" + 'a' + j;
			}
		}
		return result;
	}
}
