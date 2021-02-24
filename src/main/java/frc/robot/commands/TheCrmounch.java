/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TheCrmounch extends CommandBase {
  /**
   * Creates a new AimCameraCommand.
   */
  private double gainX = 0.005;
  private double minDistance = 7;
  private double gainDist = 0.04;
  private double maxSpeedDist = 0.4;
  private double maxSpeedturn = 0.1;

  public TheCrmounch() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // makes robot move to a certain distance from the target
    if (RobotContainer.cameraSubsystem.hasTarget()) {
      double turnSpeed = RobotContainer.cameraSubsystem.getXAngle() * gainX;
      if (turnSpeed > maxSpeedturn) {
        turnSpeed = maxSpeedturn;
      }
      if (turnSpeed < -maxSpeedturn) {
        turnSpeed = -maxSpeedturn;
      }
      double left = -turnSpeed;
      double right = turnSpeed;
      double distance = RobotContainer.cameraSubsystem.getDistance();
      double distanceSpeed = (distance - minDistance) * gainDist;
      if (distanceSpeed > maxSpeedDist) {
        distanceSpeed = maxSpeedDist;
      }
      if (distanceSpeed < -maxSpeedDist) {
        distanceSpeed = -maxSpeedDist;
      }
      left += distanceSpeed;
      right += distanceSpeed;
      RobotContainer.driveTrainSubsystem.set(left, right);
    } else {
      RobotContainer.driveTrainSubsystem.set(-0.01, -0.01);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
