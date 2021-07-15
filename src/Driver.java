import javafx.application.Application;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, IOException {

        Application.launch(UserInterface.class, args);

        //MidiPlayer midiPlayer = new MidiPlayer();
        //midiPlayer.setFileName("src/crono.mid");
        //midiPlayer.playMidiFile();
    }
}
