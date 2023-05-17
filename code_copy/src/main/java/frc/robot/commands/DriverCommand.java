package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Robot.m_robotContainer;

public class DriverCommand extends CommandBase{
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getDriver());
        super.initialize();
    }

    @Override
    public void execute() {
        m_robotContainer.getDriver().arcade(m_robotContainer.getPs4().getRightX(), m_robotContainer.getPs4().getLeftY());
        super.execute();
    }

    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getDriver().arcade(0, 0);
        super.end(interrupted);
    }
}
