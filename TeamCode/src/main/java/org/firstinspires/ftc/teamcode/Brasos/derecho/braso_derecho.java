package org.firstinspires.ftc.teamcode.Brasos.derecho;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class braso_derecho extends SubsystemBase {
    private final DcMotorEx y,x,codo;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    public braso_derecho(HardwareMap hardwareMap, Telemetry telemetry) {
        //parameters
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        //inicilizar y haedware
        //y
        y = hardwareMap.get(DcMotorEx.class, "y");
        y.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        y.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        y.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        //x
        x = hardwareMap.get(DcMotorEx.class, "x");
        x.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        x.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        x.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        //codo
        codo = hardwareMap.get(DcMotorEx.class, "codo");
        codo.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        codo.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        codo.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void hombro_y(int pos , double pow){
        y.setPower(pow);
        y.setTargetPosition(pos);
        y.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void hombro_x(int pos , double pow){
        x.setPower(pow);
        x.setTargetPosition(pos);
        x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void codo(int pos , double pow){
        codo.setPower(pow);
        codo.setTargetPosition(pos);
        codo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public boolean isAtSetpoint_codo(){
        boolean isAtPosition_codo = codo.getCurrentPosition() - codo.getTargetPosition() < codo.getTargetPositionTolerance();
        return  isAtPosition_codo;
    }
    public boolean isAtSetpoint_y(){
        boolean isAtPosition_y = y.getCurrentPosition() - y.getTargetPosition() < y.getTargetPositionTolerance();
        return  isAtPosition_y;
    }

    public boolean isAtSetpoint_x(){
        boolean isAtPosition_x = x.getCurrentPosition() - x.getTargetPosition() < x.getTargetPositionTolerance();
        return  isAtPosition_x;
    }
    @Override
    public void periodic() {
        telemetry.addData("y", y.getCurrentPosition());
        telemetry.addData("x", x.getCurrentPosition());
        telemetry.addData("codo", codo.getCurrentPosition());
        telemetry.update();
    }
}