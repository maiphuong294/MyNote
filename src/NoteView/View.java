package NoteView;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public CardLayout cardLayout;
    public HomePanel homePanel = new HomePanel();
    public AddNotePanel addNotePanel = new AddNotePanel();
    public SearchNotePanel searchNotePanel = new SearchNotePanel();
    public ShowNotePanel showNotePanel = new ShowNotePanel();

    public JPanel mainPanel = new JPanel(new CardLayout());

    public View(){
        //homePanel

        //addNotePanel

        //searchNotePanel


        //showNotePanel

        //mainPanel.setLayout(new CardLayout());
        mainPanel.add(homePanel, "homePanel");
        mainPanel.add(addNotePanel, "addNotePanel");
        mainPanel.add(searchNotePanel, "searchNotePanel");
        mainPanel.add(showNotePanel, "showNotePanel");


        //Display homePanel first
        cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "homePanel");

        this.add(mainPanel);


        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
        this.setTitle("NoteTakingApp");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setVisible(true);
    }
}
