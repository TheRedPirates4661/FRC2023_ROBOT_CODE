package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class mechDrive extends SubsystemBase{
    CANSparkMax motorA, motorB,motorC, motorD;

    public mechDrive () {
        motorA = new CANSparkMax(1, MotorType.kBrushless);
        motorB = new CANSparkMax(2, MotorType.kBrushless);
        motorC = new CANSparkMax(4, MotorType.kBrushless);
        motorD = new CANSparkMax(3, MotorType.kBrushless);
    }

    
    public void update(double x, double y) {
        Constants.drive.powerA = (x + y)*0.5*0.8;
        Constants.drive.powerB = (-x + y)*0.5*0.8;
        Constants.drive.powerC = (-x + y)*0.5*0.8;
        Constants.drive.powerD = (x + y)*0.5*0.8;
    }

    public void spin(double x) {
        Constants.drive.addA = x*0.5*0.8;
        Constants.drive.addB = x*-0.5*0.8;
        Constants.drive.addC = x*0.5*0.8;
        Constants.drive.addD = x*-0.5*0.8;
    }

    public void drive() {
        motorA.set(-(Constants.drive.addA + Constants.drive.powerA));
        motorB.set((Constants.drive.addB + Constants.drive.powerB));
        motorC.set(-(Constants.drive.addC + Constants.drive.powerC));
        motorD.set(Constants.drive.addD + Constants.drive.powerD);
    }
}
