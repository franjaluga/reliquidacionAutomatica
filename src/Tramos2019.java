public enum Tramos2019 {

    TRAMO_1_SUPERIOR( 7833186),
    TRAMO_2_SUPERIOR(17407080),
    TRAMO_3_SUPERIOR(  29011800 ),
    TRAMO_4_SUPERIOR( 40616520),
    TRAMO_5_SUPERIOR( 52221240),
    TRAMO_6_SUPERIOR( 69628320 ),
    TRAMO_7_SUPERIOR(69628320 );

    private final int tramo_superior;

    private Tramos2019(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
