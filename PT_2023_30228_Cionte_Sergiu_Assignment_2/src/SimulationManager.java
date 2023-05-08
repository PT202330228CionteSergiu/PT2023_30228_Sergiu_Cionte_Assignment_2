import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class SimulationManager implements Runnable {


	private Scheduler scheduler;
	private SimulationFrame frame;
	private List<Client> generatedClients = new ArrayList<Client>();
	private SelectionPolicy selectionPolicy=SelectionPolicy.SHORTEST_TIME;
	//private List<Client>newClients=new ArrayList<Client>();
	private int sumWaitTime=0;
	private double avgWaitTime;
	private int sumServTime=0;
	private double avgServTime;

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
		try {
		FileWriter writer=new FileWriter("log1.txt");
		BufferedWriter buffer=new BufferedWriter(writer);
		
		while (currentTime < frame.getSimulationTime()) {
			buffer.write("TIME" + currentTime);
			String newline1=System.lineSeparator();
			//System.out.println(newline);
			buffer.write(newline1);
			frame.setTextArea("TIME"+currentTime);
			frame.setTextArea(newline1);
			//System.out.println(newline);
			
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
					sumWaitTime=sumWaitTime+generatedClients.get(i).getServiceTime();
					sumServTime=sumServTime+generatedClients.get(i).getArrivalTime()+generatedClients.get(i).getServiceTime();
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
				//for(Server s:scheduler.getServere()) {
					//System.out.println("clientul"+c+"din serverul"+k);
					buffer.write("Queue "+k+":");
					frame.setTextArea("Queue "+k+":");
					for(Client c:scheduler.getServere().get(k).clienti)
					{buffer.write(c.toString());
					frame.setTextArea(c.toString());
					}
					String newline=System.lineSeparator();
					//System.out.println(newline);
					buffer.write(newline);
					frame.setTextArea(newline);
				
			}
			System.out.println(currentTime);
			//buffer.write(Integer.toString(currentTime));
			buffer.write("Waiting clients");
			frame.setTextArea("Waiting clients");
			for(int j=0;j<generatedClients.size();j++) {
				//System.out.println(generatedClients.get(j));
				//buffer.write("Waiting clients");
				buffer.write(generatedClients.get(j).toString());
				frame.setTextArea(generatedClients.get(j).toString());
			}
			String newline=System.lineSeparator();
			//System.out.println(newline);
			buffer.write(newline);
			frame.setTextArea(newline);
			currentTime++;
			try {
				Thread.sleep(1000);
				;
			} catch (InterruptedException ex) {
				ex.getStackTrace();
			}
		}
		avgWaitTime=(double)sumWaitTime/frame.getNumClients();
		avgServTime=(double)sumServTime/frame.getNumClients();
		
		//System.out.println(avgWaitTime);
		buffer.write(Double.toString(avgWaitTime));
		buffer.write(Double.toString(avgServTime));
		
		//System.out.println(avgServTime);
		frame.setTextArea(Double.toString(avgWaitTime));
		String newline=System.lineSeparator();
		//System.out.println(newline);
		frame.setTextArea(newline);
		frame.setTextArea(Double.toString(avgServTime));
		buffer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}



}
