package NoteView;

import NoteController.Controller;
import NoteModel.ANote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Application.Application.theView;
import static NoteModel.Model.notes;


public class AddNotePanel extends JPanel{
    //addNotePanel
    public JButton btn_backToMenu1 = new JButton("Back");
    public JLabel lb_enterNoteName = new JLabel("Title:");
    public JTextArea textArea_noteName = new JTextArea();
    public JLabel lb_content = new JLabel("Your note content:");
    public JTextArea textArea_content = new JTextArea();

    //JPanel addNotePanel = new JPanel(new BorderLayout());

    public JLabel lb_addNote = new JLabel("Add new note here");

    JPanel child1_notePanel = new JPanel();//boxlayout y_axis
    JPanel child2_notePanel = new JPanel();
        JPanel child1_child1_notePanel = new JPanel();
        JPanel child2_child1_notePanel = new JPanel();
    //child2 ben tren child1

    JButton btn_submitNote = new JButton("Done");

    private Controller controller = new Controller();
    public AddNotePanel(){
        Font font1 = new Font("Monospaced", Font.BOLD, 20);
        lb_addNote.setFont(font1);
        Font font2 = new Font("Monospaced", Font.BOLD, 15);
        lb_enterNoteName.setFont(font2);
        lb_content.setFont(font2);

        child1_notePanel.setBackground(new Color(73, 140, 102));
        child1_notePanel.setLayout(new BoxLayout(child1_notePanel, BoxLayout.Y_AXIS));

        child1_child1_notePanel.setBackground(new Color(125, 176, 147));
        child2_child1_notePanel.setBackground(new Color(125, 176, 147));
        child1_child1_notePanel.setLayout(new BoxLayout(child1_child1_notePanel, BoxLayout.X_AXIS));
        child2_child1_notePanel.setLayout(new BoxLayout(child2_child1_notePanel, BoxLayout.X_AXIS));

        child1_child1_notePanel.add(lb_enterNoteName);
        child1_child1_notePanel.add(textArea_noteName);
        child2_child1_notePanel.add(lb_content);
        child2_child1_notePanel.add(textArea_content);


        child1_notePanel.add(child1_child1_notePanel);
        child1_notePanel.add(child2_child1_notePanel);

        //btn_backToMenu1.setAlignmentX(Component.LEFT_ALIGNMENT);
        child2_notePanel.setBackground(new Color(73, 140, 102));
        child2_notePanel.add(btn_backToMenu1);
        child2_notePanel.add(lb_addNote);

        this.setLayout(new BorderLayout());

        this.add(child2_notePanel, BorderLayout.NORTH);
        this.add(child1_notePanel, BorderLayout.CENTER);
        this.add(btn_submitNote, BorderLayout.SOUTH);

        btn_backToMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.switchToPanel("homePanel");
            }
        });
        btn_submitNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog dialog = new JDialog(theView, "Dialog Box", true);
                //modal la true la khong duoc an ra ngoai
                JLabel lb_dialog = new JLabel();
                JButton btn_OKdialog = new JButton("OK");

                //kiem tra xem notetitle co empty hay khong
                String text = textArea_noteName.getText().trim();
                System.out.println(text);
                if(text.equals("")){

                    lb_dialog.setText("Please enter the title of the note");
                }else{
                    //neu khong empty thi save note
                    lb_dialog.setText("    Note saved");
                    ANote note = new ANote();
                    note.title = textArea_noteName.getText();
                    note.noteContent = textArea_content.getText();
                    notes.add(note);
                    controller.writeNotesToFile();
                }
                btn_OKdialog.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });
                dialog.setLayout(new BorderLayout());
                dialog.add(btn_OKdialog, BorderLayout.SOUTH);
                dialog.add(lb_dialog, BorderLayout.CENTER);
                dialog.setSize(200, 100);
                dialog.setLocationRelativeTo(child1_notePanel);
                dialog.setVisible(true);

                textArea_content.setText("");
                textArea_noteName.setText("");
            }//comment
        });
    }
}
