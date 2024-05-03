import characterManager.Character;
import characterManager.Display;
import characterManager.enums.CType;
import characterManager.enums.Race;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DisplayTest {

	Character testCharacter;
	Display display;
	
	@BeforeEach
	void newUp() 
	{
		testCharacter = new Character("Test", Race.DRAGONBORN, CType.BARD);
		
	    
	    display = new Display();
	}
	
	@Test
	void testDisplayCharacter() 
	{
		testCharacter.setLevel(1);
	    testCharacter.setStr(0);
	    testCharacter.setDex(0);
	    testCharacter.setCon(0);
	    testCharacter.setIntel(0);
	    testCharacter.setWis(0);
	    testCharacter.setCha(0);
	    
		String expected = testCharacter.toString();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		display.DisplayCharacter(testCharacter);
		
		String result = outputStream.toString().trim();
		assertEquals(expected, result);
	}
	
	@Test
	void testTitleDisplay() 
	{
		StringBuilder expected = new StringBuilder();
		expected.append("\u001B[1m" + "\u001B[33m" + "Welcome to Dungeon Forge" + "\u001B[0m");
		expected.append("Dungeon Forge is a table top application to aid with DnD character storing and data manipulation.");
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		display.titleDisplay();
		
		String result = outputStream.toString();

		assertEquals(expected.toString(), result);
	}
	
	@Test
	void testOptionsDisplay() 
	{
		StringBuilder expected = new StringBuilder();
		expected.append("--------------------------------");
		expected.append("1.) Create New Character");
		expected.append("2.) Import Custom Stats");
		expected.append("3.) Display Current Character");
		expected.append("4.) Display all saved Characters");
		expected.append("5.) Save Character");
		expected.append("6.) Clear Character List");
		expected.append("7.) Exit");
		expected.append("Enter your choice (1-7): ");
		expected.append("--------------------------------");
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		display.optionsDisplay();
		
		String result = outputStream.toString();

		assertEquals(expected.toString(), result);
	}
	
}
