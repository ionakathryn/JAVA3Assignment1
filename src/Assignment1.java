import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Assignment1 {
    public static void main(String[] args){
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}

class MainFrame extends JFrame implements ActionListener {
    public MainFrame() {
        final int DEFAULT_FRAME_WIDTH = 500;
        final int DEFAULT_FRAME_HEIGHT = 500;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        setTitle("Student Records");
        setLayout(new GridLayout(3, 2));

        add = new JButton("Add");
        add.setPreferredSize(new Dimension(100,50));
        add.addActionListener(this);

        display = new JButton("Display");
        display.setPreferredSize(new Dimension(100,50));
        display.addActionListener(this);

        update = new JButton("Update");
        update.setPreferredSize(new Dimension(100,50));
        update.addActionListener(this);

        delete = new JButton("Delete");
        delete.setPreferredSize(new Dimension(100,50));
        delete.addActionListener(this);

        list = new JButton("List");
        list.setPreferredSize(new Dimension(100,50));
        list.addActionListener(this);

        done = new JButton("Done");
        done.addActionListener(this);

        addDialog = new AddDialog(this);
        addDialog.setLayout(null);

        displayDialog = new DisplayDialog(this);




        add(add);
        add(display);
        add(update);
        add(delete);
        add(list);
        add(done);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            System.exit(0);
        }

        if (e.getSource() == add){
            addDialog.setVisible(true);
        }

        if(e.getSource() == display){
            displayDialog.setVisible(true);
        }
    }


    private JButton add, display, update, delete, list, done;
    private AddDialog addDialog;
    private DisplayDialog displayDialog;
}

