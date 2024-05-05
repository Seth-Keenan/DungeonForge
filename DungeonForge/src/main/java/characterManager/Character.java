package characterManager;

import characterManager.enums.Race;

import java.util.Scanner;

import characterManager.enums.Attributes;
import characterManager.enums.CType;

public class Character {

	private Scanner scanner = new Scanner(System.in);
	
	private String name;
	private Race race;
	private CType type;

	private int level = 1;
	private int str = 0;
	private int dex = 0;
	private int con = 0;
	private int intel = 0;
	private int wis = 0;
	private int cha = 0;

	public Character(String name, Race race, CType type) {
		this.name = name;
		this.race = race;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public CType getType() {
		return type;
	}

	public void setType(CType type) {
		this.type = type;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	@Override
	public String toString() {
		StringBuilder character = new StringBuilder();

		character.append("----------\n");
		character.append("\u001B[4m" + this.name + " the " + this.type + "\u001B[0m\n");
		character.append("\u001B[1m" + "Race: " + this.race + "\u001B[0m\n");
		character.append("\u001B[31m" + "Level        | " + "\u001B[0m" + this.level + "\n");
		character.append("\u001B[33m" + "Strength     | " + "\u001B[0m" + this.str + "\n");
		character.append("\u001B[33m" + "Dexterity    | " + "\u001B[0m" + this.dex + "\n");
		character.append("\u001B[33m" + "Constitution | " + "\u001B[0m" + this.con + "\n");
		character.append("\u001B[33m" + "Intellegence | " + "\u001B[0m" + this.intel + "\n");
		character.append("\u001B[33m" + "Wisdom       | " + "\u001B[0m" + this.wis + "\n");
		character.append("\u001B[33m" + "Charisma     | " + "\u001B[0m" + this.cha + "\n");
		character.append("----------");

		return character.toString();
	}

	public String toCSV() {
		return this.name + "," + this.type + "," + this.race + "," + this.level + "," + this.str + "," + this.dex + ","
				+ this.con + "," + this.intel + "," + this.wis + "," + this.cha;
	}

	public void displayAttributeOptions(int remainingPoints) 
	{
		System.out.println("Distribute Points: " + "\u001B[31m" + remainingPoints + "\u001B[0m");
		System.out.println();
		System.out.println("Current Attributes:");
		System.out.println(this);

		System.out.println("Choose an attribute to add a point to:");
		System.out.println("\u001B[32m" + "STR, DEX, CON, INT, WIS, CHA" + "\u001B[0m");
	}
	
	// DND Standard Attribute Array
	public void updateAbilitiesFromAttributes() 
	{
		int[] data = { 15, 14, 13, 12, 10, 8 };
	    for (int remainingPoints = 0; remainingPoints < 6; remainingPoints++) 
	    {
			System.out.println("\u001B[1m" + "Please distribute the standard array of attribute points." + "\u001B[0m");
			displayAttributeOptions(data[remainingPoints]);
			Attributes attribute = attributeChoice();
			changeAttributes(attribute, data[remainingPoints]);
			System.out.println();
	    }
	}

	public void chooseHalfElfAbilities() 
	{
		System.out.println("\u001B[1m" + "Please distribute the 2 additional attribute points for choosing Half-Elf." + "\u001B[0m");
		for(int remainingPoints = 2; remainingPoints > 0; remainingPoints--) 
		{
			// Display the available attributes and their current values
			displayAttributeOptions(remainingPoints);
			// Get attribute choice
			Attributes attribute = attributeChoice();		
			// Check if the this has already allocated a point to the chosen attribute
			changeAttributes(attribute, 1);
			System.out.println();
		}
	}
	
	public Attributes attributeChoice() 
	{
		Attributes attribute = null;
	    boolean isValidInput = false;

	    while(!isValidInput) 
	    {
			try 
			{
				String typeIn = scanner.nextLine().toUpperCase();
				attribute = Attributes.valueOf(typeIn);
				isValidInput = true;
			} 
			catch (IllegalArgumentException e) 
			{
				System.out.println("Invalid attribute. Please try again.");
				continue;
			}
		}
		return attribute;
		
	}
	
	// Race Modifiers
	public void updateAbilitiesFromRace() 
	{
		switch (race) 
		{
			case DRAGONBORN:
				this.str += 2;
				this.cha += 1;
				break;
			case DWARF:
				this.con += 2;
				break;
			case ELF:
				this.dex += 2;
				break;
			case GNOME:
				this.intel += 2;
				break;
			case HALFELF:
				this.cha += 2;
				chooseHalfElfAbilities();
				break;			
			case HALFLING:
				this.dex += 2;
				break;
			case HALFORC:
				this.dex += 2;
				this.con += 1;
				break;
			case HUMAN:
				this.cha += 1;
				this.con += 1;
				this.dex += 1;
				this.intel += 1;
				this.str += 1;
				this.wis += 1;
				break;
			case TIEFLING:
				this.cha += 2;
				this.intel += 1;
				break;
			default:
				break;
		}
	}
	
	public void changeAttributes(Attributes attribute, int addedPoints) 
	{
	    boolean isValidInput = false;

		while(!isValidInput) 
		{
			switch (attribute) {
			case STR:
				if (this.str > 17) {
					System.out.println("You've already distributed the max points to Strength. Choose another attribute.");
					continue;
				}
				this.str += addedPoints;
				isValidInput = true;
				break;
			case DEX:
				if (this.dex > 17) {
					System.out.println("You've already distributed the max points to Dexterity. Choose another attribute.");
					continue;
				}
				this.dex += addedPoints;
				isValidInput = true;
				break;
			case CON:
				if (this.con > 17) {
					System.out.println("You've already distributed the max points to Constitution. Choose another attribute.");
					continue;
				}
				this.con += addedPoints;
				isValidInput = true;
				break;
			case INT:
				if (this.intel > 17) {
					System.out.println("You've already distributed the max points to Intellegence. Choose another attribute.");
					continue;
				}
				this.intel += addedPoints;
				isValidInput = true;
				break;
			case WIS:
				if (this.wis > 17) {
					System.out.println("You've already distributed the max points to Wisdom. Choose another attribute.");
					continue;
				}
				this.wis += addedPoints;
				isValidInput = true;
				break;
			case CHA:
				if (this.cha > 17) {
					System.out.println("You've already distributed the max points to Charisma. Choose another attribute.");
					continue;
				}
				this.cha += addedPoints;
				isValidInput = true;
				break;
			default:
				break;

			}
		}
	}
}
