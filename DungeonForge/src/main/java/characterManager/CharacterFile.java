package characterManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterFile {

	public static void saveCharacter(Character character, BufferedWriter writer) 
	{
		try {
			writer.newLine();
			writer.write(character.getName() + "," + character.getType() + "," + character.getRace() + "," + character.getLevel() + "," + character.getStr() + "," + character.getDex() + "," + character.getCon() + "," + character.getIntel() + "," + character.getWis() + "," + character.getCha());
			writer.flush();
		} catch (IOException e) {
			System.out.println("An error has occured while saving your character.");
		}
	}
	
	public static void writeCharactersToFile(List<Character> characters, Scanner fileIn) 
	{
		//Skip header
		if(fileIn.hasNextLine()) 
		{
			fileIn.nextLine();
		}
		
		//TODO finish writing charcter write to csv
	
	}
	
	public static List<Character> loadCharacters(Scanner fileIn) 
	{
		//Skip header
		if(fileIn.hasNextLine()) 
		{
			fileIn.nextLine();
		}
		
		List<Character> characters = new ArrayList<>();
		while(fileIn.hasNextLine()) 
		{
			String line = fileIn.nextLine();
			Character current = CharacterCreator.readFromFile(line);
			characters.add(current);
		}
		
		return characters;
	}
	
	public static void deleteCharacter(Scanner delOption, Scanner fileIn) 
	{
		try {
			List<Character> inFile = new ArrayList<>();
			inFile = loadCharacters(fileIn);
			Display.DisplayCharacterList(inFile);
			
			System.out.println("Please choose the character to delete, or 'exit' to cancel: ");
			String in = delOption.nextLine();
			
			if(in.equalsIgnoreCase("exit")) 
			{
				System.out.println("Deletion Cancled");
				return;
			}
			
			int idxToDel = Integer.parseInt(in);
			
			if(idxToDel >= 0 && idxToDel < inFile.size()) 
			{
				Character deleted = inFile.get(idxToDel);
				inFile.remove(idxToDel);
				System.out.println("Deleted: " + deleted.getName());
				
				writeCharactersToFile(inFile, fileIn);
			}	
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Invalid Input. Please input a valid index or 'exit' to cancel");
		}
	}
	
}
