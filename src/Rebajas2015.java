public enum Rebajas2015 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 279923.04),
    REBAJA_TRAMO_3(901974.24),
    REBAJA_TRAMO_4(2327508.24),
    REBAJA_TRAMO_5( 5774708.64),
    REBAJA_TRAMO_6(9227092.80),
    REBAJA_TRAMO_7(12399553.92),
    REBAJA_TRAMO_8(15898591.92);

    private final double rebaja_tramo;

    private Rebajas2015(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
