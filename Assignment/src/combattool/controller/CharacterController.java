package combattool.controller;

import combattool.model.*;
import combattool.view.*;

import java.io.*;
import java.util.*;
public class CharacterController
{
    public void startGame(UserInterface ui, AbilityController abilityController, Map<String, Ability> abilityMap, List<Team> teamList) throws FileNotFoundException
    {
        int selection;
        boolean gameFinished = false;
        int roundNum = 0;
        int roundSelect;
        int curTeam = 0;
        //ListIterator<GameCharacter> iter;

        do
        {
            // Shows the second menu for each round
            roundSelect = ui.showMenu2();

            for (Team team : teamList)
            {
                // Allows you to use the GameCharacterList in a for each loop for both player and npc
                List<GameCharacter> gc;
                gc = team.getTeamList();


                if(roundSelect == 4)
                {
                    // Tells you who's turn it is
                    if (curTeam == 0)
                    {
                        ui.display("\nPLAYER'S TURN\n");
                        curTeam = 1;
                    }
                    else
                    {
                        ui.display("\nGAME MASTER'S TURN\n");
                        curTeam = 0;
                    }

                    roundNum++;
                    ui.display("ROUND NUMBER " + roundNum);

                    //for(iter = gc.listIterator(); iter.hasNext();)
                    for(int i = 0; i<gc.size(); i++)
                    {
                        GameCharacter player = gc.get(i);

                        ui.print(player);
                        // Displays the round menu
                        selection = ui.showTurn();

                        switch (selection)
                        {
                            case 1:
                                // Calls the AbilityController to use the ability
                                abilityController.useAbility(ui, abilityMap, teamList, player);
                                break;

                            case 2:
                                // Ends a player's turn White Space
                                break;
                        }
                    }
                }
                else if(roundSelect == 1)
                {
                    // FILE READING STUFF
                    String charFile, abilityFile;
                    ReadFile fileReader = new ReadFile();
                    Team playerTeam = new Team();
                    Team npcTeam = new Team();

                    abilityFile = ui.inputFileName("Enter name of ability file");
                    charFile = ui.inputFileName("Enter the name of the character file");

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
                    break;
                }
                else if(roundSelect == 2)
                {
                    String fileName;
                    GameState state = new GameState(teamList);

                    // Asks for FileName
                    fileName = ui.inputFileName("Enter the name of the file you want to write to");

                    // Uses Serialization
                    state.saveFile(fileName, state);

                    ui.display("SUCCESSFULLY WRITTEN TO FILE!!!");

                    break;
                }
                else if(roundSelect == 3)
                {
                    String fileName;

                    GameState state = new GameState(teamList);
                    fileName = ui.inputFileName("Enter the name of the file to load");

                    state.loadFile(fileName, state);

                    ui.display("SUCCESSFULLY LOADED FILE!!!");

                    //---------TAKING TURN STUFF------------//
                    // Tells you who's turn it is
                    if (curTeam == 0)
                    {
                        ui.display("\nPLAYER'S TURN\n");
                        curTeam = 1;
                    }
                    else
                    {
                        ui.display("\nGAME MASTER'S TURN\n");
                        curTeam = 0;
                    }

                    roundNum++;
                    ui.display("ROUND NUMBER " + roundNum);

                    //for(iter = gc.listIterator(); iter.hasNext();)
                    for(int i = 0; i<gc.size(); i++)
                    {
                        GameCharacter player = gc.get(i);

                        ui.print(player);
                        // Displays the round menu
                        selection = ui.showTurn();

                        switch (selection)
                        {
                            case 1:
                                // Calls the AbilityController to use the ability
                                abilityController.useAbility(ui, abilityMap, teamList, player);
                                break;

                            case 2:
                                // Ends a player's turn White Space
                                break;
                        }
                    }

                    break;
                }
                else if(roundSelect == 5)
                {
                    System.exit(0);
                }
            }
        }while(!gameFinished);
    }

    /**
     * METHOD: readFile
     * ASSERTION: Reads both the Ability and the Character File
     */
    public void readFile(ReadFile fileReader, UserInterface ui, Map<String, Ability> abilityMap, List<Team> teamList) throws FileNotFoundException
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
