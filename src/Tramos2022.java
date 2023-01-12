public enum Tramos2022 {

    TRAMO_1_SUPERIOR_2022(8775702),
    TRAMO_2_SUPERIOR_2022(19501560),
    TRAMO_3_SUPERIOR_2022(32502600),
    TRAMO_4_SUPERIOR_2022(45503640),
    TRAMO_5_SUPERIOR_2022(58504680),
    TRAMO_6_SUPERIOR_2022(78006240),
    TRAMO_7_SUPERIOR_2022(201516120);

    private final int tramo_superior_2022;

    private Tramos2022(int tramo_superior_2022){
        this.tramo_superior_2022 = tramo_superior_2022;
    }

    public int getTramo(){
        return tramo_superior_2022;
    }
}
