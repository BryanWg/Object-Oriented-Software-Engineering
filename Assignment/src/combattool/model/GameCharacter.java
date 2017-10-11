package combattool.model;

/**********************************************
 * CLASS: GameCharacter
 * PURPOSE: Container class to store fields for GameCharacter Objects
 * NAME: Christopher Chang
 * Student Id: 18821354
 ***********************************************/
import java.io.Serializable;
import java.util.*;
public abstract class GameCharacter implements Serializable
{
    // Maxmimum Health a character can have
    public static final int MAXHITPOINTS = 20;

    private String name;
    private int maxHp;
    private int curHp;
    private List<String> abilities;

    // CONSTRUCTOR
    public GameCharacter(String name, int maxHp, List<String> abilities)
    {
        setName(name);
        setMaxHp(maxHp);
        setCurHp(maxHp);
        setAbilities(abilities);
    }

    // MUTATORS
    public void setName(String name)
    {
        if(name == null)
        {
            throw new IllegalArgumentException("The character name is empty");
        }
        this.name = name;
    }

    public void setMaxHp(int maxHp)
    {
        if(maxHp < MAXHITPOINTS)
        {
            throw new IllegalArgumentException(("The Character's max health can't be less than 20"));
        }
        this.maxHp = maxHp;
    }

    public boolean setCurHp(int curHp)
    {
        boolean dead;
        this.curHp = curHp;

        dead = checkDeath(this.curHp);

        return dead;
    }

    /**
     * This is for the healing 10% or 5% when a player dies
     */
    public void addHeal(int healAmount)
    {
        curHp += healAmount;

        // Making sure that you don't heal over the maxHP
        if(curHp > maxHp)
        {
            curHp = maxHp;
        }
    }

    public boolean checkDeath(int curHp)
    {
        if(curHp <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setAbilities(List<String> abilities)
    {
        this.abilities = abilities;
    }

    // ACCESSORS
    public String getName()
    {
        return name;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public int getCurHp()
    {
        return curHp;
    }

    public List<String> getAbilities()
    {
        return abilities;
    }

    public String toString()
    {
        return "Name: " + name + ", HP: " + curHp + "/" + maxHp + ", Abilities: " + abilities.toString();
    }

    public String displayStats()
    {
        return "    Name: " + name + ", HP: " + curHp + "/" + maxHp;
    }




}
