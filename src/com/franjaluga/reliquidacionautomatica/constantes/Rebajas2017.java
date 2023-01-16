package com.franjaluga.reliquidacionautomatica.constantes;

public enum Rebajas2017 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 299265.84),
    REBAJA_TRAMO_3(964301.04),
    REBAJA_TRAMO_4(2488340.04),
    REBAJA_TRAMO_5( 6173743.44),
    REBAJA_TRAMO_6(9864688.80),
    REBAJA_TRAMO_7(13256368.32 ),
    REBAJA_TRAMO_8(16997191.32);

    private final double rebaja_tramo;

    private Rebajas2017(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
