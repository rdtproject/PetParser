package pl.webcache.petparser;

public class TextProcessor {
	private static final String SPLITTER = " = ";
	private static final String DSPLITTER = " = Decrypted: ";

	public static int processSimpleText(String[] lines, int i) {
		decryptLine(lines, i);
		return i++;
	}

	public static int processItemList(String[] lines, int i) {
		for (; i < lines.length; i++) {
			if (lines[i].contains("]")) {
				break;
			}
			if (lines[i].contains("_itemValue")) {
				decryptLine(lines, i);
			}
		}
		return i++;
	}

	public static int processCommentList(String[] lines, int i) {
		for (; i < lines.length; i++) {
			if (lines[i].contains("]")) {
				break;
			}
			if (lines[i].contains("_commentText")) {
				decryptLine(lines, i);
			}
		}
		return i++;
	}

	private static void decryptLine(String[] lines, int i) {
		String[] tokens = lines[i].split(SPLITTER);
		if (tokens.length == 2) {
			lines[i] = tokens[0] + DSPLITTER + lines[1];
		}
	}
}
