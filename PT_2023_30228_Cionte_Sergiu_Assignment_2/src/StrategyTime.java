import java.util.List;

public class StrategyTime implements Strategy {

	
	public Server getServ(List<Server> servere) {
	
		int minim=Integer.MAX_VALUE;
		Server serv=null;
		//for(int i=0;i<servere.size();i++) {
			//if(servere.get(i).getWaitingPeriod().intValue()<minim) {
				//poz=i;
				//minim=servere.get(i).getWaitingPeriod().intValue();
				
			//}
		//}
		for(Server s:servere) {
			   int waitingPeriod = s.getWaitingPeriod().get();
		        if (waitingPeriod < minim) {
		            minim = waitingPeriod;
		            serv = s;
		        }
		}
		return serv;
		
	}

	
}
