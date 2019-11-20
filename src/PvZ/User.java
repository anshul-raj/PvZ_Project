package PvZ;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class User implements Serializable {
    private final String USERNAME;
    private final ArrayList<Game> AllSaveGame =  new ArrayList<>();
    private int LevelsUnlocked = 1;
    private int LastPlayedLevel = 1;

    public User(String username) {
        USERNAME = username;
        for(int i=0;i<5;i++){
            AllSaveGame.add(new Game(i+1));
        }
        try {
            SaveUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public static User LoadUser(String name) throws IOException,ClassNotFoundException{
        ObjectInputStream input = null;
        User u = null;
        System.out.println(name);
        try {
            input = new ObjectInputStream(new FileInputStream("db/"+name));
            u= (User) input.readObject();
        }
        finally {
            if (input!=null){
                input.close();
            }
        }
        return u;
        // DeSerialize User
    }

    public void SaveUser() throws IOException {
        ObjectOutputStream out = null;
        try{
            File f = new File("db/"+this.USERNAME+".txt");
            System.out.println(f.exists());
            out = new ObjectOutputStream(new FileOutputStream("db/"+this.USERNAME+".txt"));
            out.writeObject(this);
        }
        finally {
            if (out!=null){
                out.close();
            }
        }
        // Serialize User
    }

    public void NewGame(){
    }
}
