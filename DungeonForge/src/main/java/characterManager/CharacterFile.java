/**
 * 
 * @author SethKeenan
 * @version 5/5/2024
 * 
 */

package characterManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import characterManager.enums.CType;
import characterManager.enums.Race;

/**
 * Handles reading from and writing to character files.
 */
public class CharacterFile {

	/**
     * Saves a character to the specified file using CSV format.
     * 
     * @param character The character to be saved.
     * @param writer    The BufferedWriter used to write to the file.
     */
	public void saveCharacter(Character character, BufferedWriter writer) 
	{		
		try {
			writer.newLine();
			writer.write(character.toCSV());
			writer.flush();
			System.out.println("Character saved.");
		} catch (IOException e) {
			System.out.println("An error has occured while saving your character.");
		}
	}
	
	/**
     * Loads characters from the given file using Scanner.
     * 
     * @param fileIn The Scanner used to read from the file.
     * @return A list of characters loaded from the file.
     */
	public List<Character> loadCharacters(Scanner fileIn) 
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
			Character current = readFromFile(line);
			characters.add(current);
		}
		return characters;
	}

	/**
     * Clears the contents of the given file.
     * 
     * @param file The file to be cleared.
     */
	public void clearFile(File file) 
	{
		String header = "Name,Class,Race,Lvl,Str,Dex,Con,Int,Wis,Cha";
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
		{
			writer.write(header);
		} 
		catch (IOException e) 
		{
			System.out.println("An issue occured while trying to clear the file.");
		}
	}
	
	/**
     * Reads character data from a string and constructs a Character object.
     * 
     * @param line The string containing character data in CSV format.
     * @return The Character object created from the provided data.
     */
	public Character readFromFile(String line) 
	{
		String[] parsed = line.split(",");
		Character character = new Character(parsed[0],Race.valueOf(parsed[2]),CType.valueOf(parsed[1]));
		character.setLevel(Integer.valueOf(parsed[3]));
		character.setStr(Integer.valueOf(parsed[4]));
		character.setDex(Integer.valueOf(parsed[5]));
		character.setCon(Integer.valueOf(parsed[6]));
		character.setIntel(Integer.valueOf(parsed[7]));
		character.setWis(Integer.valueOf(parsed[8]));
		character.setCha(Integer.valueOf(parsed[9]));
		return character;
	}
	
}
