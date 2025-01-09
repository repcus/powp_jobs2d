package edu.kis.powp.jobs2d.drivers.commands.factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;

public class CircleCommandFactory implements ShapeCommandFactory{
	
	private Job2dDriver driver;
	private double angleIncrement;
	private int midPointX, midPointY, radius, segments, startX, startY;
	
	public CircleCommandFactory(Job2dDriver driver, int midPointX, int midPointY, int radius, int segments) {
		this.driver = driver;
		this.midPointX = midPointX;
		this.midPointY = midPointY;
		this.radius = radius;
		this.segments = segments;
		this.startX = midPointX + (int)(radius * Math.cos(Math.PI / 2));
		this.startY = midPointY + (int)(radius * Math.sin(Math.PI / 2));
		this.angleIncrement = 2 * Math.PI / segments;
	}
	
	@Override
	public ComplexCommand getCommand() {
		ComplexCommand complexCommand = new ComplexCommand();
		
		complexCommand.addCommand(new SetPositionCommand(this.startX, this.startY, this.driver));
		for (int i = 1; i <= this.segments; i++) {
			double angle = i * this.angleIncrement + Math.PI / 2;
			int x = this.midPointX + (int)(this.radius * Math.cos(angle));
			int y = this.midPointY + (int)(this.radius * Math.sin(angle));
			complexCommand.addCommand(new OperateToCommand(x, y, this.driver));
		}
		
		return complexCommand;
	}
}
