import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Controller class for the quiz application. Responsible for displaying
 * questions and checking answers when the test is submitted.
 */
public class MyProjectController {

	@FXML
	private Button doneTest; // Button to submit the test

	@FXML
	private Button restartButton;

	@FXML
	private VBox questionListVbox; // The main VBox inside the ScrollPane that holds all the question blocks

	private ArrayList<Question> questions = new ArrayList<>(); // List to hold all the loaded questions
	private ArrayList<ToggleGroup> toggleGroups = new ArrayList<>();

	// Called when the "Done The Test" button is pressed
	@FXML
	void doneTestPressed(MouseEvent event) {

		int rightAnswers = 0;
		for (int i = 0; i < toggleGroups.size(); i++) {
			ToggleGroup tg = toggleGroups.get(i);
			Toggle selected = tg.getSelectedToggle();

			VBox questionBlock = (VBox) questionListVbox.getChildren().get(i);

			Label feedBackLabel;
			if (selected == null) {
				feedBackLabel = new Label("No answer ❓");
				questionBlock.getChildren().add(1, feedBackLabel);
				continue;
			}

			Answer selectedAnswer = (Answer) selected.getUserData();
			if (selectedAnswer.isCorrect()) {
				feedBackLabel = new Label("The answer is Correct ✅");
				rightAnswers++;
			} else {
				feedBackLabel = new Label("The answer is Wrong ❌");
			}
			questionBlock.getChildren().add(1, feedBackLabel);
		}

		int grade = gradeOfTest(rightAnswers, toggleGroups.size());
		Label scoreLabel = new Label("Your score: " + grade + "%");
		scoreLabel.setStyle("-fx-font-size: 18px;" + "-fx-font-weight: bold;" + "-fx-text-fill: "
				+ (grade >= 60 ? "green;" : "red;") + "-fx-padding: 15;");
		questionListVbox.getChildren().add(0, scoreLabel);
		doneTest.setDisable(true);

	}

	int gradeOfTest(int rightAnswers, int totalQuestions) {
		return (int) (((double) rightAnswers / totalQuestions) * 100);
	}

	/**
	 * Initializes the GUI by loading questions from file and displaying them as
	 * blocks of question text and answer choices inside the ScrollPane.
	 */
	public void initialize() {
		// Load the questions from file into the list
		QuestionLoader.fileInputToQuestion(questions);

		// For each question, create a visual block and add it to the VBox
		for (Question q : questions) {
			VBox questionBlock = createQuestionBlock(q);
			questionListVbox.getChildren().add(questionBlock);
		}
	}

	@FXML
	void restartPressed(MouseEvent event) {
		// Reset the choose of the questions
		for (ToggleGroup tg : toggleGroups) {
			tg.selectToggle(null);
		}

		// Remove the messages
		for (Node node : questionListVbox.getChildren()) {
			if (node instanceof VBox) {
				VBox block = (VBox) node;

				if (block.getChildren().size() > 2) {
					block.getChildren().remove(1);
				}
			}
		}

		// Remove final answer
		if (!questionListVbox.getChildren().isEmpty() && questionListVbox.getChildren().get(0) instanceof Label) {

			Label label = (Label) questionListVbox.getChildren().get(0);
			if (label.getText().startsWith("Your score:")) {
				questionListVbox.getChildren().remove(0);
			}
		}

		doneTest.setDisable(false);
	}

	// Creates a Label for the question text
	private Label createQuestionLabel(String text) {
		Label label = new Label(text);
		label.setWrapText(true);// Allow text to wrap if it's too long
		return label;
	}

	// Creates a VBox with 4 RadioButtons (answers), all connected to the same
	// ToggleGroup
	private VBox createAnswersBox(ArrayList<Answer> answers, ToggleGroup group) {
		VBox box = new VBox();
		box.setSpacing(5); // Add spacing between answers

		for (Answer answer : answers) {
			RadioButton rb = new RadioButton(answer.getText()); // Create a radio button for each answer
			rb.setToggleGroup(group); // Ensure only one answer can be selected
			rb.setUserData(answer); // Store the Answer object for later checking
			box.getChildren().add(rb); // Add to the answer VBox
		}

		return box;
	}

	// Creates a complete block (VBox) that includes the question and its answer
	// options
	private VBox createQuestionBlock(Question question) {
		Label questionLabel = createQuestionLabel(question.getQuestion()); // Create label
		ToggleGroup toggleGroup = new ToggleGroup(); // Group for answer buttons
		VBox answersBox = createAnswersBox(question.getAnswers(), toggleGroup); // Create answers box
		toggleGroups.add(toggleGroup);

		VBox block = new VBox(); // Container for the question block
		block.setSpacing(10); // Spacing between question and answers
		block.setStyle("-fx-padding: 10; -fx-border-color: lightgray;"); // Visual styling
		block.getChildren().addAll(questionLabel, answersBox); // Add label and answers to block

		return block;

	}

}
