public enum Rebajas2022 {

    REBAJA_TRAMO_1(0.00),
    REBAJA_TRAMO_2(351028.08),
    REBAJA_TRAMO_3(1131090.48),
    REBAJA_TRAMO_4(2918733.48),
    REBAJA_TRAMO_5(7241579.28),
    REBAJA_TRAMO_6(11570925.60),
    REBAJA_TRAMO_7(15159212.64),
    REBAJA_TRAMO_8(25235018.64);

    private final double rebaja_tramo;

    private Rebajas2022(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
