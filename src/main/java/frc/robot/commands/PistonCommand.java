/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;

public class PistonCommand extends CommandBase {
  /**
   * Creates a new PistonCommand.
   */
  private boolean extended = false;
  private boolean finished = false;

  public PistonCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Extends and retracts piston for shifting gears
    if (extended) {
      RobotContainer.solenoid.retractLauncher();
      // Timer.delay(0.5);
    } else {
      RobotContainer.solenoid.extendLauncher();
      // Timer.delay(1.0);
    }
    extended = !extended;
    finished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
