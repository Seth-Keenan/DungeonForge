import characterManager.Character;
import characterManager.enums.Race;
import characterManager.enums.CType;
import characterManager.Display;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
		
}
