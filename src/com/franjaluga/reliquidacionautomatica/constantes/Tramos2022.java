package com.franjaluga.reliquidacionautomatica.constantes;

public enum Tramos2022 {

    TRAMO_1_SUPERIOR(8775702),
    TRAMO_2_SUPERIOR(19501560),
    TRAMO_3_SUPERIOR(32502600),
    TRAMO_4_SUPERIOR(45503640),
    TRAMO_5_SUPERIOR(58504680),
    TRAMO_6_SUPERIOR(78006240),
    TRAMO_7_SUPERIOR(201516120);

    private final int tramo_superior;

    private Tramos2022(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
