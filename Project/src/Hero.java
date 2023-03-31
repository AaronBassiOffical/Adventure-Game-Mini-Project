import java.util.Random;

public class Hero {



	
	private String name;
	private int health;
	private boolean death;
	private boolean[] inventory;

	public Hero() {
		this.name = "";
		this.health = 3;
		this.death = false;
		this.inventory = new boolean[] { false, false, false, false, false };
	}

	public Hero(String name, int health, boolean death, boolean[] inventory) {
		this.name = name;
		this.health = health;
		this.death = death;
		this.inventory = inventory;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return this.health;
	}
	
	public void setDeath(boolean death) {
		this.death = death;
	}

	public boolean getDeath() {
		return this.death;
	}

	public void setInventory(boolean[] inventory) {
		this.inventory = inventory;
	}

	public boolean[] getInventory() {
		return this.inventory;
	}

	public int damage(int damage) { 
		this.health = this.health - damage; 

		if (this.health <= 0) {
			this.death = true; 
		}

		return damage;
	} 

	public void heal() {

		if (this.health < 3) {
			this.health++; 
		} else {
			System.out.println("You are at full health.");
		}
	} 

	public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4);
		return damage;
	}

	
	public String toString() {
		String displayHealth = this.name + ", your current health is: " + this.health + "/3.";
		return displayHealth;
	}

}
