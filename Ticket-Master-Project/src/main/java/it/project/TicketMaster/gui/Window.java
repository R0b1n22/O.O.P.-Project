package it.project.TicketMaster.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import it.project.TicketMaster.exceptions.EmptyStringException;
import it.project.TicketMaster.exceptions.WrongParamException;
import it.project.TicketMaster.model.ApiReader;

public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//Attributes
	JButton ev_All_Stats = new JButton("Show statistics");
	JButton ev_Country_Stats = new JButton("Show statistics");
	JButton ev_State_Stats = new JButton("Show statistics");
	JButton ev_City_Stats = new JButton("Show statistics");
	TextField country = new TextField("CA");
	TextField state = new TextField("ON");
	TextField city = new TextField("Toronto");
	Color color = new Color (232, 248, 248);
	Font font = new Font("", Font.BOLD, 13);
	ImageIcon icon = new ImageIcon (System.getProperty("user.dir") + "\\TicketAdvisorImage.png");

	/**
	 * Constructor
	 * @param titolo
	 */
	public Window (String titolo) { 	
		super(titolo);
		this.setSize(750, 200);
		this.setLocationRelativeTo(null);
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
  	}

	/**
	 * Method for display the main window
	 */
	public void init () {
	//Panel for JLabel, TextField and JButton
		JPanel panel = new JPanel (new GridLayout (4, 3, 15, 15));
		panel.add(new JLabel("Global Events", JLabel.RIGHT));
		panel.add(new JLabel(""));
		panel.add(ev_All_Stats);
		panel.add(new JLabel("Events of (Enter the country code)", JLabel.RIGHT));
		country.setFont(font);
		panel.add(country);
		panel.add(ev_Country_Stats);
		panel.add(new JLabel("Events of (Enter the state code)", JLabel.RIGHT));
		state.setFont(font);
		panel.add(state);
		panel.add(ev_State_Stats);
		panel.add(new JLabel("Events of (Enter the city)", JLabel.RIGHT));
		city.setFont(font);
		panel.add(city);
		panel.add(ev_City_Stats);
		panel.setBackground(color);
	//Panel for BoxLayout
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
		pnl1.add(panel);
	//Panel for FlowLayout
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl2.add(pnl1);
		pnl2.setBackground(color);
	//Adding final panel to JFrame
		this.getContentPane().add(pnl2, BorderLayout.CENTER);
	}
	
	/**
	 * Listener for stats button
	 * @throws EmptyStringException
	 * @throws WrongParamException
	 */	
	public void Listener () throws EmptyStringException, WrongParamException {
		ev_All_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				ApiReader file;
				try {
					file = new ApiReader ("http://localhost:8080/AllStats", false, true);
					statsDisplayer(file, "World");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ev_Country_Stats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				ApiReader file;
				try {
					file = new ApiReader ("http://localhost:8080/CountryStats?countryCode=" + country.getText(), false, true);
					statsDisplayer(file, country.getText());
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
					file = new ApiReader ("http://localhost:8080/StateStats?stateCode=" + state.getText(), false, true);
					statsDisplayer(file, state.getText());
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
					file = new ApiReader ("http://localhost:8080/CityStats?city=" + city.getText(), false, true);
					statsDisplayer(file, city.getText());
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Method for display the stats window
	 * @param file
	 * @param name
	 */
	public void statsDisplayer (ApiReader file, String name) {
		JSONObject stats = file.getJsonobj();
	//Stats getter
		JPanel statsPnl = new JPanel(new GridLayout(3, 2, 10, 10));
		statsPnl.setBackground(color);
		statsPnl.add(new JLabel("Total events:"));
		TextField events = new TextField("" + (Long) stats.get("events"));
		events.setFont(font);
		statsPnl.add(events);
		events.setEditable(false);
		statsPnl.add(new JLabel("Monthly average:"));
		TextField monthlyAverage = new TextField("" + (Double) stats.get("monthlyAverage"));
		monthlyAverage.setFont(font);
		statsPnl.add(monthlyAverage);
		monthlyAverage.setEditable(false);
		statsPnl.add(new JLabel("Month with more events:"));
		TextField monthWME = new TextField((String) ((JSONObject) stats.get("monthWithMoreEvents")).get("month"));
		monthWME.setFont(font);
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
		flowPnl.setBackground(color);
	//Months events number getter
		JPanel monthPnl = new JPanel(new GridLayout(4, 6, 10, 10));
		JSONArray monthlyEv = (JSONArray) stats.get("num");
		String [] months = {"January:","February:","March:","April:","May:","June:","July:","August:","September:","October:","November:","December:"};
		for(int i = 0; i < 12; i++) {
			monthPnl.add(new JLabel(months[i]));
			TextField num = new TextField("" +  monthlyEv.get(i));
			num.setFont(font);
			monthPnl.add(num);
			num.setEditable(false);
		}
		monthPnl.setBackground(color);
	//Panel with FlowLayout
		JPanel flowPnl2 = new JPanel();
		flowPnl2.add(monthPnl);
		flowPnl2.setLayout(new FlowLayout(FlowLayout.LEFT));
		flowPnl2.setBackground(color);
	//Adding flowPnl and flowPnl2 to JFrame
		JFrame statsFrame = new JFrame("Stats of " + name);
		statsFrame.getContentPane().add(flowPnl, BorderLayout.NORTH);
		statsFrame.getContentPane().add(flowPnl2, BorderLayout.CENTER);
		statsFrame.setLocationRelativeTo(null);
		statsFrame.setSize(500, 300);
		statsFrame.setIconImage(icon.getImage());
		statsFrame.setVisible(true);
	}
}
