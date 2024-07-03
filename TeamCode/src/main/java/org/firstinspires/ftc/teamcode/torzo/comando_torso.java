package org.firstinspires.ftc.teamcode.torzo;

import com.arcrobotics.ftclib.command.CommandBase;

public class comando_torso extends CommandBase {
    private final torzo torzo;
    private final int pos;
    private final double pow;
    public comando_torso(torzo torzo, int pos, double pow) {
        this.torzo = torzo;
        this.pos = pos;
        this.pow = pow;

        addRequirements(torzo);
    }
    @Override
    public void execute() {
        torzo.adelante_atras(pos,pow);
        torzo.girar(pos,pow);
    }
    @Override
    public boolean isFinished(){
        return  torzo.isAtSetpoint_girar() && torzo.isAtSetpoint_der() && torzo.isAtSetpoint_izq();
    }
}
