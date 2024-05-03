package characterManager;

import java.util.List;

public class Display {
	public void DisplayCharacter(Character player) {
		System.out.println(player);
	}
	
	public void DisplayCharacterList(List<Character> characters) 
	{
		int idx = 0;
		for(Character player : characters) 
		{
			System.out.println("Index: " + "\u001B[94m" + idx + "\u001B[0m");
			DisplayCharacter(player);
			idx++;
		}
	}
	
	public void titleDisplay() 
	{
		System.out.println("\u001B[1m" + "\u001B[33m" + "Welcome to Dungeon Forge" + "\u001B[0m");
		System.out.println("Dungeon Forge is a table top application to aid with DnD character storing and data manipulation.");
		System.out.println();
	}
	
	public void optionsDisplay() 
	{
		System.out.println("--------------------------------");
    	System.out.println("1.) Create New Character");
		System.out.println("2.) Import Custom Stats");
		System.out.println("3.) Display Current Character");
		System.out.println("4.) Display all saved Characters");
		System.out.println("5.) Save Character");
		System.out.println("6.) Clear Character List");
		System.out.println("7.) Exit");
        System.out.println("Enter your choice (1-7): ");
		System.out.println("--------------------------------");
	}
}
