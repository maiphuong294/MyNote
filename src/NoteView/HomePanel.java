package NoteView;

import NoteController.Controller;
import NoteModel.ANote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Application.Application.theView;
import static NoteModel.Model.noteTitle;
import static NoteModel.Model.notes;

public class HomePanel extends JPanel{
    //homePanel
    private JButton btn_createNote = new JButton("Create Note");
    private JButton btn_searchNote = new JButton("Search Note");
    private JButton btn_deleteAllNote = new JButton("Delete All");
    private JButton btn_selectNote = new JButton("Select");

    //JPanel homePanel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();


    JPanel child1_homePanel = new JPanel(new BorderLayout());
    JPanel child2_homePanel = new JPanel(new BorderLayout());

    JLabel lb_home = new JLabel("  Home");
    JLabel lb_lastRecent = new JLabel("Last Recent");
    JPanel child1_child1_homePanel = new JPanel();

    JPanel child1_child2_homePanel = new JPanel();
    JPanel child2_child2_homePanel = new JPanel();

    private Controller controller = new Controller();

    JComboBox<String> comboBox = new JComboBox<>();
    public HomePanel(){
        setup();

        Font font1 = new Font("Monospaced", Font.BOLD, 50);
        lb_home.setFont(font1);
        lb_home.setAlignmentX(Component.RIGHT_ALIGNMENT);
        //lb_home.setHorizontalAlignment();

        Font font2 = new Font("Monospaced", Font.PLAIN, 20);
        btn_createNote.setFont(font2);
        btn_searchNote.setFont(font2);
        btn_deleteAllNote.setFont(font2);
        //btn_searchNote.setBackground(new Color(73, 140, 102));

        Font font3 = new Font("Monospaced", Font.BOLD, 15);
        lb_lastRecent.setFont(font3);

        btn_searchNote.setMaximumSize(new Dimension(Integer.MAX_VALUE, btn_searchNote.getPreferredSize().height));
        btn_searchNote.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn_createNote.setMaximumSize(new Dimension(Integer.MAX_VALUE, btn_searchNote.getPreferredSize().height));
        btn_createNote.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn_deleteAllNote.setMaximumSize(new Dimension(Integer.MAX_VALUE, btn_searchNote.getPreferredSize().height));
        btn_deleteAllNote.setAlignmentX(Component.LEFT_ALIGNMENT);


        child1_homePanel.setBackground(new Color(125, 176, 147));
        child1_child1_homePanel.setLayout(new BoxLayout(child1_child1_homePanel, BoxLayout.Y_AXIS));
        child1_child1_homePanel.add(btn_createNote);
        child1_child1_homePanel.add(btn_searchNote);
        child1_child1_homePanel.add(btn_deleteAllNote);
        child1_child1_homePanel.setBackground(new Color(125, 176, 147));


        child1_child2_homePanel.setBackground(new Color(235, 211, 199));
        child1_child2_homePanel.setLayout(new BorderLayout());
        child2_child2_homePanel.setLayout(new BorderLayout());

        child1_child2_homePanel.add(lb_lastRecent, BorderLayout.SOUTH);
        child2_child2_homePanel.add(comboBox, BorderLayout.CENTER );
        child2_child2_homePanel.add(btn_selectNote, BorderLayout.SOUTH);

        child1_homePanel.add(lb_home, BorderLayout.NORTH);
        child1_homePanel.add(child1_child1_homePanel, BorderLayout.SOUTH);

        child2_homePanel.setLayout(new BoxLayout(child2_homePanel, BoxLayout.Y_AXIS));
        child2_homePanel.add(child1_child2_homePanel);
        child2_homePanel.add(child2_child2_homePanel);

        child1_homePanel.setPreferredSize(new Dimension(200, 400));

        this.setBackground(new Color(125, 176, 147));
        this.setLayout(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(child1_homePanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 3;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 3;

        this.add(child2_homePanel, constraints);

        btn_createNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.switchToPanel("addNotePanel");
            }
        });
        btn_searchNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.switchToPanel("searchNotePanel");
            }
        });
        btn_deleteAllNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notes.clear();
                controller.writeNotesToFile();
                comboBox.removeAllItems();
                for(ANote a : notes){
                    comboBox.addItem(a.title);
                }
                revalidate();
                repaint();
                lb_lastRecent.setText("You have " +  Integer.toString(comboBox.getItemCount()) +" items");


            }
        });
        btn_selectNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteTitle = (String)comboBox.getSelectedItem();
                controller.switchToPanel("showNotePanel");
            }
        });


    }
    public void setup(){
        comboBox.removeAllItems();
        for(ANote a : notes){
            comboBox.addItem(a.title);
        }
//        revalidate();
//        repaint();
        lb_lastRecent.setText("You have " +  Integer.toString(comboBox.getItemCount()) +" items");
    }
}
