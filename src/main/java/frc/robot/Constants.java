// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static int driverControllerId = 0;
  public static int operatorControllerId = 1;
  
  public static double driveSpeedMultiplier = 0.6;
  public static double deadband = 0.1;
  public static int leftSparkMaxID1 = 5;
  public static int leftSparkMaxID2 = 6;
  public static int rightSparkMaxID1 = 3;
  public static int rightSparkMaxID2 = 4;

  public static final int PCM_ID = 1; // Compressor/Pneumatics Control Module (used for DoubleSolenoids)
  public static int shifterSolenoidPort1Left = 0; // DoubleSolenoid
  public static int shifterSolenoidPort2Left = 1; // DoubleSolenoid
  public static int shifterSolenoidPort1Right = 2; // DoubleSolenoid
  public static int shifterSolenoidPort2Right = 3; // DoubleSolenoid

  public static int PUOBMotorID = 2;
}
