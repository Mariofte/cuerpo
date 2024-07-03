package org.firstinspires.ftc.teamcode.cabesa;

import com.arcrobotics.ftclib.command.CommandBase;

public class comando_cabesa extends CommandBase {
    private final cabesa cabesa;
    private final int pos;
    private final double pow;
    public comando_cabesa (cabesa cabesa, int pos, double pow){
        this.cabesa = cabesa;
        this.pos = pos;
        this.pow = pow;

        addRequirements(cabesa);
    }
    @Override
    public void execute(){
        cabesa.guirar(pos, pow);
        cabesa.abajo_arriba(pos, pow);
    }
    @Override
    public boolean isFinished(){
        return cabesa.isAtSetpoint_cuello() && cabesa.isAtSetpoint_arriba_abajo();

    }
}
