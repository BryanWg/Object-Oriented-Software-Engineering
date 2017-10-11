package combattool.view;
import combattool.model.*;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.util.*;
public class UserInterface
{
    public int showMenu()
    {
        int choice = 0;
        boolean finished = false;

        do
        {
            try
            {
                choice = userInput("\n\nSelect an option:\n1: New Game\n2: Exit\n\n", 1, 2);

                if(choice == 1 || choice == 2 || choice == 3 || choice == 4)
                {
                    finished = true;
                }
            }
            catch (InputMismatchException e)
            {
                finished = false;
                System.out.println(e.getMessage());
            }
        }while(!finished);


        return choice;
    }

    public int showMenu2()
    {
        int choice = 0;
        boolean finished = false;

        do
        {
            try
            {
                choice = userInput("Select an option:\n1: New Game\n" +
                        "2: Save Game\n3: Load Game\n" +
                        "4: Play Round\n5: Exit\n\n", 1, 5);

                if(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5)
                {
                    finished = true;
                }
            }
            catch (InputMismatchException e)
            {
                finished = false;
                System.out.println(e.getMessage());
            }
        }while(!finished);


        return choice;
    }

    /****
     Allows user to select a valid option from the menu
     ***/
    public int userInput(String prompt, int lower, int upper)
    {
        Scanner sc = new Scanner(System.in);
        int value = 0;

        try
        {
            System.out.println(prompt);
            value = sc.nextInt();

            while(value < lower || value > upper)
            {
                System.out.println("Invalid input try again!");
                System.out.println(prompt);
                value = sc.nextInt();
            }
        }
        catch(InputMismatchException e)
        {
            throw new InputMismatchException("Invalid input try again!");
        }

        return value;
    }

    /**
     * FUNCTION: inputFileName
     * ASSERTION: Asks the user to enter the name of the file for ability
     * and the characters
     */
    public String inputFileName(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        String file;

        System.out.println(prompt);
        file = sc.nextLine();

        return file;
    }

    /**
     * FUNCTION: showRound
     * ASSERTION: Displays the Round interface to the user
     */
    public int showTurn()
    {
        int choice = 0;
        boolean finished = false;

        do
        {
            try
            {
                choice = userInput("1. Use an ability\n2. End turn",1, 2);

                if(choice == 1 || choice == 2)
                {
                    finished = true;
                }
            }
            catch (InputMismatchException e)
            {
                finished = false;
                System.out.println(e.getMessage());
            }
        }while(!finished);


        return choice;
    }

    /**
     * FUNCTION: print
     */
    public void print(GameCharacter player)
    {
        System.out.println("\n" + player.getName() + "'s turn!");
    }

    /**
     *FUNCTION: listPlayerAbilities
     * ASSERTION: Lists out all the abilities the player has and returns the count
     */
    public int listPlayerAbilities(GameCharacter player)
    {
        int count = 0;

        for(String ability : player.getAbilities())
        {
            count++;
            System.out.printf("%d. %s\n", count, ability);
        }

        return count;
    }

    public int selectAbilityFromList(GameCharacter player, int max)
    {
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        choice = sc.nextInt();
        while (choice <= 0 || choice > max) {
            System.out.println("Invalid input...Try Again!");
            int count = 0;

            for (String ability : player.getAbilities())
            {
                count++;
                System.out.printf("%d. %s\n", count, ability);
            }
            choice = sc.nextInt();
        }

        return choice;
    }

    /**
     * FUNCTION: display
     * ASSERTION: Allows you to display whatever the prompt is
     */
    public void display(String prompt)
    {
        System.out.println(prompt);
    }

    public int selectEnemyList(List<GameCharacter> gc)
    {
        int retVal;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        boolean finished = false;

        do
        {

            System.out.println("Select Target:");
            for(GameCharacter character : gc)
            {
                count++;
                System.out.println(count + ". "+ character.getName() + " " + character.getCurHp() + "/" + character.getMaxHp());
            }
            retVal = sc.nextInt();

            while(retVal <= 0 || retVal > count)
            {
                System.out.println("Error...Try Again");
                System.out.println("Select Target:");
                count = 0;
                for(GameCharacter character : gc)
                {
                    count++;
                    System.out.println(count + ". "+ character.getName() + " " + character.getCurHp() + "/" + character.getMaxHp());
                }
                retVal = sc.nextInt();
            }
            finished = true;

        }while(!finished);



        return retVal;
    }

    public void displayCharacterInfo(GameCharacter character, String message)
    {
        System.out.println(character.getName() + message);
        System.out.println(character.displayStats());
    }

}
