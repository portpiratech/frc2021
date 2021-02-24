/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShootCommand extends CommandBase {
  /**
   * Creates a new ShooterMotorCommand.
   */
  public ShootCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double h = 2.5;
    double d = Robot.cameraSubsystem.getDistance();
    double a = Math.PI/4;
    double v = (d / Math.cos(a)) * Math.sqrt(4.9 / ((d * Math.tan(a)) - h));
    // turns the motor for shooting balls on and off
    if (Robot.shooterSubsystem.isMotorOn()) {
      Robot.shooterSubsystem.stopMotor();
    } else {
      Robot.shooterSubsystem.startMotor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
