package NoteModel;
import java.io.*;
import java.util.ArrayList;


public class Model {
    public static ArrayList<ANote> notes = new ArrayList<ANote>();
    public static ArrayList<ANote> results = new ArrayList<ANote>();
    public static File filenote = new File("D:\\mynote.txt");
    public static String noteTitle;
    public Model(){
        this.readNotesFromFile();
    }
    //CreateNote
    public static void createNote(ANote a){
        System.out.println("CreateNote");
        notes.add(a);
    }

    public static void writeNotesToFile(){

        System.out.println("Write notes to file");
        try {
            FileOutputStream fos = new FileOutputStream(filenote);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(notes);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //ShowNote
    public static void readNotesFromFile(){

        System.out.println("Read notes from file");
        try {
            FileInputStream fis = new FileInputStream(filenote);
            ObjectInputStream ois = new ObjectInputStream(fis);

            notes = (ArrayList<ANote>) ois.readObject();
            ois.close();
            System.out.println("Doc thanh cong "+ notes.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void searchNotes(String searchString){
        results.clear();
        for(ANote note : notes){
            if (note.title.contains(searchString) || note.noteContent.contains(searchString)){
                results.add(note);
            }
        }

    }

    //EDIT



}
