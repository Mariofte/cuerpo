package org.firstinspires.ftc.teamcode.Piernas.Izquierda;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class pierna_izquierda extends SubsystemBase {
    private final DcMotorEx y,x,rodilla,pie;
    private final ServoEx levantar1,levantar2;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    public pierna_izquierda( HardwareMap hardwareMap, Telemetry telemetry) {
        //paraeters
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        //hardware y inicialisar
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
        //rodilla
        rodilla = hardwareMap.get(DcMotorEx.class, "rodilla");
        rodilla.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rodilla.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rodilla.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        //pie
        pie = hardwareMap.get(DcMotorEx.class, "pie");
        pie.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        pie.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        pie.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        //levantar
        //1
        levantar1 = new SimpleServo(
                hardwareMap, "ojoder", 0, 180, AngleUnit.DEGREES);
        levantar1.setInverted(true);
        //2
        levantar2 = new SimpleServo(
                hardwareMap, "ojoder2", 0, 180, AngleUnit.DEGREES);
        levantar2.setInverted(false);
    }
    public void vajar (){
        levantar1.turnToAngle(40);
        levantar2.turnToAngle(40);
    }
    public void subir (){
        levantar1.turnToAngle(100);
        levantar2.turnToAngle(100);
    }
    public void suvir_y_bajar_pierna(int pos,double pow){
        y.setPower(pow);
        y.setTargetPosition(pos);
        y.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void suvir_y_bajar_rodilla(int pos,double pow){
        rodilla.setPower(pow);
        rodilla.setTargetPosition(pos);
        rodilla.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void suvir_y_bajar_pie(int pos,double pow) {
        pie.setPower(pow);
        pie.setTargetPosition(pos);
        pie.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void izq_der(int pos,double pow){
        x.setPower(pow);
        x.setTargetPosition(pos);
        x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public boolean isAtSetpoint_y(){
        boolean isAtSetpoint_y = y.getCurrentPosition() - y.getTargetPosition() < y.getTargetPositionTolerance();
        return isAtSetpoint_y;
    }
    public boolean isAtSetpoint_x(){
        boolean isAtSetpoint_x = x.getCurrentPosition() - x.getTargetPosition() < x.getTargetPositionTolerance();
        return isAtSetpoint_x;
    }
    public boolean isAtSetpoint_rodilla() {
        boolean isAtSetpoint_rodilla = rodilla.getCurrentPosition() - rodilla.getTargetPosition() < rodilla.getTargetPositionTolerance();
        return isAtSetpoint_rodilla;
    }
    public boolean isAtSetpoint_pie() {
        boolean isAtSetpoint_pie = pie.getCurrentPosition() - pie.getTargetPosition() < pie.getTargetPositionTolerance();
        return isAtSetpoint_pie;
    }
    @Override
    public void periodic() {
        telemetry.addData("y_izq", y.getCurrentPosition());
        telemetry.addData("x_izq", x.getCurrentPosition());
        telemetry.addData("rodilla_izq", rodilla.getCurrentPosition());
        telemetry.addData("pie_izq", pie.getCurrentPosition());
    }
}
