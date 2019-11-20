package PvZ;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class User implements Serializable {
    private final String USERNAME;
    private final ArrayList<Game> AllSaveGame =  new ArrayList<>(5);
    private int LevelsUnlocked = 1;
    private int LastPlayedLevel = 1;
    public User(String username) {
        USERNAME = username;
        for(int i=0;i<5;i++){
            AllSaveGame.set(i,new Game(i+1));
        }
    }

    public static User LoadUser(String name) throws IOException,ClassNotFoundException{
        ObjectInputStream input = null;
        User u = null;
        try {
            input = new ObjectInputStream(new FileInputStream("db/"+name));
            u= (User) input.readObject();
        } finally {
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
            out = new ObjectOutputStream(new FileOutputStream("db/"+this.USERNAME));
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
