/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Robot;
// import frc.robot.RobotMap;

/**
 * Add your docs here.
 */

public class CameraSubsystem extends SubsystemBase {

    // private double angleRange = 0.5;
    private double minAngle = 0;
    private double maxAngle = Math.PI / 2;
    NetworkTable table;
    private double cameraAngle = 0;
    private double targetHeight = 2.49555;
    private double cameraHeight = 1.1811;

    public CameraSubsystem() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }
    // Returns minAngle.
    public double getMinAngle() {
        return minAngle;
    }
    // Returns maxAngle.
    public double getMaxAngle() {
        return maxAngle;
    }
    // Prints camera values.
    public void outputToSmartDashboard() {
        NetworkTableEntry tv = table.getEntry("tv");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        double v = tv.getDouble(0.0);
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);

        SmartDashboard.putNumber("Has Target", v);
        SmartDashboard.putNumber("Degrees from target (X)", x);
        SmartDashboard.putNumber("Degrees from target (Y)", y);
        SmartDashboard.putNumber("Percentage of target", area);
    }
    // Sets camera mode.
    public void setCamMode(int mode) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(mode);
    }
    // Checks if the camera has a target.
    public boolean hasTarget() {
        NetworkTableEntry ta = table.getEntry("ta");
        double a = ta.getDouble(0.0);
        return a >= 0.1;
    }
    // Returns the angle from the center of the camera to the center of the target.
    public double getXAngle() {
        NetworkTableEntry tx = table.getEntry("tx");
        double x = tx.getDouble(0.0);
        return x;
    }
    // Returns the angle from the center of the camera to the top of the target.
    public double getYAngle() {
        NetworkTableEntry ty = table.getEntry("ty");
        double y = ty.getDouble(0.0);
        return y;
    }
    // Based on the angle finds the distance from the camera to the target.
    public double getDistance() {
        double angle = Math.toRadians(cameraAngle + getYAngle());
        double heightChange = targetHeight - cameraHeight;
        double distance = (heightChange / (Math.tan(angle)));
        SmartDashboard.putNumber("Distance", distance);
        return distance;
    }
    // Test to point the shooter directly at the target.
    // public double getTargetAngleTest() {
    //     return Math.atan((targetHeight - cameraHeight + 0.254) / (getDistance() + 0.6731));
    // }
    // Returns the target angle based on distance equations.
    // public double getTargetAngle() {
    //     double d = getDistance();
    //     double v = RobotMap.velocity;
    //     double h = targetHeight - cameraHeight;
    //     double w = (-9.8 * Math.pow(d, 2)) / Math.pow(v, 2);
    //     double ans = Math.atan((-d + Math.sqrt(Math.pow(d, 2) + 2 * w * h - Math.pow(w, 2))) / w);
    //     SmartDashboard.putNumber("Target angle", ans);
    //     if(Robot.turretSubsystem.isHighGoal()){
    //         return ans;
    //     }else{
    //         return 0;
    //     }
        
    // }
    // Returns whether or not the shot is viable.
    // public boolean shotViable() {
    //     return hasTarget() && !Double.isNaN(getTargetAngle()) && getTargetAngle() >= minAngle
    //             && getTargetAngle() <= maxAngle && getYAngle() > getTargetAngle() - angleRange
    //             && getYAngle() < getTargetAngle() + angleRange;
    // }
}
