package org.firstinspires.ftc.teamcode.Brasos;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Brasos.derecho.braso_derecho;
import org.firstinspires.ftc.teamcode.Brasos.derecho.mano_derecha;
import org.firstinspires.ftc.teamcode.Brasos.izquierdo.brazo_izquierdo;
import org.firstinspires.ftc.teamcode.Brasos.izquierdo.mano_izquirda;

public class Movimiento extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx derecho = new GamepadEx(gamepad1);
        GamepadEx izquierdo = new GamepadEx(gamepad2);

        braso_derecho braso_derecho = new braso_derecho(hardwareMap,telemetry);
        mano_derecha mano_derecha = new mano_derecha(hardwareMap, telemetry);
        brazo_izquierdo brazo_izquierdo = new brazo_izquierdo(hardwareMap, telemetry);
        mano_izquirda mano_izquierdo = new mano_izquirda(hardwareMap, telemetry);

        //izquuerdo
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.A)
                .whenPressed(() -> brazo_izquierdo.hombro_x(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.Y)
                .whenPressed(() -> brazo_izquierdo.hombro_x(3000,-0.5));
        //izquierda
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.B)
                .whenPressed(() -> brazo_izquierdo.hombro_y(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.X)
                .whenPressed(() -> brazo_izquierdo.hombro_y(3000,-0.5));
        //izquierda
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_UP)
                .whenPressed(() -> brazo_izquierdo.codo(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(() -> brazo_izquierdo.codo(3000,-0.5));
        //servos
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_LEFT)
                .whenPressed(mano_izquierdo::arriba);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_RIGHT)
                .whenPressed(mano_izquierdo::abajo);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(mano_izquierdo::soltar);

        //izquierda
        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.A)
                .whenPressed(() -> braso_derecho.hombro_x(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.Y)
                .whenPressed(() -> braso_derecho.hombro_x(-3000,-0.5));
        //izquierda
        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.B)
                .whenPressed(() -> braso_derecho.hombro_y(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.X)
                .whenPressed(() -> braso_derecho.hombro_y(-3000,-0.5));
        //izquierda
        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.DPAD_UP)
                .whenPressed(() -> braso_derecho.codo(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(() -> braso_derecho.codo(3000,-0.5));
        //servos
        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.DPAD_LEFT)
                .whenPressed(mano_derecha::arriba);

        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.DPAD_RIGHT)
                .whenPressed(mano_derecha::abajo);

        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(mano_derecha::soltar);
    }
}
