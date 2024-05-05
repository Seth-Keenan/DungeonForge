import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characterManager.Character;
import characterManager.CharacterFile;
import characterManager.enums.CType;
import characterManager.enums.Race;

public class CharacterFileTest {
	
	Character testCharacter;
	
	@BeforeEach
	void newUp()
	{
		testCharacter = new Character("Test", Race.DRAGONBORN, CType.BARD);
		testCharacter.setLevel(1);
		testCharacter.setStr(0);
		testCharacter.setDex(0);
		testCharacter.setCon(0);
		testCharacter.setIntel(0);
		testCharacter.setWis(0);
		testCharacter.setCha(0);
	}
	
	@Test
	void testLoadCharacters() throws FileNotFoundException 
	{
		CharacterFile charfile = new CharacterFile();
		
		File file = new File("files/testLoadCharacters.csv");
		Scanner fileIn = new Scanner(file);
		
		List<Character> characters = new ArrayList<>();
		characters = charfile.loadCharacters(fileIn);
		
		Character resultChar = characters.get(0);
		
		String expected = "Test,BARD,DRAGONBORN,1,0,0,0,0,0,0";
		
		assertEquals(expected, resultChar.toCSV());
	}
	
	@Test
	void testReadFromFile() 
	{
		CharacterFile charfile = new CharacterFile();
		testCharacter = charfile.readFromFile("Test,BARD,DRAGONBORN,1,0,0,0,0,0,0");
		String expected = "Test,BARD,DRAGONBORN,1,0,0,0,0,0,0";
		
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testClearFile() throws IOException 
	{
		 // Create a file with some initial content
	    File file = new File("files/testClearFile.csv");
		CharacterFile charfile = new CharacterFile();
	    
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	    writer.write("Hello");
	   
	    // Call the method to clear the file
	    charfile.clearFile(file);

	    // Verify that the file is empty
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    //assertTrue(reader.readLine() == "Name,Class,Race,Lvl,Str,Dex,Con,Int,Wis,Cha\n"); // If the file is empty, readLine() will return null
	}
}
