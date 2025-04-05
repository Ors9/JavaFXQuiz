# 🎓 JavaFX Quiz App

A sleek multiple-choice quiz app built with JavaFX. Users can take a test, see which answers were right or wrong, and get a final grade — all from a clean, interactive GUI.

---

## 🚀 Features

✅ Beautiful JavaFX GUI  
✅ Instant feedback on each answer  
✅ Final score calculation  
✅ Ability to restart the test  
✅ Reads questions from a text file (`input.txt`)  
✅ Built entirely in Java with FXML

---

## 🗂️ Project Structure

```
JavaFXQuizApp/
├── src/                  # Java source files
│   ├── MyProject.java
│   ├── MyProjectController.java
│   ├── Question.java
│   ├── Answer.java
│   └── QuestionLoader.java
├── resources/            # App resources
│   ├── input.txt         # Quiz questions and answers
│   └── MyProject.fxml    # GUI layout
├── out/                  # Compiled .class files (after build)
├── run.bat               # Compile + run script for Windows
├── .gitignore
└── README.md
```

---

## 🧠 How It Works

- The app loads questions from `resources/input.txt`
- Each question is followed by 4 answers (the **first** is the correct one)
- Answers are randomized each time
- Click **"Done The Test"** to see which answers were correct
- Click **"Restart"** to reset and try again

---

## 🛠 How to Run

1. **Install Java (17+)** and the **JavaFX SDK (e.g. version 23)**  
   [Download JavaFX SDK here](https://gluonhq.com/products/javafx/)

2. Update your JavaFX path inside `run.bat`:
   ```
   set JAVAFX="C:\Program Files\Java\javafx-sdk-23.0.2\lib"
   ```

3. Double-click `run.bat` or run from terminal:
   ```bash
   ./run.bat
   ```

---

## 📃 Example Question Format (`input.txt`)

```text
What is the capital of France?
Paris
London
Berlin
Rome

What is 2 + 2?
4
3
5
22
```

Make sure:
- Each question has exactly 4 answers
- Questions are separated by a blank line

---

## 📌 Notes

- The GUI layout is defined in `MyProject.fxml`
- You can add more questions by editing `resources/input.txt`

---

## 👤 Author

Add your name here!

---

## 🌟 License

Free to use and modify for educational purposes.
