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

      brazo_izquierdo brazo_izquierdo = new brazo_izquierdo(hardwareMap, telemetry);
        mano_izquirda mano_izquierdo = new mano_izquirda(hardwareMap, telemetry);
        //izquierda
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

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_LEFT)
                .whenPressed(mano_izquierdo::arriba);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_RIGHT)
                .whenPressed(mano_izquierdo::abajo);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(mano_izquierdo::soltar);
    }
}