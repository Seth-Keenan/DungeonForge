package characterManager;

import java.util.Scanner;

import characterManager.enums.Race;
import characterManager.enums.CType;

public class CharacterCreator {
	public Character newCharacter() 
	{
		Character character = startCharacter();

		character.updateAbilitiesFromAttributes();
		character.updateAbilitiesFromRace();

		return character;
	}
	
	public Character loadCharacter() 
	{
		Character character = startCharacter();
		
		System.out.println("Please insert current character's stats:");
		int lvl = getValidIntInput("Level: ");
		int str = getValidIntInput("Strength: ");
		int dex = getValidIntInput("Dexterity: ");
		int con = getValidIntInput("Constitution: ");
		int intel = getValidIntInput("Intelligence: ");
		int wis = getValidIntInput("Wisdom: ");
		int cha = getValidIntInput("Charisma: ");
		
		character.setLevel(lvl);
		character.setStr(str);
		character.setDex(dex);
		character.setCon(con);
		character.setIntel(intel);
		character.setWis(wis);
		character.setCha(cha);
		
		System.out.println();
		
		return character;
	}
	
	@SuppressWarnings("resource")
	public Character startCharacter() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your character's name: ");
		String name = scanner.nextLine();
		System.out.println();
		
		CType type = null;
		Race race = null;
		
		//Skills
		type = promptType(type);
		
		//Abilities
		race = promptRace(race);
		
		Character character = new Character(name, race, type);
		
		return character;
	}
	
	public int getValidIntInput(String prompt) {
		int input = 0;
	    boolean validInput = false;
		Scanner scanner = new Scanner(System.in);

	    while (!validInput) {
	        try {
	            System.out.print(prompt);
	            input = scanner.nextInt();
	            validInput = true;
	        } catch (Exception e) {
	            System.out.println("Please insert integers only.");
	            scanner.next();
	        }
	    }
	    
	    scanner.nextLine();
	    scanner.close();
	    return input;
	}
	
	@SuppressWarnings("resource")
	public CType promptType(CType type) 
	{
		Scanner scanner = new Scanner(System.in);
		while(type == null) {
			try {		
				System.out.println("Please enter your character's class: ");
				System.out.println("\u001B[32m" + "BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZARD" + "\u001B[0m");
				String typeIn = scanner.nextLine().toUpperCase();
				type = CType.valueOf(typeIn);
				System.out.println();
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid class. Please try again.");
				System.out.println();
			}
		}
		return type;
	}
	
	@SuppressWarnings("resource")
	public Race promptRace(Race race) 
	{
		Scanner scanner = new Scanner(System.in);
		while(race == null) 
		{
			try {
				System.out.println("Please enter your character's race: ");
				System.out.println("\u001B[32m" + "DRAGONBORN, DWARF, ELF, GNOME, HALFELF, HALFLING, HALFORC, HUMAN, TIEFLING" + "\u001B[0m");
				String raceIn = scanner.nextLine().toUpperCase();
				race = Race.valueOf(raceIn);
				System.out.println();
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid race. Please try again.");
				System.out.println();
			}
		}
		return race;
	}
}
