package combattool.model;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.util.*;
public class SingleTarget extends TargetBehaviour
{
    // CONSTRUCTOR
    public SingleTarget(Team team, String target)
    {
        super(team, target);
    }


    public GameCharacter selectCharacter(int index, Team characterList)
    {
        return characterList.retrieveTeamMember(index);
    }

    public Team selectAll(Team characterList)
    {
        // For single target abilities you don't want to be able to
        // select everyone in the list
        return null;
    }

}
