import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class SimulationFrame extends JFrame {

	private JLabel noClients;
	private JTextField numClients;
	private JLabel noServers;
	private JTextField numServers;
	private JLabel simTime;
	private JTextField simulationTime;
	private JLabel minServiceTime;
	private JTextField minimumServiceTime;
	private JLabel maxServiceTime;
	private JTextField maximumServiceTime;
	private JLabel minArrivalTime;
	private JTextField minimumArrivalTime;
	private JLabel maxArrivalTime;
	private JTextField maximumArrivalTime;
	private JList<Server>cozi;
	public JButton start;
	

	public void createFrame() {
		JFrame frame = new JFrame("Simulation Frame");

		frame.setSize(1920, 1080);
		//model=new DefaultListModel();
		
		start=new JButton("START");
		start.setBounds(1000,100,100,100);
		
		cozi=new JList<Server>();
		cozi.setBounds(1000,250,400,500);

		 noClients = new JLabel("Numar Clienti");
		noClients.setBounds(200, 145, 300, 150);

		 numClients = new JTextField();
		numClients.setBounds(500, 200, 300, 40);

		 noServers = new JLabel("Numar Cozi");
		noServers.setBounds(200, 245, 300, 150);

		 numServers = new JTextField();
		numServers.setBounds(500, 300, 300, 40);

		 simTime = new JLabel("Simulation Time");
		simTime.setBounds(200, 345, 300, 150);

		 simulationTime = new JTextField();
		simulationTime.setBounds(500, 400, 300, 40);

		 minServiceTime = new JLabel("Minimum Service Time");
		minServiceTime.setBounds(200, 445, 300, 150);

		 minimumServiceTime = new JTextField();
		minimumServiceTime.setBounds(500, 500, 300, 40);

		 maxServiceTime = new JLabel("Maximum Service Time");
		maxServiceTime.setBounds(200, 545, 300, 150);

		maximumServiceTime = new JTextField();
		maximumServiceTime.setBounds(500, 600, 300, 40);

		 minArrivalTime = new JLabel("Minimum Arrival Time");
		minArrivalTime.setBounds(200, 645, 300, 150);

		 minimumArrivalTime = new JTextField();
		minimumArrivalTime.setBounds(500, 700, 300, 40);

		 maxArrivalTime = new JLabel("Maximum Arrival Time");
		maxArrivalTime.setBounds(200, 745, 300, 150);

		 maximumArrivalTime = new JTextField();
		maximumArrivalTime.setBounds(500, 800, 300, 40);
		
		


		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(noClients);
		frame.add(numClients);
		frame.add(noServers);
		frame.add(numServers);
		frame.add(simTime);
		frame.add(simulationTime);
		frame.add(minServiceTime);
		frame.add(minimumServiceTime);
		frame.add(maxServiceTime);
		frame.add(maximumServiceTime);
		frame.add(maximumArrivalTime);
		frame.add(maxArrivalTime);
		frame.add(minimumArrivalTime);
		frame.add(minArrivalTime);
		frame.add(cozi);
		frame.setVisible(true);
		frame.add(start);
		
	
		SimulationFrame fr=this;
		start.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimulationManager sim = new SimulationManager(fr);
				Thread t = new Thread(sim);
				t.start();
		
			}
			
			
			
			
		});
	}

	public JLabel getNoClients() {
		return noClients;
	}

	public void setNoClients(JLabel noClients) {
		this.noClients = noClients;
	}

	public int getNumClients() {
		String input=numClients.getText();
		return Integer.parseInt(input);
		//return numClients;
	}

	public void setNumClients(JTextField numClients) {
		this.numClients = numClients;
	}

	public JLabel getNoServers() {
		return noServers;
	}

	public void setNoServers(JLabel noServers) {
		this.noServers = noServers;
	}

	public int getNumServers() {
		String input=numServers.getText();
		
		return Integer.parseInt(input);
	}

	public void setNumServers(JTextField numServers) {
		this.numServers = numServers;
	}

	public JLabel getSimTime() {
		return simTime;
	}

	public void setSimTime(JLabel simTime) {
		this.simTime = simTime;
	}

	public int getSimulationTime() {
		String input=simulationTime.getText();
		
		return Integer.parseInt(input);
	}

	public void setSimulationTime(JTextField simulationTime) {
		this.simulationTime = simulationTime;
	}

	public JLabel getMinServiceTime() {
		return minServiceTime;
	}

	public void setMinServiceTime(JLabel minServiceTime) {
		this.minServiceTime = minServiceTime;
	}

	public int getMinimumServiceTime() {
		String input=minimumServiceTime.getText();
		return Integer.parseInt(input);
	}

	public void setMinimumServiceTime(JTextField minimumServiceTime) {
		this.minimumServiceTime = minimumServiceTime;
	}

	public JLabel getMaxServiceTime() {
		return maxServiceTime;
	}

	public void setMaxServiceTime(JLabel maxServiceTime) {
		this.maxServiceTime = maxServiceTime;
	}

	public int getMaximumServiceTime() {
		String input=maximumServiceTime.getText();
		
		return Integer.parseInt(input);
	}

	public void setMaximumServiceTime(JTextField maximumServiceTime) {
		this.maximumServiceTime = maximumServiceTime;
	}

	public JLabel getMinArrivalTime() {
		return minArrivalTime;
	}

	public void setMinArrivalTime(JLabel minArrivalTime) {
		this.minArrivalTime = minArrivalTime;
	}

	public int getMinimumArrivalTime() {
		String input=minimumArrivalTime.getText();
		return Integer.parseInt(input);
	}

	public void setMinimumArrivalTime(JTextField minimumArrivalTime) {
		this.minimumArrivalTime = minimumArrivalTime;
	}

	public JLabel getMaxArrivalTime() {
		return maxArrivalTime;
	}

	public void setMaxArrivalTime(JLabel maxArrivalTime) {
		this.maxArrivalTime = maxArrivalTime;
	}

	public int getMaximumArrivalTime() {
		String input=maximumArrivalTime.getText();
		return Integer.parseInt(input);
	}

	public void setMaximumArrivalTime(JTextField maximumArrivalTime) {
		this.maximumArrivalTime = maximumArrivalTime;
	}
	
	
	public static void main(String[] args) {
		SimulationFrame frame=new SimulationFrame();
		frame.createFrame();

		
	}
	
	

}
