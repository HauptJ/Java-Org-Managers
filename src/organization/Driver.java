package organization;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	// Constants
	static int MANAGER_ALLOC=600;

	public static void main(String[] args) {
		
		List<Manager> NoSubManagers = new ArrayList();
		
		Manager managerB = new Manager("B", NoSubManagers, 1, 1);
		managerB.SetManagerAllocation();
		
		Manager managerD = new Manager("D", NoSubManagers, 0, 0);
		managerD.SetManagerAllocation();
		
		Manager managerE = new Manager("E", NoSubManagers, 1, 0);
		managerE.SetManagerAllocation();
		
		List<Manager> managerCSubs = new ArrayList();
		managerCSubs.add(managerD);
		Manager managerC = new Manager("C", managerCSubs, 0, 0); 
		managerC.SetManagerAllocation();
		
		List<Manager> managerASubs = new ArrayList();
		managerASubs.add(managerB);
		Manager managerA = new Manager("A", managerASubs, 0, 0); 
		managerA.SetManagerAllocation();
		
		List<Manager> managerFSubs = new ArrayList();
		managerFSubs.add(managerA);
		Manager managerF = new Manager("F", managerFSubs, 1, 0); 
		managerF.SetManagerAllocation();
		

		List<Manager> managerList = new ArrayList();
		managerList.add(managerA);
		managerList.add(managerB);
		managerList.add(managerC);
		managerList.add(managerD);
		managerList.add(managerE);
		
		
		printReport(managerList);

	}
	
	public static void printReport(List<Manager> managerList) {
		
		int dept_allocation = 0;
		
		for(int i = 0; i < managerList.size(); i++) {
			if(managerList.get(i).allocation == MANAGER_ALLOC) {
				System.out.println("Manager " + managerList.get(i).GetManagerName() + " has no one reporting to them");
			}
			dept_allocation += managerList.get(i).allocation;
			System.out.println("Manager " + managerList.get(i).GetManagerName() + " Allocation should be: $" +  managerList.get(i).GetManagerAllocation());
		}
		System.out.println("The Department's Allocation should be: $" + dept_allocation);
	}

}
