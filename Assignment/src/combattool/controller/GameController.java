package combattool.controller;
import combattool.view.*;
import combattool.model.*;

import java.io.*;
import java.util.*;
public class GameController
{
    private Map<String, Ability> abilityMap;
    private List<Team> teamList;

    // CONSTRUCTOR
    public GameController()
    {
        abilityMap = new HashMap<String, Ability>();
        teamList = new ArrayList<Team>();
    }

    public void setup()
    {
        // Setting up of all the Readers and Controllers
        ReadFile fileReader = null;
        AbilityController abilityController = new AbilityController();
        CharacterController characterController = new CharacterController();
        UserInterface ui = null;

        boolean finished = false;
        int input;
        ui = new UserInterface();

        do
        {
            try
            {

                input = ui.showMenu();

                switch (input)
                {
                    case 1:
                        // Reads in the file then starts the turn based game
                        readFile(fileReader, ui);
                        for (Team team : teamList)
                        {
                            int i = 0;

                            if (i == 0)
                            {
                                team.setTeamName("Player Team");
                                i++;
                            }
                            else if (i == 1)
                            {
                                team.setTeamName("Enemy Team");
                            }
                        }
                        characterController.startGame(ui, abilityController, abilityMap, teamList);
                        finished = true;
                        break;

                    case 2:
                        System.out.println("Exiting Game...goodbye!");
                        finished = true;
                        break;

                    default:
                        throw new IllegalArgumentException("Should never have to go into here");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            catch (FileNotFoundException e2)
            {
                System.out.println(e2.getMessage());
            }
        }while(!finished);

    }


    /**
     * METHOD: readFile
     * ASSERTION: Reads both the Ability and the Character File
     */
    public void readFile(ReadFile fileReader, UserInterface ui) throws FileNotFoundException
    {
        String charFile, abilityFile;
        fileReader = new ReadFile();
        Team playerTeam = new Team();
        Team npcTeam = new Team();

        abilityFile = ui.inputFileName("Please enter the name of the Ability File");
        charFile = ui.inputFileName("Please enter the name of the Character File");

        try
        {
            fileReader.read(abilityFile, charFile, abilityMap, playerTeam, npcTeam);

            // After Reading the file add the Teams to the teamList
            teamList.add(playerTeam);
            teamList.add(npcTeam);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e3)
        {
            System.out.println(e3.getMessage());
        }
    }
}
