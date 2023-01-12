public enum Tramos2020 {

    TRAMO_1_SUPERIOR( 8038926),
    TRAMO_2_SUPERIOR(17864280),
    TRAMO_3_SUPERIOR( 29773800),
    TRAMO_4_SUPERIOR( 41683320),
    TRAMO_5_SUPERIOR( 53592840),
    TRAMO_6_SUPERIOR( 71457120),
    TRAMO_7_SUPERIOR(71457120);

    private final int tramo_superior;

    private Tramos2020(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
