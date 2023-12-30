// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.SwerveDrive;

public class RobotContainer {
    private final SwerveDrive swerveDriveSubsystem = new SwerveDrive();
    private final Joystick driverController = new Joystick(0);

    public RobotContainer() {
        // Configure default command for the swerve drive subsystem
        swerveDriveSubsystem.setDefaultCommand(new DriveCommand(swerveDriveSubsystem, driverController));

        configureBindings();

    }

    // Getter for accessing the swerve drive subsystem
    public SwerveDrive getSwerveDriveSubsystem() {
        return swerveDriveSubsystem;
    }

  private void configureBindings() {
    /* Bind commands to buttons (example)
    JoystickButton exampleButton = new JoystickButton(driverController, 1);
    exampleButton.whenPressed(new ExampleCommand()); // Replace with your actual command
    */ 
    // Additional configuration...
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
