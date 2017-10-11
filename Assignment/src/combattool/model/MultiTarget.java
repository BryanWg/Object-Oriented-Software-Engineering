package combattool.model;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.util.*;
public class MultiTarget extends TargetBehaviour
{
    // CONSTRUCTOR
    public MultiTarget(Team team, String target)
    {
        super(team, target);
    }

    public GameCharacter selectCharacter(int index, Team characterList)
    {
        // For MultiTarget you want all the characters to be selected
        return null;
    }

    public Team selectAll(Team characterList)
    {
        return characterList;
    }

}
