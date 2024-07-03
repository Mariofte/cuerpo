package org.firstinspires.ftc.teamcode.torzo;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

public class mover extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        torzo torzo = new torzo(hardwareMap,telemetry);
        //izquierda
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.A)
                .whenPressed(() -> torzo.girar(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.B)
                .whenPressed(() -> torzo.girar(3000,-0.5));
        //adelante
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.X)
                .whenPressed(() -> torzo.adelante_atras(3000,0.5));
        //atras
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.Y)
                .whenPressed(() -> torzo.adelante_atras(3000,-0.5));
    }
}
