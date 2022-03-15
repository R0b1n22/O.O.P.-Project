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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Window extends JFrame{
//ATTRIBUTI
	JButton ev_Country_Stats = new JButton("Mostra Statistiche");
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
		panel.add(ev_Country_Stats);
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
		ev_Country_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				ApiReader file;
				try {
					file = new ApiReader ("http://localhost:8080/CaStats", false);
					statsDisplayer(file, "CA");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ev_State_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				ApiReader file;
				try {
					file = new ApiReader ("http://localhost:8080/StateStats?stateCode=" + state.getText(), false);
					statsDisplayer(file, state.getText())
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ev_City_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				ApiReader file;
				try {
					file = new ApiReader ("http://localhost:8080/CityStats?city=" + city.getText(), false);
					statsDisplayer(file, city.getText());
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void statsDisplayer (ApiReader file, String name) {
		JSONObject stats = file.getJsonobj();
//Stats getter
		JPanel statsPnl = new JPanel(new GridLayout(3, 2, 10, 10));
		statsPnl.add(new JLabel("Total events:"));
		TextField events = new TextField("" + (Long) stats.get("events"));
		statsPnl.add(events);
		events.setEditable(false);
		statsPnl.add(new JLabel("Monthly average:"));
		TextField monthlyAverage = new TextField("" + (Double) stats.get("monthlyAverage"));
		statsPnl.add(monthlyAverage);
		monthlyAverage.setEditable(false);
		statsPnl.add(new JLabel("Month with more events:"));
		TextField monthWME = new TextField((String) ((JSONObject) stats.get("monthWithMoreEvents")).get("month"));
		statsPnl.add(monthWME);
		monthWME.setEditable(false);
//Panel with BoxLayout
		JPanel boxPnl = new JPanel();
		boxPnl.add(statsPnl);
		boxPnl.setLayout(new BoxLayout(boxPnl, BoxLayout.X_AXIS));
//Panel with FlowLayout
		JPanel flowPnl = new JPanel();
		flowPnl.add(boxPnl);
		flowPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
//Months events number getter
		JPanel monthPnl = new JPanel(new GridLayout(4, 6, 10, 10));
		JSONArray monthlyEv = (JSONArray) stats.get("num");
		String [] months = {"January:","February:","March:","April:","May:","June:","July:","August:","September:","October:","November:","December:"};
		for(int i = 0; i < 12; i++) {
			monthPnl.add(new JLabel(months[i]));
			TextField num = new TextField("" +  monthlyEv.get(i));
			monthPnl.add(num);
			num.setEditable(false);
		}
		monthPnl.setBackground(color);
//Panel with FlowLayout
		JPanel flowPnl2 = new JPanel();
		flowPnl2.add(monthPnl);
		flowPnl2.setLayout(new FlowLayout(FlowLayout.LEFT));
//Frame
		JFrame statsFrame = new JFrame("Stats of " + name);
		statsFrame.getContentPane().add(flowPnl, BorderLayout.NORTH);
		statsFrame.getContentPane().add(flowPnl2, BorderLayout.CENTER);
		statsFrame.setLocationRelativeTo(null);
		statsFrame.setSize(500, 300);
		statsFrame.setVisible(true);
	}
}
