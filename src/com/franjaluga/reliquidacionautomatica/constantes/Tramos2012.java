package com.franjaluga.reliquidacionautomatica.constantes;

public enum Tramos2012 {

    TRAMO_1_SUPERIOR(6321402),
    TRAMO_2_SUPERIOR(14047560),
    TRAMO_3_SUPERIOR(23412600),
    TRAMO_4_SUPERIOR(32777640),
    TRAMO_5_SUPERIOR(42142680),
    TRAMO_6_SUPERIOR(56190240),
    TRAMO_7_SUPERIOR(70237800);

    private final int tramo_superior;

    private Tramos2012(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
