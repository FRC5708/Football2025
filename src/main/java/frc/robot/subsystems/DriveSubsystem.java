// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final VictorSPX m_leftMotor1 = new VictorSPX(1);
  private final VictorSPX m_leftMotor2 = new VictorSPX(2);
  private final VictorSPX m_rightMotor3 = new VictorSPX(3);
  private final VictorSPX m_rightMotor4 = new VictorSPX(4);
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {}

  @Override
  public void periodic() {}
    // This method will be called once per scheduler run
  public void drive(double left, double right) {
    m_leftMotor1.set(ControlMode.PercentOutput, -Math.pow(left, 3));
    m_leftMotor2.set(ControlMode.PercentOutput, -Math.pow(left, 3)); //old follower wheel
    m_rightMotor3.set(ControlMode.PercentOutput, Math.pow(right, 3));
    m_rightMotor4.set(ControlMode.PercentOutput, Math.pow(right, 3)); //old follower wheel 
  }
}
