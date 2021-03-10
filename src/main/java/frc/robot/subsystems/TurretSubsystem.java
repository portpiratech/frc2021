// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  public TalonSRX xMotor;
  public TalonSRX yMotor;
  public double multiplier = 0.3;
  public TurretSubsystem() {
    xMotor = new TalonSRX(Constants.turretXID);
    yMotor = new TalonSRX(Constants.turretXID);
  }

  public void mannualAim(){
    double xSpeed = RobotContainer.operatorController.getX(Hand.kLeft);
    double ySpeed = RobotContainer.operatorController.getY(Hand.kLeft);
    xSpeed *= multiplier;
    ySpeed *= multiplier;
    setX(xSpeed);
    setY(ySpeed);
  }

  public void setX(double speed){
    xMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setY(double speed){
    yMotor.set(ControlMode.PercentOutput, speed);
  }
}
