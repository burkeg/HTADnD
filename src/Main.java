public class Main {

	public static void main(String[] args) {
		// NameGenerator n = new NameGenerator();
		NameGenerator locationName = new NameGenerator(15, 20);
		for (int i = 0; i < 11; i++) {
			System.out.println(locationName.makeName());
		}
	}

}
