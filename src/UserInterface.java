import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.File;
import java.io.IOException;


/**
 * @author Lynn Yip
 */
public class UserInterface extends Application {

    /**
     * Opens a synthesizer before the app opens.
     */
    @Override
    public void init() { //This method is used to load images or any other materials before the app is launched
    }

    /**
     * Sets up the JavaFX window
     */
    @Override

    public void start(Stage stage) { //sets up JavaFX GUI
        stage.setTitle("MidiPlayer"); //sets window title
        MidiPlayer midiPlayer = new MidiPlayer();

        Label l = new Label("File");
        l.setFont(new Font("Times New Roman", 32));
        l.setTranslateX(50);
        l.setTranslateY(75);

        //buttons
        Button fileSelect = new Button("Select File");
        Button play = new Button("Play");
        Button stop = new Button("Stop");


        //moving things around
        fileSelect.setTranslateX(300);
        play.setTranslateX(300);
        stop.setTranslateX(300);

        //TODO: Event Handlers for buttons
        fileSelect.setOnAction(actionEvent -> {  //EventHandler replaced with lambda

            final FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select midi file");
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                l.setText(selectedFile.toString());
                midiPlayer.setFileName(selectedFile.toString());
            }

        });

        // Play button
        play.setOnAction(actionEvent -> {
            try {
                midiPlayer.playMidiFile();
            } catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
                e.printStackTrace();
            }
        });

        // Stop button
        stop.setOnAction(actionEvent -> midiPlayer.stopPlayback());



        VBox root = new VBox(); //VBox displays all scene elements vertically
        Scene scene = new Scene(root, 500, 250); //sets VBox root and scene size
        root.getChildren().addAll(l, fileSelect, play, stop); //adds elements

        stage.setScene(scene); //puts everything together on the stage
        stage.show(); //makes the window visible
    }

    /**
     * Closes synthesizer when application is closed.
     */
    @Override
    public void stop() { //Runs after the app is closed
    }
}