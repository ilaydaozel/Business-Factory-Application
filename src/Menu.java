import java.util.Scanner;

public class Menu {
	public static void show() {
		Scanner scan = new Scanner(System.in);
		Budget budget = new Budget();
		Factory factory = new Factory();
		Warehouse warehouse = new Warehouse();
		DistributionCenter distributionCenter = new DistributionCenter();
		DryStorageContainer<ICountable> dryStorageContainer = new DryStorageContainer<ICountable>(factory);
		OpenTopContainer<IUncountable> openTopContainer = new OpenTopContainer<IUncountable>(factory);
		TankContainer<IUncountable> tankContainer = new TankContainer<IUncountable>(factory);
		while (true) {
			System.out.println();
			System.out.println("To produce 1000 liters of boxed milk and 1000 boxed milk products: 1000 liters of milk is needed.");
			System.out.println("To produce 800 liters of chocolate and 1600 chocolate products: 500 liters of milk, 200 liters of cream and 300 liters of cacao are needed.");
			System.out.println("To produce 1400 liters of yoghurt and 700 yoghurt products: 1500 liters of milk and 100 liters of yeast are needed.");
			System.out.println();
			System.out.println("Enter 1 to buy ingredients in warehouse.");
			System.out.println("Enter 2 to transfer containers between facilities.");
			System.out.println("Enter 3 to produce products in factory.");
			System.out.println("Enter 4 to sell products in distribution center.");
			System.out.println("Enter 5 to see the products or ingredients in facilities.");
			System.out.println("Enter 0 to quit.");
			String choice =scan.nextLine();
			if(choice.equals("1")) {
				System.out.println("Which ingredient do you want to buy?");
				System.out.println("1) Milk");
				System.out.println("2) Cream");
				System.out.println("3) Cacao");
				System.out.println("4) Yeast");
	  			String ingredient = scan.nextLine();
	  			if (ingredient.equals("1") || ingredient.equals("2") || ingredient.equals("3") || ingredient.equals("4")) {
	  				System.out.println("How many liters do you want to buy?");
	  				String stringLiter = scan.nextLine();
	  				int liter = Integer.parseInt(stringLiter);
		  			if (ingredient.equals("1")) {
		  				warehouse.buyIngredients("Milk", budget, liter);
		  			}
		  			else if (ingredient.equals("2")) {
		  				warehouse.buyIngredients("Cream", budget, liter);
		  			}
		  			else if (ingredient.equals("3")) {
		  				warehouse.buyIngredients("Cacao", budget, liter);
		  			}
		  			else if (ingredient.equals("4")) {
		  				warehouse.buyIngredients("Yeast", budget, liter);
		  			}
	  			}
	  			else{
	  				System.out.println("In order to buy an ingredient; 1, 2, 3 or 4 should be written. Invalid input! ");
	  			}
				
			}
			else if (choice.equals("2")) {
				Transfer transfer = new Transfer();
				System.out.println("Which ingredient or product do you want to transfer?");
				System.out.println("1) Milk");
				System.out.println("2) Cream");
				System.out.println("3) Cacao");
				System.out.println("4) Yeast");
				System.out.println("5) Boxed Milk");
				System.out.println("6) Chocolate");
				System.out.println("7) Yoghurt");
				String transferedObject = scan.nextLine();
				if (transferedObject.equals("1")|| transferedObject.equals("2") || transferedObject.equals("3") || transferedObject.equals("4") ) {
					if (transferedObject.equals("1")) {
						transferedObject="Milk";
					}
					else if (transferedObject.equals("2")) {
						transferedObject = "Cream";
					}
					else if (transferedObject.equals("3")) {
						transferedObject = "Cacao";
					}
					else if (transferedObject.equals("4")) {
						transferedObject = "Yeast";
					}
					System.out.println("From which facility do you want to transfer?");
					System.out.println("1) From warehouse to factory");
					System.out.println("2) From factory to warehouse");
					String from =scan.nextLine();
					if (from.equals("1")) {
						from = "Warehouse";
						transfer.transferTo(transferedObject, from, budget, warehouse, factory, distributionCenter, tankContainer, openTopContainer, dryStorageContainer);	
					}
					else if (from.equals("2")) {
						from = "Factory";
						transfer.transferTo(transferedObject, from, budget, warehouse, factory, distributionCenter, tankContainer, openTopContainer, dryStorageContainer);	
					}
					else {
						System.out.println("In order to choose from which facility the ingredient will be transfered; 1 or 2 should be written. Invalid input!");
					}
	  			}

	  			else if (transferedObject.equals("5")||transferedObject.equals("6")|| transferedObject.equals("7")) {
	  				if (transferedObject.equals("5")) {
						transferedObject="Boxed Milk";
					}
					else if (transferedObject.equals("6")) {
						transferedObject = "Chocolate";
					}
					else if (transferedObject.equals("7")) {
						transferedObject = "Yoghurt";
					}
	  				System.out.println("From which facility do you want to transfer?");
					System.out.println("1) From factory to distribution center");
					System.out.println("2) From distribution center to factory");
					String from =scan.nextLine();
					if (from.equals("1")) {
						from = "Factory";
						transfer.transferTo(transferedObject, from, budget, warehouse, factory, distributionCenter, tankContainer, openTopContainer, dryStorageContainer);
					}
					else if (from.equals("2")) {
						from = "Distribution Center";
						transfer.transferTo(transferedObject, from, budget, warehouse, factory, distributionCenter, tankContainer, openTopContainer, dryStorageContainer);
					}
					else {
						System.out.println("In order to choose from which facility the product will be transfered; 1 or 2 should be written. Invalid input!");
					}
	  			}
	  			else{
	  				System.out.println("In order to choose a product or an ingredient; 1, 2, 3, 4, 5, 6, 7 should be written. Invalid input!");
	  			}
			}
			
			else if (choice.equals("3")) {
				System.out.println("What product do you want to produce?");
				System.out.println("1) Boxed Milk");
				System.out.println("2) Chocolate");
				System.out.println("3) Yoghurt");
				String product = scan.nextLine();
				if(product.equals("1")) {
					factory.produceProduct("Boxed Milk");
				}
				else if (product.equals("2")) {
					factory.produceProduct("Chocolate");
				}
				else if(product.equals("3")) {
					factory.produceProduct("Yoghurt");
				}
				else {
					System.out.println("In order to produce a product; 1, 2 or 3 should be written. Invalid input!");
				}
			}
			else if(choice.equals("4")) {
				System.out.println("What product do you want to sell?");
				System.out.println("1) Boxed Milk");
				System.out.println("2) Chocolate");
				System.out.println("3) Yoghurt");
				String soldProduct= scan.nextLine();
				System.out.println("How many products do you want to sell?");
				String StringAmount = scan.nextLine();
				int amount = Integer.parseInt(StringAmount);
				if(soldProduct.equals("1")) {
					distributionCenter.sellProducts("Boxed Milk", budget, amount);
				}
				else if (soldProduct.equals("2")) {
					distributionCenter.sellProducts("Chocolate", budget, amount);
				}
				else if(soldProduct.equals("3")) {
					distributionCenter.sellProducts("Yoghurt", budget, amount);
				}
				else {
					System.out.println("In order to sell a product; 1, 2 or 3 should be written. Invalid input!");
				}
				
			}
			else if (choice.equals("5")) {
				System.out.println("Which facility ingredients or products do you want to see?");
				System.out.println("1) Warehouse");
				System.out.println("2) Factory");
				System.out.println("3) Distribution Center");
				String facility = scan.nextLine();
				if (facility.equals("1")) {
					warehouse.show();
				}
				else if (facility.equals("2")) {
				    factory.show();
				}
				else if (facility.equals("3")) {
				    distributionCenter.show();
				}
				else {
					System.out.println("In order to see the number of products or ingredients in a facility; 1, 2 or 3 should be written. Invalid input!");
				}
			}
			else if (choice.equals("0")) {
				System.out.println("Quiting...");
				System.out.println("Done!");
				break;
			}
			else {
				System.out.println("In order to choose an operation; 1, 2, 3, 4 or 5 should be written. Choose 0 to exit the program. Invalid input!");
			}

		}
		scan.close();
	}
}

