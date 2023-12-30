package frc.robot.subsystems;

import frc.robot.commands.DriveCommand;

public class SwerveDrive {
    private SwerveModule[] modules;

    public SwerveDrive() {
        modules = new SwerveModule[] {
        /* The numbers below are just for testing and to remove errors,
        should be changed later */ 
            new SwerveModule(0, 0),
            new SwerveModule(1, 1),
            new SwerveModule(2, 2),
            new SwerveModule(3, 3)
        };
    }

    public void drive(double forward, double strafe, double rotation) {
        // Calculate individual module speeds and angles based on input
        // Apply the calculated speeds and angles to each module
        for (int i = 0; i < modules.length; i++) {
            SwerveModule module = modules[i];
            double moduleSpeed = Math.sqrt(forward * forward + strafe * strafe);
            double moduleAngle = rotation;
            module.set(moduleSpeed, moduleAngle);
        }
    }

    public void setDefaultCommand(DriveCommand driveCommand) {
    }
}
