package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class doorSubsys extends SubsystemBase{
    WPI_TalonSRX motor;
    public doorSubsys() {
        motor = new WPI_TalonSRX(10);
    }

    public void move(double power) {
        motor.set(ControlMode.PercentOutput, power*0.3);
    }
}
