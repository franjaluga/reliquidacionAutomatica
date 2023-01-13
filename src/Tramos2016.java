public enum Tramos2016 {

    TRAMO_1_SUPERIOR( 7282710),
    TRAMO_2_SUPERIOR(16183800),
    TRAMO_3_SUPERIOR(  26973000 ),
    TRAMO_4_SUPERIOR(  37762200),
    TRAMO_5_SUPERIOR( 48551400),
    TRAMO_6_SUPERIOR( 64735200 ),
    TRAMO_7_SUPERIOR( 80919000 );

    private final int tramo_superior;

    private Tramos2016(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
