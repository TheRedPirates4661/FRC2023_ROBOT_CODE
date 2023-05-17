package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import java.lang.Math;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class driverSubsys extends SubsystemBase{
    CANSparkMax motorRightFront, motorRightRear;
    CANSparkMax motorLeftFront, motorLeftRear;
    DifferentialDrive diffDrive;
    MotorControllerGroup left, right;
    DigitalInput inp;
    DutyCycleEncoder encoder;
    private ADXRS450_Gyro gyro =new ADXRS450_Gyro();

    public driverSubsys() {
        motorRightFront = new CANSparkMax(1, MotorType.kBrushless);
        motorRightRear = new CANSparkMax(5, MotorType.kBrushless);
        motorLeftFront = new CANSparkMax(3, MotorType.kBrushless);
        motorLeftRear = new CANSparkMax(4, MotorType.kBrushless);
        left = new MotorControllerGroup(motorLeftFront, motorLeftRear);
        right = new MotorControllerGroup(motorRightFront, motorRightRear);
        diffDrive = new DifferentialDrive(left, right);
        inp = new DigitalInput(0);
        encoder = new DutyCycleEncoder(inp);
        encoder.setDistancePerRotation(Math.PI*0.15);
    }

    public void arcade(double x, double z) {
        diffDrive.arcadeDrive(x*Constants.drive.power, z*(Constants.drive.power-0.05));
    }

    public double getDistance() {
        return Math.abs(this.encoder.getDistance()) + 0.36;
    }

    public void reset(){
        this.encoder.reset();
    }

    public void balance(){
        double angle = gyro.getAngle();

        if(Math.abs(angle)>2){
            arcade(angle/10*3, 0);
        }

        if(angle>360) angle-=360;
        else if(angle<-360) angle+=360;
    }

}
