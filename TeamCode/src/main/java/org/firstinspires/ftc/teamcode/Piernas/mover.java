package org.firstinspires.ftc.teamcode.Piernas;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Piernas.Derecha.pierna_derecha;
import org.firstinspires.ftc.teamcode.Piernas.Isquierda.pierna_izquierda;


public class mover extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);


        pierna_izquierda pierna_izquierda = new pierna_izquierda(hardwareMap,telemetry);
        pierna_derecha pierna_derecha = new pierna_derecha(hardwareMap,telemetry);

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.A)
                .whenPressed(() -> pierna_derecha.suvir_y_bajar_pierna(3000,0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.Y)
                .whenPressed(() -> pierna_derecha.suvir_y_bajar_pierna(3000,-0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.B)
                .whenPressed(() -> pierna_izquierda.suvir_y_bajar_pierna(3000,0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.X)
                .whenPressed(() -> pierna_izquierda.suvir_y_bajar_pierna(3000,-0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_UP)
                .whenPressed(() -> pierna_derecha.suvir_y_bajar_rodilla(3000,0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(() -> pierna_derecha.suvir_y_bajar_rodilla(3000,-0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_LEFT)
                .whenPressed(() -> pierna_izquierda.suvir_y_bajar_rodilla(3000,0.5));

        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_RIGHT)
                .whenPressed(() -> pierna_izquierda.suvir_y_bajar_rodilla(3000,-0.5));
    }
}
