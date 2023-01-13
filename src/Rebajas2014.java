public enum Rebajas2014 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 264202.56),
    REBAJA_TRAMO_3(851319.36),
    REBAJA_TRAMO_4( 2196795.36),
    REBAJA_TRAMO_5( 5450400.96),
    REBAJA_TRAMO_6( 8708899.20),
    REBAJA_TRAMO_7(11703194.88),
    REBAJA_TRAMO_8(15005726.88);

    private final double rebaja_tramo;

    private Rebajas2014(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
