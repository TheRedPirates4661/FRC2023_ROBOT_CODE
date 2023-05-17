package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Robot.m_robotContainer;

public class ClawCommand extends CommandBase{
    double power;

    public ClawCommand(double power) {
        this.power = power;
    }

    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getClaw());
        super.initialize();
    }

    @Override
    public void execute() {
        m_robotContainer.getClaw().move(power);
        super.execute();
    }

    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getClaw().move(0);
        super.end(interrupted);
    }
}
