import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.*;
import java.io.RandomAccessFile;
import java.io.IOException;

public class AddDialog extends JDialog  {


    public AddDialog(JFrame f) {
        super(f, true);
        final int DEFAULT_DIALOG_WIDTH = 750;
        final int DEFAULT_DIALOG_HEIGHT = 850;
        setSize(DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT);
        setTitle("addRecord");
        module_code = new JTextField("module_code");
        module_code.setSize(124, 50);
        module_code.setLocation(500, 20);
        add(module_code);

        surnameL = new JLabel("enter surname:");
        surnameL.setSize(100,50);
        surnameL.setLocation(50,80);
        add(surnameL);

        surname = new JTextField("surname");
        surname.setSize(100, 50);
        surname.setLocation(200, 80);
        add(surname);

        initialsL = new JLabel("enter initials:");
        initialsL.setSize(100,50);
        initialsL.setLocation(50,160);
        add(initialsL);

        initials = new JTextField("initials");
        initials.setSize(100, 50);
        initials.setLocation(200, 160);
        add(initials);

        titleL = new JLabel("enter title:");
        titleL.setSize(100,50);
        titleL.setLocation(50,240);
        add(titleL);

        title = new JTextField("title");
        title.setSize(100, 50);
        title.setLocation(200, 240);
        add(title);

        studentNumL = new JLabel("enter studentNum:");
        studentNumL.setSize(100,50);
        studentNumL.setLocation(50,320);
        add(studentNumL);

        studentNum = new JTextField("studentNum");
        studentNum.setSize(100, 50);
        studentNum.setLocation(200, 320);
        add(studentNum);

        assesment_markL = new JLabel("enter assesment_mark:");
        assesment_markL.setSize(100,50);
        assesment_markL.setLocation(50,400);
        add(assesment_markL);

        assesment_mark = new JTextField("assesment_mark");
        assesment_mark.setSize(100, 50);
        assesment_mark.setLocation(200, 400);
        add(assesment_mark);

        exam_markL = new JLabel("enter exam_mark:");
        exam_markL.setSize(100,50);
        exam_markL.setLocation(50,480);
        add(exam_markL);

        exam_mark = new JTextField("exam_mark");
        exam_mark.setSize(100, 50);
        exam_mark.setLocation(200, 480);
        add(exam_mark);

        tuition_feeL = new JLabel("enter tuition fee:");
        tuition_feeL.setSize(100,50);
        tuition_feeL.setLocation(50,560);
        add(tuition_feeL);

        tuition_fee = new JTextField("tuition fee:");
        tuition_fee.setSize(100,50);
        tuition_fee.setLocation(200,560);
        add(tuition_fee);

        error = new JTextField("this is an error textfield");
        add(error);

        submit = new JButton("submit");
        submit.setSize(100,50);
        submit.setLocation(50,620);
        submit.addActionListener(handle);
        add(submit);


        exit = new JButton("exit");
        exit.setSize(100,50);
        exit.setLocation(200,620);
        exit.addActionListener(handle);
        add(exit);

        error = new JTextField("error message goes here");
        error.setSize(300,150);
        error.setLocation(500,100);
        error.setEditable(false);
        add(error);


    }

    handler handle = new handler();

    public JTextField error, module_code, surname, initials, title,studentNum, assesment_mark, exam_mark, tuition_fee ;
    public JButton submit,exit;
    public JLabel surnameL, initialsL,titleL,studentNumL,assesment_markL,exam_markL, tuition_feeL;
    int count = 0;
    int module_codeVal, studentNumVal, assesment_markVal, exam_markVal, tuition_feeVal;
    String surnameVal, initialsVal, titleVal;

    public class handler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == exit){
                System.exit(0);
            }

            if (e.getSource() == submit){
                count = 0;
                // validation tests
                validateSurname(surname.getText());
                validateInitials(initials.getText());
                validateTitle(title.getText());
                validateIntVal(studentNum.getText());
                validateIntVal(assesment_mark.getText());
                validateAll();



            }

            }

        }


    public void validateSurname(String input){
        if (input.matches("^.*[^a-zA-Z ].*$") || input.length() > 20) {
            JOptionPane.showMessageDialog(null, "please enter valid surname value - must contain all alphabetical chars" +
                    " and be max 20 chars in length");
        }
        else{
            JOptionPane.showMessageDialog(null, "surname valid");
            count ++;
        }


    }

    public void validateInitials(String input){
        if (input.matches("^.*[^a-zA-Z].*$") || input.length() > 6) {
            JOptionPane.showMessageDialog(null, "please enter valid initials value - must contain all alphabetical chars" +
                    " and be max 6 chars in length");
        }
        else{
            JOptionPane.showMessageDialog(null, "initials valid");
            count ++;
        }

    }

    public void validateTitle(String input){
        // make sure 6 chars and alphachars
        if (input.matches("^.*[^a-zA-Z].*$") || input.length() > 6) {
            JOptionPane.showMessageDialog(null, "please enter valid title value - must contain all alphabetical chars" +
                    " and be max 6 chars in length");
        }
        else{
            JOptionPane.showMessageDialog(null, "title valid");
            count ++;
        }
    }

    public void validateIntVal(String input) {
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "please enter valid number -  must be an integer");
        } else {
            JOptionPane.showMessageDialog(null,  "valid");
            count++;
        }
    }



    public void validateAll(){
        if (count == 5){
            JOptionPane.showMessageDialog(null,"OK to proceed with raf write");
            makeNewFile();
        }
        else{
            System.out.println(count);
        }

    }

   public void makeNewFile(){
    RandomAccessFile file = null;
    int recSize = 96;
    try{
        file = new RandomAccessFile("students", "rw");
        JOptionPane.showMessageDialog(null,"RandomAccessFile created succesfully!!!");
    }
    catch (IOException ioe){
        System.out.println("error opening file!");
        System.exit(1);
    }

    module_codeVal = Integer.parseInt(module_code.getText());
    studentNumVal = Integer.parseInt(studentNum.getText());

    }

    




  //  }
}
