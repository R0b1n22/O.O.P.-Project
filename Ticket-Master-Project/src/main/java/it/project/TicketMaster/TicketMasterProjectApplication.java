package it.project.TicketMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.project.TicketMaster.exceptions.EmptyStringException;
import it.project.TicketMaster.exceptions.WrongParamException;
import it.project.TicketMaster.gui.Window;

@SpringBootApplication
public class TicketMasterProjectApplication {
	/**
	 * Main
	 * @param args
	 * @throws EmptyStringException
	 * @throws WrongParamException
	 */
	public static void main(String[] args) throws EmptyStringException, WrongParamException {
		Window w = new Window ("TicketAdvisor");
		w.init();
		w.Listener();
		SpringApplication.run(TicketMasterProjectApplication.class, args);
		w.setVisible(true);
	}
}
