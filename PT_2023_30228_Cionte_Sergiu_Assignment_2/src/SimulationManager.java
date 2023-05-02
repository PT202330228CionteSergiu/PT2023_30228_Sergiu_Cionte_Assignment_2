import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class SimulationManager implements Runnable {


	private Scheduler scheduler;
	private SimulationFrame frame;
	private List<Client> generatedClients = new ArrayList<Client>();
	private SelectionPolicy selectionPolicy=SelectionPolicy.SHORTEST_TIME;
	private List<Client>newClients=new ArrayList<Client>();

	public SimulationManager(SimulationFrame frame) {
		// scheduler = new Scheduler(noServers);

	this.frame=frame;

		scheduler = new Scheduler(frame.getNumServers());
		scheduler.selectStrategy(selectionPolicy);

		generateNRandomClients();

		// scheduler=new Scheduler(frame.getNumServers());

		// generateNRandomClients();
	}

	

	public synchronized void generateNRandomClients() {
		for (int i = 0; i <frame.getNumClients(); i++) {
			int id = i;
			Random rand = new Random();
			int serviceTime = rand.nextInt(frame.getMinimumServiceTime(), frame.getMaximumServiceTime());
			Random rand1 = new Random();
			int arrivalTime = rand1.nextInt(2, frame.getSimulationTime() / 2);
			Client c = new Client(id, arrivalTime, serviceTime);
			generatedClients.add(c);

		}
		 Collections.sort(generatedClients,new CompArrival());
	}

	public  synchronized void run() {

		int currentTime = 0;
		while (currentTime < frame.getSimulationTime()) {
			for (int i = 0; i < generatedClients.size(); i++) {
				if (generatedClients.get(i).getArrivalTime() == currentTime) {
					scheduler.dispatchClient(generatedClients.get(i));
					//try {
					//scheduler.getServere().get(1).clienti.put(generatedClients.get(i));
					//}catch(InterruptedException ex) {
						//ex.getStackTrace();
					//}
					//newClients.add(generatedClients.get(i));
					//scheduler.getServere().get(1).clienti.add(newClients.get(0));
					generatedClients.remove(i);

				}
	
			

			}
			//for(Client c:newClients) {
				//System.out.println(c);
			//}
			
			for(int m=0;m<frame.getNumServers();m++) {
				
				for(Client c:scheduler.getServere().get(m).getClienti()) {
					if(c.getServiceTime()>0)
					c.setServiceTime(c.getServiceTime()-1);;
				}
			}
			for(int k=0;k<frame.getNumServers();k++) {
				//System.out.println(scheduler.getServere().get(k).clienti);
				for(Client c:scheduler.getServere().get(k).getClienti()) {
					System.out.println("clientul"+c+"din serverul"+k);
				}
			}
			System.out.println(currentTime);
			for(int j=0;j<generatedClients.size();j++) {
				System.out.println(generatedClients.get(j));
			}
			String newline=System.lineSeparator();
			System.out.println(newline);
			currentTime++;
			try {
				Thread.sleep(1000);
				;
			} catch (InterruptedException ex) {
				ex.getStackTrace();
			}
		}

	}



}
