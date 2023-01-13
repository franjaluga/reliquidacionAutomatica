public enum Rebajas2011 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 304600.50),
    REBAJA_TRAMO_3(981490.50),
    REBAJA_TRAMO_4( 2109640.50),
    REBAJA_TRAMO_5( 5268460.50),
    REBAJA_TRAMO_6( 8111398.50),
    REBAJA_TRAMO_7(10818958.50),
    REBAJA_TRAMO_8(12849628.50);

    private final double rebaja_tramo;

    private Rebajas2011(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
