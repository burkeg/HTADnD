public class NameGenerator {
	
	String[] conBlends = { "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr",
			"gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk",
			"sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr" };
	String[] vowBlends = { "ai", "au", "aw", "ay", "ea", "ee", "ei", "eu",
			"ew", "ey", "ie", "oi", "oo", "ou", "ow", "oy" };
	int letterRangeLower;
	int letterRangeUpper;
	
	public NameGenerator(int letterRangeLower, int letterRangeUpper) {
		this.letterRangeLower = letterRangeLower;
		this.letterRangeUpper = letterRangeUpper;
		System.out.println("hi");
	}
	
	/*public NameGenerator() {
		this.letterRangeLower = 3;
		this.letterRangeUpper = 5;
	}*/

	public String getVowel() {

		int rand = (int) (Math.random() * vowBlends.length);

		return vowBlends[rand];
	}

	public String getConsonant() {

		int rand = (int) (Math.random() * conBlends.length);

		return conBlends[rand];
	}

	public String makeName() {
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
}
