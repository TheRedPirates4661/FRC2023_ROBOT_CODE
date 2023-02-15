package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class upAndDown {
    CANSparkMax motorLeft = new CANSparkMax(5, MotorType.kBrushless);
    CANSparkMax motorRight = new CANSparkMax(6, MotorType.kBrushless);    
    DigitalInput inputLeft = new DigitalInput(8);
    DigitalInput inputRight = new DigitalInput(9);
    DutyCycleEncoder encoderLeft = new DutyCycleEncoder(inputLeft);
    DutyCycleEncoder encoderRight = new DutyCycleEncoder(inputRight);

    public void move(double p) {
        double takeP1 = 0, takeP2 = 0;
        if(Math.abs(encoderLeft.get()-encoderRight.get()) > 0.1) {
            boolean temp = encoderLeft.get() < encoderRight.get();
            takeP1 = temp?(encoderLeft.get()-encoderRight.get()):0;
            takeP2 = temp?0:(encoderLeft.get()-encoderRight.get());
        }
        motorLeft.set(p-takeP1*2);
        motorRight.set(p-takeP2*2);
    }
}
