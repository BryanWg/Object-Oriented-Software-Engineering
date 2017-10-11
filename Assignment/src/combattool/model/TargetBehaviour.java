package combattool.model;


/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.util.*;
public abstract class TargetBehaviour
{
    private Team team;
    private String target;

    public TargetBehaviour(Team team, String target)
    {
        setTeam(team);
        setTarget(target);
    }

    // Mutators
    public void setTarget(String target)
    {
        if(target == null)
        {
            throw new IllegalArgumentException("Target is empty");
        }
        this.target = target;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    // ACCESSORS
    public Team getTeam()
    {
        return team;
    }

    public String getTarget()
    {
        return target;
    }

    // ABSTRACT  METHODS
    public abstract GameCharacter selectCharacter(int index, Team characterList);
    public abstract Team selectAll(Team characterList);
}
