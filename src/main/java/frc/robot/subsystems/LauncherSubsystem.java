// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;

//import com.revrobotics.spark.SparkMax;
//import com.revrobotics.spark.SparkLowLevel.MotorType;

public class LauncherSubsystem extends SubsystemBase {
  /** Creates a new LauncherSubsystem. */
  private final TalonSRX m_leftShooter = new TalonSRX (5);
  private final TalonSRX m_rightShooter = new TalonSRX (6);
  //public final SparkMax m_testMotor = new SparkMax(32, MotorType.kBrushless);
  //private final VictorSPX m_leftShooterAngle = new VictorSPX(18);
  //private final VictorSPX m_rightShooterAngle = new VictorSPX(7);

  public LauncherSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double powerRight, double powerLeft) {
    m_leftShooter.set(ControlMode.PercentOutput,-powerRight);
    m_rightShooter.set(ControlMode.PercentOutput,-powerLeft);//changed by george
    //m_testMotor.set(0);
  }

  // public void testMotor() {
  //   m_testMotor.set(.20);
  //   System.out.println("yippie");
  // }


  public void autoShoot(String speed) {
    
  }

}
