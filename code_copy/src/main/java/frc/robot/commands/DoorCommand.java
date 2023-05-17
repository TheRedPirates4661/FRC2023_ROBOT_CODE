package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Robot.m_robotContainer;

public class DoorCommand extends CommandBase{
    double power;
    public DoorCommand(double power) {
        this.power = power;
    }

    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getDoor());
        super.initialize();
    }

    @Override
    public void execute() {
        m_robotContainer.getDoor().move(power);
        super.execute();
    }

    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getDoor().move(0);
        super.end(interrupted);
    }
}
