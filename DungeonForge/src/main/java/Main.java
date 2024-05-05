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
		File file = new File("files/characters.csv");
		Character current = null;
		
		CharacterCreator characterCreator = new CharacterCreator();
		CharacterFile characterFile = new CharacterFile();
		Display display = new Display();
		Scanner scanner = new Scanner(System.in);
		
		display.titleDisplay();

		boolean loop = true;
		int choice = -1;
        while (loop)
        {
    		display.optionsDisplay();
            try 
            {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) 
                {
                    case 1:
                    	System.out.println();
                		current = characterCreator.newCharacter();
                        break;
                    case 2:
                    	System.out.println();
                		current = characterCreator.loadCharacter();
                        break;
                    case 3:
                    	System.out.println();
                    	if(current != null) 
                    	{
							display.DisplayCharacter(current); 
                    	}
                    	else
                    		System.out.println("There is no current character selected.");                    		
                        break;
                    case 4:
                    	//TODO fix file searching
                    	System.out.println();
                    	Scanner fileIn = new Scanner(file);
                    	List<Character> characters = new ArrayList<>();
                		characters = characterFile.loadCharacters(fileIn);
                		if(characters.isEmpty() == true) 
                		{                			
                			System.out.println("There are no characters saved in the list.");
                		}
                		else
                			display.DisplayCharacterList(characters);
                		fileIn.close();
                        break;
                    case 5:
                    	System.out.println();
                    	if(current != null) 
                    	{
	                		FileWriter fr = new FileWriter(file,true);
	                		BufferedWriter br = new BufferedWriter(fr);
	                		characterFile.saveCharacter(current, br);
	                		fr.close();
	                		br.close();
                    	}
                    	else
                    		System.out.println("No selected character.");
                        break;
                    case 6:
                    	System.out.println();
                    	characterFile.clearFile(file);
                    	System.out.println("Files Deleted.");                    	
                    	break;
                    case 7:
                    	loop = false;
                    	break;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 7.");
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        scanner.close();
	}
}
