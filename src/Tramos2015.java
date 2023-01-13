public enum Tramos2015 {

    TRAMO_1_SUPERIOR( 6998076),
    TRAMO_2_SUPERIOR(15551280),
    TRAMO_3_SUPERIOR(  25918800 ),
    TRAMO_4_SUPERIOR(  36286320),
    TRAMO_5_SUPERIOR( 46653840),
    TRAMO_6_SUPERIOR( 62205120 ),
    TRAMO_7_SUPERIOR( 77756400 );

    private final int tramo_superior;

    private Tramos2015(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
