package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SwerveModule {
    private CANSparkMax translationMotor;  // Spark MAX for controlling translation
    private CANSparkMax rotationMotor;     // Spark MAX for controlling rotation
    private RelativeEncoder rotationEncoder;    // Encoder for measuring rotation angle
    private double previousAngle;          // Previous angle for calculating rotation changes

    // Constructor for initializing the swerve module with Spark MAX controllers
    public SwerveModule(int translationMotorID, int rotationMotorID) {
        translationMotor = new CANSparkMax(translationMotorID, MotorType.kBrushless);
        rotationMotor = new CANSparkMax(rotationMotorID, MotorType.kBrushless);
        rotationEncoder = rotationMotor.getEncoder();
        
        // Additional configuration, if needed
        configureMotorControllers();
        
        this.previousAngle = 0.0;
    }

    // Set the speed and angle of the swerve module
    public void set(double speed, double angle) {
        double deltaAngle = angle - previousAngle;
        rotationMotor.set(deltaAngle);
        translationMotor.set(speed);
        previousAngle = angle;
    }

    // Additional methods for getting sensor readings, resetting encoders, etc.
    public double getRotationAngle() {
        return rotationEncoder.getPosition();
    }

    public void resetRotationEncoder() {
        rotationEncoder.setPosition(0);
    }

    // Additional method for configuring Spark MAX controllers
    private void configureMotorControllers() {
        // You may need to set control modes, PID parameters, etc.
        // Refer to the Spark MAX documentation for configuration details.
    }
}
