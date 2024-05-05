/**
 * This class represents a character in a role-playing game.
 * It stores information about the character's name, race, class, attributes, and level.
 * Attributes include strength, dexterity, constitution, intelligence, wisdom, and charisma.
 * The class provides methods for setting and getting character attributes,
 * as well as methods for updating attributes based on race and class.
 * Additionally, it includes methods for displaying character information and
 * distributing attribute points during character creation.
 * 
 * @author SethKeenan
 * @version 5/5/2024
 */

package characterManager;

import characterManager.enums.Race;

import java.util.Scanner;

import characterManager.enums.Attributes;
import characterManager.enums.CType;

/**
 * Represents a character in a role-playing game.
 */
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

	/**
     * Constructs a new Character with the given name, race, and class.
     * 
     * @param name The name of the character.
     * @param race The race of the character.
     * @param type The class/type of the character.
     */
	public Character(String name, Race race, CType type) {
		this.name = name;
		this.race = race;
		this.type = type;
	}
	
	/**
     * Gets the name of the character.
     * 
     * @return The name of the character.
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name of the character.
     * 
     * @param name The new name of the character.
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Gets the level of the character.
     * 
     * @return The level of the character.
     */
	public int getLevel() {
		return level;
	}

	/**
     * Sets the level of the character.
     * 
     * @param level The new level of the character.
     */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
     * Gets the race of the character.
     * 
     * @return The race of the character.
     */
	public Race getRace() {
		return race;
	}
	
	/**
     * Sets the race of the character.
     * 
     * @param race The new race of the character.
     */
	public void setRace(Race race) {
		this.race = race;
	}
	
	/**
     * Gets the class/type of the character.
     * 
     * @return The class/type of the character.
     */
	public CType getType() {
		return type;
	}
	
	/**
     * Sets the class/type of the character.
     * 
     * @param type The new class/type of the character.
     */
	public void setType(CType type) {
		this.type = type;
	}
	
	/**
     * Gets the strength attribute of the character.
     * 
     * @return The strength attribute of the character.
     */
	public int getStr() {
		return str;
	}
	
	/**
     * Sets the strength attribute of the character.
     * 
     * @param str The new strength attribute of the character.
     */
	public void setStr(int str) {
		this.str = str;
	}

	/**
     * Gets the dexterity attribute of the character.
     * 
     * @return The dexterity attribute of the character.
     */
	public int getDex() {
		return dex;
	}

	/**
     * Sets the dexterity attribute of the character.
     * 
     * @param dex The new dexterity attribute of the character.
     */
	public void setDex(int dex) {
		this.dex = dex;
	}

	/**
     * Gets the constitution attribute of the character.
     * 
     * @return The constitution attribute of the character.
     */
	public int getCon() {
		return con;
	}

	/**
     * Sets the constitution attribute of the character.
     * 
     * @param con The new constitution attribute of the character.
     */
	public void setCon(int con) {
		this.con = con;
	}

	/**
     * Gets the intelligence attribute of the character.
     * 
     * @return The intelligence attribute of the character.
     */
	public int getIntel() {
		return intel;
	}

	/**
     * Sets the intelligence attribute of the character.
     * 
     * @param intel The new intelligence attribute of the character.
     */
	public void setIntel(int intel) {
		this.intel = intel;
	}
	
	/**
     * Gets the wisdom attribute of the character.
     * 
     * @return The wisdom attribute of the character.
     */
	public int getWis() {
		return wis;
	}

	/**
     * Sets the wisdom attribute of the character.
     * 
     * @param wis The new wisdom attribute of the character.
     */
	public void setWis(int wis) {
		this.wis = wis;
	}

	/**
     * Gets the charisma attribute of the character.
     * 
     * @return The charisma attribute of the character.
     */
	public int getCha() {
		return cha;
	}

	/**
     * Sets the charisma attribute of the character.
     * 
     * @param cha The new charisma attribute of the character.
     */
	public void setCha(int cha) {
		this.cha = cha;
	}

    /**
     * Returns a string representation of the character's attributes and information.
     * 
     * @return A string representation of the character.
     */
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
	
	/**
     * Returns a CSV-formatted string representing the character's information.
     * 
     * @return A CSV-formatted string representing the character.
     */
	public String toCSV() {
		return this.name + "," + this.type + "," + this.race + "," + this.level + "," + this.str + "," + this.dex + ","
				+ this.con + "," + this.intel + "," + this.wis + "," + this.cha;
	}
	
	/**
     * Displays the available attribute options during character creation,
     * including remaining points and current attribute values.
     * 
     * @param remainingPoints The number of attribute points remaining to distribute.
     */
	public void displayAttributeOptions(int remainingPoints) 
	{
		System.out.println("Distribute Points: " + "\u001B[31m" + remainingPoints + "\u001B[0m");
		System.out.println();
		System.out.println("Current Attributes:");
		System.out.println(this);

		System.out.println("Choose an attribute to add a point to:");
		System.out.println("\u001B[32m" + "STR, DEX, CON, INT, WIS, CHA" + "\u001B[0m");
	}
	
	 /**
     * Distributes attribute points based on the DnD standard attribute array.
     */
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

	 /**
     * Distributes additional attribute points for choosing the HalfElf race.
     */
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
	
	/**
	 * This will return the attribute choice if it is valid
	 * @return Attributes
	 */
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
	
	 /**
     * Updates character attributes based on the chosen race.
     */
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
	
	/**
     * Changes the specified attribute by adding the given number of points to it.
     * 
     * @param attribute The attribute to change.
     * @param addedPoints The number of points to add to the attribute.
     */
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
