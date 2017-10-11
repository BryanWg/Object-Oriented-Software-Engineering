package combattool.model;

/**********************************************
 * CLASS: NonPlayer
 * PURPOSE: Subclass of GameCharacter
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.io.Serializable;
import java.util.*;
public class NonPlayer extends GameCharacter implements Serializable
{
    public NonPlayer(String name, int maxHp, List<String> abilities)
    {
        super(name, maxHp, abilities);
    }

}
