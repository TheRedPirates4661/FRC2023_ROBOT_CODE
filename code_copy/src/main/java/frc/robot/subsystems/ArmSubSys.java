package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;

public class ArmSubSys extends SubsystemBase {
    private WPI_TalonSRX motor;
    private DutyCycleEncoder encoder;

    public ArmSubSys(){
        DigitalInput  inp = new DigitalInput(9);
        this.motor = new WPI_TalonSRX(11);
        this.encoder = new DutyCycleEncoder(inp);
    }

    public void move(double power) {
        //if(Math.abs(getEncoderCycle()) < 0.04 && power < 0) power = 0; -> saftey thingy
        motor.set(ControlMode.PercentOutput, power);
    }
    
    public double getEncoderCycle() {
        return this.encoder.get();
    }

    public void reset() {
        this.encoder.reset();
    }
}
        