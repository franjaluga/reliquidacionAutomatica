public class Main {
    public static void main(String[] args) {

        // TESTING
        int baset1 = 8000000;
        int baset2 = 9000000;
        int baset3 = 25000000;
        int baset4 = 35000000;
        int baset5 = 47000000;
        int baset6 = 60000000;
        int baset7 = 80000000;
        int baset8 = 220000000;

        int res1 = 0;
        int res2 = 8972;
        int res3 = 868910;
        int res4 = 1806267;
        int res5 = 3568421;
        int res6 = 6669074;
        int res7 = 12840787;
        int res8 = 62764981;

        int[] bases = {baset1,baset2,baset3,baset4,baset5,baset6,baset7,baset8};
        int[] resultados = {res1,res2,res3,res4,res5,res6,res7,res8};

        for(int i = 0; i <8; i++){
            System.out.println(Funciones.calcularIGCAt2022(bases[i]) + "=" + resultados[i] + (Funciones.calcularIGCAt2022(bases[i]) == resultados[i] ));
        }







    }

}