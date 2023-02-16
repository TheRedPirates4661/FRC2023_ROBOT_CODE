package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shootingSubsys extends SubsystemBase{
    CANSparkMax motorRight, motorLeft;
    public shootingSubsys() {
        motorRight = new CANSparkMax(101, MotorType.kBrushless);
        motorLeft = new CANSparkMax(100, MotorType.kBrushless);
    }

    public void shot(double power) {
        motorRight.set(power);
        motorLeft.set(-power);
    }
}
