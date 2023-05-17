package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class ChangeSpeedCommand extends CommandBase{
    private double changeSpeed;
    public ChangeSpeedCommand(double changeSpeed) {
        this.changeSpeed = changeSpeed;
    }
    @Override
    public void initialize() {
        Constants.drive.power = this.changeSpeed;
        super.initialize();
    }
    
    @Override
    public void end(boolean interrupted) {
        Constants.drive.power = 0.7;
        super.end(interrupted);
    }
}
