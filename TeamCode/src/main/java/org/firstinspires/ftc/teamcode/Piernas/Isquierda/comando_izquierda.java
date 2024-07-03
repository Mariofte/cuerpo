package org.firstinspires.ftc.teamcode.Piernas.Isquierda;

import com.arcrobotics.ftclib.command.CommandBase;

public class comando_izquierda extends CommandBase {
    private final pierna_izquierda pierna_izquierda;
    private final int pos;
    private final double pow;
    public comando_izquierda(pierna_izquierda pierna_izquierda, int pos, double pow) {
        this.pierna_izquierda = pierna_izquierda;
        this.pos = pos;
        this.pow = pow;
    }
    @Override
    public void execute() {
        pierna_izquierda.suvir_y_bajar_pie(pos,pow);
        pierna_izquierda.suvir_y_bajar_pierna(pos,pow);
        pierna_izquierda.suvir_y_bajar_rodilla(pos,pow);
        pierna_izquierda.izq_der(pos,pow);
    }
    public boolean isFinished() {
        return pierna_izquierda.isAtSetpoint_pie() && pierna_izquierda.isAtSetpoint_y() && pierna_izquierda.isAtSetpoint_rodilla() && pierna_izquierda.isAtSetpoint_x();
    }
}
