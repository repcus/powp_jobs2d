package edu.kis.powp.jobs2d.drivers.commands;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
	
	private List<DriverCommand> driverCommandList = new ArrayList<DriverCommand>();
	
	public ComplexCommand() {
		this.driverCommandList = new ArrayList<DriverCommand>();
	}

	public void addCommand(DriverCommand command) {
		this.driverCommandList.add(command);
	}
	
	@Override
	public void execute() {
		for(DriverCommand command: driverCommandList) {
			command.execute();
		}
		driverCommandList.clear();
	}
}