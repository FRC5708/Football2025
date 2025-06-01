package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AutoLoader extends SubsystemBase {
    private Servo m_babyActuator;

    public AutoLoader() {
        m_babyActuator = new Servo(1);
        m_babyActuator.setBoundsMicroseconds(2000, 1800, 1500, 1200, 1000);
    }

    public void actuatorOut() {
        m_babyActuator.set(.82);
    }

    public void actuatorIn() {
        m_babyActuator.set(.17);
    }
}



//