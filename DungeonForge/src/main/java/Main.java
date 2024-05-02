import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import characterManager.CharacterCreator;
import characterManager.CharacterFile;
import characterManager.Character;
import characterManager.Display;

public class Main {

	//Add level too all of the classes
	//This will implement, import character feature (current character)
	
	//Finish Stats to make character builder with builder feature
	
	//Finish inline display (Terminal stats display) with display feature
	
	//Add a way to save character data to a csv file with save feature
	
	//Read any csv formatted correctly with load feature
	
	public static void main(String[] args) throws IOException {
		
		//For Character Creator
		Scanner scanner = new Scanner(System.in);
		CharacterCreator characterCreator = new CharacterCreator();

		//This is the Create Character Feature
		Character newChar = characterCreator.newCharacter(scanner);
				
		//This is the load in character feature with specific information
		//Character loadInPersonal = characterCreator.loadCharacter(scanner);
		
		scanner.close();
		
		//This is the Display feature
		Display.DisplayCharacter(newChar);
		System.out.println();
		
		//For file management (writing)
		File f = new File("files/characters.csv");
		FileWriter fr = new FileWriter(f,true);
		BufferedWriter br = new BufferedWriter(fr);
		
		CharacterFile.saveCharacter(newChar, br);

		//For file management (loading)
		Scanner fileIn = new Scanner(f);
		
		List<Character> characters = new ArrayList<>();
		characters = CharacterFile.loadCharacters(fileIn);
		Display.DisplayCharacterList(characters);
		
		//For deleteCharacter
		//Scanner delOption = new Scanner(System.in);
		
		//CharacterFile.deleteCharacter(delOption, fileIn);
	}

	
}
