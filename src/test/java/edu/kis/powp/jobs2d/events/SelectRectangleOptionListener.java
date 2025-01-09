package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.factories.RectangleCommandFactory;

public class SelectRectangleOptionListener implements ActionListener{
	
	private DriverManager driverManager;
	
	public SelectRectangleOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RectangleCommandFactory rectangleCommandFactory = new RectangleCommandFactory(
				driverManager.getCurrentDriver(), -120, -120, 150, 120);
		ComplexCommand command = rectangleCommandFactory.getCommand();
		command.execute();
	}
}
