package combattool.model;

/**********************************************
 * CLASS: AbilityStats
 * PURPOSE: Implementation of the Ability interface
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
public class AbilityStats implements Ability
{
    // Minimum Base Damage an Ability can Deal
    public static final int MIN_BASE = 0;
    public static final int MIN_DICE = 1;
    public static final int MAX_DICE = 10;
    public static final int[] FACE_SET = {2, 3, 4, 6, 8, 10, 12};

    private String type;
    private String name;
    private String target;
    private int base;
    private int numDice;
    private int numFaces;

    // CONSTRUCTOR
    public AbilityStats(String type, String name, String target, int base, int numDice, int numFaces)
    {
        setType(type);
        setName(name);
        setTarget(target);
        setBase(base);
        setNumDice(numDice);
        setNumFaces(numFaces);
    }

    public void setType(String type)
    {
        if(type == null)
        {
            throw new IllegalArgumentException("Ability Type cannot be empty");
        }
        this.type = type;
    }

    public void setName(String name)
    {
        if(name == null)
        {
            throw new IllegalArgumentException("Name of ability cannot be empty");
        }
        this.name = name;
    }

    public void setTarget(String target)
    {
        if(target == null)
        {
            throw new IllegalArgumentException("Ability target cannot be empty");
        }
        this.target = target;
    }

    public void setBase(int base)
    {
        if(base < MIN_BASE)
        {
            throw new IllegalArgumentException("Base amount effect must be a positive integer");
        }
        this.base = base;
    }

    public void setNumDice(int numDice)
    {
        if((numDice < MIN_DICE) || (numDice > MAX_DICE))
        {
            throw new IllegalArgumentException("The number of dice must be a range from 1-10");
        }
        this.numDice = numDice;
    }

    public void setNumFaces(int numFaces)
    {
        boolean finished = false;

        for(int value : FACE_SET)
        {
            if(numFaces == value)
            {
                finished = true;
                this.numFaces = numFaces;
                break;
            }
        }

        // Checking to see if we iterated over the whole set and not set any value
        if(finished != true)
        {
            throw new IllegalArgumentException("Invalid number of faces");
        }
    }

    // ACCESSORS
    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public String getTarget()
    {
        return target;
    }

    public int getBase()
    {
        return base;
    }

    public int getNumDice()
    {
        return numDice;
    }

    public int getNumFaces()
    {
        return numFaces;
    }

    public String toString()
    {
        return "Type: " + type + ", Name: " + name + ", Target: " +  target + ", Base: " + base + ", NumDice: " + numDice + ", numFace: " + numFaces;
    }

}
