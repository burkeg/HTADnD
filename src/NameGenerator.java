public class NameGenerator {

	static String[] conBlends = { "br", "ch", "ck", "cl", "cr", "dr", "fl",
			"fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh",
			"sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh",
			"wr" };
	static String[] vowBlends = { "ai", "au", "aw", "ay", "ea", "ee", "ei",
			"eu", "ew", "ey", "ie", "oi", "oo", "ou", "ow", "oy" };

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
		int weightedValue = 0;
		int rand = (int) (Math.random() * 2 + 3);
		for (int i = 0; i < rand; i++) {
			// if (Math.random() + (weightedValue* 4.0/10.0)< 0.5) {
			if (weightedValue < 0) {
				name += getVowel();
				weightedValue++;
			} else {
				name += getConsonant();
				weightedValue--;
			}
		}

		return name;
	}
}
