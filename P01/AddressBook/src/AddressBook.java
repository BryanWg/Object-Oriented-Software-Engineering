import java.util.*;

/**
 * Contains all the address book entries.
 *
 * @author ...
 */
public class AddressBook
{
    // I don't think key and value classfields are necessary
    private String key;
    private Entry value;
    private Map<String, Entry> hashMap;
    private Map<String, Entry> hashMapTwo;

    // CONSTRUCTOR
    /****************************************************************
    * Default Constructor
    *******************************************************************/
    public AddressBook()
    {
        hashMap = new HashMap<String, Entry>();
        hashMapTwo = new HashMap<String, Entry>();
    }

    /******************************************************************
    * Alternate Constructor
    * ****************************************************************/
    public AddressBook(String key, Entry value)
    {
        this.key = key;
        this.value = value;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setValue(Entry value)
    {
        this.value = value;
    }

    public void addKVP(String key, Entry value)
    {
//System.out.println("MAPONE: " + key + " " + value);
        hashMap.put(key, value);
    }

    public void addKVP2(String key, Entry value)
    {
//System.out.println("MAPTWO: " + key + " " + value);
        hashMapTwo.put(key, value);
    }

    public boolean findKeyName(String name)
    {
        return hashMap.containsKey(name);
    }

    public boolean findKeyEmail(String email)
    {
        return hashMapTwo.containsKey(email);
    }


    public String getKey()
    {
        return key;
    }

    /* Returns the specified value to where the key is mapped*/
    public Entry getValue(String key)
    {
        return hashMap.get(key);
    }

    public Entry getValueTwo(String email)
    {
        return hashMapTwo.get(email);
    }

    public String toString()
    {
        return value.toString(key);
    }
}
