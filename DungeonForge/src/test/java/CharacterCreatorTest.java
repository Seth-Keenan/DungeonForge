import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import characterManager.CharacterCreator;
public class CharacterCreatorTest 
{
	@Test
	void testGetValidIntInput() 
	{
		CharacterCreator creator = new CharacterCreator();
		
		String input = "123\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		assertEquals(123, creator.getValidIntInput(""));
	}
}
