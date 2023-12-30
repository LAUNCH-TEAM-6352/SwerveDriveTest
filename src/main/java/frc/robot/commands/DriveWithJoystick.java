package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveDriveSubsystem;

public class DriveWithJoystick extends CommandBase
{
    private final SwerveDriveSubsystem swerveDriveSubsystem;
    private final Joystick driverController;

    public DriveWithJoystick(SwerveDriveSubsystem swerveDriveSubsystem, Joystick driverController, boolean isFieldRelative)
    {
        this.swerveDriveSubsystem = swerveDriveSubsystem;
        this.driverController = driverController;

        // Specify subsystem dependencies (if any)
        addRequirements(swerveDriveSubsystem);
    }

    @Override
    public void initialize()
    {
        // Perform any initialization if needed
    }

    @Override
    public void execute()
    {
        // Get joystick inputs
        double joystickX = driverController.getX();
        double joystickY = -driverController.getY(); // Invert Y axis if needed
        double joystickRotation = driverController.getTwist();

        // Perform swerve drive calculations and set module speeds and angles
        swerveDriveSubsystem.drive(joystickX, joystickY, joystickRotation);
    }

    @Override
    public void end(boolean interrupted)
    {
        // Perform any actions when the command ends
    }

    @Override
    public boolean isFinished()
    {
        // This command is intended to run continuously during teleop
        return false;
    }
}
