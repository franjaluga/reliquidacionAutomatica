public enum Tramos2013 {

    TRAMO_1_SUPERIOR(6513372),
    TRAMO_2_SUPERIOR(14474160),
    TRAMO_3_SUPERIOR(24123600),
    TRAMO_4_SUPERIOR(33773040),
    TRAMO_5_SUPERIOR(43422480),
    TRAMO_6_SUPERIOR(57896640),
    TRAMO_7_SUPERIOR(72370800);

    private final int tramo_superior;

    private Tramos2013(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
