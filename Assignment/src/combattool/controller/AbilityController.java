package combattool.controller;

import combattool.model.*;
import combattool.view.*;
import java.util.*;

public class AbilityController
{

    public void useAbility(UserInterface ui, Map<String, Ability> map, List<Team> teamList, GameCharacter player)
    {
        int index;
        int count;
        String abilityName;
        Ability ability;

        count = ui.listPlayerAbilities(player);

        index = ui.selectAbilityFromList(player, count);

        // Gets the String value of the Ability, -1 because they index at 0
        abilityName = player.getAbilities().get(index - 1);

        // Uses the String as the key and hash's it to actually get the Ability object
        ability = map.get(abilityName);

        // Checks if it's damage or healing
        switch(ability.getType())
        {
            case "D":
                doDamage(ability, teamList, ui, player);
                break;

            case "H":
                doHealing(ability, teamList, ui, player);
                break;
        }
    }

    /**
     * FUNCTION: doDamage
     * ASSERTION: Checks to see if the Ability is single or multitarget then does the respective damage
     */
    public void doDamage(Ability ability, List<Team> teamList, UserInterface ui, GameCharacter curPlayer)
    {
        int index, damageDealt, newHp;
        GameCharacter target;

        // Decorates the damage with the ability
        Damage damage = new Damage(ability);

        List<GameCharacter> targetList;
        //List<GameCharacter> nonTargetList;

        List<GameCharacter> playerTeam = teamList.get(0).getTeamList();
        List<GameCharacter> npcTeam = teamList.get(1).getTeamList();

        targetList = playerTeam;
        //nonTargetList = npcTeam;
        for(GameCharacter character : playerTeam)
        {
            // If you can find the name, the target list is not the one being iterated
            if(curPlayer.getName().equals(character.getName()))
            {
                targetList = npcTeam;
                //nonTargetList = playerTeam;
                break;
            }
        }

        // Checks if the ability is single or multi target
        switch (ability.getTarget())
        {
            // Single Target Abilities
            case "S":
                index = ui.selectEnemyList(targetList);
                target = targetList.get(index - 1);


                damageDealt = damage.doEffect();

                // Gives the new hp and sets it
                newHp = target.getCurHp() + damageDealt;


                if (target.setCurHp(newHp))
                {

                    ui.display("\n" + target.getName() + " Has died!");
                    if (target instanceof NonPlayer)
                    {
                        ui.display("All Allies has been healed for 10%");
                        // Gets the Player List to heal 10%
                        for (GameCharacter player : teamList.get(0).getTeamList()) {
                            player.addHeal((int) (player.getMaxHp() * 0.1));
                            ui.displayCharacterInfo(player, " Has been healed");
                        }
                    } else {
                        ui.display("All npc's has been healed for 5%");
                        // Heal non player list for 5%
                        for (GameCharacter player : teamList.get(1).getTeamList()) {
                            player.addHeal((int) (player.getMaxHp() * 0.05));
                            ui.displayCharacterInfo(player, " Has been healed");
                        }
                    }


                    // If the character dies, remove it from the list
                    if (target.getCurHp() <= 0)
                    {
                        targetList.remove(target);
                    }
                }
                else
                {
                    ui.displayCharacterInfo(target, " has been damaged!");
                }

                // Checks to see if there is a winner
                if (targetList.size() == 0)
                {
                    for (Team team : teamList)
                    {
                        if (team.getSize() != 0)
                        {
                            ui.display(team.getTeamName() + " Wins!!");
                            System.exit(0);
                        }
                    }
                }
                // You want to break here because you don't want to iterate the other team when someone wins
                break;

            // Multi Target Abilities
            case "M":
                ui.display("\nEveryone in the enemy list has been selected for damage: ");

                // Goes through everyone in the list and damages them
                for(GameCharacter person : targetList)
                {
                    if(person.getCurHp() > 0) {
                        damageDealt = damage.doEffect();

                        newHp = person.getCurHp() + damageDealt;


                        if (person.setCurHp(newHp))
                        {
                            ui.display(person.getName() + " Has died!");
                            if (person instanceof NonPlayer)
                            {
                                ui.display("\nAll Allies has been healed for 10%");
                                // Gets the Player List to heal 10%
                                for (GameCharacter player : teamList.get(0).getTeamList())
                                {
                                    player.addHeal((int) (player.getMaxHp() * 0.1));
                                    ui.displayCharacterInfo(player, " Has been healed");
                                }
                            }
                            else
                            {
                                ui.display("\nAll npc's has been healed for 5%");
                                // Heal non player list for 5%
                                for (GameCharacter player : teamList.get(1).getTeamList())
                                {
                                    player.addHeal((int) (player.getMaxHp() * 0.05));
                                    ui.displayCharacterInfo(player, " Has been healed");
                                }
                            }


                            // If the character dies, remove it from the list
                            if (person.getCurHp() <= 0)
                            {
                                 //This causes an Concurrent error exception
                                 targetList.remove(person);
                            }

                        }
                        else
                        {
                            ui.displayCharacterInfo(person, " has been damaged!");
                        }
                    }
                }
                break;
        }
    }


    /**
     * FUNCTION: doHealing
     * ASSERTION: Checks to see if the Ability is single or multitarget then does the respective healing
     */
    public void doHealing(Ability ability, List<Team> teamList, UserInterface ui, GameCharacter curPlayer)
    {

        int index, healingDealt, newHp;
        GameCharacter target;

        List<GameCharacter> targetList;
        //List<GameCharacter> nonTargetList;

        List<GameCharacter> playerTeam = teamList.get(0).getTeamList();
        List<GameCharacter> npcTeam = teamList.get(1).getTeamList();

        targetList = npcTeam;
        //nonTargetList = npcTeam;

        // Decorates the heal with ability
        Heal heal = new Heal(ability);

        for (GameCharacter character : playerTeam)
        {
            // If you can find the name, the target list is not the one being iterated
            if (curPlayer.getName().equals(character.getName())) {
                targetList = playerTeam;
                //nonTargetList = playerTeam;
                break;
            }
        }



        // Checks if the ability is single or multi target
        switch (ability.getTarget())
        {
            // Single Target Abilities
            case "S":
                index = ui.selectEnemyList(targetList);
                target = targetList.get(index - 1);
                healingDealt = heal.doEffect();

                // Gives the new hp and sets it
                newHp = target.getCurHp() - healingDealt;

                // Sets the healing value by calling the mutator
                target.addHeal(newHp);
                ui.displayCharacterInfo(target, " has been healed!");
                break;

            case "M":
                ui.display("\nEveryone in the list has been selected for healing: ");

                // Goes through everyone in the list and heals them
                for (GameCharacter person : targetList)
                {
                    healingDealt = heal.doEffect();

                    newHp = person.getCurHp() - healingDealt;

                    // Sets the healing value by calling the mutator
                    person.addHeal(newHp);
                    ui.displayCharacterInfo(person, " has been healed!");
                }
                break;
        }
    }
}

