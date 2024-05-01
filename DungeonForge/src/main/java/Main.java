import characterManagement.CharacterFactory;
import characterManagement.classType;

public class Main {

	//Add level too all of the classes
	//This will implement, import character feature (current character)
	
	//Finish Stats to make character builder with builder feature
	
	//Finish inline display (Terminal stats display) with display feature
	
	//Add a way to save character data to a csv file with save feature
	
	//Read any csv formatted correctly with load feature
	
	public static void main(String[] args) {
		CharacterFactory factory = new CharacterFactory();
		
		characterManagement.Character character = factory.createClass(classType.BARBARIAN);	
		character.talk();
	}

}
