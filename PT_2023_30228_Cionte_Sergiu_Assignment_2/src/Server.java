import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
	public LinkedBlockingQueue<Client>clienti;
	private AtomicInteger waitingPeriod;
	public Server() {
		super();
		clienti=new LinkedBlockingQueue<Client>();
		waitingPeriod=new AtomicInteger(0);
	
	}
	
	public  void addClient(Client cl) {
		try {
		clienti.put(cl);
	waitingPeriod.getAndIncrement();
		}catch(InterruptedException ex) {
			ex.getStackTrace();
		}
		//notifyAll();
		}

	public LinkedBlockingQueue<Client> getClienti() {
		return clienti;
	}

	public void setClienti(LinkedBlockingQueue<Client> clienti) {
		this.clienti = clienti;
	}

	public AtomicInteger getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(AtomicInteger waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}
	
	public synchronized void run() {
		while(true) {
			try {
			for(Client c:clienti) {
				if(c.getServiceTime()==0)
					{clienti.remove(c);
					waitingPeriod.getAndDecrement();
					Thread.sleep(c.getServiceTime()*1000);
					}
				
			}
			}	catch(InterruptedException ex) {
			ex.printStackTrace();
		}
			
			//Thread.sleep(c.getServiceTime());
			//waitingPeriod.getAndDecrement()
//;
			//}
			//catch(InterruptedException ex) {
				//ex.printStackTrace();
			//}
		}
	}
	

}
