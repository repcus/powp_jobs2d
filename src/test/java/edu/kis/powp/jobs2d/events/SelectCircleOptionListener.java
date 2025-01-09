package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.factories.CircleCommandFactory;

public class SelectCircleOptionListener implements ActionListener{
	
	private DriverManager driverManager;
	
	public SelectCircleOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CircleCommandFactory circleCommandFactory = new CircleCommandFactory(
				driverManager.getCurrentDriver(), 0, 0, 120, 100);
		ComplexCommand command = circleCommandFactory.getCommand();
		command.execute();
	}
}