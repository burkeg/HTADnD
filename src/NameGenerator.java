public class NameGenerator {
	
	static String[] conBlends = { "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr",
			"gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk",
			"sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr" };
	static String[] vowBlends = { "ai", "au", "aw", "ay", "ea", "ee", "ei", "eu",
			"ew", "ey", "ie", "oi", "oo", "ou", "ow", "oy" };
	
	public static String getVowel() {

		int rand = (int) (Math.random() * vowBlends.length);

		return vowBlends[rand];
	}

	public static String getConsonant() {

		int rand = (int) (Math.random() * conBlends.length);

		return conBlends[rand];
	}

	public static String makeName() {
		String name = "";
		boolean startVowel = false;
		int rand = (int) (Math.random() * 2 + 3);
		for (int i = 0; i < rand; i++) {
			// if (Math.random() + (weightedValue* 4.0/10.0)< 0.5) {
			if (startVowel) {
				name += getVowel();
				startVowel = true;
			} else {
				name += getConsonant();
				startVowel = false;
			}
		}

		return name;
	}
	
	public static String makeName(int letterRangeLower, int letterRangeUpper) {
		String name = "";
		boolean startVowel = false;
		int rand = (int) (Math.random() * (letterRangeUpper - letterRangeLower) + letterRangeLower);
		for (int i = 0; i < rand; i++) {
			// if (Math.random() + (weightedValue* 4.0/10.0)< 0.5) {
			if (startVowel) {
				name += getVowel();
				startVowel = true;
			} else {
				name += getConsonant();
				startVowel = false;
			}
		}

		return name;
	}
	
	public static String makeName(int letterRangeLower, int letterRangeUpper, boolean startVowel) {
		String name = "";
		int rand = (int) (Math.random() * (letterRangeUpper - letterRangeLower) + letterRangeLower);
		for (int i = 0; i < rand; i++) {
			// if (Math.random() + (weightedValue* 4.0/10.0)< 0.5) {
			if (startVowel) {
				name += getVowel();
				startVowel = true;
			} else {
				name += getConsonant();
				startVowel = false;
			}
		}

		return name;
	}
}
