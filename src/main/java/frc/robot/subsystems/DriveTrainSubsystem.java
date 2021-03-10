/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class DriveTrainSubsystem extends SubsystemBase {
  private CANSparkMax leftMotor2;
  private CANSparkMax rightMotor2;
  private CANSparkMax leftMotor1;
  private CANSparkMax rightMotor1;

  public DriveTrainSubsystem() {
    leftMotor1 = new CANSparkMax(Constants.leftSparkMaxID1, MotorType.kBrushless);
    rightMotor1 = new CANSparkMax(Constants.rightSparkMaxID1, MotorType.kBrushless);
    leftMotor2 = new CANSparkMax(Constants.leftSparkMaxID2, MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(Constants.rightSparkMaxID2, MotorType.kBrushless);
  }

  // Moves drivebase.
  public void drive() {
    double leftSpeed, rightSpeed;
    // tank drive
    double leftY = -RobotContainer.driverController.getY(Hand.kLeft);
    double rightY = RobotContainer.driverController.getY(Hand.kRight);
    leftSpeed = leftY;
    rightSpeed = rightY;

    if (Math.abs(leftSpeed) <= Constants.deadband) {
      leftSpeed = 0;
    }
    if (Math.abs(rightSpeed) <= Constants.deadband) {
      rightSpeed = 0;
    }
    leftSpeed *= Constants.driveSpeedMultiplier;
    rightSpeed *= Constants.driveSpeedMultiplier;

    if(RobotContainer.driverController.getBumper(Hand.kLeft))
    {	
      leftSpeed /= 2;
      rightSpeed /= 2;
    }
    // press right bumper for halfspeed
    set(leftSpeed, rightSpeed);
    SmartDashboard.putNumber("Left speed", leftSpeed);
    SmartDashboard.putNumber("Right speed", rightSpeed);
  }
  // Sets the speed of the drive base.
  public void set(double left, double right) {
    leftMotor1.set(-left);
    leftMotor2.set(-left);
    rightMotor1.set(-right);
    rightMotor2.set(-right);
  }
}
