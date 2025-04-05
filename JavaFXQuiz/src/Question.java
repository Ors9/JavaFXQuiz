import java.util.ArrayList;
import java.util.Collections;

public class Question {

	private String question; // Text of the question
	private ArrayList<Answer> answers; // Array of answers
	int correctAnswerIndex; // The index (0 to 3) of the correct answer in the answers array

	// Constructor: receives the question text and an array of answers,
	// where the first answer is considered the correct one
	public Question(String question, String[] answersStr) {
		this.question = question;
		createAnswerShuffledList(answersStr);
		this.correctAnswerIndex = 0;
	}

	/**
	 * Creates Answer objects from the given array of strings, marks the first one
	 * as correct, shuffles the list, and updates the correct answer index.
	 */
	public void createAnswerShuffledList(String[] answersStr) {
		answers = new ArrayList<Answer>();
		boolean isCorrect = true;
		for (int i = 0; i < answersStr.length; i++) {
			answers.add(new Answer(answersStr[i], isCorrect));
			isCorrect = false;
		}
		Collections.shuffle(answers);
	}

	// Getter for the question text
	public String getQuestion() {
		return question;
	}

	// Return the answer list
	public ArrayList<Answer> getAnswers() {
		return answers;
	}

}
