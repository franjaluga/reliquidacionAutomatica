public enum Rebajas2021 {

    REBAJA_TRAMO_1(0.00),
    REBAJA_TRAMO_2(330667.92),
    REBAJA_TRAMO_3(1065485.52),
    REBAJA_TRAMO_4(2749442.52),
    REBAJA_TRAMO_5(6821556.72),
    REBAJA_TRAMO_6(10899794.40),
    REBAJA_TRAMO_7(14279955.36),
    REBAJA_TRAMO_8(23771349.36);

    private final double rebaja_tramo;

    private Rebajas2021(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
