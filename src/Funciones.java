public class Funciones {

    public static int calcularIGCAt2022(int base){

        int igc = 0;

        int t1Superior = Tramos2022.TRAMO_1_SUPERIOR_2022.getTramo();
        int t2Superior = Tramos2022.TRAMO_2_SUPERIOR_2022.getTramo();
        int t3Superior = Tramos2022.TRAMO_3_SUPERIOR_2022.getTramo();
        int t4Superior = Tramos2022.TRAMO_4_SUPERIOR_2022.getTramo();
        int t5Superior = Tramos2022.TRAMO_5_SUPERIOR_2022.getTramo();
        int t6Superior = Tramos2022.TRAMO_6_SUPERIOR_2022.getTramo();
        int t7Superior = Tramos2022.TRAMO_7_SUPERIOR_2022.getTramo();

        float t1_tasa = Tasas2022.TASA_1_2022.getTasa2022();
        float t2_tasa = Tasas2022.TASA_2_2022.getTasa2022();
        float t3_tasa = Tasas2022.TASA_3_2022.getTasa2022();
        float t4_tasa = Tasas2022.TASA_4_2022.getTasa2022();
        float t5_tasa = Tasas2022.TASA_5_2022.getTasa2022();
        float t6_tasa = Tasas2022.TASA_6_2022.getTasa2022();
        float t7_tasa = Tasas2022.TASA_7_2022.getTasa2022();
        float t8_tasa = Tasas2022.TASA_8_2022.getTasa2022();

        double t1_rebaja = 0.00;
        double t2_rebaja = 351028.08;
        double t3_rebaja = 1131090.48;
        double t4_rebaja = 2918733.48;
        double t5_rebaja = 7241579.28;
        double t6_rebaja = 11570925.60;
        double t7_rebaja = 15159212.64;
        double t8_rebaja = 25235018.64;


        if( base >= 0 && base <= t1Superior ){
            igc = (int) Math.round((base * t1_tasa) - t1_rebaja);

        }else if( base > t1Superior && base <= t2Superior){
            igc = (int) Math.round((base * t2_tasa) - t2_rebaja);

        }else if( base > t2Superior && base <= t3Superior){
            igc = (int) Math.round((base * t3_tasa) - t3_rebaja);

        }else if( base > t3Superior && base <= t4Superior){
            igc = (int) Math.round((base * t4_tasa) - t4_rebaja);

        }else if( base > t4Superior && base <= t5Superior){
            igc = (int) Math.round((base * t5_tasa) - t5_rebaja);

        }else if( base > t5Superior && base <= t6Superior){
            igc = (int) Math.round((base * t6_tasa) - t6_rebaja);

        }else if( base > t6Superior && base <= t7Superior){
            igc = (int) Math.round((base * t7_tasa) - t7_rebaja);

        }else if( base > t7Superior){
            igc = (int) Math.round((base * t8_tasa) - t8_rebaja);

        }
        return igc;
    }


}
