package Manager;

public class Manager {
	
	Manager[] subManagers;
	int developers;
	int qualityAssurance;

	public Manager(Manager[] submanagers, int devs, int qa) {
		this.subManagers = submanagers;
		this.developers = devs;
		this.qualityAssurance = qa;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
