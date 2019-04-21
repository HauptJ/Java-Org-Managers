package organization;

import java.util.List;

class Manager {
	
	// Constants
	static int MANAGER_COST = 600;
	static int DEV_COST = 2000;
	static int QA_COST = 1000;
	
	List<Manager> subManagers;
	int developers;
	int qualityAssurance;
	int allocation;
	String name;

	
	public Manager(String name, List<Manager> submanagers, int devs, int qa) {
		this.name = name;
		this.subManagers = submanagers;
		if(devs < 0 || qa < 0) {
			System.out.println("ERROR: Manager " + name + " is invalid. Cannot have negative developers or QA");
			System.exit(1);
		}
		if(submanagers.contains(name)) {
			System.out.println("ERROR: Manager " + name + " is invalid. A submanager cannot be a submanager of itself");
			System.exit(1);
		}
		this.developers = devs;
		this.qualityAssurance = qa;
		this.allocation = 0;
	}
	
	
	public void SetManagerAllocation() {
		// check if all SubManagers Have been allocated
		if (subManagers.isEmpty() == false) {
			for (int i = 0; i < subManagers.size(); i++) {
				if (!(subManagers.get(i).allocation > 0)) {
					System.out.println("ERROR: Manager: " + subManagers.get(i).name + " sub-managers are not allocated");
					System.exit(1);
				}
			}
		}
		this.allocation = SubManagerAllocationSum(subManagers) + MANAGER_COST + developers * DEV_COST + qualityAssurance * QA_COST;	
	}
	
	
	public int SubManagerAllocationSum(List<Manager> subManagers) {
		int allocation = 0;
		
		for(int i = 0; i < subManagers.size(); i++) {
			allocation += subManagers.get(i).allocation;
		}
		return allocation;
	}
	

	public String GetManagerName() {
		return this.name;
	}
	
	
	public int GetManagerAllocation() {
		return this.allocation;
	}
}
