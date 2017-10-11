package combattool.model;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.io.*;
import java.util.*;
public class GameState implements Serializable
{
    private List<Team> teamList;

    public GameState(List<Team> teamList)
    {
        this.teamList = teamList;
    }

    /**
     * Uses Serialization to save the current state of the game
     */
    public void saveFile(String fileName, GameState gameState)
    {
        FileOutputStream fileOut;
        ObjectOutputStream out;

        try
        {
            fileOut = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(gameState);
            out.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public void loadFile(String fileName, GameState state)
    {
        FileInputStream fileIn;
        ObjectInputStream in;

        try
        {
            fileIn = new FileInputStream(fileName);
            in = new ObjectInputStream(fileIn);

            state = (GameState) in.readObject();
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        catch(ClassNotFoundException e2)
        {
            e2.printStackTrace();
        }
    }
}
