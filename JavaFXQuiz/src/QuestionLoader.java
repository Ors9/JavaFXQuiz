import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Utility class to load questions from a text file
public class QuestionLoader {

	// Static method that fills the provided questions list with data from
	// "input.txt"
	public static void fileInputToQuestion(ArrayList<Question> questions) {
		try {
			// Open the file "input.txt" for reading
			Scanner s = new Scanner(new File("input.txt"));
			// Loop over the lines in the file
			while (s.hasNextLine()) {
				String line = s.nextLine().trim();
				if (line.isEmpty()) {
					continue;// Skip empty lines
				}
				// The first non-empty line is the question text
				String questionText = line;
				// Create an array to store 4 answers
				String[] answers = new String[4];

				// Read the next 4 lines (the answers)
				for (int i = 0; i < 4; i++) {
					if (s.hasNextLine()) {
						answers[i] = s.nextLine().trim();
					}
				}
				// Create a new Question object with the text and answers
				questions.add(new Question(questionText, answers));

			}

			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: input.txt not found.");
		}

	}
}
