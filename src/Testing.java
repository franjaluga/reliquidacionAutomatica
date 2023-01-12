public class Testing {

    public void test(){

        int res1a = 0;
        int res2a = 8972;
        int res3a = 868910;
        int res4a = 1806267;
        int res5a = 3568421;
        int res6a = 6669074;
        int res7a = 12840787;
        int res8a = 62764981;

        int res1b = 0;
        int res2b = 29332;
        int res3b = 934514;
        int res4b = 1975557;
        int res5b = 3988443;
        int res6b = 7340206;
        int res7b = 13720045;
        int res8b = 64228651;

        // TESTING
        int baset1 = 8000000;
        int baset2 = 9000000;
        int baset3 = 25000000;
        int baset4 = 35000000;
        int baset5 = 47000000;
        int baset6 = 60000000;
        int baset7 = 80000000;
        int baset8 = 220000000;

        int res1c = 0;
        int res2c = 38443;
        int res3c = 963872;
        int res4c = 2051313;
        int res5c = 4176397;
        int res6c = 7640527;
        int res7c = 14113500;
        int res8c = 63113500;

        int[] bases = {baset1,baset2,baset3,baset4,baset5,baset6,baset7,baset8};
        int[] resultados1 = {res1a,res2a,res3a,res4a,res5a,res6a,res7a,res8a};
        int[] resultados2 = {res1b,res2b,res3b,res4b,res5b,res6b,res7b,res8b};
        int[] resultados3 = {res1c,res2c,res3c,res4c,res5c,res6c,res7c,res8c};

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;


        for(int i = 0; i <8; i++){
            //System.out.println(Funciones.calcularIGCAt2022(bases[i]) + "=" + resultados1[i] + (Funciones.calcularIGCAt2022(bases[i]) == resultados1[i] ));
            if(!(Funciones.calcularIGCAt2022(bases[i]) == resultados1[i] )){
                System.out.println("FAIL 2022");
            }
        }

        for(int i = 0; i <8; i++){
            //System.out.println(Funciones.calcularIGCAt2021(bases[i]) + "=" + resultados2[i] + (Funciones.calcularIGCAt2021(bases[i]) == resultados2[i] ));
            if(!(Funciones.calcularIGCAt2021(bases[i]) == resultados2[i] )){
                System.out.println("FAIL 2021");
            }
        }

        for(int i = 0; i <8; i++){
            //System.out.println(Funciones.calcularIGCAt2020(bases[i]) + "=" + resultados3[i] + (Funciones.calcularIGCAt2020(bases[i]) == resultados3[i] ));
            if(!(Funciones.calcularIGCAt2020(bases[i]) == resultados3[i] )){
                System.out.println("FAIL 2020");
            }
        }
    }
}
