package org.firstinspires.ftc.teamcode.Brasos.izquierdo;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Brasos.derecho.braso_derecho;
import org.firstinspires.ftc.teamcode.Brasos.derecho.mano_derecha;

public class mover_izquierdo extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        braso_derecho braso_izquierdo= new braso_derecho(hardwareMap,telemetry);
        mano_derecha mano_izquierdo = new mano_derecha(hardwareMap);
        //izquierda
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.A)
                .whenPressed(() -> braso_izquierdo.hombro_x(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.Y)
                .whenPressed(() -> braso_izquierdo.hombro_x(3000,-0.5));
        //izquierda
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.B)
                .whenPressed(() -> braso_izquierdo.hombro_y(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.X)
                .whenPressed(() -> braso_izquierdo.hombro_y(3000,-0.5));
        //izquierda
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_UP)
                .whenPressed(() -> braso_izquierdo.codo(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(() -> braso_izquierdo.codo(3000,-0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_LEFT)
                .whenPressed(mano_izquierdo::arriba);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_RIGHT)
                .whenPressed(mano_izquierdo::abajo);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(mano_izquierdo::soltar);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(mano_izquierdo::agarrar);

    }
}