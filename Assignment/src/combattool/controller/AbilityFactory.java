package combattool.controller;
import combattool.model.*;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
public class AbilityFactory
{
    private Ability ability;

    public AbilityFactory()
    {
        ability = null;
    }

    public Ability createAbility(String type, String name, String target, int base, int numDice, int numFaces)
    {
        ability = new AbilityStats(type, name, target, base, numDice, numFaces);

        return ability;
    }
}
