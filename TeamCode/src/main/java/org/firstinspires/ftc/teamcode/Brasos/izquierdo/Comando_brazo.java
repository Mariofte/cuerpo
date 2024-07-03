package org.firstinspires.ftc.teamcode.Brasos.izquierdo;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Brasos.derecho.braso_derecho;

public class Comando_brazo extends CommandBase {
    private final braso_derecho brazo;
    private final int pos;
    private final double pow;
    public Comando_brazo(braso_derecho brazo, int pos, double pow) {
        this.brazo = brazo;
        this.pos = pos;
        this.pow = pow;
    }
    @Override
    public void execute() {
        brazo.hombro_x(pos, pow);
        brazo.hombro_y(pos, pow);
        brazo.codo(pos, pow);
    }
    @Override
    public boolean isFinished() {
        return brazo.isAtSetpoint_codo() && brazo.isAtSetpoint_y() && brazo.isAtSetpoint_x();
    }
}
