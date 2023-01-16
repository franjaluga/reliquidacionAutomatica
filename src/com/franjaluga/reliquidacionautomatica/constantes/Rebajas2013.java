package com.franjaluga.reliquidacionautomatica.constantes;

public enum Rebajas2013 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 325668.60),
    REBAJA_TRAMO_3(1049376.60),
    REBAJA_TRAMO_4( 2255556.60),
    REBAJA_TRAMO_5( 5632860.60),
    REBAJA_TRAMO_6( 8672434.20),
    REBAJA_TRAMO_7(11567266.20),
    REBAJA_TRAMO_8(13738390.20);

    private final double rebaja_tramo;

    private Rebajas2013(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
