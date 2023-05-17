package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class ClawSubsys extends SubsystemBase{
    private WPI_TalonSRX motorLeft, motorRight;

    public ClawSubsys() {
        motorLeft = new WPI_TalonSRX(0);
        motorRight = new WPI_TalonSRX(12);
    }

    public void move(double power) {
        motorLeft.set(ControlMode.PercentOutput, power);
        motorRight.set(ControlMode.PercentOutput, -power);
    }
}
