public class BeginJourney {
	

	
	private final int room1 = 1;
	private final int room2 = 2;
	private final int room3 = 3;
	private final int room4 = 4;
	private final int room5 = 5;
	private final int room6 = 6;

	
	private int roomNum;

	
	public BeginJourney() {
		roomNum = 0;
	} 

	public BeginJourney(int roomNum) {
		this.roomNum = roomNum;
	}

	public void setRoomNumber(int roomNum) {
		this.roomNum = roomNum;
	} 

	public int getRoomNumber() {
		return this.roomNum;
	} 


	public String getRoomDescription(boolean[] inventory, Villain enemy) {
		

		String description = ""; 

		if (this.roomNum == room1) { 

			if (inventory[0] == true) {

				if (inventory[3] == true) {
					description = "You are back in the mansion lobby..." + "\nYou've picked up the car keys here already.";
			
				} else {
					description = "You are back in the mansion lobby..."
							+ "\nYou can see a key lying on the"
							+ "\ntable to the north of you, and locate a dark"
							+ "\nhallway to the west. You are not sure where it leads. "
							+ "\nWhat would you like to do?";
				}
			} else {
				description = "You are inside the lobby of a haunted mansion... "
						+ "\nYou Don't know how you got here, but the door"
						+ "\nbehind you is locked. There is no leaving."
						+ "\nIt's pitch black, but you can see a faint light coming "
						+ "\nfrom the east of where you're standing. What do you want" + "\nto do?";
			}

		} else if (this.roomNum == room2) {

			if (inventory[0] == true) {
				description = "You are back at the bar... "
						+ "\nYou already picked up the torch and bottle that were " + "\non the counter.";

			} else {
				description = "You are in the bar." + "\nAs you scan the room, you can see a flashlight on the "
						+ "\ncounter next to a bottle of liquor. You're feeling thirsty, "
						+ "\nand the torch can also come in handy to navigate the "
						+ "\ndark. What would you like to do?";
			}

		} else if (this.roomNum == room3) { 

			if (inventory[4] == true) {
				description = "You are back in the kitchen..."
						+ "\nThe corpse of the monster you killed is laying there"
						+ "\nYou already collected" + "\nthe key you wanted.";
				
			} else if (enemy.getDeath() == true) {
				description = "You are back in the kitchen..."
						+ "The corpse of the monster you killed is laying there"
						+ "\nmotionless. You can see a glittering key behind it.";

			} else {
				description = "You are in the kitchen..." 
						+"\nA creature from across the room is"
						+ "\nlooking at you dangerously"
						+ "\nBehind it, you can see a glittering key.";
			} 

		} else if (this.roomNum == room4) { 
			description = "You are in the bedroom... " + "\nThere is a question on the door to the bathroom."
					+ "\nThe question must be answered correctly for you to "
					+ "\nget into the bathroom. The question on the door reads"
					+ "\n'What color is a ghost?";

		} else if (this.roomNum == room5) { 

			if (inventory[2] == true) {
				description = "You are in the bathroom..." + "\nThe window to the outside is in front of you,"
						+ "\nand it looks like it could be opened easily."
						+ "\nYou already picked up the pipe here. What do" + "\nyou want to do?";
			} else {
				description = "You are in the bathroom..." + "\nThe window to the outside is in front of you."
						+ "\nand it looks like it could be opened easily."
						+ "\nThere is a t pipe under the sink to " + "\nyour left. What do you want to do?";
			}

		} else if (this.roomNum == room6 && enemy.getDeath() == false) { 
			description = "You jumped out the bathroom window, "
					+ "\nthere's a shadowy figure blocking you from moving"
					+ "\nforward to the car you can see in the distance." + "\nWhat would you like to do?";
		}
		return description;
	} 

	
	public boolean[] lobby(String command, boolean[] inventory, Hero player) {
		
		boolean[] newInv = inventory; 
		
		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null)); 

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk east towards the light.");
			this.roomNum = 2; 

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("The entrance door is locked. You can't leave, but how" + "\ndid you get here?");

		} else if (command.equalsIgnoreCase("go west")) {
			if (newInv[0] == true) {
				if (newInv[4] == true) {
					System.out.println("You successfully unlocked the door to the hallway! You walk west."		
							+ "\then take a door which leads to the master bedroom.");
					this.roomNum = 4; 

				} else {
					System.out.println("The door to the hallway is locked. You need a key.");
				}

			} else if (newInv[0] == false) {
				System.out.println("It's too dark to see that far.");
			}

		} else if (command.equalsIgnoreCase("take") ) {
			
			if(newInv[0] == false) {
				System.out.println("You feel around for the keys but cannot find it in the dark.");
				
			} else if(newInv[0] == true && newInv[3] == true) {
				System.out.println("There is nothing to take.");
				
			} else {
				System.out.println("You take the keys.");
				newInv[3] = true; 
			} 

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == false) {
				System.out.println("You don't have anything to drink.");

			} else {
				System.out.println("You drink all of the bottle and You lose 1 health point!");
				player.damage(1); 
				newInv[1] = false; 
			}

		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You heal yourself by 1 point!");
				player.heal(); 
				newInv[1] = false; 
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("torch");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}

		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player); 

		} else {
			System.out.println("Please enter only commands from the command list.");
		}
		return newInv; 

	} 

	
	public boolean[] bar(String command, boolean[] inventory, Hero player) {
		
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null)); 

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk east into the kitchen.");
			this.roomNum = 3; 

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("You go west back to the lobby.");
			this.roomNum = 1; 

		} else if (command.equalsIgnoreCase("take")) {
			
			if(newInv[0] == true && newInv[1] == true) {
				System.out.println("There is nothing to take.");
				
			} else if(newInv[0] == true && newInv[1] == false) {
				System.out.println("There is nothing to take.");
				
			} else {
				System.out.println("You pick up the torch and the bottle of alcohol.");
				newInv[0] = true; 
				newInv[1] = true; 
			}

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the bottle You lost 1 health!");
				player.damage(1); 
				newInv[1] = false; 

			} else {
				System.out.println("You don't have anything to drink.");

			}
			
		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You heal yourself by 1 point!");
				player.heal(); 
				newInv[1] = false; 
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("torch");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else {
			System.out.println("Please enter only commands from the command list.");
		}

		return newInv; 
	}

	
	public boolean[] kitchen(String command, boolean[] inventory, Hero player, Villain enemy) {
		
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, enemy)); 

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("go east")) {

			if (enemy.getDeath() == false && newInv[1] == false) {
				System.out.println(
						"You attack without a weapon! the enemy tries to kill you");
				int pDamage = player.damage(enemy.attack());

				if (player.getDeath() == true) {
					System.out.println("You were killed! " + "\nBAD ENDING D:");
					
					this.roomNum = 0; 

				} else {
					System.out.println("\nYou Survived and You received "+ pDamage + " damage!");
					enemy.setDeath(true); 
					System.out.println("The enemy was killed!");

				}
				
			} else if (enemy.getDeath() == false && newInv[1] == true) {
				System.out.println("The monster is blocking your path.");

			} else {
				System.out.println("There is nowhere for you to go.");
			}

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("You go west back to the bar.");
			this.roomNum = 2; 

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the bottle and You lost 1 health!");
				player.damage(1);
				newInv[1] = false; 
				
			} else {
				System.out.println("You don't have anything to drink.");
			} 

		} else if (command.equalsIgnoreCase("take")) {
			
			if(newInv[4] == false && enemy.getDeath() == true) {
				System.out.println("You pick up the key.");
				newInv[4] = true; 
				
			} else if(newInv[4] == false && enemy.getDeath() == false) {
				System.out.println("You see a key on the floor behind your enemy. The" + "\nenemy will not let you pass!");
				
			} else {
				System.out.println("There is nothing to take.");
			}

		} else if (command.equalsIgnoreCase("attack")) {

			if (newInv[1] == true) {
				System.out.println(
						"You attack the enemy with the bottle, and it shatters!" + "\nThe enemy is killed!");
				enemy.setDeath(true);
				newInv[1] = false; 
			} else {
				System.out.println("Attack with what?");
			}

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");

			} else if (newInv[1] == true) {
				System.out.println("You heal yourself by 1 point!");
				player.heal(); 
				newInv[1] = false; 

			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("torch");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else {
			System.out.println("Please enter only commands from the command list.");
		}

		return newInv;
	} 

	
	public boolean[] Bedroom(String command, boolean[] inventory, Hero player) {
		
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null));

		} else if (command.equalsIgnoreCase("go north")) {
			System.out.println("You must answer the question first to enter the bathroom." + "\nWhat color is a ghost?");

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("You walk back into the hallway and to the lobby");
			this.roomNum = 1; 

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There's nothing in that direction.");

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the bottle and You lost 1 health!");
				player.damage(1); 
				newInv[1] = false; 

			} else {
				System.out.println("You don't have anything to" + "\ndrink.");
			}
			
		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You heal yourself by 1 point!");
				player.heal(); 
				newInv[1] = false; 
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}
			
		} else if (command.equalsIgnoreCase("take")) {
			System.out.println("There is nothing to take.");

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("white")) { 

			System.out.println("You hear a click, and the door opens. You pass through to the bathroom.");
			this.roomNum = 5; 

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("torch");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player); 

		} else {
			System.out.println("Incorrect answer and invalid command.");
		}

		return newInv;
	} 

	
	public boolean[] Bathroom(String command, boolean[] inventory, Hero player) {
		
		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, null)); 

		} else if (command.equalsIgnoreCase("go north")) {

			if (newInv[2] == false) {
				System.out.println("You raise the window and climb outside.");
				this.roomNum = 6; 
				
			} else {
				System.out.println("You smash the window open and you climb out" + "\nof the mansion.");
				this.roomNum = 6; 
			}

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("You walk back into the master bedroom.");
			this.roomNum = 4; 

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There is nowhere for you to go.");

		} else if (command.equalsIgnoreCase("take")) {
			
			if(newInv[2] == true) {
				System.out.println("There is nothing to take");
				
			} else {
				System.out.println("You pick up the pipe.");
				newInv[2] = true; 
			}

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the bottle You lost 1 health!");
				player.damage(1); 
				newInv[1] = false; 

			} else {
				System.out.println("You don't have anything to" + "\ndrink.");
			}

		} else if (command.equalsIgnoreCase("attack")) {

			System.out.println("Attack what?");

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");

			} else if (newInv[1] == true) {
				System.out.println("You heal yourself by 1 point!");
				player.heal(); 
				newInv[1] = false; 
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			} 

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("torch");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Faucet Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else {
			System.out.println("Please enter only commands from the command list.");
		} 

		return newInv;
	} 

	
	public boolean[] outside(String command, boolean[] inventory, Hero player, Villain enemy) {

		boolean[] newInv = inventory;

		command = command.trim();

		if (command.equalsIgnoreCase("look around")) {
			System.out.println(this.getRoomDescription(newInv, enemy)); 

		} else if (command.equalsIgnoreCase("go north")) {

			if (newInv[2] == false && enemy.getDeath() == false) {
				System.out.println("Without any weapon, you attack at the enemy.");
				int pDamage = player.damage(enemy.attack()); 
				
				if (player.getDeath() == true) {
					System.out.println("You were killed!");
				
					this.roomNum = 0; 

				} else {
					System.out.println("You Survived" + "\nYou received "
							+ pDamage + " damage!");
					int eDamage = enemy.damage(player.attack()); 
					
					if (enemy.getDeath() == true) {
						System.out.println("The enemy was killed!");
					} else {
						System.out.println("The enemy received only " + eDamage + " damage!");
						System.out.println(enemy); 
					}
				} 
			} else if (newInv[2] == true && enemy.getDeath() == false) {
				System.out.println("The shadow is blocking your path to your car.");

			} else if (enemy.getDeath() == true) {
				System.out.println("The shadow disappears and you are left" + "\nstanding in front of a car.");

				if (newInv[3] == true) {
					System.out.println("you got the car keys while you were still inside"
							+ "\nand drive away somewhere far from the mansion.");
					
					this.roomNum = 0; 

				} else {
					System.out.println("Although you are finally outside the mansion, you have no"
							+ "\nkeys to drive the car, and you're in the middle" + "\nof nowhere!");
				
					this.roomNum = 0; 
				} 
			}

		} else if (command.equalsIgnoreCase("go east")) {
			System.out.println("There is a fence you cannot climb.");

		} else if (command.equalsIgnoreCase("go south")) {
			System.out.println("glass prevents you from climbing back into the window.");

		} else if (command.equalsIgnoreCase("go west")) {
			System.out.println("There is a fence you cannot climb.");

		} else if (command.equalsIgnoreCase("drink")) {

			if (newInv[1] == true) {
				System.out.println("You drink all of the bottle and You lost 1 health!");
				player.damage(1);
				newInv[1] = false; 

			} else {
				System.out.println("You don't have anything to drink.");
			}

		} else if (command.equalsIgnoreCase("attack")) {

			if (newInv[2] == true) {
				System.out.println("You run at the villain and strike it with the pipe!");
				int eDamage = enemy.damage(player.attack()); 
				
				if (enemy.getDeath() == true) {
					System.out.println("You successfully defeated the villain!");
				} else {
					System.out.println("This enemy eceived only " + eDamage + " damage!");
					System.out.println(enemy); 
					System.out.println("It strikes you back!");
					int pDamage = player.damage(enemy.attack()); 
					
					if (player.getDeath() == true) {
						System.out.println("You were killed!");
					
						this.roomNum = 0; 

					} else {
						System.out.println("You were hit and received " + pDamage + " damage!");
					}
				}

			} else {
				System.out.println("Attack with what?");
			}

		} else if (command.equalsIgnoreCase("heal")) {

			if (player.getHealth() == 3) {
				System.out.println("Your health is already full.");
				
			} else if (newInv[1] == true) {
				System.out.println("You heal yourself by 1 point!");
				player.heal(); 
				newInv[1] = false; 
				
			} else {
				System.out.println("You have nothing to heal yourself with!");
			}

		} else if (command.equalsIgnoreCase("take")) {
			System.out.println("There is nothing to take.");

		} else if (command.equalsIgnoreCase("help")) {
			System.out.println("List of Commands:" + "\nlook around" + "\ngo north" + "\ngo east" + "\ngo west"
					+ "\ngo south" + "\ntake" + "\ndrink" + "\nheal" + "\nattack" + "\nview inventory" + "\nview health"
					+ "\nhelp");

		} else if (command.equalsIgnoreCase("view inventory")) {

			System.out.println("List of Items in Inventory:");
			if (newInv[0] == true) {
				System.out.println("torch");
			}
			if (newInv[1] == true) {
				System.out.println("Bottle");
			}
			if (newInv[2] == true) {
				System.out.println("Pipe");
			}
			if (newInv[3] == true) {
				System.out.println("Car Keys");
			}
			if (newInv[4] == true) {
				System.out.println("Hallway Keys");
			}
			
		} else if (command.equalsIgnoreCase("view health")) {
			System.out.println(player);

		} else if (command.equalsIgnoreCase("skip")) { 
			System.out.println("The shadow disappeared before you had to fight it.");
			enemy.setDeath(true); 

		} else {
			System.out.println("Please enter commands from the command list.");
		}

		return newInv; 
	} 

}