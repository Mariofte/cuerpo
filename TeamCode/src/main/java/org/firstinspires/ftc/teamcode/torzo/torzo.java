package org.firstinspires.ftc.teamcode.torzo;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class torzo extends SubsystemBase {
    private final DcMotorEx girar, der, izq;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    public torzo(HardwareMap hardwareMap, Telemetry telemetry){
        //parametros
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        //inicializar y hardware
        //girar
        girar = hardwareMap.get(DcMotorEx.class, "girar");
        girar.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        girar.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        girar.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //derecha
        der = hardwareMap.get(DcMotorEx.class, "der");
        der.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        der.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        der.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //izquierda
        izq = hardwareMap.get(DcMotorEx.class, "izq");
        izq.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        izq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        izq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void adelante_atras(int pos, double pow){
        //derecha
        der.setPower(pow);
        der.setTargetPosition(pos);
        der.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //izquierdo
        izq.setPower(pow);
        izq.setTargetPosition(pos);
        izq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void girar(int pos, double pow){
        //girar
        girar.setPower(pow);
        girar.setTargetPosition(pos);
        girar.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public boolean isAtSetpoint_girar(){
        boolean isAtPosition_cuello = girar.getCurrentPosition() - girar.getTargetPosition() < girar.getTargetPositionTolerance();
        return  isAtPosition_cuello;
    }
    public boolean isAtSetpoint_der(){
        boolean isAtPosition_cuello = der.getCurrentPosition() - der.getTargetPosition() < der.getTargetPositionTolerance();
        return  isAtPosition_cuello;
    }

    public boolean isAtSetpoint_izq(){
        boolean isAtPosition_cuello = izq.getCurrentPosition() - izq.getTargetPosition() < izq.getTargetPositionTolerance();
        return  isAtPosition_cuello;
    }
    @Override
    public void periodic() {
        telemetry.addData("girar", girar.getCurrentPosition());
        telemetry.addData("der", der.getCurrentPosition());
        telemetry.addData("izq", izq.getCurrentPosition());
        telemetry.update();
    }
}
