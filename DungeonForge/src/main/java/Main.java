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
	
	public static void main(String[] args) throws IOException 
	{
		Scanner scanner = new Scanner(System.in);
		File file = new File("files/characters.csv");
		Character current = null;

		System.out.println("\u001B[1m" + "\u001B[33m" + "Welcome to Dungeon Forge" + "\u001B[0m");
		System.out.println("Dungeon Forge is a table top application to aid with DnD character storing and data manipulation.");
		
		int choice = -1;
        while (choice < 1 || choice > 6) 
        {
    		System.out.println();
        	System.out.println("1.) Create New Character");
    		System.out.println("2.) Import Custom Stats");
    		System.out.println("3.) Display Current Character");
    		System.out.println("4.) Display all save Characters");
    		System.out.println("5.) Save Character");
    		System.out.println("6.) Clear Character List");
            System.out.print("Enter your choice (1-6): ");
            try 
            {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) 
                {
                    case 1:
                    	System.out.println();
                		CharacterCreator characterCreator = new CharacterCreator();
                		current = characterCreator.newCharacter(scanner);
                        break;
                    case 2:
                    	System.out.println();
                    	CharacterCreator characterImporter = new CharacterCreator();
                		current = characterImporter.loadCharacter(scanner);
                        break;
                    case 3:
                    	System.out.println();
                    	if(current != null) 
                    	{
                    		Display.DisplayCharacter(current); 
                    	}
                    	else
                    		System.out.println("There is no current character selected.");                    		
                        break;
                    case 4:
                    	//TODO fix file searching
                    	System.out.println();
                    	Scanner fileIn = new Scanner(file);
                    	List<Character> characters = new ArrayList<>();
                		characters = CharacterFile.loadCharacters(fileIn);
                		Display.DisplayCharacterList(characters);
                		fileIn.close();
                        break;
                    case 5:
                    	System.out.println();
                    	if(current != null) 
                    	{
                		FileWriter fr = new FileWriter(file,true);
                		BufferedWriter br = new BufferedWriter(fr);
                		CharacterFile.saveCharacter(current, br);
                		fr.close();
                		br.close();
                    	}
                    	else
                    		System.out.println("No selected character.");
                        break;
                    case 6:
                    	System.out.println();
                    	Scanner fp = new Scanner(file);
                    	CharacterFile.clearFile(fp);
                    	System.out.println("Files Deleted.");
                    	
                    	//TODO delete the file
                    	
                    	break;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 6.");
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a number.");
            }
            choice = -1;
        }
        scanner.close();
    }
}
	/*
		CharacterCreator characterCreator = new CharacterCreator();
		//This is the Create Character Feature
		//This is the load in character feature with specific information
		
		
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
		
		
		fileIn.close();
		scanner.close();
	}

	*/
