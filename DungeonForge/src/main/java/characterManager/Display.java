package characterManager;


public class Display {
	public static void Display(Character player) {
		System.out.println("\u001B[4m" + player.getName() + " the " + player.getType() + "\u001B[0m");
		System.out.println("\u001B[1m" + "Race: " + player.getRace() + "\u001B[0m");
		System.out.println("\u001B[33m" + "LVL | " + "\u001B[0m" + player.getLevel());
		System.out.println("\u001B[33m" + "STR | " + "\u001B[0m" + player.getStr());
		System.out.println("\u001B[33m" + "DEX | " + "\u001B[0m" + player.getDex());
		System.out.println("\u001B[33m" + "CON | " + "\u001B[0m" + player.getCon());
		System.out.println("\u001B[33m" + "INT | " + "\u001B[0m" + player.getIntel());
		System.out.println("\u001B[33m" + "WIS | " + "\u001B[0m" + player.getWis());
		System.out.println("\u001B[33m" + "CHA | " + "\u001B[0m" + player.getCha());
	}
}
