package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

public class SwerveDriveSubsystem extends SubsystemBase
{
    private SwerveDrive swerveDrive;

    public SwerveDriveSubsystem() throws IOException
    {
        double maximumSpeed = Units.feetToMeters(4.5);
        File swerveJsonDirectory = new File(Filesystem.getDeployDirectory(), "swerve");
        swerveDrive = new SwerveParser(swerveJsonDirectory).createSwerveDrive(maximumSpeed);

    }

    public void drive(Translation2d translation, double rotation, boolean fieldRelative)
    {
        // Open loop is disabled since it shouldn't be used most of the time.
        swerveDrive.drive(translation, rotation, fieldRelative, false);

    }

    /**
     * Drive the robot given a chassis field oriented velocity.
     *
     * @param velocity
     *            Velocity according to the field.
     */
    public void driveFieldOriented(ChassisSpeeds velocity)
    {
        swerveDrive.driveFieldOriented(velocity);
    }

    /**
     * Drive according to the chassis robot oriented velocity.
     *
     * @param velocity
     *            Robot oriented {@link ChassisSpeeds}
     */
    public void drive(ChassisSpeeds velocity)
    {
        swerveDrive.drive(velocity);
    }

}
