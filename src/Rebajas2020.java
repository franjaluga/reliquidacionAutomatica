public enum Rebajas2020 {

    REBAJA_TRAMO_1(0.00),
    REBAJA_TRAMO_2(321557.04),
    REBAJA_TRAMO_3(1036128.24),
    REBAJA_TRAMO_4(2673687.24),
    REBAJA_TRAMO_5( 6633602.64),
    REBAJA_TRAMO_6(10599472.80),
    REBAJA_TRAMO_7(10599472.80),
    REBAJA_TRAMO_8(13886500.32);

    private final double rebaja_tramo;

    private Rebajas2020(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
