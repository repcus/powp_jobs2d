package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleCommandFactory {
	public static DriverCommand createRectangle(Job2dDriver driver) {
		ComplexCommand complexCommand = new ComplexCommand();
		complexCommand.addCommand(new SetPositionCommand(0, 0, driver));
		complexCommand.addCommand(new OperateToCommand(150, 0, driver));
		complexCommand.addCommand(new OperateToCommand(150, 100, driver));
		complexCommand.addCommand(new OperateToCommand(0, 100, driver));
		complexCommand.addCommand(new OperateToCommand(0, 0, driver));
		return complexCommand;
	}
}
