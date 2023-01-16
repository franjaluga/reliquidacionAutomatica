package com.franjaluga.reliquidacionautomatica.constantes;

public enum Rebajas2018 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 304378.56),
    REBAJA_TRAMO_3(980775.36),
    REBAJA_TRAMO_4(2530851.36),
    REBAJA_TRAMO_5( 6279216.96),
    REBAJA_TRAMO_6(10033219.20 ),
    REBAJA_TRAMO_7(10033219.20 ),
    REBAJA_TRAMO_8(13144644.48);

    private final double rebaja_tramo;

    private Rebajas2018(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
