package org.firstinspires.ftc.teamcode.Piernas.Derecha;

import com.arcrobotics.ftclib.command.CommandBase;

public class comando_dereche extends CommandBase {
    private final pierna_derecha pierna_derecha;
    private final int pos;
    private final double pow;
    public comando_dereche(pierna_derecha pierna_derecha, int pos, double pow) {
        this.pierna_derecha = pierna_derecha;
        this.pos = pos;
        this.pow = pow;

        addRequirements(pierna_derecha);
    }
    @Override
    public void execute() {
        pierna_derecha.suvir_y_bajar_pie(pos,pow);
        pierna_derecha.suvir_y_bajar_pierna(pos,pow);
        pierna_derecha.suvir_y_bajar_rodilla(pos,pow);
        pierna_derecha.izq_der(pos,pow);
    }
    public boolean isFinished() {
        return pierna_derecha.isAtSetpoint_pie() && pierna_derecha.isAtSetpoint_y() && pierna_derecha.isAtSetpoint_rodilla() && pierna_derecha.isAtSetpoint_x();
    }
}
