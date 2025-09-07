// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.LauncherSubsystem;

public class ShootVerySlow extends Command {
  /** Creates a new ShootFast. */
  LauncherSubsystem m_launcher;

  public ShootVerySlow(LauncherSubsystem launcher) {
    m_launcher = launcher;
    addRequirements(m_launcher);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_launcher.shoot(Constants.LauncherConstants.speedVerySlow*Constants.LauncherConstants.leftSpeedMult, 
      Constants.LauncherConstants.speedVerySlow*Constants.LauncherConstants.rightSpeedMult);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
