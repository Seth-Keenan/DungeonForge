package characterManagement;

public interface Character {
	
	void talk();
	
	String getRace();
	String getName();
	
	int getStrength();
	void setStrength(int strength);
	
	int getDex();
	void setDex(int dex);
	
	int getConsti();
	void setConsti(int consti);

	int getIntel();
	void setIntel(int intel);
	
	int getWisdom();
	void setWisdom(int wisdom);
	
	int getCharisma();
	void setCharisma(int charisma);
}
