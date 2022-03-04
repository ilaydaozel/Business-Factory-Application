

public class Warehouse extends Facility {
	private StorageTank<Milk> milkStorageTank;
	private StorageTank<Cream> creamStorageTank;
	private StorageTank<Yeast> yeastStorageTank;
	private StorageTank<Cacao> cacaoStorageTank;
	
	public Warehouse() {
		 milkStorageTank = new StorageTank<Milk>(new Milk());
		 creamStorageTank = new StorageTank<Cream>(new Cream());
		 yeastStorageTank = new StorageTank<Yeast>(new Yeast());
		 cacaoStorageTank = new StorageTank<Cacao>(new Cacao()) ;
	}
	public Warehouse(int capacity) {
		this();
	}
	
	/**
	 * This method is used for buying a given ingredient as much as the given amount.
	 * The operations will be made according to the ingredient type. 
	 * Calculates the cost and checks if there is enough money in the budget. If there is, ads the ingredient to the
	 * storage tank and decreases the cost from the budget.
	 * 
	 * @param ing  the ingredient type that is bought
	 * @param budget the money
	 * @param liter the amount of ingredient that is bought
	 */
	public void buyIngredients(String ing,Budget budget,double liter) {
		if (ing.equals("Milk")) {
			double costedMoney = liter*(0.25);
			if (budget.haveEnoughMoney(costedMoney)) {
				IUncountable milk = new Milk(liter);
				milkStorageTank.add((Milk)milk);
				budget.decreaseMoneyBy(costedMoney);
				System.out.println(liter +" liter milk is bought.");
				budget.toString();
		    }
			else {
				System.out.println("Your money isn't enough,try again!");
			}
			
		}
		else if (ing.equals("Cream")) {
			double costedMoney=liter*(0.30);
			if (budget.haveEnoughMoney(costedMoney)) {
				IUncountable cream = new Cream(liter);
				creamStorageTank.add((Cream)cream);
				budget.decreaseMoneyBy(costedMoney);
				System.out.println(liter + " liter cream is bought.");
				budget.toString();
			}
			else {
				System.out.println("Your money isn't enough,try again!");
			}
			
		}
		else if (ing.equals("Yeast")) {
			double costedMoney=liter*(5);
			if (budget.haveEnoughMoney(costedMoney)) {
				IUncountable yeast = new Yeast(liter);
				yeastStorageTank.add((Yeast)yeast);
				budget.decreaseMoneyBy(costedMoney);
				System.out.println(liter +" liter yeast is bought.");
				budget.toString();
			}
			else {
				System.out.println("Your money isn't enough,try again!");
			}
		}
		else if (ing.equals("Cacao")) {
			double costedMoney=liter*(1);
			if (budget.haveEnoughMoney(costedMoney)) {
				IUncountable cacao = new Cacao(liter);
				cacaoStorageTank.add((Cacao)cacao);
				budget.decreaseMoneyBy(costedMoney);
				System.out.println(liter + " liter cacao is bought.");
				budget.toString();
			}
			else {
				System.out.println("Your money isn't enough,try again!");
			}
		}
		else {
			System.out.println("We are full of of capacity for this storage tank, first transfer some ingredients to factory, sorry!");
		}
	}
	
	/**
	 * This method is used for transferring the open top container's objects to the according storage tank.
	 * If storage tanks have enough liters of capacity for the ingredients of the open top container, transfer starts. 
	 * The ingredient in the open top container is removed from the container. If open top container is not empty, according to the ingredient type, the ingredients in the open top container
	 * will be added to the according storage tank.
	 * @param oTC the open top container whose ingredients will be transfered to the storage tank
	 */
	public void transferOpenTopIngredientsToStorageTanks(OpenTopContainer<IUncountable> oTC) {
		if((yeastStorageTank.haveEnoughTankCapacity(oTC.findOpenTopContainerIngredient("Yeast")) && (cacaoStorageTank.haveEnoughTankCapacity(oTC.findOpenTopContainerIngredient("Cacao"))))) {
			IUncountable ingredient=oTC.remove();
			if (!(ingredient==null)) {
				if(ingredient.toString().equals("Yeast")){
					yeastStorageTank.add((Yeast)ingredient);
					System.out.println("Yeast is transfered from open top container to storage tank.");
				}
				else if(ingredient.toString().equals("Cacao")){
					cacaoStorageTank.add((Cacao)ingredient);
					System.out.println("Cacao is transfered from open top container to storage tank.");
				}	
			}
			else {
				System.out.println("Open Top Container is empty!");
			}
			
		}
		else {
			System.out.println("We don't have enough capacity in storage tanks to transfer the ingredients.");
		}
	}
	
	/**
	 * This method is used for transferring the tank container's objects to the according storage tank.
	 * If storage tanks have enough liters of capacity for the ingredients of the tank container, transfer starts. 
	 * The ingredient in the tank container is removed from the container. If tank container is not empty, according to the ingredient type, the ingredients in the tank container will be
	 * added to the according storage tank.
	 * @param tC the tank container whose ingredients will be transfered to the storage tank
	 */
	public void transferTankIngredientsToStorageTanks(TankContainer<IUncountable> tC) {
		if((milkStorageTank.haveEnoughTankCapacity(tC.findTankContainerIngredient("Milk")) && (creamStorageTank.haveEnoughTankCapacity(tC.findTankContainerIngredient("Cream"))))) {
			IUncountable ingredient=tC.remove();
			if (!(ingredient==null)) {
				if(ingredient.toString().equals("Milk")){
					milkStorageTank.add((Milk)ingredient);
					System.out.println("Milk is transfered from tank container to storage tank.");
				}
				else if(ingredient.toString().equals("Cream")){
					creamStorageTank.add((Cream)ingredient);
					System.out.println("Cream is transfered from tank container to storage tank.");
				}	
			}
			else {
				System.out.println("Tank Container is empty!");
			}
			
		}
		else {
			System.out.println("We don't have enough capacity in storage tanks to transfer the ingredients.");
		}
	}
	/**
	 * This method is used for removing ingredient from the storage tank and transferring it to the open top container.
	 * According to the ingredient type parameter the operations will be made. 
	 * If the amount of the ingredient in the storage tank is greater than container's capacity, removes ingredients from 
	 * the storage tank as much as the container's capacity and adds it to the container. If the amount of the ingredient
	 * in the storage tank is not greater than container's capacity, removes all the ingredients in the storage tank and adds 
	 * it to the container.If the transfer is successful, returns 1 and if there wasn't any 
	 * ingredient in the storage tank, returns -1.
	 * @param oTC   the open top container that will take the transfer
	 * @param ingredient    the ingredient type that will be transferred
	 * @return    returns 1 , if there is any ingredient in the storage tank and it is added to the container
	 *            returns -1, otherwise
	 */
	public int shipOpenTopContainer(OpenTopContainer<IUncountable> oTC,String ingredient) {
		int result = 0;
		if (ingredient.equals("Yeast")) {
				double amount = yeastStorageTank.getUncountable().getAmount();
				if (amount >1000) {
					Yeast yeast = (Yeast)yeastStorageTank.remove(1000);
					oTC.add(yeast);
					result =1;
					System.out.println("1000 liter of yeast is transfered from storage tank to open top container.");
				}
				else if (amount >0){
					Yeast yeast = (Yeast)yeastStorageTank.remove(amount);
					oTC.add(yeast);
					result = 1;
					System.out.println(amount +" liter of yeast is transfered from storage tank to open top container.");
				}
				else {
					result = -1;
					System.out.println("There is no yeast in the storage tank.");
				}
		}
		if (ingredient.equals("Cacao")) {
			double amount = cacaoStorageTank.getUncountable().getAmount();
			if (amount >1000) {
				Cacao cacao = (Cacao)cacaoStorageTank.remove(1000);
				oTC.add(cacao);
				result = 1;
				System.out.println("1000 liter of cacao is transfered from storage tank to open top container.");
			}
			else if (amount >0){
				Cacao cacao = (Cacao)cacaoStorageTank.remove(amount);
				oTC.add(cacao);
				result = 1;
				System.out.println(amount + " liter of cacao is transfered from storage tank to open top container.");
			}
			else {
				result = -1;
				System.out.println("There is no cacao in the storage tank.");
			}
		}
		return result;
	}
	/**
	 * This method is used for removing ingredient from the storage tank and transferring it to the tank container.
	 * According to the ingredient type parameter the operations will be made. 
	 * If the amount of the ingredient in the storage tank is greater than container's capacity, removes ingredients from 
	 * the storage tank as much as the container's capacity and adds it to the container. If the amount of the ingredient
	 * in the storage tank is not greater than container's capacity, removes all the ingredients in the storage tank and adds 
	 * it to the container. If the transfer is successful, returns 1 and if there wasn't any 
	 * ingredient in the storage tank, returns -1.
	 * @param tC   the tank container that will take the transfer
	 * @param ingredient    the ingredient type that will be transferred
	 * @return    returns 1 , if there is any ingredient in the storage tank and it is added to the container
	 *            returns -1, otherwise
	 */
	public int shipTankContainer(TankContainer<IUncountable> tC,String ingredient) {
		int result = 0;
		if (ingredient.equals("Milk")) {
			double amount = milkStorageTank.getUncountable().getAmount();
			if (amount >1000) {
				Milk milk = (Milk)milkStorageTank.remove(1000);
				tC.add(milk);
				result = 1;
				System.out.println("1000 liter of milk is transfered from storage tank to tank container.");
			}
			else if (amount>0) {
				Milk milk = (Milk)milkStorageTank.remove(amount);
				tC.add(milk);
				System.out.println(amount + " liter of milk is transfered from storage tank to tank container.");
				result = 1;
			}
			else {
				System.out.println("There is no milk in the storage tank.");
				result = -1;
			}
	}
	if (ingredient.equals("Cream")) {
		double amount = creamStorageTank.getUncountable().getAmount();
		if (amount >1000) {
			Cream cream = (Cream)creamStorageTank.remove(1000);
			tC.add(cream);
			result = 1;
			System.out.println("1000 liter of cream is transfered from storage tank to tank container.");
		}
		else if (amount>0){
			Cream cream = (Cream)creamStorageTank.remove(amount);
			tC.add(cream);
			result = 1;
			System.out.println(amount + " liter of cream is transfered from storage tank to tank container.");
		}
		else {
			System.out.println("There is no cream in the storage tank");
			result = -1;
		}
	}
	return result;
  }
	/**
	 * This is the show method which prints the number of ingredients in the storage tanks.
	 */
	public void show() {
		System.out.println("Milk Storage Tank has "+ milkStorageTank.getUncountable().getAmount()+ " liters of milk.");
		System.out.println("Cream Storage Tank has "+ creamStorageTank.getUncountable().getAmount()+ " liters of cream.");
		System.out.println("Yeast Storage Tank has "+ yeastStorageTank.getUncountable().getAmount()+ " liters of yeast.");
		System.out.println("Cacao Storage Tank has "+ cacaoStorageTank.getUncountable().getAmount()+ " liters of cacao.");
	}
}
