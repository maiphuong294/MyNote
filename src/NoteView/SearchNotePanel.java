package NoteView;

import NoteController.Controller;
import NoteModel.ANote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static NoteModel.Model.noteTitle;
import static NoteModel.Model.results;

public class SearchNotePanel extends JPanel{
    //searchNotePanel
    public JButton btn_backToMenu2 = new JButton("Back");
    public JLabel lb_searchNote = new JLabel("Search for your note");
    public JTextField textField_keyword = new JTextField();
    public JButton btn_findNote = new JButton("Find");

    public JLabel lb_result = new JLabel("Result");
    //JPanel searchNotePanel = new JPanel(new GridBagLayout());
    JPanel child1_searchNotePanel = new JPanel();//se quyet dinh layout sau
    JPanel child2_searchNotePanel = new JPanel();
    GridBagConstraints constraints = new GridBagConstraints();

    JPanel child1_child1_searchNotePanel = new JPanel();
    JPanel child2_child1_searchNotePanel = new JPanel();

    private Controller controller = new Controller();

    JComboBox<String> comboBox = new JComboBox<>();
    public JButton btn_select = new JButton("Select");
    public SearchNotePanel(){

        Font font1 = new Font("Monospaced", Font.BOLD, 20);
        lb_searchNote.setFont(font1);
        Font font2 = new Font("Monospaced", Font.BOLD, 15);
        btn_backToMenu2.setFont(font2);
        btn_findNote.setFont(font2);
        lb_result.setFont(font2);

        child1_searchNotePanel.setLayout(new BoxLayout(child1_searchNotePanel, BoxLayout.Y_AXIS));

        child1_child1_searchNotePanel.setBackground(new Color(23, 136, 84));
        child1_child1_searchNotePanel.setLayout(new BoxLayout(child1_child1_searchNotePanel, BoxLayout.X_AXIS));
        child1_child1_searchNotePanel.add(btn_backToMenu2);
        child1_child1_searchNotePanel.add(lb_searchNote);

        child2_child1_searchNotePanel.setBackground(new Color(125, 176, 147));
        child2_child1_searchNotePanel.setLayout(new BoxLayout(child2_child1_searchNotePanel, BoxLayout.X_AXIS));
        child2_child1_searchNotePanel.add(textField_keyword);
        child2_child1_searchNotePanel.add(btn_findNote);


        //Jcombobox luu result o day?
        //tao tinh nang tim kiem note dua vao cac character giong nhau
        child1_searchNotePanel.setPreferredSize(new Dimension(100, 600));
        child1_searchNotePanel.setBackground(new Color(125, 176, 147));

        child1_searchNotePanel.add(child1_child1_searchNotePanel);
        child1_searchNotePanel.add(child2_child1_searchNotePanel);

        //child2_searchNotePanel.setLayout()
        child2_searchNotePanel.setBackground(new Color(125, 176, 147));
        child2_searchNotePanel.add(lb_result);
        child2_searchNotePanel.add(comboBox);
        child2_searchNotePanel.add(btn_select);

        this.setBackground(new Color(43, 43, 43));
        this.setLayout(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        this.add(child1_searchNotePanel, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridheight = 3;
        this.add(child2_searchNotePanel, constraints);
        this.revalidate();
        this.repaint();

        btn_backToMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.switchToPanel("homePanel");
            }
        });
        btn_findNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.searchNotes(textField_keyword.getText());
                comboBox.removeAllItems();
                for(ANote note : results){
                    comboBox.addItem(note.title);


                }
//                if (comboBox. ){
//                    lb_result.setText("Found: ");
//                    comboBox.setVisible(true);
//                    comboBox.setEnabled(true);
//
//                }
//
//                else lb_result.setText("No result found");
//                lb_result.setVisible(false);
//                lb_result.setVisible(true);
            }

        });
        btn_select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteTitle = (String) comboBox.getSelectedItem();
                System.out.println(noteTitle);
                controller.switchToPanel("showNotePanel");
            }
        });
    }

}
