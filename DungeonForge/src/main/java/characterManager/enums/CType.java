package characterManager.enums;

import characterManager.Character;

public enum CType {
	BARBARIAN,
	BARD,
	CLERIC,
	DRUID,
	FIGHTER,
	MONK,
	PALADIN,
	RANGER,
	ROGUE,
	SORCERER,
	WARLOCK,
	WIZARD;
	
	//This can be used if not using the standard dnd attribute array
	public void updateAbilitiesFromClass(CType type, Character player) 
	{
		switch(type) 
		{
			case BARBARIAN:
				player.setStr(player.getStr() + 1);
				player.setCon(player.getCon() + 1);
				break;
			case BARD:
				player.setDex(player.getDex() + 1);
				player.setCha(player.getCha() + 1);
				break;
			case CLERIC:
				player.setWis(player.getWis() + 1);
				player.setCha(player.getCha() + 1);
				break;
			case DRUID:
				player.setIntel(player.getIntel() + 1);
				player.setWis(player.getWis() + 1);
				break;
			case FIGHTER:
				player.setStr(player.getStr() + 1);
				player.setCon(player.getCon() + 1);
				break;
			case MONK:
				player.setStr(player.getStr() + 1);
				player.setDex(player.getDex() + 1);
			case PALADIN:
				player.setWis(player.getWis() + 1);
				player.setCha(player.getCha() + 1);
			case RANGER:
				player.setStr(player.getStr() + 1);
				player.setDex(player.getDex() + 1);
			case ROGUE:
				player.setDex(player.getDex() + 1);
				player.setIntel(player.getIntel() + 1);
			case SORCERER:
				player.setCon(player.getCon() + 1);
				player.setCha(player.getCha() + 1);
			case WARLOCK:
				player.setWis(player.getWis() + 1);
				player.setCha(player.getCha() + 1);
			case WIZARD:
				player.setIntel(player.getIntel() + 1);
				player.setWis(player.getWis() + 1);
			default:
				break;
		}
	}
}
