package addressbook.view;
import addressbook.model.*;
import addressbook.controller.*;

import java.util.*;
import java.io.*;

public class AddressBookUI
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String fileName, entryName;

        System.out.print("Enter address book filename: ");
        fileName = input.nextLine();

        try
        {
            showMenu(AddressBookApp.readAddressBook(fileName));
        }
        catch(IOException e)
        {
            System.out.println("Could not read from " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Show the main menu, offering the user options to (1) search entries by
     * name, (2) search entries by email, or (3) quit.
     *
     * @param addressBook The AddressBook object to search.
     */
    private static void showMenu(AddressBook addressBook)
    {
        Scanner input = new Scanner(System.in);
        boolean done = false;
        while(!done)
        {
            int option;
            System.out.println("(1) Search by name, (2) Search by email, (3) Quit");

            try
            {
                switch(Integer.parseInt(input.nextLine()))
                {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = input.nextLine();

                        // Checking if the input name exists in the Map
                        if(addressBook.findKeyName(name))
                        {
                            // Prints out the corresponding email address
                            System.out.println(addressBook.getValue(name).toString(name));
                        }
                        else
                        {
                            System.out.println("Name not found!");
                        }

/******************************************************************************
                        // Insert your code here to find an entry by name and display it.
******************************************************************************/
                        break;

                    case 2:
                        System.out.print("Enter email address: ");
                        String email = input.nextLine();

                        // Prints out the Entry
                        if(addressBook.findKeyEmail(email))
                        {
                            System.out.println(addressBook.getValueTwo(email).toString(email));
                        }
                        else
                        {
                            System.out.println("Email not found!");
                        }
    /******************************************************************************
                        // Insert your code here to find an entry by email and display it.
    ******************************************************************************/
                        break;

                    case 3:
                        done = true;
                        break;
                }
            }
            catch(NumberFormatException e)
            {
                // The user entered something non-numerical.
                System.out.println("Enter a number");
            }
        }
    }
}
