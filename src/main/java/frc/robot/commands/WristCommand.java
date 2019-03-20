/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class WristCommand extends Command {
  boolean manualMode;
  public WristCommand() {
    requires(Robot.wristSubsystem);
    manualMode = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double output = 0.2*OI.getWrist();
    //TODO Wrist PID
    /*SmartDashboard.putNumber("Wrist rot", RobotMap.wristEncoder.get());
    SmartDashboard.putNumber("Wrist angle", Math.toDegrees(Robot.wristSubsystem.getAngle()));
    if(output != 0){
      if(!manualMode){
        manualMode = true;
        Robot.wristPID.disable();
      }*/
      Robot.wristSubsystem.rotate(output);
    //}
    /*if(Robot.wristPID.getPIDController().isEnabled()){
      Robot.wristPID.setSetpoint(Robot.wristSubsystem.angleToSensorUnit(Robot.armSubsystem.getAngle()));
    }*/
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
