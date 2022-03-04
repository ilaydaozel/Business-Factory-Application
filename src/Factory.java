
public class Factory extends Facility {
	private StorageTank<Milk> milkStorageTank;
	private StorageTank<Cream> creamStorageTank;
	private StorageTank<Yeast> yeastStorageTank;
	private StorageTank<Cacao> cacaoStorageTank;
	private StorageArea<BoxedMilk> boxedMilkStorageArea;
	private StorageArea<Chocolate> chocolateStorageArea;
	private StorageArea<Yoghurt> yoghurtStorageArea;
	
	public Factory() {
		 milkStorageTank = new StorageTank<Milk>(new Milk());
		 creamStorageTank = new StorageTank<Cream>(new Cream());
		 yeastStorageTank = new StorageTank<Yeast>(new Yeast());
		 cacaoStorageTank = new StorageTank<Cacao>(new Cacao()) ;
		 boxedMilkStorageArea= new StorageArea<BoxedMilk>();
		 chocolateStorageArea= new StorageArea<Chocolate>();
		 yoghurtStorageArea= new StorageArea<Yoghurt>();
	}
	
	/**
	 * This method is used for removing ingredient from the storage area and transferring it to the dry storage container.
	 * According to the ingredient type parameter the operations will be made. 
	 * If the amount of the ingredient in the storage area is greater than container's capacity, removes ingredients from 
	 * the storage area as much as the container's capacity and adds it to the container. If the amount of the ingredient
	 * in the storage area is not greater than container's capacity, removes all the ingredients in the storage area and adds 
	 * it to the container. If the transfer is successful, returns 1 and if there wasn't any 
	 * ingredient in the storage area, returns -1.
	 * @param dSC    the dry storage container that will take the transfer
	 * @param ingredient    the ingredient type that will be transferred
	 * @return    returns 1 , if there is any ingredient in the storage tank and it is added to the container
	 *            returns -1, otherwise
	 */
	public int shipToDryStorage(DryStorageContainer<ICountable> dSC, String string) {
		int result = 0;
		if(string.equals("Boxed Milk")) {
			if (boxedMilkStorageArea.getNumberOfElements()>=1000) {
				for (int i =0;i <1000;i++) {
					BoxedMilk boxedMilk = boxedMilkStorageArea.remove();
					dSC.add(boxedMilk);
				}
				result = 1;
				System.out.println("1000 boxed milk is transfered from storage area to dry storage container.");
			}
			else if (boxedMilkStorageArea.getNumberOfElements()>0){
				int amount = boxedMilkStorageArea.getNumberOfElements();
				for (int i=0;i<amount;i++) {
					BoxedMilk boxedMilk = boxedMilkStorageArea.remove();
					dSC.add(boxedMilk);
				}
				result = 1;
				System.out.println(amount +" boxed milk are transfered from storage area to dry storage container.");
			}
			else {
				result = -1;
				System.out.println("There is no boxed milk to transfer.");
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
				System.out.println(amount +" chocolate are transfered from storage area to dry storage container.");
			}
			else {
				result = -1;
				System.out.println("There is no chocolate to transfer.");
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
				System.out.println(amount +" yoghurt are transfered from storage area to dry storage container.");
			}
			else {
				result = -1;
				System.out.println("There is no yoghurt to transfer");
			}
		}
		return result;
	}

	public int shipDryStorageContainer(DryStorageContainer<ICountable> dSC, String product) {
		int resume = 0;
		if (product.equals("Boxed Milk")) {
			int amount = boxedMilkStorageArea.getNumberOfElements();
			if (amount >= 1000) {
				for (int i =0;i<1000;i++) {
					ICountable boxedMilk = boxedMilkStorageArea.remove();
					dSC.add(boxedMilk);
				}
				resume = 1;
				System.out.println("1000 boxed milk are transfered from storage area to dry storage container.");
			}
			else if (amount >0){
				for (int i=0;i<amount;i++) {
					ICountable boxedMilk = boxedMilkStorageArea.remove();
					dSC.add(boxedMilk);
				}
				resume = 1;
				System.out.println(amount + " boxed milk are transfered from storage area to dry storage container.");
			}
			else {
				resume = -1;
				System.out.println("There is no boxed milk in the storage area.");
			}
		}
		else if (product.equals("Chocolate")) {
			int amount = chocolateStorageArea.getNumberOfElements();
			if (amount >= 1000) {
				for (int i =0;i<1000;i++) {
					ICountable chocolate = chocolateStorageArea.remove();
					dSC.add(chocolate);
				}
				resume = 1;
				System.out.println("1000 chocolate are transfered from storage area to dry storage container.");
			}
			else if (amount >0){
				for (int i=0;i<amount;i++) {
					ICountable chocolate = chocolateStorageArea.remove();
					dSC.add(chocolate);
				}
				resume = 1;
				System.out.println(amount + " chocolate are transfered from storage area to dry storage container.");
			}
			else {
				resume = -1;
				System.out.println("There is no chocolate in the storage area.");
			}
		}
		else if (product.equals("Yoghurt")) {
			int amount = yoghurtStorageArea.getNumberOfElements();
			if (amount >= 1000) {
				for (int i =0;i<1000;i++) {
					ICountable yoghurt = yoghurtStorageArea.remove();
					dSC.add(yoghurt);
				}
				resume =1;
				System.out.println("1000 yoghurt are transfered from storage area to dry storage container.");
			}
			else if (amount >0){
				for (int i=0;i<amount;i++) {
					ICountable yoghurt = yoghurtStorageArea.remove();
					dSC.add(yoghurt);
				}
				resume = 1;
				System.out.println(amount +  " yoghurt are transfered from storage area to dry storage container.");
			}
			else {
				resume = -1;
				System.out.println("There is no yoghurt in the storage area.");
			}
		}
		return resume;
	}
	

	
	/**
	 * This method is used for removing ingredient from the storage tank and transferring it to the open top container.
	 * According to the ingredient type parameter the operations will be made. 
	 * If the amount of the ingredient in the storage tank is greater than container's capacity, removes ingredients from 
	 * the storage tank as much as the container's capacity and adds it to the container. If the amount of the ingredient
	 * in the storage tank is not greater than container's capacity, removes all the ingredients in the storage tank and adds 
	 * it to the container. If the transfer is successful, returns 1 and if there wasn't any 
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
					result = 1;
					System.out.println("1000 liter of yeast are transfered from storage tank to open top container.");
				}
				else if (amount >0){
					Yeast yeast = (Yeast)yeastStorageTank.remove(amount);
					oTC.add(yeast);
					result = 1;
					System.out.println(amount +" liter of yeast are transfered from storage tank to open top container.");
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
				System.out.println("1000 liter of cacao are transfered from storage tank to open top container.");
			}
			else if (amount >0){
				Cacao cacao = (Cacao)cacaoStorageTank.remove(amount);
				oTC.add(cacao);
				result = 1;
				System.out.println(amount + " liter of cacao are transfered from storage tank to open top container.");
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
				System.out.println("1000 liter of milk are transfered from storage tank to tank container.");
			}
			else if (amount >0){
				Milk milk = (Milk)milkStorageTank.remove(amount);
				tC.add(milk);
				result = 1;
				System.out.println(amount + " liter of milk are transfered from storage tank to tank container.");
			}
			else {
				result = -1;
				System.out.println("There is no milk in the storage tank.");
			}
	}
	if (ingredient.equals("Cream")) {
		double amount = creamStorageTank.getUncountable().getAmount();
		if (amount >1000) {
			Cream cream = (Cream)creamStorageTank.remove(1000);
			tC.add(cream);
			result = 1;
			System.out.println("1000 liter of cream are transfered from storage tank to tank container.");
		}
		else if (amount >0){
			Cream cream = (Cream)creamStorageTank.remove(amount);
			tC.add(cream);
			result = 1;
			System.out.println(amount + " liter of cream are transfered from storage tank to tank container.");
		}
		else {
			result = -1;
			System.out.println("There is no cream in the storage tank.");
		}
	 }
	return result;
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
			if (!(ingredient ==null)) {
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
		if((milkStorageTank.haveEnoughTankCapacity(tC.findTankContainerIngredient("Milk"))) && (creamStorageTank.haveEnoughTankCapacity(tC.findTankContainerIngredient("Cream")))) {
			IUncountable ingredient=tC.remove();
			if (!(ingredient == null)) {
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
	 * This method is used for transferring the dry storage container's objects to the according storage area.
	 * If storage area have enough liters of capacity for the products of the dry storage container, transfer starts. 
	 * The product in the dry storage container is removed from the container. If dry storage container is not empty, according to the product type, the products in the container will be
	 * added to the according storage area.
	 * @param dSC the dry storage container whose products will be transfered to the storage area
	 */
	public void transferDryStorageProductsToStorageAreas(DryStorageContainer<ICountable> dSC) {
		int boxedMilk =0;
		int chocolate = 0;
		int yoghurt = 0;
		if((boxedMilkStorageArea.haveEnoughAreaCapacity(dSC.findDryStorageContainerIngredient("Boxed Milk")))&&(chocolateStorageArea.haveEnoughAreaCapacity(dSC.findDryStorageContainerIngredient("Chocolate")))&&(yoghurtStorageArea.haveEnoughAreaCapacity(dSC.findDryStorageContainerIngredient("Yoghurt")))) {
			for(int i=0; i<dSC.getNumberOfElements();i++) {
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
			System.out.println(boxedMilk + " boxed milk are transfered from dry storage container to storage areas.");
			System.out.println(chocolate + " chocolate are transfered from dry storage container to storage areas.");
			System.out.println(yoghurt + " yoghurt are transfered from dry storage container to storage areas.");
		}
		else {
			System.out.println("We don't have enough capacity!");
		}
	}

	/**
	 *  This method produces product, according to the product parameter
	 * @param product  the type of the product that will be produced
	 */
	public void produceProduct(String product) {
		if (product.equals("Boxed Milk")) {
			produceBoxedMilk();
		}
		else if (product.equals("Chocolate")) {
			produceChocolate();
		}
		else if (product.equals("Yoghurt")) {
			produceYoghurt();
		}
	}
	/**
	 * This method produces boxed milk, if there is enough milk in the storage tank and enough capacity in the boxed milk storage area. 
	 */
	private void produceBoxedMilk() {
		if((milkStorageTank.haveEnoughTankElements(1000)) && (boxedMilkStorageArea.haveEnoughAreaCapacity(1000))) {
			milkStorageTank.remove(1000);
			for(int i=0; i<1000; i++) {
				boxedMilkStorageArea.add(new BoxedMilk());
			}
			System.out.println("1000 Boxed Milk are produced");
		}
		else {
			System.out.println("Storage Tank does not have enough Milk to produce Boxed Milk or Storage Area does not have enough capacity to storage them.");
		}
	}
	/**
	 * This method produces chocolate, if there are enough milk ,enough cream and enough cacao in the storage tanks and there is enough capacity in the chocolate storage area. 
	 */
	private void produceChocolate() {
		if((milkStorageTank.haveEnoughTankElements(500)) && (creamStorageTank.haveEnoughTankElements(200)) && (cacaoStorageTank.haveEnoughTankElements(300)) && ((chocolateStorageArea.haveEnoughAreaCapacity(1600)))) {
			milkStorageTank.remove(500);
			creamStorageTank.remove(200);
			cacaoStorageTank.remove(300);
			for(int i=0; i<1600; i++) {
				chocolateStorageArea.add(new Chocolate());
			}
			System.out.println("1600 Chocolate are produced");
		}
		else {
			System.out.println("Storage Tank does not have enough ingredients to produce Chocolate or Storage Area does not have enough capacity to storage them.");
		}
	}
	
	/**
	 * This method produces yoghurt, if there are enough milk and enough yeast in the storage tanks and there is enough capacity in the yoghurt storage area. 
	 */
	private void produceYoghurt() {
		if((milkStorageTank.haveEnoughTankElements(1500)) && (yeastStorageTank.haveEnoughTankElements(100)) && (yoghurtStorageArea.haveEnoughAreaCapacity(700))) { 
			milkStorageTank.remove(1500);
			yeastStorageTank.remove(100);
			for(int i=0; i<700; i++) {
				yoghurtStorageArea.add(new Yoghurt());
			}
			System.out.println("700 Yoghurt are produced");
		}
		else {
			System.out.println("Storage Tank does not have enough ingredients to produce Yoghurt or Storage Area does not have enough capacity to storage them.");
		}
	}
	
	/**
	 * This is the show method which prints the number of ingredients in the storage tanks and the 
	 * number of products in the storage areas.
	 */
	public void show() {
		System.out.println("Milk Storage Tank has "+ milkStorageTank.getUncountable().getAmount()+ " liters of milk.");
		System.out.println("Cream Storage Tank has "+ creamStorageTank.getUncountable().getAmount()+ " liters of cream.");
		System.out.println("Yeast Storage Tank has "+ yeastStorageTank.getUncountable().getAmount()+ " liters of yeast.");
		System.out.println("Cacao Storage Tank has "+ cacaoStorageTank.getUncountable().getAmount()+ " liters of cacao.");
		System.out.println("Boxed Milk Storage Area has " + boxedMilkStorageArea.getNumberOfElements()+ " boxed milks.");
		System.out.println("Chocolate Storage Area has "+ chocolateStorageArea.getNumberOfElements()+ " chocolates.");
		System.out.println("Yoghurt Storage Area has " + yoghurtStorageArea.getNumberOfElements()+ " yoghurts.");
	}
	
}
