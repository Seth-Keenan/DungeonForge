import characterManager.Character;
import characterManager.enums.Race;
import characterManager.enums.CType;
import characterManager.Display;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CharacterTest 
{

	private Character testCharacter;
	
	@BeforeEach
	void newUp() 
	{
		testCharacter = new Character("Test", Race.DRAGONBORN, CType.BARD);
	}
	
	@Test
	void testGetSet() 
	{
		//Getters
		assertEquals("Test", testCharacter.getName());
        
		assertEquals(Race.DRAGONBORN, testCharacter.getRace());
        
        assertEquals(CType.BARD, testCharacter.getType());
        
        assertEquals(1, testCharacter.getLevel());
        
        assertEquals(0, testCharacter.getStr());
        
        assertEquals(0, testCharacter.getDex());
        
        assertEquals(0, testCharacter.getCon());
        
        assertEquals(0, testCharacter.getIntel());
        
        assertEquals(0, testCharacter.getWis());
        
        assertEquals(0, testCharacter.getCha());
        
        //Setters
        testCharacter.setName("Tester");
        assertEquals("Tester", testCharacter.getName());
        
        testCharacter.setRace(Race.ELF);
        assertEquals(Race.ELF, testCharacter.getRace());
        
        testCharacter.setType(CType.DRUID);
        assertEquals(CType.DRUID, testCharacter.getType());
        
        testCharacter.setLevel(10);
        assertEquals(10, testCharacter.getLevel());
        
        testCharacter.setStr(5);
        assertEquals(5, testCharacter.getStr());
        
        testCharacter.setDex(5);
        assertEquals(5, testCharacter.getDex());
        
        testCharacter.setCon(5);
        assertEquals(5, testCharacter.getCon());
        
        testCharacter.setIntel(5);
        assertEquals(5, testCharacter.getIntel());
        
        testCharacter.setWis(5);
        assertEquals(5, testCharacter.getWis());
        
        testCharacter.setCha(5);
        assertEquals(5, testCharacter.getCha());
	}
	
	@Test
	void testToString() 
	{
		testCharacter.setName("Test");
	    testCharacter.setRace(Race.DRAGONBORN);
	    testCharacter.setType(CType.BARD);
	    testCharacter.setLevel(10);
	    testCharacter.setStr(5);
	    testCharacter.setDex(5);
	    testCharacter.setCon(5);
	    testCharacter.setIntel(5);
	    testCharacter.setWis(5);
	    testCharacter.setCha(5);
		
		StringBuilder character = new StringBuilder();

		character.append("----------\n");
		character.append("\u001B[4m" + "Test" + " the " + CType.BARD + "\u001B[0m\n");
		character.append("\u001B[1m" + "Race: " + Race.DRAGONBORN + "\u001B[0m\n");
		character.append("\u001B[31m" + "Level        | " + "\u001B[0m" + 10 + "\n");
		character.append("\u001B[33m" + "Strength     | " + "\u001B[0m" + 5 + "\n");
		character.append("\u001B[33m" + "Dexterity    | " + "\u001B[0m" + 5 + "\n");
		character.append("\u001B[33m" + "Constitution | " + "\u001B[0m" + 5 + "\n");
		character.append("\u001B[33m" + "Intellegence | " + "\u001B[0m" + 5 + "\n");
		character.append("\u001B[33m" + "Wisdom       | " + "\u001B[0m" + 5 + "\n");
		character.append("\u001B[33m" + "Charisma     | " + "\u001B[0m" + 5 + "\n");
		character.append("----------");
		
		assertEquals(character.toString(), testCharacter.toString());
	}
	
	@Test
	void testToCSV() 
	{
		testCharacter.setName("Test");
	    testCharacter.setRace(Race.DRAGONBORN);
	    testCharacter.setType(CType.BARD);
	    
	    String expected = "Test,BARD,DRAGONBORN,1,0,0,0,0,0,0";
	    
	    assertEquals(expected, testCharacter.toCSV());
	}

	@Test
	void testUAFRDragon() 
	{
		String expected = "Test,BARD,DRAGONBORN,1,2,0,0,0,0,1";
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testUAFRDwarf() 
	{
		String expected = "Test,BARD,DWARF,1,0,0,2,0,0,0";
		testCharacter.setRace(Race.DWARF);
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testUAFRElf() 
	{
		String expected = "Test,BARD,ELF,1,0,2,0,0,0,0";
		testCharacter.setRace(Race.ELF);
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testUAFRGnome() 
	{
		String expected = "Test,BARD,GNOME,1,0,0,0,2,0,0";
		testCharacter.setRace(Race.GNOME);
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testUAFRHalfling() 
	{
		String expected = "Test,BARD,HALFLING,1,0,2,0,0,0,0";
		testCharacter.setRace(Race.HALFLING);
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testUAFRHalforc() 
	{
		String expected = "Test,BARD,HALFORC,1,0,2,1,0,0,0";
		testCharacter.setRace(Race.HALFORC);
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testUAFRHuman() 
	{
		String expected = "Test,BARD,HUMAN,1,1,1,1,1,1,1";
		testCharacter.setRace(Race.HUMAN);
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	@Test
	void testUAFRTiefling() 
	{
		String expected = "Test,BARD,TIEFLING,1,0,0,0,1,0,2";
		testCharacter.setRace(Race.TIEFLING);
		testCharacter.updateAbilitiesFromRace();
		assertEquals(expected, testCharacter.toCSV());
	}
	
	/*
	@Test
    public void testChooseHalfElfAbilities() {
        String input = "STR";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Replace "YourClass" with the name of your class containing the chooseHalfElfAbilities() method
        testCharacter.chooseHalfElfAbilities();
    }
	
	@Test
	public void testDisplayChoice() 
	{
		StringBuilder expected = new StringBuilder();
		expected.append("Distribute Points: " + "\u001B[31m" + 1 + "\u001B[0m");
		expected.append("\n");
		expected.append("Current Attributes:");
		expected.append(testCharacter.toString());
		expected.append("Choose an attribute to add a point to:");
		expected.append("\u001B[32m" + "STR, DEX, CON, INT, WIS" + "\u001B[0m");

		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		testCharacter.displayChoice(1);
		
		String result = outputStream.toString();
		
		assertEquals(expected.toString(), result);
	}
    */
}
