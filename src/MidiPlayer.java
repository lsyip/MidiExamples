import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class MidiPlayer {

    private String fileName;
    private Sequence sequence;

    /**
    static {
        Sequencer sequencer = null; // Get the default Sequencer
        try {
            sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        if (sequencer == null) {
            System.err.println("Sequencer device not supported");
        }
    }
    **/
    // Constructor
    public MidiPlayer() {
        this.sequence = null;
        this.fileName = null;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "MidiPlayer{" +
                "fileName='" + fileName + '\'' +
                ", sequence=" + sequence +
                '}';
    }

    /**
    public Sequencer getSequencer() {
        Sequencer sequencer = null; // Get the default Sequencer
        try {
            sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        if (sequencer == null) {
            System.err.println("Sequencer device not supported");
        }
        return sequencer;
    }
**/
    public void playMidiFile() throws MidiUnavailableException, InvalidMidiDataException, IOException {

        Sequencer sequencer = null; // Get the default Sequencer
        try {
            sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        if (sequencer == null) {
            System.err.println("Sequencer device not supported");
        }

        sequencer.open(); // Open device
        // Create sequence, the File must contain MIDI file data.
        Sequence sequence = MidiSystem.getSequence(new File(getFileName()));
        sequencer.setSequence(sequence); // load it into sequencer

        sequencer.start();  // start the playback
    }

    public void stopPlayback() {
        Sequencer sequencer = null; // Get the default Sequencer
        try {
            sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        if (sequencer == null) {
            System.err.println("Sequencer device not supported");
        }

        sequencer.stop();
    }


}


