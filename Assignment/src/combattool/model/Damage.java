package combattool.model;

/**********************************************
 * CLASS:
 * PURPOSE:                                    
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
import java.util.Random;
public class Damage extends EffectBehaviour
{

    // ALTERNATE CONSTRUCTOR
    public Damage(/*TargetBehaviour tb, */Ability ability)
    {
        super(/*tb,*/ ability);
    }

    // Calculates how much damage needs to be done based on the ability
    public int doEffect()
    {
        Random random = new Random();
        int effect;

        // nextInt(int bound) takes in the upper bound and returns a random number up to the number of faces
        // We have to add 1 to whatever random number it spits at us because nextInt() starts at zero (Inclusive) and
        // goes up to the boundary (Exclusive), this ensures that the number is between 1 and the boundary inclusive.

        effect = (super.getAbility().getBase());

        for(int i = 0; i < super.getAbility().getNumDice(); i++)
        {
            effect += (1 + random.nextInt(super.getAbility().getNumFaces()));
        }

        // Since we are doing damage we must have the effect as a negative number
        effect *= (-1);

        return effect;
    }
}
