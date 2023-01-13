public enum Rebajas2019 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 313327.44),
    REBAJA_TRAMO_3(1009610.64),
    REBAJA_TRAMO_4(2605259.64),
    REBAJA_TRAMO_5( 6463829.04),
    REBAJA_TRAMO_6(10328200.80 ),
    REBAJA_TRAMO_7(10328200.80 ),
    REBAJA_TRAMO_8(13531103.52);

    private final double rebaja_tramo;

    private Rebajas2019(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
