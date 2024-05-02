package characterManager.enums;

import java.util.Scanner;

import characterManager.Character;

public enum Attributes {
	STR,
	DEX,
	CON,
	INT,
	WIS,
	CHA;
	
	//DND Standard Attribute Array
	public static void updateAbilitiesFromAttributes(Character player, Scanner scanner) 
	{
		int remainingPoints = 0;
		int[] data = {15,14,13,12,10,8};
		
        System.out.println("\u001B[1m" +"Please distribute the standard array of attribute points." + "\u001B[0m");
        
        while (remainingPoints < 6) {
            Attributes attribute = null;
            
            // Display the available attributes and their current values
            System.out.println("Distribute Points: " + "\u001B[31m" + data[remainingPoints] + "\u001B[0m");
            System.out.println();
            System.out.println("Current Attributes:");
            System.out.println("Strength: " + player.getStr());
            System.out.println("Dexterity: " + player.getDex());
            System.out.println("Constitution: " + player.getCon());
            System.out.println("Intelligence: " + player.getIntel());
            System.out.println("Wisdom: " + player.getWis());
            System.out.println("Charisma: " + player.getCha());
            System.out.println();
            
            System.out.println("Choose an attribute to add a point to:");
            System.out.println("\u001B[32m" + "STR, DEX, CON, INT, WIS, CHA" + "\u001B[0m");
            String typeIn = scanner.nextLine().toUpperCase();
            
            try {
                attribute = Attributes.valueOf(typeIn);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid attribute. Please try again.");
                continue;
            }
            
            // Check if the player has already allocated a point to the chosen attribute
            switch (attribute) {
                case STR:
                    if (player.getStr() >= 15) {
                        System.out.println("You've already distributed points to Strength. Choose another attribute.");
                        continue;
                    }
                    player.setStr(player.getStr() + data[remainingPoints]);
                    break;
                case DEX:
                    if (player.getDex() >= 15) {
                        System.out.println("You've already distributed points to Dexterity. Choose another attribute.");
                        continue;
                    }
                    player.setDex(player.getDex() + data[remainingPoints]);
                    break;
                case CON:
                    if (player.getCon() >= 15) {
                        System.out.println("You've already distributed points to Constitution. Choose another attribute.");
                        continue;
                    }
                    player.setCon(player.getCon() + data[remainingPoints]);
                    break;
                case INT:
                    if (player.getIntel() >= 15) {
                        System.out.println("You've already distributed points to Intellegence. Choose another attribute.");
                        continue;
                    }
                    player.setIntel(player.getIntel() + data[remainingPoints]);
                    break;
                case WIS:
                    if (player.getWis() >= 15) {
                        System.out.println("You've already distributed points to Wisdom. Choose another attribute.");
                        continue;
                    }
                    player.setWis(player.getWis() + data[remainingPoints]);
                    break;
                case CHA:
                    if (player.getCha() >= 15) {
                        System.out.println("You've already distributed points to Charisma. Choose another attribute.");
                        continue;
                    }
                    player.setCha(player.getCha() + data[remainingPoints]);
                    break;
                default:
                    break;
            }
            System.out.println();
            remainingPoints++;
        }
	}
}
