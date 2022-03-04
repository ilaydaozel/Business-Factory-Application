
public class Transfer {
	private boolean firstTimeOpenTop;
	private boolean firstTimeTank;
	public boolean getFirstTimeOpenTop() {
		return firstTimeOpenTop;
	}
	public void setFirstTimeOpenTop(boolean firstTimeOpenTop) {
		this.firstTimeOpenTop = firstTimeOpenTop;
	}
	public boolean getFirstTimeTank() {
		return firstTimeTank;
	}
	public void setFirstTimeTank(boolean firstTimeTank) {
		this.firstTimeTank = firstTimeTank;
	}
	public Transfer(){
		firstTimeOpenTop = true;
		firstTimeTank = true;
	}
	/**
	 * This method is a summed transfer method for all the products and ingredients.
	 * If an ingredient will be transfered, there are two transfer options: factory or warehouse. 
	 * If an product will be transfered, there are two transfer options: factory or distribution center.
	 * When tank container, dry storage container and open top container are being created, first they are created in factory.
	 * Containers are sent from the given from parameter facility to the other facility. When tank and open top containers are first sent from factory to another facilitiy
	 * firstTimetank  and firsttimeopentop will be set to false.  Then, if the shipping is successful, resume will be 1  and
	 * the operations will continue. Containers will be sent to the goal facility and ingredients or products will
	 * be transfered to the storageareas or storagetanks then the containers will be shipped back to their initial
	 * facilities'.
	 * 
	 * @param transferedObject the object type that will be transfered
	 * @param from  the initial facility of the transfered object
	 * @param budget  the money
	 * @param warehouse  the warehouse object
	 * @param factory  the factory object
	 * @param distributionCenter the distribution center object
	 * @param tankContainer  the tank container object
	 * @param openTopContainer  the open top container object
	 * @param dryStorageContainer the dry storage object
	 */
	public void transferTo(String transferedObject, String from, Budget budget, Warehouse warehouse, Factory factory, DistributionCenter distributionCenter, TankContainer<IUncountable> tankContainer,OpenTopContainer<IUncountable> openTopContainer, DryStorageContainer<ICountable> dryStorageContainer) {
		if(transferedObject.equals("Milk")) {
			if(from.equals("Warehouse")) {
				if (getFirstTimeTank()) {
					tankContainer.transferToW(warehouse, budget);
					setFirstTimeTank(false);
				}
				int resume = warehouse.shipTankContainer(tankContainer, transferedObject);
				if (resume ==1) {
					tankContainer.transferToF(factory, budget);
					factory.transferTankIngredientsToStorageTanks(tankContainer);
					tankContainer.transferToW(warehouse, budget);
					System.out.println("Last Situation: Milk is transfered from warehouse to factory.");
				}	
			}
			else if(from.equals("Factory")) {
				if (!getFirstTimeTank()) {
					tankContainer.transferToF(factory, budget);
					setFirstTimeOpenTop(false);
				}
				int resume = factory.shipTankContainer(tankContainer, transferedObject);
				if (resume ==1) {
					tankContainer.transferToW(warehouse, budget);
					warehouse.transferTankIngredientsToStorageTanks(tankContainer);
					System.out.println("Last Situation: Milk is transfered from factory to warehouse.");
				}
			}
		}
		else if(transferedObject.equals("Cream")) {
			if(from.equals("Warehouse")) {
				if (getFirstTimeTank()) {
					tankContainer.transferToW(warehouse, budget);
					setFirstTimeTank(false);
				}
				int resume = warehouse.shipTankContainer(tankContainer, transferedObject);
				if (resume==1) {
					tankContainer.transferToF(factory, budget);
					factory.transferTankIngredientsToStorageTanks(tankContainer);
					tankContainer.transferToW(warehouse, budget);
					System.out.println("Last Situation: Cream is transfered from warehouse to factory.");
				}
			}
			else if(from.equals("Factory")) {
				if (!getFirstTimeTank()) {
					tankContainer.transferToF(factory, budget);
					setFirstTimeOpenTop(false);
				}
				int resume = factory.shipTankContainer(tankContainer, transferedObject);
				if (resume==1) {
					tankContainer.transferToW(warehouse, budget);
					warehouse.transferTankIngredientsToStorageTanks(tankContainer);
					System.out.println("Last Situation: Cream is transfered from factory to warehouse.");
				}
			}
		}
		else if (transferedObject.equals("Cacao")) {
			if (from.equals("Warehouse")) {
				if (getFirstTimeOpenTop()) {
					openTopContainer.transferToW(warehouse, budget);
					setFirstTimeOpenTop(false);
				}
				int resume = warehouse.shipOpenTopContainer(openTopContainer, transferedObject);
				if (resume ==1) {
					openTopContainer.transferToF(factory, budget);
					factory.transferOpenTopIngredientsToStorageTanks(openTopContainer);
					openTopContainer.transferToW(warehouse, budget);
					System.out.println("Last Situation: Cacao is transfered from warehouse to factory.");
				}
			}
			else if(from.equals("Factory")) {
				if (!getFirstTimeOpenTop()) {
					openTopContainer.transferToF(factory, budget);
					setFirstTimeOpenTop(false);
				}
				int resume =factory.shipOpenTopContainer(openTopContainer, transferedObject);
				if (resume ==1) {
					openTopContainer.transferToW(warehouse, budget);
					warehouse.transferOpenTopIngredientsToStorageTanks(openTopContainer);
					System.out.println("Last Situation: Cacao is transfered from factory to warehouse.");
				}
			}
		}
		else if (transferedObject.equals("Yeast")) {
			if (from.equals("Warehouse")) {
				if (getFirstTimeOpenTop()) {
					openTopContainer.transferToW(warehouse, budget);
					setFirstTimeOpenTop(false);
				}
				int resume= warehouse.shipOpenTopContainer(openTopContainer, transferedObject);
				if (resume ==1) {
					openTopContainer.transferToF(factory, budget);
					factory.transferOpenTopIngredientsToStorageTanks(openTopContainer);
					openTopContainer.transferToW(warehouse, budget);
					System.out.println("Last Situation: Yeast is transfered from warehouse to factory.");
				}
			}
			else if(from.equals("Factory")) {
				if (!getFirstTimeOpenTop()) {
					openTopContainer.transferToF(factory, budget);
					setFirstTimeOpenTop(false);
				}
				int resume = factory.shipOpenTopContainer(openTopContainer, transferedObject);
				if (resume ==1) {
					openTopContainer.transferToW(warehouse, budget);
					warehouse.transferOpenTopIngredientsToStorageTanks(openTopContainer);
					System.out.println("Last Situation: Yeast is transfered from factory to warehouse");
				}
			}
		}
		else if (transferedObject.equals("Boxed Milk")) {
			if(from.equals("Factory")) {
				int resume = factory.shipDryStorageContainer(dryStorageContainer, transferedObject);
				if (resume ==1) {
					dryStorageContainer.transferToDC(distributionCenter, budget);
					distributionCenter.transferDryStorageProductsToStorageAreas(dryStorageContainer);
					dryStorageContainer.transferToF(factory, budget);
					System.out.println("Last Situation: Boxed milk is transfered from factory to distribution center.");
				}
			}
			else if(from.equals("Distribution Center")) {
				dryStorageContainer.transferToDC(distributionCenter, budget);
				int resume = distributionCenter.shipToDryStorage(dryStorageContainer, transferedObject);
				if (resume ==1) {
					dryStorageContainer.transferToF(factory, budget);
					factory.transferDryStorageProductsToStorageAreas(dryStorageContainer);
					System.out.println("Last Situation: Boxed milk is transfered from distribution center to factory.");
				}
			}
		}
		else if (transferedObject.equals("Chocolate")) {
			if(from.equals("Factory")) {
				dryStorageContainer.transferToF(factory, budget);
				int resume = factory.shipDryStorageContainer(dryStorageContainer, transferedObject);
				if (resume ==1) {
					dryStorageContainer.transferToDC(distributionCenter, budget);
					distributionCenter.transferDryStorageProductsToStorageAreas(dryStorageContainer);
					dryStorageContainer.transferToF(factory, budget);
					System.out.println("Last Situation: Chocolate is transfered from factory to distribution center.");
				}
			}
			else if(from.equals("Distribution Center")) {
				dryStorageContainer.transferToDC(distributionCenter, budget);
				int resume = distributionCenter.shipToDryStorage(dryStorageContainer, transferedObject);
				if (resume ==1) {
					dryStorageContainer.transferToF(factory, budget);
					factory.transferDryStorageProductsToStorageAreas(dryStorageContainer);
					System.out.println("Last Situation: Chocolate is transfered from distribution center to factory.");
				}	
			}
		}
		else if (transferedObject.equals("Yoghurt")) {
			if(from.equals("Factory")) {
				dryStorageContainer.transferToF(factory, budget);
				int resume = factory.shipDryStorageContainer(dryStorageContainer, transferedObject);
				if (resume ==1) {
					dryStorageContainer.transferToDC(distributionCenter, budget);
					distributionCenter.transferDryStorageProductsToStorageAreas(dryStorageContainer);
					dryStorageContainer.transferToF(factory, budget);
					System.out.println("Last Situation: Yoghurt is transfered from factory to distribution center.");
				}
			}
			else if(from.equals("Distribution Center")) {
				dryStorageContainer.transferToDC(distributionCenter, budget);
				int resume = distributionCenter.shipToDryStorage(dryStorageContainer, transferedObject);
				if (resume ==1) {
					dryStorageContainer.transferToF(factory, budget);
					factory.transferDryStorageProductsToStorageAreas(dryStorageContainer);
					System.out.println("Last Situation: Yoghurt is transfered from distribution center to factory.");
				}
			}
		}
	}

}
