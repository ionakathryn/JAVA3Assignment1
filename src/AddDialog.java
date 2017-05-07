import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.*;

public class AddDialog extends Dialog  {


    public AddDialog(JFrame f) {
        super(f, true);
        final int DEFAULT_DIALOG_WIDTH = 1000;
        final int DEFAULT_DIALOG_HEIGHT = 700;
        setSize(DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT);
        setTitle("addRecord");
        module_code = new JTextField("module_code");
        module_code.setSize(124, 50);
        module_code.setLocation(500, 20);
        add(module_code);


        surname = new JTextField("Surname");
        surname.setSize(100, 50);
        surname.setLocation(20, 80);
        add(surname);

        initials = new JTextField("initials");
        initials.setSize(100, 50);
        initials.setLocation(20, 160);
        add(initials);

        title = new JTextField("title");
        title.setSize(100, 50);
        title.setLocation(20, 240);
        add(title);

        studentNum = new JTextField("studentNum");
        studentNum.setSize(100, 50);
        studentNum.setLocation(20, 320);
        add(studentNum);

        assesment_mark = new JTextField("assesment_mark");
        assesment_mark.setSize(100, 50);
        assesment_mark.setLocation(20, 400);
        add(assesment_mark);

        exam_mark = new JTextField("exam_mark");
        exam_mark.setSize(100, 50);
        exam_mark.setLocation(20, 480);
        add(exam_mark);

        error = new JTextField("this is an error textfield");
        add(error);

        submit = new JButton("submit");
        submit.setSize(100,50);
        submit.setLocation(20,560);
        submit.addActionListener(handle);
        add(submit);


        exit = new JButton("exit");
        exit.setSize(100,50);
        exit.setLocation(160,560);
        exit.addActionListener(handle);
        add(exit);

        error = new JTextField("error message goes here");
        error.setSize(300,150);
        error.setLocation(500,500);
        error.setEditable(false);
        add(error);


    }

    handler handle = new handler();

    public JTextField error, module_code, surname, initials, title,studentNum, assesment_mark, exam_mark ;
    public JButton submit,exit;

    public class handler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == exit){
                System.exit(0);
            }

            if (e.getSource() == submit){
                System.out.println("test" + module_code.getText());

                // validation tests
                validateSurname(surname.getText());
                validateInitials(initials.getText());
                validateTitle(title.getText());
                validateIntVal(studentNum.getText());
                validateIntVal(assesment_mark.getText());
                // validateDoubleVal(tuition_fee.getText());

               /* if (count > numOfChecks){

                    // write all data to file
                }

                 else {
                    // restart application and ask user to input again
                }
             */



            }

            }

        }


    public void validateSurname(String input){
        if (input.matches("^.*[^a-zA-Z0-9 ].*$") || input.length() > 20) {
            JOptionPane.showMessageDialog(null, "please enter valid surname value - must contain all alphabetical chars" +
                    " and be max 20 chars in length");
        }
        else{
            JOptionPane.showMessageDialog(null, "surname valid");
        }


    }

    public void validateInitials(String input){
        if (input.matches("^.*[^a-zA-Z0-9 ].*$") || input.length() > 6) {
            JOptionPane.showMessageDialog(null, "please enter valid initials value - must contain all alphabetical chars" +
                    " and be max 6 chars in length");
        }
        else{
            JOptionPane.showMessageDialog(null, "initials valid");
        }

    }

    public void validateTitle(String input){
        // make sure 6 chars and alphachars
        if (input.matches("^.*[^a-zA-Z0-9 ].*$") || input.length() > 6) {
            JOptionPane.showMessageDialog(null, "please enter valid title value - must contain all alphabetical chars" +
                    " and be max 6 chars in length");
        }
        else{
            JOptionPane.showMessageDialog(null, "title valid");
        }
    }

    public void validateIntVal(String input) {
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "please enter valid number -  must be an integer");
        } else {
            JOptionPane.showMessageDialog(null,  "valid");
        }
    }


    public void validateDoubleVal(String input){
        // make sure int
        try{
            Double.parseDouble(input);
            JOptionPane.showMessageDialog(null,"tuition fee valid");
        }
        catch(NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "please enter valid tuition fee");
        }
    }

    public void writeDatatoFile(){

    }
}