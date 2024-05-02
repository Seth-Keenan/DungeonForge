package characterManager;

import java.util.Scanner;

import characterManager.enums.Race;
import characterManager.enums.Attributes;
import characterManager.enums.CType;

public class CharacterCreator {
	public Character newCharacter(Scanner scanner) 
	{
		System.out.println("Please enter your character's name: ");
		String name = scanner.nextLine();
		System.out.println();
		
		CType type = null;
		Race race = null;
		
		//Skills
		type = promptType(type, scanner);
		
		//Abilities
		race = promptRace(race, scanner);
		
		Character character = new Character(name, race, type);
		
		Attributes.updateAbilitiesFromAttributes(character, scanner);
		race.updateAbilitiesFromRace(race, character, scanner);

		return character;
	}
	
	public Character loadCharacter(Scanner scanner) 
	{
		System.out.println("Please enter your character's name: ");
		String name = scanner.nextLine();
		System.out.println();
		
		CType type = null;
		Race race = null;
		
		//Skills
		type = promptType(type, scanner);
		
		//Abilities
		race = promptRace(race, scanner);
		
		Character character = new Character(name, race, type);
		
		System.out.println("Please insert current character's stats:");
		int lvl = getValidIntInput(scanner, "Level: ");
		int str = getValidIntInput(scanner, "Strength: ");
		int dex = getValidIntInput(scanner, "Dexterity: ");
		int con = getValidIntInput(scanner, "Constitution: ");
		int intel = getValidIntInput(scanner, "Intelligence: ");
		int wis = getValidIntInput(scanner, "Wisdom: ");
		int cha = getValidIntInput(scanner, "Charisma: ");
		
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
	
	public static int getValidIntInput(Scanner scanner, String prompt) {
	    int input = 0;
	    boolean validInput = false;

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
	    return input;
	}
	
	public static CType promptType(CType type, Scanner scanner) 
	{
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
	
	public static Race promptRace(Race race, Scanner scanner) 
	{
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
