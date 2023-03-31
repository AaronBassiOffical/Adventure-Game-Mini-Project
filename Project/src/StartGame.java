import java.util.Scanner;


public class StartGame {

	public static void main(String[] args) {

	
		
		System.out.println("Welcome to Haunted Mansion Escape");


		Scanner scanner = new Scanner(System.in); 
		String input1 = "";
		do {
			System.out.print("\nType Y to start a New Game or N to End the Game: ");
			input1 = scanner.next();
		} while (!input1.equalsIgnoreCase("y") && !input1.equalsIgnoreCase("n")); 

		if (input1.equalsIgnoreCase("n")) {
			System.out.println("Exiting...");
			System.exit(0);
		} 
		System.out.println("New Game Selected!");
		BeginJourney adventure = new BeginJourney(); 

		Hero player = new Hero(); 
		System.out.print("Enter Player name: ");
		String name = scanner.next();
		player.setName(name);
		

	
		do {
			System.out.println("\nNEW GAME STARTED");
			String input2 = "";
			int roomNum = 1;
			adventure.setRoomNumber(roomNum); 
			boolean torch = false;
			boolean bottle = false;
			boolean pipe = false;
			boolean keyCar = false;
			boolean keyHall = false;
			boolean[] inventory = { torch, bottle, pipe, keyCar, keyHall };
			player.setInventory(inventory); 
			Villain enemy1 = new Villain();
			Villain enemy2 = new Villain();

			do {
				if (adventure.getRoomNumber() == 1) {
					System.out.println(adventure.getRoomDescription(player.getInventory(), null)); 
					do {
						input2 = scanner.nextLine();
						inventory = adventure.lobby(input2, player.getInventory(), player); 
						player.setInventory(inventory); 
					} while (adventure.getRoomNumber() == 1); 
				}

				if (adventure.getRoomNumber() == 2) {
					System.out.println(adventure.getRoomDescription(player.getInventory(), null)); 
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						input2 = scanner.nextLine();
						inventory = adventure.bar(input2, player.getInventory(), player);
						player.setInventory(inventory); 
					} while (adventure.getRoomNumber() == 2);
				}

				if (adventure.getRoomNumber() == 3) {
					System.out.println(adventure.getRoomDescription(player.getInventory(), enemy1)); 
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						input2 = scanner.nextLine();
						inventory = adventure.kitchen(input2, player.getInventory(), player, enemy1); 
						player.setInventory(inventory); 
					} while (adventure.getRoomNumber() == 3);
				}

				if (adventure.getRoomNumber() == 4) {
					System.out.println(adventure.getRoomDescription(player.getInventory(), null));
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						input2 = scanner.nextLine();
						inventory = adventure.Bedroom(input2, player.getInventory(), player); 
						player.setInventory(inventory); 
					} while (adventure.getRoomNumber() == 4);
				}

				if (adventure.getRoomNumber() == 5) {
					System.out.println(adventure.getRoomDescription(player.getInventory(), null)); 
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						input2 = scanner.nextLine();
						inventory = adventure.Bathroom(input2, player.getInventory(), player); 
						player.setInventory(inventory); 
					} while (adventure.getRoomNumber() == 5);
				}

				if (adventure.getRoomNumber() == 6) {
					System.out.println(adventure.getRoomDescription(player.getInventory(), enemy2)); 
					System.out.print("Type 'help' for a list of commands.\n");
					do {
						input2 = scanner.nextLine();
						inventory = adventure.outside(input2, player.getInventory(), player, enemy2);
						player.setInventory(inventory); 
					} while (adventure.getRoomNumber() == 6);
				}

			} while (adventure.getRoomNumber() != 0); 

				do {
					System.out.print("Game Over. Type Y to Play Again or N to Exit: ");
					input2 = scanner.next();
				} while (!input2.equalsIgnoreCase("y") && !input2.equalsIgnoreCase("n"));
				if (input2.equalsIgnoreCase("n")) {
					System.out.println("Exiting...");
					System.out.println("Game Exited!");
					System.exit(0);
				}
			
		} while (input1.equalsIgnoreCase("y")); 
		
		System.out.println("Exiting...");
		System.out.println("Game Exited!");
		System.exit(0); 

	}
	
}