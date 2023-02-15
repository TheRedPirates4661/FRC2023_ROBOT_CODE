package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class breaksSubsys extends SubsystemBase {
    Compressor pcmComp;
    DoubleSolenoid solenoid1;
    DoubleSolenoid solenoid2;
    
    public breaksSubsys(){
        pcmComp = new Compressor(0, PneumaticsModuleType.CTREPCM);
        solenoid1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0,1);
        solenoid2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6,7);
    }
    public void openBreak1(boolean state){
        if(state) solenoid1.set(Value.kForward);
        else solenoid1.set(Value.kReverse);
    }
    public void openBreak2(boolean state){
        if(state) solenoid2.set(Value.kForward);
        else solenoid2.set(Value.kReverse);
    }
    public void openBothBreaks(boolean state){
        if(state){
            solenoid1.set(Value.kForward);
            solenoid2.set(Value.kForward);
        }
        else{
            solenoid2.set(Value.kReverse);
            solenoid1.set(Value.kReverse);
        }
    }
    public void lockBreaks(){
        solenoid1.set(Value.kOff);
        solenoid2.set(Value.kOff);
    }
}
