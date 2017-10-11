package combattool.model;

import java.lang.annotation.Target;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
public abstract class EffectBehaviour
{
    private Ability ability;
    //private String tb;

    // ALTERNATE CONSTRUCTOR
    public EffectBehaviour(/*TargetBehaviour tb,*/ Ability ability)
    {
        setAbility(ability);
        //setTargetBehaviour(tb);
    }

    // MUTATORS
    /*public void setTargetBehaviour(TargetBehaviour tb)
    {
        this.tb = tb;
    }*/

    public void setAbility(Ability ability)
    {
        this.ability = ability;
    }

    // ACCESSORS
    /*public TargetBehaviour getTargetBehaviour()
    {
        return tb;
    }*/

    public Ability getAbility()
    {
        return ability;
    }

    // Abstract method that calculate either healing or damage
    public abstract int doEffect();
}
