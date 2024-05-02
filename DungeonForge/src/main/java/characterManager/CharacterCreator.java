package characterManager;

import java.util.Scanner;

import characterManager.enums.Race;
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
		
		//Abilities
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
		
		Character character = new Character(name, race, type);
		race.updateAbilitiesFromRace(race, character, scanner);
		type.updateAbilitiesFromClass(type, character);
		
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
		
		//Abilities
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

	    return input;
	}
	
	public static Character readFromFile(String line) 
	{
		String[] parsed = line.split(",");
		Character character = new Character(parsed[0],Race.valueOf(parsed[2]),CType.valueOf(parsed[1]));
		character.setLevel(Integer.valueOf(parsed[3]));
		character.setStr(Integer.valueOf(parsed[4]));
		character.setDex(Integer.valueOf(parsed[5]));
		character.setCon(Integer.valueOf(parsed[6]));
		character.setIntel(Integer.valueOf(parsed[7]));
		character.setWis(Integer.valueOf(parsed[8]));
		character.setCha(Integer.valueOf(parsed[9]));
		return character;
	}
}
