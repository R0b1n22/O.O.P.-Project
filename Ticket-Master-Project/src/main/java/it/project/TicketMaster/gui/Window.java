package it.project.TicketMaster.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame{
//ATTRIBUTI
	JButton ev_Stats = new JButton("Mostra Statistiche");
	JButton ev_State_Stats = new JButton("Mostra Statistiche");
	JButton ev_City_Stats = new JButton("Mostra Statistiche");
	TextField state = new TextField(15);
	TextField city = new TextField(15);
//BUILDER
	public Window (String titolo) { 	
		super(titolo);
		this.setSize(700, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
  	}
//METHODS (for the main screen and the stats window)
	public void init () {
	//Setting ActionCommand for buttons
		ev_Stats.setActionCommand("Stats");
		ev_State_Stats.setActionCommand("evStateStats");
		ev_City_Stats.setActionCommand("evCityStats");
	//Panel for JLabel, TextField and JButton
		JPanel panel = new JPanel (new GridLayout (3, 3, 15, 15));
		panel.add(new JLabel("Eventi del Canada", JLabel.RIGHT));
		panel.add(new JLabel(""));
		panel.add(ev_Stats);
		panel.add(new JLabel("Eventi di (Inserisci il codice dello Stato)", JLabel.RIGHT));
		panel.add(state);
		panel.add(ev_State_Stats);
		panel.add(new JLabel("Eventi di (Inserisci Città)", JLabel.RIGHT));
		panel.add(city);
		panel.add(ev_City_Stats);
	//Panel for BoxLayout
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
		pnl1.add(panel);
	//Panel for FlowLayout
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl2.add(pnl1);
	//Adding final panel to JFrame
		this.getContentPane().add(pnl2, BorderLayout.CENTER);
	}
	
//Listener for Stats Buttons	
	public void Listener () {
		ev_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {					
			}
		});
		ev_State_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
			}
		});
		ev_City_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
			}
		});
	}
}
