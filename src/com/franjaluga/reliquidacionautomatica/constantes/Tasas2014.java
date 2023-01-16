package com.franjaluga.reliquidacionautomatica.constantes;

public enum Tasas2014 {
    TASA_1(0.000f),
    TASA_2(0.040f),
    TASA_3(0.080f),
    TASA_4(0.135f),
    TASA_5(0.230f),
    TASA_6(0.304f),
    TASA_7(0.355f),
    TASA_8(0.400f);

    private final float tasa;

    private Tasas2014(float tasa){
        this.tasa = tasa;
    }

    public float getTasa(){
        return tasa;
    }
}
