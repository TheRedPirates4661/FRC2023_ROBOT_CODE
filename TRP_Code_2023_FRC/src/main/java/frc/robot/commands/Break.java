package frc.robot.commands;

import static frc.robot.Robot.m_robotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class Break extends CommandBase{
    @Override
    public void initialize() {
        Constants.breaking.shouldBreak = !Constants.breaking.shouldBreak;
    }
    @Override
    public void execute() {
        m_robotContainer.getBreakSys().openBothBreaks(Constants.breaking.shouldBreak);
    }
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
}