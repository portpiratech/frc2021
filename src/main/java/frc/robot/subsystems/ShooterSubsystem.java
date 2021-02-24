/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  // private DoubleSolenoid piston;
  private CANSparkMax leftMotor;
  private CANPIDController leftMotorPIDController;
  private CANSparkMax rightMotor;
  private CANPIDController rightMotorPIDController;
  private boolean isMotorOn;

  public ShooterSubsystem() {
    leftMotor = new CANSparkMax(RobotMap.SPIFFYLeftMotorID, MotorType.kBrushless);
    leftMotorPIDController = leftMotor.getPIDController();
    rightMotor = new CANSparkMax(RobotMap.SPIFFYRightMotorID, MotorType.kBrushless);
    rightMotorPIDController = rightMotor.getPIDController();
    stopMotor();
  }
  
  public void startMotor() {
    leftMotorPIDController.setReference(RobotMap.rpm, ControlType.kVelocity);
    rightMotorPIDController.setReference(-RobotMap.rpm, ControlType.kVelocity);
    isMotorOn = true;
  }
  
  public void stopMotor() {
    leftMotorPIDController.setReference(0, ControlType.kVelocity);
    rightMotorPIDController.setReference(0, ControlType.kVelocity);
    isMotorOn = false;
  }
  
  public boolean isMotorOn() {
    return isMotorOn;
  }

  public void setRPM(double rpm) {
    leftMotorPIDController.setReference(-rpm, ControlType.kVelocity);
    rightMotorPIDController.setReference(rpm, ControlType.kVelocity);
  }

  public void getMotorRPM() {
    SmartDashboard.putNumber("Left RPM", leftMotor.getEncoder().getVelocity());
    SmartDashboard.putNumber("Right PRM", rightMotor.getEncoder().getVelocity());
  }
  
  // public boolean shoot(){
  //   if (Robot.shooterSubsystem.isMotorOn()
  //     && Robot.cameraSubsystem.hasTarget()
  //     && Robot.cameraSubsystem.shotViable()
  //   ) {
  //     Robot.shooterSubsystem.retractLauncher();
  //     Timer.delay(1);
  //     Robot.shooterSubsystem.extendLauncher();
  //     return true;
  //   }else{
  //     return false;
  //   }
  // }
}