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
}
