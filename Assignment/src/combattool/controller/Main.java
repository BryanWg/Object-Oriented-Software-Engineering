package combattool.controller;

public class Main
{
    public static void main(String args[])
    {
        // Setting up of Main Controller
        GameController                  controller = new GameController();

        // Starting the game environment for the combat tool
        controller.setup();
    }
}
