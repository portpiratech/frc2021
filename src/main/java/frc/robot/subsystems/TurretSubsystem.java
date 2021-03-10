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
  public boolean manual = true;
  public double maxSpeedX = 0.2;
  public double gainX = 0.15;
  public TurretSubsystem() {
    xMotor = new TalonSRX(Constants.turretXID);
    yMotor = new TalonSRX(Constants.turretXID);
  }

  public boolean isManual(){
    return manual;
  }

  public void toggleManual(){
    manual = !manual;
  }

  public void autoAimX(){
    double turnSpeedX;
    if (RobotContainer.cameraSubsystem.hasTarget()) {
      // X movement
      turnSpeedX = RobotContainer.cameraSubsystem.getXAngle() * gainX;
      if (turnSpeedX > maxSpeedX) {
        turnSpeedX = maxSpeedX;
      }
      if (turnSpeedX < -maxSpeedX) {
        turnSpeedX = -maxSpeedX;
      }
    }else{
      turnSpeedX = 0;
    }
    setX(turnSpeedX);
  }

  public void manualAimX(){
    double xSpeed = RobotContainer.operatorController.getX(Hand.kLeft);
    xSpeed *= maxSpeedX;
    setX(xSpeed);
  }

  public void manualAimY(){
    double ySpeed = RobotContainer.operatorController.getY(Hand.kLeft);
    ySpeed *= maxSpeedX;
    setY(ySpeed);
  }

  public void setX(double speed){
    xMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setY(double speed){
    yMotor.set(ControlMode.PercentOutput, speed);
  }
}
