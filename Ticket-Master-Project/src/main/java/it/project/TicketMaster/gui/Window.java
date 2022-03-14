package it.project.TicketMaster.gui;

public class Window extends JFrame{
//ATTRIBUTI
	JButton ev_Stats = new JButton("Mostra Statistiche");
	JButton ev_State_Stats = new JButton("Mostra Statistiche");
	JButton ev_City_Stats = new JButton("Mostra Statistiche");
//BUILDER
	public Window (String titolo) { 	
		super(titolo);
		this.setSize(700, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
  	}

	public void init () {
		ev_Stats.setActionCommand("Stats");
		ev_State_Stats.setActionCommand("evStateStats");
		ev_City_Stats.setActionCommand("evCityStats");
		JPanel panel = new JPanel (new GridLayout (3, 2 15, 15));
		panel.add(new JLabel("Eventi del Canada", JLabel.RIGHT));
		panel.add(ev_Stats);
		panel.add(new JLabel("Eventi di (Inserisci il codice dello Stato)", JLabel.RIGHT));
		panel.add(ev_State_Stats);
		panel.add(new JLabel("Eventi di (Inserisci Città)", JLabel.RIGHT));
		panel.add(ev_City_Stats);
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
		pnl1.add(panel);
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl2.add(pnl1);
		this.getContentPane().add(pnl2, BorderLayout.CENTER
	}
}
