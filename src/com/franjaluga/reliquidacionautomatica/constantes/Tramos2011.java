package com.franjaluga.reliquidacionautomatica.constantes;

public enum Tramos2011 {

    TRAMO_1_SUPERIOR(6092010),
    TRAMO_2_SUPERIOR(13537800),
    TRAMO_3_SUPERIOR(22563000),
    TRAMO_4_SUPERIOR(31588200),
    TRAMO_5_SUPERIOR(40613400),
    TRAMO_6_SUPERIOR(54151200),
    TRAMO_7_SUPERIOR(67689000);

    private final int tramo_superior;

    private Tramos2011(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
