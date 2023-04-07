package NoteController;

import NoteModel.Model;
import NoteModel.ANote;
import NoteView.View;

import java.awt.*;
import java.util.ArrayList;

import static Application.Application.theModel;
import static Application.Application.theView;


public class Controller {

    public Controller(){
        //theModel.readNotesFromFile();
        //de lay lai nhung du lieu da luu tu lan mo app truoc do
    }

    public void searchNotes(String searchString){
        theModel.searchNotes(searchString);
    }
    public void writeNotesToFile(){
        theModel.writeNotesToFile();
    }
    public void switchToPanel(String panelName){

        System.out.println("Chuyen sang panel:" + panelName);
        CardLayout cardLayout = (CardLayout) theView.mainPanel.getLayout();
        cardLayout.show(theView.mainPanel, panelName);
        for(Component component : theView.mainPanel.getComponents()){
            if (!component.isVisible()){
                disableComponents(component);
            }else{
                enableComponents(component);
            }
        }
        if(panelName.equals("homePanel") ){
            theModel.readNotesFromFile();
            theView.homePanel.setup();

        }
        if(panelName.equals("showNotePanel")){
            theView.showNotePanel.setup();
        }

    }

    private void disableComponents(Component component){
        if (component instanceof Container){
            for(Component child : ((Container) component).getComponents()){
                child.setEnabled(false);
                disableComponents(child);
            }
        }else{
            component.setEnabled(false);
        }
    }

    private void enableComponents (Component component){
        if (component instanceof Container){
            for(Component child : ((Container) component).getComponents()){
                child.setEnabled(true);
                enableComponents(child);
            }
        }else{
            component.setEnabled(true);
        }
    }
    public void ShowNoteByNoteTitle(String s){

    }

    /*class JumpCreateNoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            cardLayout.show("homePanel");

        }
    }
    class ShowNoteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           theModel.readNotesFromFile();
           String s = "";
           for(int i = 0; i < notes.size(); i++){
               s += "Note thu " + (i + 1) + ":\n";
               ANote a = notes.get(i);
               s += a.noteContent + '\n';
           }
           View.noteContent.setText(s);
        }
    }

    class DeleteNoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //delete note
            //luc sau se lam lai cai nay theo id
            //hoac la search roi delete
            //hoac la delete this one
            notes.clear();
            theModel.writeNotesToFile();
        }
    }
*/
}
