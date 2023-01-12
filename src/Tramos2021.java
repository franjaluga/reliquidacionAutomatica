public enum Tramos2021 {

    TRAMO_1_SUPERIOR( 8266698),
    TRAMO_2_SUPERIOR(18370440),
    TRAMO_3_SUPERIOR( 30617400),
    TRAMO_4_SUPERIOR( 42864360),
    TRAMO_5_SUPERIOR( 55111320),
    TRAMO_6_SUPERIOR( 73481760),
    TRAMO_7_SUPERIOR(189827880);

    private final int tramo_superior;

    private Tramos2021(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
