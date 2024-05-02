import java.util.Scanner;

import characterManager.CharacterCreator;
import characterManager.Character;
import characterManager.Display;

public class Main {

	//Add level too all of the classes
	//This will implement, import character feature (current character)
	
	//Finish Stats to make character builder with builder feature
	
	//Finish inline display (Terminal stats display) with display feature
	
	//Add a way to save character data to a csv file with save feature
	
	//Read any csv formatted correctly with load feature
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		CharacterCreator characterCreator = new CharacterCreator();
		
		//This is the Create Character Feature
		Character newChar = characterCreator.newCharacter(scanner);
				
		//This is the load in character feature with specific information
		//Character loadInPersonal = characterCreator.loadCharacter(scanner);
		
		//This is the Display feature
		Display.Display(newChar);
	}

	
}
