package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AutoLoader;

public class actuatorOut extends Command {
  /** Creates a new ShootFast. */
  AutoLoader m_autoLoader;

  public actuatorOut(AutoLoader autoLoader) {
    m_autoLoader = autoLoader;
    addRequirements(m_autoLoader);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_autoLoader.actuatorOut();
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

