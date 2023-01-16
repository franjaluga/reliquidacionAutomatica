package com.franjaluga.reliquidacionautomatica.constantes;

public enum Tramos2017 {

    TRAMO_1_SUPERIOR( 7481646),
    TRAMO_2_SUPERIOR(16625880),
    TRAMO_3_SUPERIOR(  27709800 ),
    TRAMO_4_SUPERIOR(  38793720),
    TRAMO_5_SUPERIOR( 49877640),
    TRAMO_6_SUPERIOR( 66503520 ),
    TRAMO_7_SUPERIOR( 83129400 );

    private final int tramo_superior;

    private Tramos2017(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
