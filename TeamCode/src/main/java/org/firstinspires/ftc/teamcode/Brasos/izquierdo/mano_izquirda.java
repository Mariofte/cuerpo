package org.firstinspires.ftc.teamcode.Brasos.izquierdo;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SensorDistance;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class mano_izquirda extends SubsystemBase {
    private final ServoEx mueca_der,mueca_izq,dedo1,dedo2,dedo3,dedo4,dedo5;
    private SensorDistance sensor;
    private final HardwareMap hardwareMap;
    private Telemetry telemetry;
    public mano_izquirda(HardwareMap hardwareMap) {
        //parameters
        this.hardwareMap = hardwareMap;
        //servos
        mueca_der = new SimpleServo(
                hardwareMap, "ojoder", 0, 180, AngleUnit.DEGREES);
        mueca_der.setInverted(true);
        mueca_izq = new SimpleServo(
                hardwareMap, "ojoder", 0, 180, AngleUnit.DEGREES);
        mueca_izq.setInverted(false);
        dedo1 = new SimpleServo(
                hardwareMap, "dedo1", 0, 180, AngleUnit.DEGREES);
        dedo1.setInverted(true);
        dedo2 = new SimpleServo(
                hardwareMap, "dedo2", 0, 180, AngleUnit.DEGREES);
        dedo2.setInverted(true);
        dedo3 = new SimpleServo(
                hardwareMap, "dedo3", 0, 180, AngleUnit.DEGREES);
        dedo3.setInverted(true);
        dedo4 = new SimpleServo(
                hardwareMap, "dedo4", 0, 180, AngleUnit.DEGREES);
        dedo4.setInverted(true);
        dedo5 = new SimpleServo(
                hardwareMap, "dedo5", 0, 180, AngleUnit.DEGREES);
        dedo5.setInverted(true);
    }
    public boolean getSensor(){
        return sensor.getDistance(DistanceUnit.MM) < 9;
    }
    public void arriba(){
        mueca_der.turnToAngle(90);
        mueca_izq.turnToAngle(90);
    }
    public void abajo(){
        mueca_der.turnToAngle(10);
        mueca_izq.turnToAngle(10);
    }
    public void agarrar(){
        dedo1.turnToAngle(90);
        dedo2.turnToAngle(90);
        dedo3.turnToAngle(90);
        dedo4.turnToAngle(90);
        dedo5.turnToAngle(90);
    }
    public void soltar(){
        dedo1.turnToAngle(10);
        dedo2.turnToAngle(10);
        dedo3.turnToAngle(10);
        dedo4.turnToAngle(10);
        dedo5.turnToAngle(10);
    }
    @Override
    public void periodic() {
        telemetry.addData("Sensor", getSensor());
        telemetry.update();
    }
}
