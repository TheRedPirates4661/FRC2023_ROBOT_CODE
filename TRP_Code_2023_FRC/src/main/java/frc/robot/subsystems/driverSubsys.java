package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class driverSubsys extends SubsystemBase{
    WPI_TalonSRX frontR, backR;
    WPI_TalonSRX frontL, backL;
    MotorControllerGroup right, left;
    DifferentialDrive diff;

    public driverSubsys() {
        frontL = new WPI_TalonSRX(0);
        frontR = new WPI_TalonSRX(1);
        backL = new WPI_TalonSRX(2);
        backR = new WPI_TalonSRX(3);

        right = new MotorControllerGroup(frontR, backR);
        left = new MotorControllerGroup(frontL, backL);

        diff = new DifferentialDrive(left, right);
    }

    public void arcade(double x, double y) {
        diff.arcadeDrive(x*0.6, y*0.6);
    }

    public void stop(){
        diff.arcadeDrive(0, 0);
    }
}
