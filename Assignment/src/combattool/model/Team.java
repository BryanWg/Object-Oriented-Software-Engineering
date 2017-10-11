package combattool.model;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.io.Serializable;
import java.util.*;
public class Team implements Serializable
{
    private List<GameCharacter> teamList;
    private String teamName;

    // CONSTRUCTORS
   public Team()
    {
        teamList = new ArrayList<GameCharacter>();
    }

    public Team(List<GameCharacter> teamList, String teamName)
    {
        setTeamList(teamList);
        setTeamName(teamName);
    }

    // MUTATORS
    public void setTeamList(List<GameCharacter> teamList)
    {
        this.teamList = teamList;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public void addTeamMember(GameCharacter member)
    {
        if(member == null)
        {
            throw new IllegalArgumentException("Member doesn't exist");
        }
        teamList.add(member);
    }

    public void teamMemberDies(GameCharacter member)
    {
        if(teamList.contains(member) == false)
        {
            throw new NullPointerException("Member doesn't exist");
        }
        teamList.remove(member);
    }

    // ACCESSORS
    public List<GameCharacter> getTeamList()
    {
        return teamList;
    }

    public GameCharacter retrieveTeamMember(int index)
    {
        return teamList.get(index);
    }

    public String getTeamName()
    {
        return teamName;
    }

    public int getSize()
    {
        return teamList.size();
    }

    /**
     * Team's toString displays all the GameCharacters inside the teamList
     *
     */
    public String toString()
    {
        String str = "";

        for(GameCharacter character : teamList)
        {
            str += character.getName() + ", ";
        }

        return str;
    }

}
