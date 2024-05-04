import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characterManager.Character;
import characterManager.CharacterCreator;
import characterManager.enums.CType;
import characterManager.enums.Race;

public class CharacterCreatorTest {
	
	Character testCharacter;
	
	@BeforeEach
	void newUp() 
	{
		testCharacter = new Character("Test", Race.ELF, CType.BARD);
		testCharacter.setStr(15);
		testCharacter.setDex(16);
		testCharacter.setCon(13);
		testCharacter.setIntel(12);
		testCharacter.setWis(10);
		testCharacter.setCha(8);
	}
}
