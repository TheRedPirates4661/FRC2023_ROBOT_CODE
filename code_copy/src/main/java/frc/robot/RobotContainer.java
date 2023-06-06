// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.ArmSubSys;
import frc.robot.commands.DoorCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.subsystems.driverSubsys;
import frc.robot.subsystems.doorSubsys;
import frc.robot.commands.ChangeSpeedCommand;
import frc.robot.commands.ClawCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ClawSubsys;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final Joystick stick = new Joystick(2);
  private JoystickButton[] buttons = new JoystickButton[12];

  private final CommandPS4Controller Controls_PS4 = new CommandPS4Controller(1);
  private final CommandPS4Controller ps4 = new CommandPS4Controller(0);
  private final ArmSubSys arm = new ArmSubSys();
  private final driverSubsys driver = new driverSubsys();
  private final doorSubsys door = new doorSubsys();
  private final ClawSubsys claw = new ClawSubsys();
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  public CommandPS4Controller getPs4(){
    return this.ps4;
  }

  public driverSubsys getDriver() {
    return this.driver;
  }

  public doorSubsys getDoor() {
    return this.door;   
  }

  public CommandPS4Controller get_Controls_PS4() {
    return this.Controls_PS4;
  }

  public ArmSubSys getArmSubSys(){
    return this.arm;
  }

  public ClawSubsys getClaw() {
    return this.claw;
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
    for(int i = 0; i < 12; i++) {
      buttons[i] = new JoystickButton(stick, i);
    }
    
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    
    //Commands for the controls driver
    Controls_PS4.circle().whileTrue(new DoorCommand(1.5));
    Controls_PS4.square().whileTrue(new DoorCommand(-2.75));
    Controls_PS4.triangle().whileTrue(new ClawCommand(-0.85));
    Controls_PS4.cross().whileTrue(new ClawCommand(0.85));
    //Commands for the robot driver
    ps4.circle().whileTrue(new ChangeSpeedCommand(0.3));
    ps4.R2().whileTrue(new ChangeSpeedCommand(0.95));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}
