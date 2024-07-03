package org.firstinspires.ftc.teamcode.cabesa;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class cabesa extends SubsystemBase {
    private final DcMotorEx girar_cuello, cuello_arriba_abajo;
    private final ServoEx ojoder, ojoizq, bocader, bocaizq;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    public cabesa (HardwareMap hardwareMap, Telemetry telemetry){
        //paremetros
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        //inicializar y hardware
        //girar_cuello
        girar_cuello = hardwareMap.get(DcMotorEx.class, "girar_cuello");
        girar_cuello.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        girar_cuello.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        girar_cuello.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        //cuello_arriba_abajo
        cuello_arriba_abajo = hardwareMap.get(DcMotorEx.class, "cuello_arriba_abajo");
        cuello_arriba_abajo.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        cuello_arriba_abajo.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        cuello_arriba_abajo.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        //servos
        ojoder = new SimpleServo(
                hardwareMap, "ojoder", 0, 180, AngleUnit.DEGREES);
        ojoder.setInverted(true);
        ojoizq = new SimpleServo(
                hardwareMap, "ojoizq", 0, 180, AngleUnit.DEGREES);
        ojoizq.setInverted(false);
        bocader = new SimpleServo(
                hardwareMap, "bocader", 0, 180, AngleUnit.DEGREES);
        bocader.setInverted(true);
        bocaizq = new SimpleServo(
                hardwareMap, "bocaizq", 0, 180, AngleUnit.DEGREES);
        bocaizq.setInverted(false);
    }
    public void guirar(int pos,double pow){
        girar_cuello.setPower(pow);
        girar_cuello.setTargetPosition(pos);
        girar_cuello.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
    public void abajo_arriba(int pos,double pow){
        cuello_arriba_abajo.setPower(pow);
        cuello_arriba_abajo.setTargetPosition(pos);
        cuello_arriba_abajo.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
    public void cerrar_boca(){
        bocader.turnToAngle(50);
        bocaizq.turnToAngle(50);
    }
    public void abrir_boca(){
        bocader.turnToAngle(150);
        bocaizq.turnToAngle(150);
    }
    public boolean isAtSetpoint_cuello(){
        boolean isAtPosition_cuello = girar_cuello.getCurrentPosition() - girar_cuello.getTargetPosition() < girar_cuello.getTargetPositionTolerance();
        return  isAtPosition_cuello;
    }
    public boolean isAtSetpoint_arriba_abajo(){
        boolean isAtPosition_arriba_abajo = cuello_arriba_abajo.getCurrentPosition() - cuello_arriba_abajo.getTargetPosition() < cuello_arriba_abajo.getTargetPositionTolerance();
        return  isAtPosition_arriba_abajo;
    }
    @Override
    public void periodic(){
        telemetry.addData("girar", girar_cuello.getCurrentPosition());
        telemetry.addData("arriba_abajo", cuello_arriba_abajo.getCurrentPosition());
        telemetry.update();
    }
}