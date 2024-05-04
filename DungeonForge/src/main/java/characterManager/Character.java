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

	// DND Standard Attribute Array
	public void updateAbilitiesFromAttributes() 
	{
		int remainingPoints = 0;
		int[] data = { 15, 14, 13, 12, 10, 8 };
		//Scanner scanner = new Scanner(System.in);

		System.out.println("\u001B[1m" + "Please distribute the standard array of attribute points." + "\u001B[0m");

		while (remainingPoints < 6) {
			Attributes attribute = null;

			// Display the available attributes and their current values
			System.out.println("Distribute Points: " + "\u001B[31m" + data[remainingPoints] + "\u001B[0m");
			System.out.println();
			System.out.println("Current Attributes:");
			System.out.println(this);

			System.out.println("Choose an attribute to add a point to:");
			System.out.println("\u001B[32m" + "STR, DEX, CON, INT, WIS, CHA" + "\u001B[0m");
			String typeIn = scanner.nextLine().toUpperCase();

			try 
			{
				attribute = Attributes.valueOf(typeIn);
			} 
			catch (IllegalArgumentException e) 
			{
				System.out.println("Invalid attribute. Please try again.");
				continue;
			}

			// Check if the player has already allocated a point to the chosen attribute
			switch (attribute) {
			case STR:
				if (this.str >= 15) {
					System.out.println("You've already distributed points to Strength. Choose another attribute.");
					continue;
				}
				this.str = (this.str + data[remainingPoints]);
				break;
			case DEX:
				if (this.dex >= 15) {
					System.out.println("You've already distributed points to Dexterity. Choose another attribute.");
					continue;
				}
				this.dex = (this.dex + data[remainingPoints]);
				break;
			case CON:
				if (this.con >= 15) {
					System.out.println("You've already distributed points to Constitution. Choose another attribute.");
					continue;
				}
				this.con = (this.con + data[remainingPoints]);
				break;
			case INT:
				if (this.intel >= 15) {
					System.out.println("You've already distributed points to Intellegence. Choose another attribute.");
					continue;
				}
				this.intel = (this.intel + data[remainingPoints]);
				break;
			case WIS:
				if (this.wis >= 15) {
					System.out.println("You've already distributed points to Wisdom. Choose another attribute.");
					continue;
				}
				this.wis = (this.wis + data[remainingPoints]);
				break;
			case CHA:
				if (this.cha >= 15) {
					System.out.println("You've already distributed points to Charisma. Choose another attribute.");
					continue;
				}
				this.cha = (this.cha + data[remainingPoints]);
				break;
			default:
				break;
			}
			System.out.println();
			remainingPoints++;
		}
	}

	// Race Modifiers
	public void updateAbilitiesFromRace() {
//		Scanner scanner = new Scanner(System.in);
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
	
	public void chooseHalfElfAbilities() 
	{
		int remainingPoints = 2;
		System.out.println("\u001B[1m" + "Please distribute the additional attribute points." + "\u001B[0m");

		while (remainingPoints > 0) {
			Attributes attribute = null;

			// Display the available attributes and their current values
			System.out.println("Remaining Points: " + "\u001B[31m" + remainingPoints + "\u001B[0m");
			System.out.println();
			System.out.println(this);
			System.out.println();

			System.out.println("Choose an attribute to add a point to:");
			System.out.println("\u001B[32m" + "STR, DEX, CON, INT, WIS" + "\u001B[0m");
			String typeIn = scanner.nextLine().toUpperCase();

			try 
			{
				attribute = Attributes.valueOf(typeIn);
			} 
			catch (IllegalArgumentException e) 
			{
				System.out.println("Invalid attribute. Please try again.");
				continue;
			}
			// Check if the this has already allocated a point to the chosen attribute
			switch (attribute) {
			case STR:
				if (this.str >= 17) {
					System.out.println("You've already given a point to Strength. Choose another attribute.");
					continue;
				}
				this.str = (this.str + 1);
				break;
			case DEX:
				if (this.dex >= 17) {
					System.out.println("You've already given a point to Dexterity. Choose another attribute.");
					continue;
				}
				this.dex = (this.dex + 1);
				break;
			case CON:
				if (this.con >= 17) {
					System.out.println("You've already given a point to Constitution. Choose another attribute.");
					continue;
				}
				this.con = (this.con + 1);
				break;
			case INT:
				if (this.intel >= 17) {
					System.out.println("You've already given a point to Intelligence. Choose another attribute.");
					continue;
				}
				this.intel = (this.intel + 1);
				break;
			case WIS:
				if (this.wis >= 17) {
					System.out.println("You've already given a point to Wisdom. Choose another attribute.");
					continue;
				}
				this.wis = (this.wis + 1);
				break;
			case CHA:
				if (this.cha >= 17) {
					System.out.println(
							"You've given the max amount of points to Charisma. Choose another attribute.");
					continue;
				}
				this.cha = (this.cha + 1);
				break;
			default:
				break;
			}
			System.out.println();
			remainingPoints--;
		}
	}
}
