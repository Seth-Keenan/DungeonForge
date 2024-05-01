package characterManagement;

public class CharacterFactory {
	
	public Character createCharacter(classType type, raceType race, String name) 
	{
		switch(type) {
			case BARBARIAN:
				return new Barbarian(race, name);
			case BARD:
				return new Bard(race, name);
			case CLERIC:
				return new Cleric(race, name);
			case DRUID:
				return new Druid(race, name);
			case FIGHTER:
				return new Fighter(race, name);
			case MONK:
				return new Monk(race, name);
			case PALADIN:
				return new Paladin(race, name);
			case RANGER:
				return new Ranger(race, name);
			case ROGUE:
				return new Rogue(race, name);
			case SORCERER:
				return new Sorcerer(race, name);
			case WARLOCK:
				return new Warlock(race, name);
			case WIZARD:
				return new Wizard(race, name);
			default:
				throw new IllegalArgumentException("Invalid character type: " + type);
		}
	}
}