import java.util.Scanner;

import characterManagement.CharacterFactory;
import characterManagement.classType;
import characterManagement.raceType;

public class Main {

	//Add level too all of the classes
	//This will implement, import character feature (current character)
	
	//Finish Stats to make character builder with builder feature
	
	//Finish inline display (Terminal stats display) with display feature
	
	//Add a way to save character data to a csv file with save feature
	
	//Read any csv formatted correctly with load feature
	
	public static void main(String[] args) {
		CharacterFactory factory = new CharacterFactory();
		
		characterManagement.Character character = factory.createCharacter(classType.BARBARIAN, raceType.HUMAN, "Seth");	
		character.talk();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your character's name: ");
		String name = scanner.nextLine();
		
		classType type = null;
		raceType race = null;
		
		while(type == null) {
			try {		
				System.out.println("Please enter your character's class: ");
				String typeIn = scanner.nextLine().toUpperCase();
				type = classType.valueOf(typeIn);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid class. Please try again.");
			}
		}
		
		while(race == null) 
		{
			try {
				System.out.println("Please enter your character's race: ");
				String raceIn = scanner.nextLine().toUpperCase();
				race = raceType.valueOf(raceIn);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid race. Please try again.");
			}
		}
		
		
		characterManagement.Character c = factory.createCharacter(type, race, name);	
		c.talk();
		
		scanner.close();
		

	}

}
