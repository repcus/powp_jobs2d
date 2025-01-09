package edu.kis.powp.jobs2d.drivers.commands.factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;

public class RectangleCommandFactory implements ShapeCommandFactory{
	
	private Job2dDriver driver;
	private int startX, startY, endX, endY;
	
	public RectangleCommandFactory(Job2dDriver driver, int startX, int startY, int endX, int endY) {
		this.driver = driver;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	@Override
	public ComplexCommand getCommand() {
		ComplexCommand complexCommand = new ComplexCommand();
		
		complexCommand.addCommand(new SetPositionCommand(this.startX, this.startY, this.driver));
		complexCommand.addCommand(new OperateToCommand(this.endX, this.startY, this.driver));
		complexCommand.addCommand(new OperateToCommand(this.endX, this.endY, this.driver));
		complexCommand.addCommand(new OperateToCommand(this.startX, this.endY, this.driver));
		complexCommand.addCommand(new OperateToCommand(this.startX, this.startY, this.driver));
		
		return complexCommand;
	}
}
