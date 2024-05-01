package characterManagement;

public class Bard implements Character{
	
	private int strength = 0;
	private int dex = 0;
	private int consti = 0;
	private int intel = 0;
	private int wisdom = 0;
	private int charisma = 0;
	
	private String race;
	private String name;
	
	public Bard(raceType race, String name) {
		this.race = race.toString().toLowerCase();
		this.name = name.toLowerCase();
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
		System.out.println("I am a Bard");		
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
