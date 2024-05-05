import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characterManager.Character;
import characterManager.CharacterCreator;
import characterManager.enums.CType;
import characterManager.enums.Race;
public class CharacterCreatorTest 
{
	Character testCharacter;
	
	@BeforeEach
	void newUp() 
	{
		testCharacter = new Character("Test", Race.DRAGONBORN, CType.BARD);
	}
	
	@Test
	void testGetValidIntInput() 
	{
		CharacterCreator creator = new CharacterCreator();
		
		String input = "123\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		assertEquals(123, creator.getValidIntInput(""));
	}
	
	@Test
	void testPromptType() 
	{
		CharacterCreator creator = new CharacterCreator();
		String input = "BARD";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		assertEquals(CType.BARD, creator.promptType(null));
	}
	
	@Test
	void testPromptRace() 
	{
		CharacterCreator creator = new CharacterCreator();
		String input = "DRAGONBORN";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		assertEquals(Race.DRAGONBORN, creator.promptRace(null));

	}
	/*
	@Test
    void testNewCharacter() {
        // Prepare input data
        String input = "John\nBARBARIAN\nELF\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Execute the method to be tested
        CharacterCreator creator = new CharacterCreator();
    }
	
	@Test
	void testStartCharacter() 
	{
		CharacterCreator creator = new CharacterCreator();
		String input = "Joe\nBARD\nDRAGONBORN";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		testCharacter = creator.startCharacter();
		
		assertEquals("Joe", testCharacter.getName());
		assertEquals(CType.BARD, testCharacter.getType());
		assertEquals(Race.DRAGONBORN, testCharacter.getRace());
	}
	*/
}
