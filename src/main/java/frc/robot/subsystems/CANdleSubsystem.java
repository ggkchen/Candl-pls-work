package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.configs.CANdleConfiguration;
import com.ctre.phoenix6.controls.SolidColor;
import com.ctre.phoenix6.controls.RainbowAnimation;
import com.ctre.phoenix6.signals.RGBWColor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANdleSubsystem extends SubsystemBase {

    private static final int LED_START = 0;
    private static final int LED_END = 59;

    private final CANdle candle = new CANdle(10);

    public CANdleSubsystem() {
        CANdleConfiguration config = new CANdleConfiguration();
        config.LED.BrightnessScalar = 0.5;
        candle.getConfigurator().apply(config);
    }

    public void setColor(int r, int g, int b) {
        candle.setControl(new SolidColor(LED_START, LED_END)
                .withColor(new RGBWColor(r, g, b)));
    }

    public void setRainbow() {
        candle.setControl(new RainbowAnimation(LED_START, LED_END)
                .withBrightness(1.0));
    }
}
