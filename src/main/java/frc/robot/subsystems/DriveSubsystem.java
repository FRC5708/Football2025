// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final VictorSPX m_leftMotor1 = new VictorSPX(1);
  private final VictorSPX m_leftMotor2 = new VictorSPX(2);
  private final VictorSPX m_rightMotor3 = new VictorSPX(3);
  private final VictorSPX m_rightMotor4 = new VictorSPX(4);
  //private static final double ramprate = .5;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {}

  @Override
  public void periodic() {}
  // This method will be called once per scheduler run
  public void drive(double speed, double rotation) {
    speed = Math.pow(speed, 3);

    double leftSpeed = speed;
    double rightSpeed = speed;
    double differenceOfRot = 0;

    //detects if the driver wants to turn and which side, can also account for joystick not being perfectly zero-ed
    if (-.05 < rotation && rotation < .05){
      rotation = 0;
    }
    else if (-.05 < speed && speed < .05){
      rotation = Math.pow(rotation, 3);
      leftSpeed = -rotation;
      rightSpeed = rotation;
    }
    else {
      differenceOfRot = 1-Math.abs(rotation);
      if (rotation < 0){
        leftSpeed *= differenceOfRot;
      }
      else if (rotation > 0){
        rightSpeed *= differenceOfRot;
      }
    }

    SmartDashboard.putNumber("left speed",leftSpeed);
    SmartDashboard.putNumber("right speed", rightSpeed);
    SmartDashboard.putNumber("rotation value", rotation);
    SmartDashboard.putNumber("difference of Rot", differenceOfRot);
    
    m_leftMotor1.set(ControlMode.PercentOutput, -leftSpeed);
    m_leftMotor2.set(ControlMode.PercentOutput, -leftSpeed); //old follower wheel
    m_rightMotor3.set(ControlMode.PercentOutput, rightSpeed);
    m_rightMotor4.set(ControlMode.PercentOutput, rightSpeed); //old follower wheel 
  }
}