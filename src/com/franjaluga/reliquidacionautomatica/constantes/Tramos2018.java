package com.franjaluga.reliquidacionautomatica.constantes;

public enum Tramos2018 {

    TRAMO_1_SUPERIOR( 7609464),
    TRAMO_2_SUPERIOR(16909920),
    TRAMO_3_SUPERIOR( 28183200 ),
    TRAMO_4_SUPERIOR( 39456480),
    TRAMO_5_SUPERIOR( 50729760),
    TRAMO_6_SUPERIOR( 67639680 ),
    TRAMO_7_SUPERIOR(67639680 );

    private final int tramo_superior;

    private Tramos2018(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
