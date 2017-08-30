import java.util.*;

/**
 * Represents a single address book entry.
 *
 * @author ...
 */
public class Entry
{
    // CLASSFIELDS
    private String name;
    private String emailOne;
    private String emailTwo;

    // CONSTRUCTOR
    public Entry(String name, String emailOne)
    {
        this.name = name;
        this.emailOne = emailOne;
    }
    public Entry(String name, String emailOne, String emailTwo)
    {
        this.name = name;
        this.emailOne = emailOne;
        this.emailTwo = emailTwo;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmailOne(String emailOne)
    {
        this.emailOne = emailOne;
    }

    public void setEmailTwo(String emailTwo)
    {
        this.emailTwo = emailTwo;
    }

    public String getName()
    {
        return name;
    }

    public String getEmailOne()
    {
        return emailOne;
    }

    public String getEmailTwo()
    {
        return emailTwo;
    }

    public String toString(String key)
    {
        return "Name: " + name + "\nEmail: " + emailOne + " " + emailTwo;
    }
}
