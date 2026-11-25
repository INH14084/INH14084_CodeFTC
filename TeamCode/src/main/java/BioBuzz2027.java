import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

public class BioBuzz2027 extends OpMode {
    // Ryan was here to run a test

    // Drive Motors
    DcMotor FrontLeftDrive;
    DcMotor BackLeftDrive;
    DcMotor FrontRightDrive;
    DcMotor BackRightDrive;

    IMU imu;
@Override
    public void init(){
        FrontLeftDrive = hardwareMap.get(DcMotor.class, "front_left_drive");
        BackLeftDrive = hardwareMap.get(DcMotor.class, "back_left_drive");
        FrontRightDrive = hardwareMap.get(DcMotor.class, "front_right_drive");
        BackRightDrive = hardwareMap.get(DcMotor.class, "front_right_drive");

        BackLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        FrontLeftDrive.setDirection(DcMotor.Direction.REVERSE);

        // Are we going to use encoders? We could use them to set a posssition for the bot.
        FrontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Change IMU to match Robot
        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection =
                RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection usbDirection =
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;

        RevHubOrientationOnRobot orientationOnRobot = new
                RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
    }

    @Override
    public void loop() {

    }
}
