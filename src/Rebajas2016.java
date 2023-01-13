public enum Rebajas2016 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 291308.40),
    REBAJA_TRAMO_3(938660.40),
    REBAJA_TRAMO_4(2422175.40),
    REBAJA_TRAMO_5( 6009584.40),
    REBAJA_TRAMO_6(9602388.00),
    REBAJA_TRAMO_7(12903883.20),
    REBAJA_TRAMO_8(16545238.20);

    private final double rebaja_tramo;

    private Rebajas2016(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
