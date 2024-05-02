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

public class CharacterFile {

	public static void saveCharacter(Character character, BufferedWriter writer) 
	{		
		try {
			writer.newLine();
			writer.write(character.getName() + "," + character.getType() + "," + character.getRace() + "," + character.getLevel() + "," + character.getStr() + "," + character.getDex() + "," + character.getCon() + "," + character.getIntel() + "," + character.getWis() + "," + character.getCha());
			writer.flush();
			System.out.println("Character saved.");
		} catch (IOException e) {
			System.out.println("An error has occured while saving your character.");
		}
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
			Character current = readFromFile(line);
			characters.add(current);
		}
		return characters;
	}

	public static void clearFile(File file) 
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
	
	public static Character readFromFile(String line) 
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
