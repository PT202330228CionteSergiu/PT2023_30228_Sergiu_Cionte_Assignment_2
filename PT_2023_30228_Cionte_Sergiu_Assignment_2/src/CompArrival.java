import java.util.Comparator;

public class CompArrival implements Comparator<Client>{

	@Override
	public int compare(Client c1, Client c2) {
		// TODO Auto-generated method stub
		return c1.getArrivalTime()-c2.getArrivalTime();
	}
	
	
	
}