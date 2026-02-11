package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.RainbowAnimation;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANdleSubsystem extends SubsystemBase {

    private final CANdle candle = new CANdle(10);

    public CANdleSubsystem() {
        CANdleConfiguration config = new CANdleConfiguration();
        config.brightnessScalar = 0.5;

        candle.configAllSettings(config);
        candle.setLEDs(0, 0, 0);
    }

    public void setColor(int r, int g, int b) {
        candle.clearAnimation(0);
        candle.setLEDs(r, g, b);
    }

    public void setRainbow() {
        RainbowAnimation rainbow = new RainbowAnimation(1.0, 0.5, 60);
        candle.animate(rainbow);
    }
}
