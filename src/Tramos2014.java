public enum Tramos2014 {

    TRAMO_1_SUPERIOR(6605064),
    TRAMO_2_SUPERIOR(14677920),
    TRAMO_3_SUPERIOR(24463200),
    TRAMO_4_SUPERIOR(34248480),
    TRAMO_5_SUPERIOR(44033760),
    TRAMO_6_SUPERIOR(58711680),
    TRAMO_7_SUPERIOR(73389600);

    private final int tramo_superior;

    private Tramos2014(int tramo_superior){
        this.tramo_superior = tramo_superior;
    }

    public int getTramo(){
        return tramo_superior;
    }
}
