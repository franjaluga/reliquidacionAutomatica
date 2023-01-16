package com.franjaluga.reliquidacionautomatica.constantes;

public enum Tasas2013 {
    TASA_1(0.000f),
    TASA_2(0.050f),
    TASA_3(0.100f),
    TASA_4(0.150f),
    TASA_5(0.250f),
    TASA_6(0.320f),
    TASA_7(0.370f),
    TASA_8(0.400f);

    private final float tasa;

    private Tasas2013(float tasa){
        this.tasa = tasa;
    }

    public float getTasa(){
        return tasa;
    }
}
