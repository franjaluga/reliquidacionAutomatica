import java.util.Scanner;

public class Core {
    /*


        0. Ingresar la base e impuesto de termino de giro y sacar el % de socio o accionistas
        // TODO proceso 1 :  Ingresar la base de TG a reliquidar
        // TODO proceso 2 : Ingresar participación del socio o accionista (int), en la base

        1. ver la cantidad de años en los que fui dueño, hasta un máximo de 10 años
        2. No se cuenta como año, el año del TG, para efectos del punto 1
        // TODO proceso 3 : Ingresar periodos a reliquida
        // TODO proceso 4: conforme a los periodos a reliquidar, pedir las bases

        // TODO proceso 4 : Reliquidar bases
        3. La base de TG se convierte (aquella porción que me corresponde) a UTM, desde la fecha del TG
        4. Las UTMS/años reliqu. , se devengan parceladamente en cada año anterior "SE RETROTRAEN" a sus valores UTM de cierre de dicho año al cierre
        5. Recalculamos el IGC por año (anteriores), sin perder la huella anterior
        6. Se obtiene una diferencia histórica, por año, de la diferencia entre las bases
        7. Se lleva a la UTM actual y se suman todas para obtener la reliquidación
        8. Compone la sumatoria del punto 7, y se resta al % del crédito que le corresponde, solo aquel CD va a devolución, lo demás se pierde
    */


    public void runCore(){

        Libro libro = new Libro();

        Scanner scanConsoleUserResponse = new Scanner(System.in);
        int consoleUserMenuResponse;


        do {
            System.out.println("========== INICIO ==========");
            System.out.println("1....Ingresar base de TG a reliquidar");
            System.out.println("2....Ingresar participación del socio o accionista, en la base");
            System.out.println("3....Ingresar periodos a reliquidar");
            System.out.println("4....Ingresar bases IGC por año");
            System.out.println("5....Reliquidar bases");
            System.out.println("0....Salir de la aplicación");

            consoleUserMenuResponse = Integer.parseInt(scanConsoleUserResponse.nextLine());

            switch (consoleUserMenuResponse) {
                case 0:
                    System.out.println("Ha salido de la aplicación");
                    break;
                case 1:
                    System.out.println("Ingrese base de TG de la empresa (corresponde al 100%)");
                    case1(libro);
                    break;
                case 2:
                    System.out.println("Ingrese el porcentaje de participación del socio o accionista"+
                            "\nPor ejemplo: 40% debe anotarlo como 0.40");
                    case2(libro);
                    break;
                case 3:
                    case3(libro);
                    break;
                case 4:
                    case4(libro);
                    break;
                case 5:
                    case5(libro);
                    break;
                default:
                    System.out.println("Vuelva a ingresar una opción válida");
                    break;
            }
        } while (consoleUserMenuResponse != 0);

    }

    public void case1(Libro libro){

        Scanner scanSubConsoleUserResponse = new Scanner(System.in);
        int subConsoleUserMenuResponse = Integer.parseInt(scanSubConsoleUserResponse.nextLine());

        libro.setBase(subConsoleUserMenuResponse);
        System.out.println("Ingresó una base: " + libro.getBase());

    }

    public void case2(Libro libro){

        Scanner scanSubConsoleUserResponse = new Scanner(System.in);
        float subConsoleUserMenuResponse = Float.parseFloat(scanSubConsoleUserResponse.nextLine());

        libro.setPorcentajeDeParticipacion(subConsoleUserMenuResponse);
        System.out.println("Ingresó el siguiente decimal: " + libro.getPorcentajeDeParticipacion());

        libro.setBaseProporcional( (int) (libro.getBase() * libro.getPorcentajeDeParticipacion()));
        System.out.println("Su proporción es "+libro.getBase()+" x "+libro.getPorcentajeDeParticipacion()+" = "+libro.getBaseProporcional());
    }

    public void case3(Libro libro){

        Scanner scanSubConsoleUserResponse = new Scanner(System.in);

        System.out.println("Ingrese el año de termino de giro: ");
        int actualYear = Integer.parseInt(scanSubConsoleUserResponse.nextLine());
        libro.setYearTG(actualYear);

        System.out.println("Ingrese el año en que adquirió las acciones o derechos");
        int initialYear = Integer.parseInt(scanSubConsoleUserResponse.nextLine());
        libro.setYearInit(initialYear);

        System.out.println("Entonces, inició en "+initialYear+" y está haciendo TG en "+actualYear);


        int yearsToReliq = 0;

        if( ( (actualYear-1) - (initialYear) ) > 10 ){
            yearsToReliq = 10;
        }else{
            yearsToReliq = (actualYear-1) - (initialYear) + 1;
        }

        System.out.println("Eso significa que puedes reliquidar en: "+yearsToReliq + " años como máximo");

        System.out.println("Entonces, ¿en cuantos años quieres reliquidar?, máximo: " + yearsToReliq);

        int finalYearsToReliq = Integer.parseInt(scanSubConsoleUserResponse.nextLine());

        if(finalYearsToReliq > 0 && finalYearsToReliq <= yearsToReliq){
            libro.setPeriodosAReliquidar(finalYearsToReliq);
            System.out.println("Ingresó "+ libro.getPeriodosAReliquidar() + " años a reliquidar");

        }else{
            System.out.println("No ingresó un dato válido");
        }
    }

    public void case4(Libro libro){
        libro.resetBasesAntiguas();

        Scanner scanSubConsoleUserResponse = new Scanner(System.in);

        //int[][] bases = new int[libro.getPeriodosAReliquidar()][2];
        int[][] bases = new int[10][2];

        for(int i = 0; i < libro.getPeriodosAReliquidar(); i++ ){

            System.out.println("Ingrese Base imponible año: "+ (libro.getYearInit()+i));

            bases[i][0] = Integer.parseInt(scanSubConsoleUserResponse.nextLine());
            bases[i][1] = libro.getYearInit() + i;
            System.out.println("Ingresó: " +  bases[i][0] + "En el año "+ bases[i][1]);

        }

        libro.setBasesAntiguas(bases);

        System.out.println("Se trabajarán con las siguientes bases por año");

        for(int i = 0; i < libro.basesAntiguas.length; i++){
            System.out.println(libro.basesAntiguas[i][1]+ " : " + libro.basesAntiguas[i][0]);
        }


    }

    public void case5(Libro libro){
        System.out.println("Reporte final de reliquidación");
        // TODO proceso 4 : Reliquidar bases

        // inicializa base recalculada
        libro.resetBasesRecalculadas();

        // cuantas UTM son por año?
        howMuchUtmIsPerYear(libro);

        // 3. La base de TG se convierte (aquella porción que me corresponde) a UTM, desde la fecha del TG
        System.out.println("Base a UTM a la fecha del TG: " + baseToUtmInDateTg(libro));

        // 4. Las UTMS/años reliqu. , se devengan parceladamente en cada año anterior "SE RETROTRAEN" a sus valores UTM de cierre de dicho año al cierre
        addUtmToBaseRecalc(libro);

        // 5. Recalculamos el IGC por año, sin perder la huella anterior
            // necesitamos el IGC anterior
            // necesitamos el IGC nuevo

            // pasar "BASE" + AÑO y calcular IGC



        // 6. Se obtiene una diferencia histórica, por año, de la diferencia entre las bases
            // necesitamos su difrencia



        /*
            7. Se lleva a la UTM actual y se suman todas para obtener la reliquidación
            8. Compone la sumatoria del punto 7, y se resta al % del crédito que le corresponde, solo aquel CD va a devolución, lo demás se pierde
         */



    }

    // OTRAS FUNCIONES, LA IDEA ES NO ANIDAR MÁS ELEMENTOS

    public double baseToUtmInDateTg(Libro libro){

        selectorDeUtm(libro);
        double basePp = libro.getBaseProporcional();
        double utmTg = libro.getUtmTG();

        libro.setBaseProporcionalEnUtm( basePp / utmTg );

        double utmTgReturn = libro.getBaseProporcionalEnUtm();

        return utmTgReturn;
    }


    public void selectorDeUtm(Libro libro){
         int yearTg = libro.getYearTG();

         switch (yearTg){
             case 2022:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2022.getUtm());
                 break;

             case 2021:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2021.getUtm());
                 break;

             case 2020:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2020.getUtm());
                 break;

             case 2019:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2019.getUtm());
                 break;

             case 2018:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2018.getUtm());
                 break;

             case 2017:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2017.getUtm());
                 break;

             case 2016:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2016.getUtm());
                 break;

             case 2015:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2015.getUtm());
                 break;

             case 2014:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2014.getUtm());
                 break;

             case 2013:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2013.getUtm());
                 break;

             case 2012:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2012.getUtm());
                 break;

             default:
                 System.out.println("case default");
                 break;
         }
    }


    public void howMuchUtmIsPerYear(Libro libro){
        // visualizar cuanto queda por año
        double basePorYearToReliq = baseToUtmInDateTg(libro) / libro.getPeriodosAReliquidar();
        libro.setBasePorYearToReliq(basePorYearToReliq);
        System.out.println("Entonces, por año serían: " + basePorYearToReliq );
    }


    public void addUtmToBaseRecalc(Libro libro){

        int slot1 = libro.basesAntiguas[0][1];
        int slot2 = libro.basesAntiguas[1][1];
        int slot3 = libro.basesAntiguas[2][1];
        int slot4 = libro.basesAntiguas[3][1];
        int slot5 = libro.basesAntiguas[4][1];
        int slot6 = libro.basesAntiguas[5][1];
        int slot7 = libro.basesAntiguas[6][1];
        int slot8 = libro.basesAntiguas[7][1];
        int slot9 = libro.basesAntiguas[8][1];
        int slot10 = libro.basesAntiguas[9][1];

        evaluarYearInitial(slot1, libro, 0);
        evaluarYearInitial(slot2, libro, 1);
        evaluarYearInitial(slot3, libro, 2);
        evaluarYearInitial(slot4, libro, 3);
        evaluarYearInitial(slot5, libro, 4);
        evaluarYearInitial(slot6, libro, 5);
        evaluarYearInitial(slot7, libro, 6);
        evaluarYearInitial(slot8, libro, 7);
        evaluarYearInitial(slot9, libro, 8);
        evaluarYearInitial(slot10, libro, 9);

        printDataRecalc(libro);

    }

    public void evaluarYearInitial(int data, Libro libro, int lugar){
        int slot = data;
        double convertido = 0;

        if(slot == 2012){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2012.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2012;
        }

        if(slot == 2013){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2013.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2013;
        }

        if(slot == 2014){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2014.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2014;
        }

        if(slot == 2015){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2015.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2015;
        }

        if(slot == 2016){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2016.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2016;
        }

        if(slot == 2017){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2017.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2017;
        }

        if(slot == 2018){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2018.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2018;
        }

        if(slot == 2019){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2019.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2019;
        }

        if(slot == 2020){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2020.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2020;
        }

        if(slot == 2021){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2021.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2021;
        }

        if(slot == 2022){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2022.getUtm();
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2022;
        }
    }

    public void printDataRecalc(Libro libro){
        System.out.println(libro.baseRecalculada[0][0] + " : "+ libro.baseRecalculada[0][1]);
        System.out.println(libro.baseRecalculada[1][0] + " : "+ libro.baseRecalculada[1][1]);
        System.out.println(libro.baseRecalculada[2][0] + " : "+ libro.baseRecalculada[2][1]);
        System.out.println(libro.baseRecalculada[3][0] + " : "+ libro.baseRecalculada[3][1]);
        System.out.println(libro.baseRecalculada[4][0] + " : "+ libro.baseRecalculada[4][1]);
        System.out.println(libro.baseRecalculada[5][0] + " : "+ libro.baseRecalculada[5][1]);
        System.out.println(libro.baseRecalculada[6][0] + " : "+ libro.baseRecalculada[6][1]);
        System.out.println(libro.baseRecalculada[7][0] + " : "+ libro.baseRecalculada[7][1]);
        System.out.println(libro.baseRecalculada[8][0] + " : "+ libro.baseRecalculada[8][1]);
        System.out.println(libro.baseRecalculada[9][0] + " : "+ libro.baseRecalculada[9][1]);
    }

}
