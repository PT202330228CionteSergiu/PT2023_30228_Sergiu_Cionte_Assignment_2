import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	
	private List<Server>servere;
	//private int noServers;
	private Strategy strategie;
	public Scheduler(int noServers) {
		
		servere=new ArrayList<Server>();
		for(int i=0;i<noServers;i++) {
			Server serv=new Server();
			servere.add(serv);
			Thread th=new Thread(serv);
			th.start();
			
		}
	}
	
	public void selectStrategy(SelectionPolicy policy) {
		if(policy==SelectionPolicy.SHORTEST_TIME) {
			strategie=new StrategyTime();
		}
	}
	
	public synchronized void dispatchClient(Client c) {
		strategie.getServ(servere).addClient(c);
	}

	public List<Server> getServere() {
		return servere;
	}

	public void setServere(List<Server> servere) {
		this.servere = servere;
	}

	public Strategy getStrategie() {
		return strategie;
	}

	public void setStrategie(Strategy strategie) {
		this.strategie = strategie;
	}
	
	
	
}
