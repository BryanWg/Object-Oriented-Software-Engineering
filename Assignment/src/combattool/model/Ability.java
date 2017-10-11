package combattool.model;

/**********************************************
 * CLASS: Ability
 * PURPOSE: Ability Interface
 * NAME: Christopher Chang
 * Student Id: 18821354 
 ***********************************************/
public interface Ability
{
    public void setType(String type);
    public void setName(String name);
    public void setTarget(String target);
    public void setBase(int base);
    public void setNumDice(int numDice);
    public void setNumFaces(int numFaces);
    public String getType();
    public String getName();
    public String getTarget();
    public int getBase();
    public int getNumDice();
    public int getNumFaces();
    public String toString();

}
