package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Robot.m_robotContainer;

public class shootingCommand extends CommandBase{
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getShootingSubsys());
        super.initialize();
    }

    @Override
    public void execute() {
        m_robotContainer.getShootingSubsys().shot(0.5);
        super.execute();
    }

    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getShootingSubsys().shot(0);
        super.end(interrupted);
    }
}
