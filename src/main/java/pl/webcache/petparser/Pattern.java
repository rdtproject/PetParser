package pl.webcache.petparser;

public enum Pattern {
	USER_COMENT("_comment") {
		public int process(String[] lines, int idx) {
			return TextProcessor.processSimpleText(lines, idx);
		}
	},
	CLIENT_NAME("_clientName") {
		public int process(String[] lines, int idx) {
			return TextProcessor.processSimpleText(lines, idx);
		}
	},
	PROCESS_ITEM_LIST("_itemList") {
		public int process(String[] lines, int idx) {
			return TextProcessor.processItemList(lines, idx);
		}
	},
	PROCESS_COMMENT_LIST("_commentList") {
		public int process(String[] lines, int idx) {
			return TextProcessor.processCommentList(lines, idx);
		}
	};

	private String pattern;

	private Pattern(String pattern) {
		this.pattern = pattern;
	}

	public static Pattern getPattern(String text) {
		for (Pattern pattern : Pattern.values()) {
			if (text.contains(pattern.pattern)) {
				return pattern;
			}
		}
		return null;
	}

	public abstract int process(String[] lines, int index);
}
