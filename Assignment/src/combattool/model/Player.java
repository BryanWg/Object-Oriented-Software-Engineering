package combattool.model;

/**********************************************
 * CLASS: Player
 * PURPOSE: SubClass of GameCharacter
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.io.Serializable;
import java.util.*;
public class Player extends GameCharacter implements Serializable
{
    public Player(String name, int maxHp, List<String> abilities)
    {
        super(name, maxHp, abilities);
    }
}
