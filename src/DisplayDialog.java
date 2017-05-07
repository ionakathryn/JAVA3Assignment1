import javax.swing.*;
import java.awt.Dialog;

public class DisplayDialog extends Dialog {

    public DisplayDialog(JFrame f) {
        super(f, true);
        final int DEFAULT_DIALOG_WIDTH = 1000;
        final int DEFAULT_DIALOG_HEIGHT = 700;
        setSize(DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT);
        setTitle("displayRecords");
    }
}
