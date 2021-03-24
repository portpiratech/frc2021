// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private TalonSRX fireMotor;
  private double fireSpeed = 0.5;
  private boolean isFireMotorOn = false;

  private TalonSRX feedMotor;
  private double feedSpeed = 0.5;
  private boolean isFeedMotorOn = false;

  public ShooterSubsystem() {
    fireMotor = new TalonSRX(Constants.fireMotorID);
    feedMotor = new TalonSRX(Constants.feedMotorID);
  }

  public void setFireSpeed(){
    if(isFireMotorOn){
      fireMotor.set(ControlMode.PercentOutput, 0);
    }else{
      fireMotor.set(ControlMode.PercentOutput, fireSpeed);
    }
    isFireMotorOn = !isFireMotorOn;
  }

  public void setFeedSpeed(){
    if(isFeedMotorOn){
      feedMotor.set(ControlMode.PercentOutput, 0);
    }else{
      feedMotor.set(ControlMode.PercentOutput, feedSpeed);
    }
    isFeedMotorOn = !isFeedMotorOn;
  }
}
