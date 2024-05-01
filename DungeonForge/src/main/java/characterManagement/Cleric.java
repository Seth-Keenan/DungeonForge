package characterManagement;

public class Cleric implements Character{

	public int strength = 0;
	public int dex = 0;
	public int consti = 0;
	public int intel = 0;
	public int wisdom = 0;
	public int charisma = 0;
	
	private raceType race;
	private String name;
	
	public Cleric(raceType race, String name) {
		this.race = race;
		this.name = name;
	}

	@Override
	public String getRace() {
		return race.toString();
	}
	
	@Override
	public String getName() 
	{
		return name;
	}
	
	@Override
	public void talk() {
		System.out.println("I am a Cleric");		
	}
	
	@Override
	public int getStrength() {
		return strength;
	}

	@Override
	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public int getDex() {
		return dex;
	}

	@Override
	public void setDex(int dex) {
		this.dex = dex;
	}

	@Override
	public int getConsti() {
		return consti;
	}

	@Override
	public void setConsti(int consti) {
		this.consti = consti;
	}

	@Override
	public int getIntel() {
		return intel;
	}

	@Override
	public void setIntel(int intel) {
		this.intel = intel;
	}

	@Override
	public int getWisdom() {
		return wisdom;
	}

	@Override
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	@Override
	public int getCharisma() {
		return charisma;
	}

	@Override
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	
}
