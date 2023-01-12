public class Main {
    public static void main(String[] args) {

        System.out.println(Main.calcularIGCAt2022(19501560));

    }

    public static int calcularIGCAt2022(int base){
        int igc = 0;

        int t1Superior = 8775702;
        int t2Superior = 19501560;
        int t3Superior = 32502600;
        int t4Superior = 45503640;
        int t5Superior = 58504680;
        int t6Superior = 78006240;
        int t7Superior = 201516120;

        float t1_tasa = 0.000f;
        float t2_tasa = 0.040f;
        float t3_tasa = 0.080f;
        float t4_tasa = 0.135f;
        float t5_tasa = 0.230f;
        float t6_tasa = 0.304f;
        float t7_tasa = 0.350f;
        float t8_tasa = 0.400f;

        double t1_rebaja = 0.00;
        double t2_rebaja = 351028.08;
        double t3_rebaja = 1131090.48;
        double t4_rebaja = 2918733.48;
        double t5_rebaja = 7241579.28;
        double t6_rebaja = 11570925.60;
        double t7_rebaja = 15159212.64;
        double t8_rebaja = 25235018.64;




        if( base >= 0 && base <= t1Superior ){
            igc = (int) Math.round(base * t1_tasa - t1_rebaja);
        }else if( base > t1Superior && base <= t2Superior){
            igc = (int) Math.round(base * t2_tasa - t2_rebaja);
        }else if( base > t2Superior && base <= t3Superior){
            igc = (int) Math.round(base * t3_tasa - t3_rebaja);
        }else if( base > t3Superior && base <= t4Superior){
            igc = (int) Math.round(base * t4_tasa - t4_rebaja);
        }else if( base > t4Superior && base <= t5Superior){
            igc = (int) Math.round(base * t5_tasa - t5_rebaja);
        }else if( base > t5Superior && base <= t6Superior){
            igc = (int) Math.round(base * t6_tasa - t6_rebaja);
        }else if( base > t6Superior && base <= t7Superior){
            igc = (int) Math.round(base * t7_tasa - t7_rebaja);
        }else if( base > t7Superior){
            igc = (int) Math.round(base * t8_tasa - t8_rebaja);
        }
        return igc;
    }
}