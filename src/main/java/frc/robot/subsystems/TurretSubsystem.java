/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.RemoteLimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class TurretSubsystem extends SubsystemBase {
  /**
   * Creates a new TurretSubsystem.
   */
  private TalonSRX xMotor;

  public TurretSubsystem() {
    xMotor = new TalonSRX(RobotMap.turretXMotorID);
    xMotor.configForwardLimitSwitchSource(RemoteLimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled,
        RobotMap.turretXMotorID, 10);
    xMotor.configReverseLimitSwitchSource(RemoteLimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled,
        RobotMap.turretXMotorID, 10);
    xMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    xMotor.getSensorCollection().setQuadraturePosition(0, 10);
  }
  // Sets the speed of the X motor.
  public void setXMotor(double speed) {
    SmartDashboard.putNumber("x Speed", speed);
    xMotor.set(ControlMode.PercentOutput, speed);
  }
  // Returns the encoder position on the X motor.
  public double getXPosition() {
    SmartDashboard.putNumber("Position", xMotor.getSelectedSensorPosition(0));
    return xMotor.getSelectedSensorPosition(0);
  }
  // Returns the forward limit switch on the X motor.
  public int getForwardLimitSwitchX() {
    SmartDashboard.putNumber("Forward Limit Switch X", xMotor.isFwdLimitSwitchClosed());
    return xMotor.isFwdLimitSwitchClosed();
  }
  // Returns the reverse limit switch on the X motor.
  public int getReverseLimitSwitchX() {
    SmartDashboard.putNumber("Reverse Limit Switch X", xMotor.isRevLimitSwitchClosed());
    return xMotor.isRevLimitSwitchClosed();
  }
}
