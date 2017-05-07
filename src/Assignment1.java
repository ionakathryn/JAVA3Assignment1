import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

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
        setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        setTitle("Student Records");
        setLayout(new GridLayout(3, 2));
        add = new JButton("Add");
        add.addActionListener(this);
        display = new JButton("Display");
        update = new JButton("Update");
        delete = new JButton("Delete");
        list = new JButton("List");
        done = new JButton("Done");
        done.addActionListener(this);

        addDialog = new AddDialog(this);
        addDialog.add(submit = new JButton("submit"));
        submit.setLocation(250,250);
        addDialog.setLayout(null);


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

        if (e.getSource() == add) {
            addDialog.setVisible(true);
        }
    }


    private JButton add, display, update, delete, list, done, submit;
    private AddDialog addDialog;
}

