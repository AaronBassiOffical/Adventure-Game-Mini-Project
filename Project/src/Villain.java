import java.util.Random;

public class Villain{


	private int lives; 
	private boolean death;

	public Villain() {
		this.lives = 3; 
		this.death = false;

	}

	public Villain(int lives, boolean death) {
		this.lives = lives;
		this.death = death;
	}

	

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getLives() {
		return this.lives;
	}
	
	public void setDeath(boolean death) {
		this.death = death;
	}

	public boolean getDeath() {
		return this.death;
	}

	public int attack() {
		Random rand = new Random();
		int damage = rand.nextInt(4); 
		return damage;
	}

	public int damage(int damage) { 
		this.lives = this.lives - damage; 

		if (this.lives <= 0) {
			this.death = true; 
		}
		
		return damage;
	}
	
	public String toString() {
		String displayLives = "The enemy's current lives are: " + this.lives + "!"; 
		return displayLives;
	}

}