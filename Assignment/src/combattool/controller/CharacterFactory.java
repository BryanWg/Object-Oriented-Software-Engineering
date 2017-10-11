package combattool.controller;

import combattool.model.*;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.util.*;
public class CharacterFactory
{
    private GameCharacter gc;

    public CharacterFactory()
    {
        gc = null;
    }

    public GameCharacter createCharacter(String type, String name, int hp, List<String> abilities)
    {
        switch (type)
        {
            case "P":
                gc = new Player(name, hp, abilities);
                break;
            case "N":
                gc = new NonPlayer(name, hp, abilities);
                break;
            default:
                throw new IllegalArgumentException("Cannot create character");
        }

        return gc;
    }

}
