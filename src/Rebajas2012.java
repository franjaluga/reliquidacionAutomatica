public enum Rebajas2012 {

    REBAJA_TRAMO_1(0),
    REBAJA_TRAMO_2( 316070.10),
    REBAJA_TRAMO_3(1018448.10),
    REBAJA_TRAMO_4( 2189078.10),
    REBAJA_TRAMO_5( 5466842.10),
    REBAJA_TRAMO_6( 8416829.70),
    REBAJA_TRAMO_7(11226341.70),
    REBAJA_TRAMO_8(13333475.70);

    private final double rebaja_tramo;

    private Rebajas2012(double rebaja_tramo){
        this.rebaja_tramo = rebaja_tramo;
    }

    public double getRebaja(){
        return rebaja_tramo;
    }
}
