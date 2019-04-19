package organization;

import java.util.List;

class Manager {
	
	// Constants
	static int MANAGER_COST = 600;
	static int DEV_COST = 2000;
	static int QA_COST = 800;
	
	List<Manager> subManagers;
	int developers;
	int qualityAssurance;
	int allocation;
	String name;

	public Manager(String name, List<Manager> submanagers, int devs, int qa) {
		this.name = name;
		// TODO check if manager is a submanager
		this.subManagers = submanagers;
		this.developers = devs;
		this.qualityAssurance = qa;
	}
	
	public void SetManagerAllocation() {
		// TODO check if all SubManagers Have been allocated
		this.allocation = SubManagerAllocationSum() + MANAGER_COST + developers * DEV_COST + qualityAssurance * QA_COST;
	}
	
	public int GetManagerAllocation() {
		return this.allocation;
	}
	
	public int SubManagerAllocationSum() {
		int allocation = 0;
		
		for(int i = 0; i < subManagers.size(); i++) {
			allocation += subManagers.get(i).allocation;
		}
		return allocation;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
