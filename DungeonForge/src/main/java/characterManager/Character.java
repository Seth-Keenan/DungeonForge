package characterManager;

import characterManager.enums.Race;
import characterManager.enums.CType;

public class Character {
	
	private String name;
	private int level = 1;
	private Race race;
	private CType type;
	
	private int str = 0;
	private int dex = 0;
	private int con = 0;
	private int intel = 0;
	private int wis = 0;
	private int cha = 0;
	
	public Character(String name, Race race, CType type) 
	{
		this.name = name;
		this.race = race;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public CType getType() {
		return type;
	}
	public void setType(CType type) {
		this.type = type;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public int getIntel() {
		return intel;
	}
	public void setIntel(int intel) {
		this.intel = intel;
	}
	public int getWis() {
		return wis;
	}
	public void setWis(int wis) {
		this.wis = wis;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	@Override
	public String toString() {
		return "Character [name=" + name + ", level=" + level + ", str=" + str + ", dex=" + dex + ", con=" + con
				+ ", intel=" + intel + ", wis=" + wis + ", cha=" + cha + "]";
	}
}
