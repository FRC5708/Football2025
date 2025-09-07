// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.defaultDrive;
import frc.robot.commands.ShootVeryFast;
import frc.robot.commands.ShootFast;
import frc.robot.commands.ShootMedium;
import frc.robot.commands.ShootSlow;
import frc.robot.commands.ShootVerySlow;
//import frc.robot.commands.testMotor;
import frc.robot.commands.actuatorIn;
import frc.robot.commands.actuatorOut;
import frc.robot.commands.ShootStop;
import frc.robot.subsystems.AutoLoader;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bul`k of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_drive;
  private final LauncherSubsystem m_launcher;
  private final AutoLoader m_autoLoader;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    m_drive = new DriveSubsystem();
    m_launcher = new LauncherSubsystem();
    m_autoLoader = new AutoLoader();
    m_drive.setDefaultCommand(new defaultDrive(m_drive, m_driverController::getRightY, m_driverController::getLeftX));
    m_launcher.setDefaultCommand(new ShootStop(m_launcher));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
    /*private ShuffleboardTab tab = Shuffleboard.getTab("Drive");
   private GenericEntry maxSpeed =
      tab.add("Max Speed", 1)
         .getEntry(); */

  private void configureBindings() {
    //m_driverController.a().whileTrue(new ShootFast(m_launcher));
    m_driverController.b().whileTrue(new ShootMedium(m_launcher));
    m_driverController.y().whileTrue(new ShootSlow(m_launcher));
    m_driverController.x().whileTrue(new ShootVerySlow(m_launcher));
    m_driverController.a().whileTrue(new ShootFast(m_launcher));

    m_driverController.leftTrigger().whileTrue(new actuatorIn(m_autoLoader));
    m_driverController.rightTrigger().whileTrue(new actuatorOut(m_autoLoader));

    //m_driverController.rightTrigger().whileTrue(new testMotor(m_launcher));

    m_driverController.povDown().whileTrue(new ShootVeryFast(m_launcher));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
