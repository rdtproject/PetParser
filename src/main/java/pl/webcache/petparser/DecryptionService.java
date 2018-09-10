package pl.webcache.petparser;

public class DecryptionService {

	public static void decryptText(String[] lines) {
		for (int i = 0; i < lines.length; i++) {
			Pattern pattern = Pattern.getPattern(lines[i]);
			if (pattern != null) {
				i = pattern.process(lines, i);
			}
		}
	}

}
