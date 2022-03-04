
public class DistributionCenter extends Facility {
	private StorageArea<BoxedMilk> boxedMilkStorageArea;
	private StorageArea<Chocolate> chocolateStorageArea;
	private StorageArea<Yoghurt> yoghurtStorageArea;
	
	
	public DistributionCenter() {
		boxedMilkStorageArea= new StorageArea<BoxedMilk>();
		chocolateStorageArea= new StorageArea<Chocolate>();
	    yoghurtStorageArea= new StorageArea<Yoghurt>();
	}
	public DistributionCenter(int capacity) {
		this();
	}

	/**
	 * This method is used for selling products as much as the given amount.
	 * The operations will be made according to the product type.
	 * If storage are of the products have enough products, then the money in the budget
	 * is increased and products much as the amount will be removed from the product' storage area.
	 * @param product the product type that will be sold
	 * @param budget  the money
	 * @param amount  the amount of products that will be sold
	 */
	public void sellProducts(String product,Budget budget, int amount) {
		if(product.equals("Boxed Milk")) {
			if(boxedMilkStorageArea.haveEnoughAreaElements(amount)) {
				double gainedMoney = amount*1;
				budget.increaseMoneyBy(gainedMoney);
				for(int i=0; i<amount; i++) {
					boxedMilkStorageArea.remove();
				}
				System.out.println(amount + " boxed milks are sold.");
				budget.toString();
			}
			else {
				System.out.println("We don't have enough amount of boxed milk to sell, sorry!");
			}
			
		}
		else if(product.equals("Chocolate")) {
			if(chocolateStorageArea.haveEnoughAreaElements(amount)) {
				double gainedMoney = amount*4;
				budget.increaseMoneyBy(gainedMoney);
				for(int i=0; i<amount; i++) {
					chocolateStorageArea.remove();
				}
				System.out.println(amount +" chocolates are sold.");
				budget.toString();
			}
			else {
				System.out.println("We don't have enough amount of chocolate to sell, sorry!");
			}
		}
		else if (product.equals("Yoghurt")) {
			if(yoghurtStorageArea.haveEnoughAreaElements(amount)) {
				double gainedMoney=amount*2;
				budget.increaseMoneyBy(gainedMoney);
				for(int i=0; i<amount; i++) {
					yoghurtStorageArea.remove();
				}
				System.out.println(amount + " yoghurts are sold.");
				budget.toString();
			}
			else {
				System.out.println("We don't have enough amount of yoghurt to sell, sorry!");
			}
			
		}
	   else {
			System.out.println("We don't have the entered product to sell, first you have to produce it, sorry!");
		}
	}
	public int shipToDryStorage(DryStorageContainer<ICountable> dSC, String string) {
		int result = 0;
		if(string.equals("Boxed Milk")) {
			if (boxedMilkStorageArea.getNumberOfElements()>=1000) {
				for (int i =0;i <1000;i++) {
					BoxedMilk boxedMilk = boxedMilkStorageArea.remove();
					dSC.add(boxedMilk);
				}
				result =1;
				System.out.println("1000 boxed milk are transfered from storage area to dry storage container.");
			}
			else if (boxedMilkStorageArea.getNumberOfElements()>0) {
				int amount = boxedMilkStorageArea.getNumberOfElements();
				for (int i=0;i<amount;i++) {
					BoxedMilk boxedMilk = boxedMilkStorageArea.remove();
					dSC.add(boxedMilk);
				}
				result = 1;
				System.out.println(amount + " boxed milk are transfered from storage area to dry storage container.");
			}
			else {
				result = -1;
				System.out.println("There is no boxed milk in the boxed milk storage area.");
			}
		}
		if(string.equals("Chocolate")) {
			if (chocolateStorageArea.getNumberOfElements()>=1000) {
				for (int i =0;i <1000;i++) {
					Chocolate chocolate = chocolateStorageArea.remove();
					dSC.add(chocolate);
				}
				result = 1;
				System.out.println("1000 chocolate are transfered from storage area to dry storage container.");
			}
			else if (chocolateStorageArea.getNumberOfElements()>0) {
				int amount = chocolateStorageArea.getNumberOfElements();
				for (int i=0;i<amount;i++) {
					Chocolate chocolate = chocolateStorageArea.remove();
					dSC.add(chocolate);
				}
				result = 1;
				System.out.println(amount + " chocolate are transfered from storage area to dry storage container.");
			}
			else {
				result = -1;
				System.out.println("There is no chocolate in the storage area.");
			}
		}
		if(string.equals("Yoghurt")) {
			if (yoghurtStorageArea.getNumberOfElements()>=1000) {
				for (int i =0;i <1000;i++) {
					Yoghurt yoghurt = yoghurtStorageArea.remove();
					dSC.add(yoghurt);
				}
				result = 1;
				System.out.println("1000 yoghurt are transfered from storage area to dry storage container.");
			}
			else if (yoghurtStorageArea.getNumberOfElements()>0){
				int amount = yoghurtStorageArea.getNumberOfElements();
				for (int i=0;i<amount;i++) {
					Yoghurt yoghurt = yoghurtStorageArea.remove();
					dSC.add(yoghurt);
				}
				result = 1;
				System.out.println(amount + " yoghurt are transfered from storage area to dry storage container.");
			}
			else {
				result = -1;
				System.out.println("There is no yoghurt in the storage area.");
			}
		}
		return result;
	}
	/**
	 * This method is used for transferring the dry storage container's objects to the according storage area.
	 * If storage area have enough liters of capacity for the products of the dry storage container, transfer starts. 
	 * The product in the dry storage container is removed from the container. If dry storage container is not empty, according to the product type, the products in the container will be
	 * added to the according storage area.
	 * @param dSC the dry storage container whose products will be transfered to the storage area
	 */
	public void transferDryStorageProductsToStorageAreas(DryStorageContainer<ICountable> dSC) {
		int boxedMilk = 0;
		int chocolate = 0;
		int yoghurt = 0;
		if((boxedMilkStorageArea.haveEnoughAreaCapacity(dSC.findDryStorageContainerIngredient("Boxed Milk")))&&(chocolateStorageArea.haveEnoughAreaCapacity(dSC.findDryStorageContainerIngredient("Chocolate")))&&(yoghurtStorageArea.haveEnoughAreaCapacity(dSC.findDryStorageContainerIngredient("Yoghurt")))) {
			int numberOfElements = dSC.getNumberOfElements();
			for(int i=0; i<numberOfElements;i++) {
				ICountable product=dSC.remove();
				if(product.toString().equals("Boxed Milk")){
					boxedMilkStorageArea.add((BoxedMilk)product);
					boxedMilk++;
				}
				else if(product.toString().equals("Chocolate")){
					chocolateStorageArea.add((Chocolate)product);
					chocolate++;
				}
				else if(product.toString().equals("Yoghurt")){
					yoghurtStorageArea.add((Yoghurt)product);
					yoghurt++;
				}
			}
			System.out.println(boxedMilk +" boxed milks are transfered from dry storage container to storage area.");
			System.out.println(chocolate +" chocolates are transfered from dry storage container to storage area.");
			System.out.println(yoghurt +" yoghurts are transfered from dry storage container to storage area.");
		}
		else {
			System.out.println("There is no capacity in the storage area.");
		}
	}
	
	/**
	 * This is the show method which prints the number of products in the storage areas.
	 */
	public void show() {
		System.out.println("Boxed Milk Storage Area has " + boxedMilkStorageArea.getNumberOfElements()+ " boxed milks.");
		System.out.println("Chocolate Storage Area has "+ chocolateStorageArea.getNumberOfElements()+ " chocolates.");
		System.out.println("Yoghurt Storage Area has " + yoghurtStorageArea.getNumberOfElements()+ " yoghurts.");
	}
}
