package org.firstinspires.ftc.teamcode.cabesa;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class mover extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        cabesa cabesa = new cabesa(hardwareMap,telemetry);
        //controles
        //abajo
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.A)
                .whenPressed(() -> cabesa.abajo_arriba(3000,-0.5));
        //arriba
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.B)
                .whenPressed(() -> cabesa.abajo_arriba(3000,0.5));
        //derecha
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.X)
                .whenPressed(() -> cabesa.guirar(3000,-0.5));
        //izquierda
        new GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.Y)
                .whenPressed(() -> cabesa.guirar(3000,0.5));
        //muñeca
    }
}
