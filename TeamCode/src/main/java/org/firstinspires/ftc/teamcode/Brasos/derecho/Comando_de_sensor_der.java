package org.firstinspires.ftc.teamcode.Brasos.derecho;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

public class Comando_de_sensor_der extends SequentialCommandGroup {
    private mano_derecha sensor;
    public Comando_de_sensor_der(mano_derecha sensor) {
        this.sensor = sensor;

        addCommands(
                new WaitUntilCommand(sensor::getSensor),
                new WaitCommand(500),
                new InstantCommand(sensor::agarrar)
        );
    }
}
