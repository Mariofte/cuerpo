package org.firstinspires.ftc.teamcode.Brasos.izquierdo;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.Brasos.derecho.mano_derecha;

public class Comando_de_sensor_izq extends SequentialCommandGroup {
    private mano_izquirda sensor;
    public Comando_de_sensor_izq(mano_izquirda sensor) {
     this.sensor = sensor;

        addCommands(
                new WaitUntilCommand(sensor::getSensor),
                new WaitCommand(500),
                new InstantCommand(sensor::agarrar)
                );
    }
}
