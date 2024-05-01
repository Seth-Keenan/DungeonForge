import characterManagement.CharacterFactory;
import characterManagement.classType;

public class Main {

	public static void main(String[] args) {
		CharacterFactory factory = new CharacterFactory();
		
		characterManagement.Character character = factory.createClass(classType.BARBARIAN);	
		character.talk();
	}

}
