package characterManager;

import java.util.List;

public class Display {
	public static void DisplayCharacter(Character player) {
		System.out.println("\u001B[4m" + player.getName() + " the " + player.getType() + "\u001B[0m");
		System.out.println("\u001B[1m" + "Race: " + player.getRace() + "\u001B[0m");
		System.out.println("\u001B[31m" + "LVL - " + "\u001B[0m" + player.getLevel());
		System.out.println("\u001B[33m" + "STR | " + "\u001B[0m" + player.getStr());
		System.out.println("\u001B[33m" + "DEX | " + "\u001B[0m" + player.getDex());
		System.out.println("\u001B[33m" + "CON | " + "\u001B[0m" + player.getCon());
		System.out.println("\u001B[33m" + "INT | " + "\u001B[0m" + player.getIntel());
		System.out.println("\u001B[33m" + "WIS | " + "\u001B[0m" + player.getWis());
		System.out.println("\u001B[33m" + "CHA | " + "\u001B[0m" + player.getCha());
	}
	
	public static void DisplayCharacterList(List<Character> characters) 
	{
		int idx = 0;
		for(Character player : characters) 
		{
			System.out.println("Index: " + "\u001B[94m" + idx + "\u001B[0m");
			System.out.println("\u001B[4m" + player.getName() + " the " + player.getType() + "\u001B[0m");
			System.out.println("\u001B[1m" + "Race: " + player.getRace() + "\u001B[0m");
			System.out.println("\u001B[31m" + "LVL - " + "\u001B[0m" + player.getLevel());
			System.out.println("\u001B[33m" + "STR | " + "\u001B[0m" + player.getStr());
			System.out.println("\u001B[33m" + "DEX | " + "\u001B[0m" + player.getDex());
			System.out.println("\u001B[33m" + "CON | " + "\u001B[0m" + player.getCon());
			System.out.println("\u001B[33m" + "INT | " + "\u001B[0m" + player.getIntel());
			System.out.println("\u001B[33m" + "WIS | " + "\u001B[0m" + player.getWis());
			System.out.println("\u001B[33m" + "CHA | " + "\u001B[0m" + player.getCha());
			idx++;
			System.out.println();
			System.out.println();
		}
	}
	
	public static void titleDisplay() 
	{
		System.out.println("\u001B[1m" + "\u001B[33m" + "Welcome to Dungeon Forge" + "\u001B[0m");
		System.out.println("Dungeon Forge is a table top application to aid with DnD character storing and data manipulation.");
	}
	
	public static void optionsDisplay() 
	{
		System.out.println();
    	System.out.println("1.) Create New Character");
		System.out.println("2.) Import Custom Stats");
		System.out.println("3.) Display Current Character");
		System.out.println("4.) Display all saved Characters");
		System.out.println("5.) Save Character");
		System.out.println("6.) Clear Character List");
        System.out.print("Enter your choice (1-6): ");
	}
}
