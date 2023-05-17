package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Robot.m_robotContainer;

public class ArmCommand extends CommandBase{
    private double power;
    public ArmCommand(double power) {
        this.power = power;
    }
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getArmSubSys());
        super.initialize();
    }

    @Override
    public void execute() {
        m_robotContainer.getArmSubSys().move(power);
        super.execute();
    }

    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getArmSubSys().move(0);
        super.end(interrupted);
    }
}