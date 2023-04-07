package NoteView;

import NoteController.Controller;
import NoteModel.ANote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

import static Application.Application.theModel;
import static NoteModel.Model.noteTitle;
import static NoteModel.Model.notes;

public class ShowNotePanel extends JPanel{
    //showNotePanel
    public JButton btn_backToMenu3 = new JButton("Back");
    public JButton btn_deleteNote = new JButton("Delete this one");

    public JLabel lb_noteName = new JLabel("Title: ");
    public JLabel lb_noteContent = new JLabel("Content: ");
    public JTextArea textArea_noteName = new JTextArea();
    public JTextArea textArea_content2 = new JTextArea();
    //JPanel showNotePanel = new JPanel(new GridBagLayout());
    JPanel child1_showNotePanel = new JPanel();

    private Controller controller = new Controller();
    public ShowNotePanel(){
        setup();

        child1_showNotePanel.setBackground(new Color(125, 176, 147));
        child1_showNotePanel.setLayout(new BoxLayout(child1_showNotePanel, BoxLayout.Y_AXIS));
        child1_showNotePanel.add(lb_noteName);
        child1_showNotePanel.add(textArea_noteName);
        child1_showNotePanel.add(lb_noteContent);
        child1_showNotePanel.add(textArea_content2);

        this.setLayout(new BorderLayout());
        this.add(btn_backToMenu3, BorderLayout.NORTH);
        this.add(child1_showNotePanel, BorderLayout.CENTER);
        this.add(btn_deleteNote, BorderLayout.SOUTH);

        btn_backToMenu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.switchToPanel("homePanel");
            }
        });
        btn_deleteNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < notes.size(); i++){
                    if(notes.get(i).title.equals(noteTitle)){
                        notes.remove(i);
                        theModel.writeNotesToFile();
                        break;

                    }
                }
                controller.switchToPanel("homePanel");
            }
        });
    }
    public void setup(){
        textArea_noteName.setText(noteTitle);
        String s = "khong tim thay";
        for(ANote note : notes){
            System.out.println(note.title +" "+ noteTitle);

            if(note.title.equals(noteTitle) ){
                System.out.println("tim thay" );
                s = note.noteContent;
                break;
            }
        }

            textArea_content2.setText(s);

    }

}
