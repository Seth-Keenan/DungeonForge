package characterManagement;

public class CharacterFactory {
	
	public Character createClass(classType type) 
	{
		switch(type) {
			case BARBARIAN:
				return new Barbarian();
			case BARD:
				return new Bard();
			case CLERIC:
				return new Cleric();
			case DRUID:
				return new Druid();
			case FIGHTER:
				return new Fighter();
			case MONK:
				return new Monk();
			case PALADIN:
				return new Paladin();
			case RANGER:
				return new Ranger();
			case ROGUE:
				return new Rogue();
			case SORCERER:
				return new Sorcerer();
			case WARLOCK:
				return new Warlock();
			case WIZARD:
				return new Wizard();
			case ARTIFICER:
				return new Artificer();
			case BLOODHUNTER:
				return new BloodHunter();
			default:
				throw new IllegalArgumentException("Invalid character type: " + type);
		}
	}
}