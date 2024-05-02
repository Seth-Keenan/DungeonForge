package characterManager.enums;

import java.util.Scanner;

import characterManager.Character;

public enum Race {
	DRAGONBORN,
	DWARF,
	ELF,
	GNOME,
	HALFELF,
	HALFLING,
	HALFORC,
	HUMAN,
	TIEFLING;
	
	//Race Modifiers
	public void updateAbilitiesFromRace(Race race, Character player, Scanner scanner) {
	    switch (race) {
	        case DRAGONBORN:
	            player.setStr(player.getStr() + 2);
	            player.setCha(player.getCha() + 1);
	            break;
	        case DWARF:
	            player.setCon(player.getCon() + 2);
	            break;
	        case ELF:
	            player.setDex(player.getDex() + 2);
	            break;
	        case GNOME:
	            player.setIntel(player.getIntel() + 2);
	            break;
	        case HALFELF:
	            player.setCha(player.getCha() + 2);
	            int remainingPoints = 2;
	            System.out.println("\u001B[1m" +"Please distribute the additional attribute points." + "\u001B[0m");
	            
	            while (remainingPoints > 0) {
	                Attributes attribute = null;
	                
	                // Display the available attributes and their current values
	                System.out.println("Remaining Points: " + "\u001B[31m" + remainingPoints + "\u001B[0m");
	                System.out.println();
	                System.out.println("Current Attributes:");
	                System.out.println("Strength: " + player.getStr());
	                System.out.println("Dexterity: " + player.getDex());
	                System.out.println("Constitution: " + player.getCon());
	                System.out.println("Intelligence: " + player.getIntel());
	                System.out.println("Wisdom: " + player.getWis());
	                System.out.println();
	                
	                System.out.println("Choose an attribute to add a point to:");
	                System.out.println("\u001B[32m" + "STR, DEX, CON, INT, WIS" + "\u001B[0m");
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
	                        if (player.getStr() >= 17) {
	                            System.out.println("You've already given a point to Strength. Choose another attribute.");
	                            continue;
	                        }
	                        player.setStr(player.getStr() + 1);
	                        break;
	                    case DEX:
	                        if (player.getDex() >= 17) {
	                            System.out.println("You've already given a point to Dexterity. Choose another attribute.");
	                            continue;
	                        }
	                        player.setDex(player.getDex() + 1);
	                        break;
	                    case CON:
	                        if (player.getCon() >= 17) {
	                            System.out.println("You've already given a point to Constitution. Choose another attribute.");
	                            continue;
	                        }
	                        player.setCon(player.getCon() + 1);
	                        break;
	                    case INT:
	                        if (player.getIntel() >= 17) {
	                            System.out.println("You've already given a point to Intelligence. Choose another attribute.");
	                            continue;
	                        }
	                        player.setIntel(player.getIntel() + 1);
	                        break;
	                    case WIS:
	                        if (player.getWis() >= 17) {
	                            System.out.println("You've already given a point to Wisdom. Choose another attribute.");
	                            continue;
	                        }
	                        player.setWis(player.getWis() + 1);
	                        break;
	                    case CHA:
	                        if (player.getCha() >= 17) {
	                            System.out.println("You've given the max amount of points to Charisma. Choose another attribute.");
	                            continue;
	                        }
	                        player.setCha(player.getCha() + 1);
	                        break;
	                    default:
	                        break;
	                }
	                System.out.println();
	                remainingPoints--;
	            }
	            break;
	        case HALFLING:
	            player.setDex(2);
	            break;
	        case HALFORC:
	            player.setStr(2);
	            player.setCon(1);
	            break;
	        case HUMAN:
	            player.setCha(1);
	            player.setCon(1);
	            player.setDex(1);
	            player.setIntel(1);
	            player.setStr(1);
	            player.setWis(1);
	            break;
	        case TIEFLING:
	            player.setCha(2);
	            player.setIntel(1);
	            break;
	        default:
	            break;
	    }
	}
}
