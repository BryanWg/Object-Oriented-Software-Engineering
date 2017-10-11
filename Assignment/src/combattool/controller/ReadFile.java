package combattool.controller;
import combattool.model.*;

import java.util.*;
import java.io.*;
public class ReadFile
{
    public void read(String abilityFile, String characterFile, Map<String, Ability> abilityMap, Team playerTeam, Team npcTeam) throws FileNotFoundException
    {
        File file = null;
        File file2 = null;
        Scanner sc = null;
        Scanner sc2 = null;
        String line, line2;
        String[] lineArray, lineArray2;

        try
        {
            // Reads the file via Scanner
            file = new File(abilityFile);
            sc = new Scanner(file);

            // Reads the first line of the file because this doesn't have
            // to be formatted
            sc.nextLine();

            // While not EOF
            while (sc.hasNextLine())
            {
                // Reads next line
                line = sc.nextLine();

                // Stores the line into an array and splits on white space
                lineArray = line.split(",\\s*");

                processLine(lineArray, abilityMap);
            }

            // Now begins to read in the character file
            file2 = new File(characterFile);
            sc2 = new Scanner(file2);

            line2 = sc2.nextLine();

            while(sc2.hasNextLine())
            {
                line2 = sc2.nextLine();

                lineArray2 = line2.split(",\\s*");

                processLine2(lineArray2, playerTeam, npcTeam);
            }


        }
        catch (FileNotFoundException e)
        {
            throw new FileNotFoundException(e.getMessage());
        }
        catch(NumberFormatException e2)
        {
            throw new NumberFormatException(e2.getMessage());
        }
    }

    public void processLine(String[] line, Map<String, Ability> abilityMap)
    {
        String type, name, target;
        int base, numDice, numFaces;
        Ability ability;

        type        = line[0];
        name        = line[1];
        target      = line[2];
        base        = Integer.parseInt(line[3]);
        numDice     = Integer.parseInt(line[4]);
        numFaces    = Integer.parseInt(line[5]);

        // Constructs and call the Ability Objects
        AbilityFactory creation = new AbilityFactory();
        ability = creation.createAbility(type, name, target, base, numDice, numFaces);

        // Adds the ability to the map
        abilityMap.put(name, ability);

    }

    public void processLine2(String[] line, Team playerTeam, Team npcTeam)
    {
        String type, name;
        int hp;
        GameCharacter character;
        List<String> abilities = new ArrayList<String>();

        type                    = line[0];
        name                    = line[1];
        hp                      = Integer.parseInt(line[2]);

        // Adds the abilities to the ability list because there can be many
        // abilites for one character
        for(int i = 3; i < line.length; i++)
        {
            abilities.add(line[i]);
        }

        CharacterFactory creation = new CharacterFactory();
        character = creation.createCharacter(type, name, hp, abilities);

        // Storing the characters into Teams
        if(type.equals("N"))
        {
            npcTeam.addTeamMember(character);
        }
        else if(type.equals("P"))
        {
            playerTeam.addTeamMember(character);
        }
        else
        {
            throw new IllegalArgumentException("Player type is invalid");
        }


    }







}

