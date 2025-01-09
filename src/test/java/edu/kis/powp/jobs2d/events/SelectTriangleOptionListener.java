package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.factories.TriangleCommandFactory;

public class SelectTriangleOptionListener implements ActionListener{
	
	private DriverManager driverManager;
	
	public SelectTriangleOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TriangleCommandFactory triangleCommandFactory = new TriangleCommandFactory(
				driverManager.getCurrentDriver(), -120, -120, 200, 200);
		ComplexCommand command = triangleCommandFactory.getCommand();
		command.execute();
	}
}