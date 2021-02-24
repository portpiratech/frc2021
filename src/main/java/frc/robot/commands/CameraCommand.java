/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.OI;
import frc.robot.Robot;

public class CameraCommand extends CommandBase {
  public CameraCommand() {
    addRequirements(Robot.cameraSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    // outputs values obtained from the camera
    Robot.cameraSubsystem.outputToSmartDashboard();
    // outputs distance calculation
    Robot.cameraSubsystem.getDistance();
    // outputs angle calculation
    // Robot.cameraSubsystem.getTargetAngle();
    // played with making the controller rumble
    /*
     * if(OI.driverController.getPOV() > -1){
     * OI.operatorController.setRumble(RumbleType.kLeftRumble, 1); }else{
     * OI.operatorController.setRumble(RumbleType.kLeftRumble, 0); }
     * if(OI.operatorController.getPOV() > -1){
     * OI.driverController.setRumble(RumbleType.kLeftRumble, 1); }else{
     * OI.driverController.setRumble(RumbleType.kLeftRumble, 0); }
     */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

}
