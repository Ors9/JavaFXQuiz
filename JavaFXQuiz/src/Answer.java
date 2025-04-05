
/**
 * Represents a single answer option in a multiple-choice question. Each answer
 * has the answer text and a flag indicating whether it's the correct one.
 */
public class Answer {
	private String text; // The text of the answer
	private boolean isCorrect; // Indicates whether this answer is the correct one

	// Constructor for Answer.
	public Answer(String text, boolean isCorrect) {
		this.text = text;
		this.isCorrect = isCorrect;
	}

	// @return The text of the answer.
	public String getText() {
		return text;
	}

	// @return true if this is the correct answer, false otherwise.
	public boolean isCorrect() {
		return isCorrect;
	}
}
