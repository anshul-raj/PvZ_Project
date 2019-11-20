package PvZ;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private final String USERNAME;
    private final ArrayList<Game> AllSaveGame =  new ArrayList<>();

    public User(String username) {
        USERNAME = username;
    }

    public void LoadGame(int n){

    }

    public void SaveUser(){

    }

    public void NewGame(){

    }
}
