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
    private Set<String> emails;

    // CONSTRUCTOR
    public Entry(String name)
    {
        this.name = name;
        emails = new HashSet<String>();
    }

    public boolean add(String email)
    {
        return emails.add(email);
    }

    public boolean contains(String key)
    {
        return emails.contains(key);
    }

    public String toString(String key)
    {
        String str = "Name: " + name + " Emails: ";

        for(String email : emails)
        {
            str += email + " ";
        }

        return str;
    }
}
