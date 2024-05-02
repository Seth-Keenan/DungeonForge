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

	public static void main(String[] args) throws IOException 
	{
		Scanner scanner = new Scanner(System.in);
		File file = new File("files/characters.csv");
		Character current = null;

		Display.titleDisplay();
		
		int choice = -1;
        while (choice < 1 || choice > 6) 
        {
    		Display.optionsDisplay();
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
                		if(characters.isEmpty() == true) 
                		{                			
                			System.out.println("There are no characters saved in the list.");
                		}
                		else
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
                    	CharacterFile.clearFile(file);
                    	System.out.println("Files Deleted.");
                    	
                    	//TODO delete the file contents
                    	
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
