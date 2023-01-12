public enum Tasas2022 {
    TASA_1_2022(0.000f),
    TASA_2_2022(0.040f),
    TASA_3_2022(0.080f),
    TASA_4_2022(0.135f),
    TASA_5_2022(0.230f),
    TASA_6_2022(0.304f),
    TASA_7_2022(0.350f),
    TASA_8_2022(0.400f);

    private final float tasa_2022;

    private Tasas2022(float tasa_2022){
        this.tasa_2022 = tasa_2022;
    }

    public float getTasa2022(){
        return tasa_2022;
    }
}
