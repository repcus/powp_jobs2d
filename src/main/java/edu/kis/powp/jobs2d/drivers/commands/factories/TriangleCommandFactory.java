package edu.kis.powp.jobs2d.drivers.commands.factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;

public class TriangleCommandFactory implements ShapeCommandFactory{
	
	private Job2dDriver driver;
	private int startX, startY, baseLength, height;
	
	public TriangleCommandFactory(Job2dDriver driver, int startX, int startY, int baseLength, int height) {
		this.driver = driver;
		this.startX = startX;
		this.startY = startY;
		this.baseLength = baseLength;
		this.height = height;
	}
	
	@Override
	public ComplexCommand getCommand() {
		ComplexCommand complexCommand = new ComplexCommand();
		
		complexCommand.addCommand(new SetPositionCommand(this.startX, this.startY, this.driver));
		complexCommand.addCommand(new OperateToCommand(this.startX + this.baseLength, this.startY, this.driver));
		complexCommand.addCommand(new OperateToCommand(this.startX, this.startY + this.height, this.driver));
		complexCommand.addCommand(new OperateToCommand(this.startX, this.startY, this.driver));
		
		return complexCommand;
	}
}
