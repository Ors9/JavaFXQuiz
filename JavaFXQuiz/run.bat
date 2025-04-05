@echo off
set JAVAFX_PATH="C:\Program Files\Java\javafx-sdk-23.0.2\lib"
javac --module-path %JAVAFX_PATH% --add-modules javafx.controls,javafx.fxml MyProject.java
java --module-path %JAVAFX_PATH% --add-modules javafx.controls,javafx.fxml MyProject
pause
