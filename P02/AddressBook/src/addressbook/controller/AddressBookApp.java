package addressbook.controller;
import addressbook.view.*;
import addressbook.model.*;

import java.io.*;
import java.util.*;

/**
 * A simple address book application.
 * @author Dave and ...
 */
public class AddressBookApp
{
    /**
     * Read the address book file, containing all the names and email addresses.
     *
     * @param fileName The name of the address book file.
     * @return A new AddressBook object containing all the information.
     * @throws IOException If the file cannot be read.
     */
    public static AddressBook readAddressBook(String fileName) throws IOException
    {
        AddressBook addressBook = new AddressBook();
        Entry entry;

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while(line != null)
        {
            String[] parts = line.split(":");

            // Processes each line
            entry = processLine(parts);

            // Adds the Key and Value into the HashMap
            addressBook.addKVP(parts[0], entry);

            // Adds so you can search by entry
            for(int i = 1; i < parts.length; i++)
            {
                addressBook.addKVP2(parts[i], entry);
            }

/*******************************************************************************
            // Insert your code here to add a new address book entry.
            // Note:
            // parts[0] contains the person's name.
            // parts[1], parts[2], etc. contain the person's email address(es).
*******************************************************************************/
            line = reader.readLine();
        }
        reader.close();

        return addressBook;
    }

    /************************************************************************
    * SUBMODULE: processLine                                                *
    * IMPORTS: line (String[])                                              *
    * EXPORT: none                                                          *
    * ASSERTION: Constructs the Entry for the Entry                         *
    * **********************************************************************/
    public static Entry processLine(String[] line)
    {
        Entry entry = new Entry(line[0]);

        // Assuming element 0 is never an email
        for(int i = 1; i < line.length; i++)
        {
            entry.add(line[i]);
        }

        return entry;
    }
}
