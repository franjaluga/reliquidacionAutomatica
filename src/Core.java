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

        System.out.println("Ingrese el año TRIBUTARIO de termino de giro: ");
        int actualYear = Integer.parseInt(scanSubConsoleUserResponse.nextLine());
        libro.setYearTG(actualYear);

        System.out.println("Ingrese el año COMERCIAL en que adquirió las acciones o derechos");
        int initialYear = Integer.parseInt(scanSubConsoleUserResponse.nextLine());
        libro.setYearInit( initialYear + 1 );

        System.out.println("se ocupará año tributario inicial: " + libro.getYearInit());
        System.out.println("se ocupará año tributario final: " + libro.getYearTG());

        System.out.println("Entonces, inició en "+initialYear+" y está haciendo TG en "+actualYear + "(Cerrando al 31.12."+(actualYear-1)+")");


        int yearsToReliq = 0;

        if( ( ( actualYear - 1 ) - ( initialYear + 1 ) ) > 10 ){
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

        // 3. La base de TG se convierte (aquella porción que me corresponde) a UTM, desde la fecha del TG
        System.out.println("Base a UTM a la fecha del TG: " + baseToUtmInDateTg(libro));

        // cuantas UTM son por año?
        howMuchUtmIsPerYear(libro);

        // 4. Las UTMS/años reliqu. , se devengan parceladamente en cada año anterior "SE RETROTRAEN" a sus valores UTM de cierre de dicho año al cierre
        addUtmToBaseRecalc(libro);

        // 5. Recalculamos el IGC por año, sin perder la huella anterior
            // necesitamos el IGC anterior
            // necesitamos el IGC nuevo

            // pasar "BASE" + AÑO y calcular IGC
        asignarIgcRespectivoViaYearAndBase(libro);

        // 6. Se obtiene una diferencia histórica, por año, de la diferencia entre las bases
            // necesitamos su difrencia
        diferenciaDeIgc(libro);

        // 7. Se lleva a la UTM actual y se suman todas para obtener la reliquidación

        // TODO: OCUPAR DEL ARRAY INICIAL LOS AÑOS INVOLUCRADOS --> basesAntiguas[i][0]
        // TODO: Pedir la UTM en base al año que reciba
        // TODO: OCUPAR EL ARRAY DE LAS DIFERENCIAS EN PESOS --> diferenciaDeBases[i]
        // TODO: PROCESAR Y GUARDAR EN difIgcEnUtmHistorica[i]


        libro.difIgcEnUtmHistorica[0] = libro.diferenciaDeBases[0] / whatUtmIs(libro.basesAntiguas[0][1]);
        libro.difIgcEnUtmHistorica[1] = libro.diferenciaDeBases[1] / whatUtmIs(libro.basesAntiguas[1][1]);
        libro.difIgcEnUtmHistorica[2] = libro.diferenciaDeBases[2] / whatUtmIs(libro.basesAntiguas[2][1]);
        libro.difIgcEnUtmHistorica[3] = libro.diferenciaDeBases[3] / whatUtmIs(libro.basesAntiguas[3][1]);
        libro.difIgcEnUtmHistorica[4] = libro.diferenciaDeBases[4] / whatUtmIs(libro.basesAntiguas[4][1]);
        libro.difIgcEnUtmHistorica[5] = libro.diferenciaDeBases[5] / whatUtmIs(libro.basesAntiguas[5][1]);
        libro.difIgcEnUtmHistorica[6] = libro.diferenciaDeBases[6] / whatUtmIs(libro.basesAntiguas[6][1]);
        libro.difIgcEnUtmHistorica[7] = libro.diferenciaDeBases[7] / whatUtmIs(libro.basesAntiguas[7][1]);
        libro.difIgcEnUtmHistorica[8] = libro.diferenciaDeBases[8] / whatUtmIs(libro.basesAntiguas[8][1]);
        libro.difIgcEnUtmHistorica[9] = libro.diferenciaDeBases[9] / whatUtmIs(libro.basesAntiguas[9][1]);

        System.out.println("=====DIFERENCIAS EN UTM HISTORICAS======");
        System.out.println(libro.difIgcEnUtmHistorica[0]);
        System.out.println(libro.difIgcEnUtmHistorica[1]);
        System.out.println(libro.difIgcEnUtmHistorica[2]);
        System.out.println(libro.difIgcEnUtmHistorica[3]);
        System.out.println(libro.difIgcEnUtmHistorica[4]);
        System.out.println(libro.difIgcEnUtmHistorica[5]);
        System.out.println(libro.difIgcEnUtmHistorica[6]);
        System.out.println(libro.difIgcEnUtmHistorica[7]);
        System.out.println(libro.difIgcEnUtmHistorica[8]);
        System.out.println(libro.difIgcEnUtmHistorica[9]);

        // TODO CONVERTIR A UTM DE TG

        libro.difIgcEnUtmHistoricaAPesosActualesTG[0] = libro.difIgcEnUtmHistorica[0] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[1] = libro.difIgcEnUtmHistorica[1] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[2] = libro.difIgcEnUtmHistorica[2] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[3] = libro.difIgcEnUtmHistorica[3] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[4] = libro.difIgcEnUtmHistorica[4] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[5] = libro.difIgcEnUtmHistorica[5] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[6] = libro.difIgcEnUtmHistorica[6] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[7] = libro.difIgcEnUtmHistorica[7] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[8] = libro.difIgcEnUtmHistorica[8] * libro.getUtmTG();
        libro.difIgcEnUtmHistoricaAPesosActualesTG[9] = libro.difIgcEnUtmHistorica[9] * libro.getUtmTG();



        // TODO: APLICAR SUMATORIA VERTICAL A [X+2]

        int sumatoria = 0;

        for(int i = 0; i < libro.difIgcEnUtmHistoricaAPesosActualesTG.length; i++){
            sumatoria += libro.difIgcEnUtmHistoricaAPesosActualesTG[i];
        }

        System.out.println("sumatoria reliquidación: " + sumatoria);

        // 8. Compone la sumatoria del punto 7, y se resta al % del crédito que le corresponde, solo aquel CD va a devolución, lo demás se pierde


    }

    // OTRAS FUNCIONES, LA IDEA ES NO ANIDAR MÁS ELEMENTOS

    public double baseToUtmInDateTg(Libro libro){

        selectorDeUtm(libro);
        double basePp = libro.getBaseProporcional();

        // TODO BORRAR LA LINEA DE ABAJO Y REMPLAZARA POR ESTA ---> double utmTg = libro.getUtmTG();
        double utmTg = 52842;

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

             case 2011:
                 libro.setUtmTG(UnidadesTributariasMensuales.UTM_DIC_2011.getUtm());
                 break;

             default:
                 System.out.println("case default");
                 break;
         }
        System.out.println("SE USÓ UTM DE ---->" + libro.getUtmTG());
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

        if(slot == 2011){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2010.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2011;
        }

        if(slot == 2012){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2011.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2012;
        }

        if(slot == 2013){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2012.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2013;
        }

        if(slot == 2014){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2013.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2014;
        }

        if(slot == 2015){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2014.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2015;
        }

        if(slot == 2016){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2015.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2016;
        }

        if(slot == 2017){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2016.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2017;
        }

        if(slot == 2018){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2017.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2018;
        }

        if(slot == 2019){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2018.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2019;
        }

        if(slot == 2020){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2019.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2020;
        }

        if(slot == 2021){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2020.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
            libro.baseRecalculada[lugar][0] = libro.basesAntiguas[lugar][0] + (int) (convertido);
            libro.baseRecalculada[lugar][1] = 2021;
        }

        if(slot == 2022){
            convertido = libro.getBasePorYearToReliq() * UnidadesTributariasMensuales.UTM_DIC_2021.getUtm();
            convertido = Math.round(convertido);
            System.out.println("convertido = " + convertido);
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

    public void asignarIgcRespectivoViaYearAndBase(Libro libro){

        int y1a = libro.basesAntiguas[0][1];
        int y2a = libro.basesAntiguas[1][1];
        int y3a = libro.basesAntiguas[2][1];
        int y4a = libro.basesAntiguas[3][1];
        int y5a = libro.basesAntiguas[4][1];
        int y6a = libro.basesAntiguas[5][1];
        int y7a = libro.basesAntiguas[6][1];
        int y8a = libro.basesAntiguas[7][1];
        int y9a = libro.basesAntiguas[8][1];
        int y10a = libro.basesAntiguas[9][1];

        int b1a = libro.basesAntiguas[0][0];
        int b2a = libro.basesAntiguas[1][0];
        int b3a = libro.basesAntiguas[2][0];
        int b4a = libro.basesAntiguas[3][0];
        int b5a = libro.basesAntiguas[4][0];
        int b6a = libro.basesAntiguas[5][0];
        int b7a = libro.basesAntiguas[6][0];
        int b8a = libro.basesAntiguas[7][0];
        int b9a = libro.basesAntiguas[8][0];
        int b10a = libro.basesAntiguas[9][0];


        int y1n = libro.baseRecalculada[0][1];
        int y2n = libro.baseRecalculada[1][1];
        int y3n = libro.baseRecalculada[2][1];
        int y4n = libro.baseRecalculada[3][1];
        int y5n = libro.baseRecalculada[4][1];
        int y6n = libro.baseRecalculada[5][1];
        int y7n = libro.baseRecalculada[6][1];
        int y8n = libro.baseRecalculada[7][1];
        int y9n = libro.baseRecalculada[8][1];
        int y10n = libro.baseRecalculada[9][1];

        int b1n = libro.baseRecalculada[0][0];
        int b2n = libro.baseRecalculada[1][0];
        int b3n = libro.baseRecalculada[2][0];
        int b4n = libro.baseRecalculada[3][0];
        int b5n = libro.baseRecalculada[4][0];
        int b6n = libro.baseRecalculada[5][0];
        int b7n = libro.baseRecalculada[6][0];
        int b8n = libro.baseRecalculada[7][0];
        int b9n = libro.baseRecalculada[8][0];
        int b10n = libro.baseRecalculada[9][0];

        libro.igcHistoricoYRecalculado[0][0] = calcularIgc(y1a,b1a);
        libro.igcHistoricoYRecalculado[1][0] = calcularIgc(y2a,b2a);
        libro.igcHistoricoYRecalculado[2][0] = calcularIgc(y3a,b3a);
        libro.igcHistoricoYRecalculado[3][0] = calcularIgc(y4a,b4a);
        libro.igcHistoricoYRecalculado[4][0] = calcularIgc(y5a,b5a);
        libro.igcHistoricoYRecalculado[5][0] = calcularIgc(y6a,b6a);
        libro.igcHistoricoYRecalculado[6][0] = calcularIgc(y7a,b7a);
        libro.igcHistoricoYRecalculado[7][0] = calcularIgc(y8a,b8a);
        libro.igcHistoricoYRecalculado[8][0] = calcularIgc(y9a,b9a);
        libro.igcHistoricoYRecalculado[9][0] = calcularIgc(y10a,b10a);

        libro.igcHistoricoYRecalculado[0][1] = calcularIgc(y1n,b1n);
        libro.igcHistoricoYRecalculado[1][1] = calcularIgc(y2n,b2n);
        libro.igcHistoricoYRecalculado[2][1] = calcularIgc(y3n,b3n);
        libro.igcHistoricoYRecalculado[3][1] = calcularIgc(y4n,b4n);
        libro.igcHistoricoYRecalculado[4][1] = calcularIgc(y5n,b5n);
        libro.igcHistoricoYRecalculado[5][1] = calcularIgc(y6n,b6n);
        libro.igcHistoricoYRecalculado[6][1] = calcularIgc(y7n,b7n);
        libro.igcHistoricoYRecalculado[7][1] = calcularIgc(y8n,b8n);
        libro.igcHistoricoYRecalculado[8][1] = calcularIgc(y9n,b9n);
        libro.igcHistoricoYRecalculado[9][1] = calcularIgc(y10n,b10n);

        System.out.println(libro.igcHistoricoYRecalculado[0][0] + " -> " + libro.igcHistoricoYRecalculado[0][1]);
        System.out.println(libro.igcHistoricoYRecalculado[1][0] + " -> " + libro.igcHistoricoYRecalculado[1][1]);
        System.out.println(libro.igcHistoricoYRecalculado[2][0] + " -> " + libro.igcHistoricoYRecalculado[2][1]);
        System.out.println(libro.igcHistoricoYRecalculado[3][0] + " -> " + libro.igcHistoricoYRecalculado[3][1]);
        System.out.println(libro.igcHistoricoYRecalculado[4][0] + " -> " + libro.igcHistoricoYRecalculado[4][1]);
        System.out.println(libro.igcHistoricoYRecalculado[5][0] + " -> " + libro.igcHistoricoYRecalculado[5][1]);
        System.out.println(libro.igcHistoricoYRecalculado[6][0] + " -> " + libro.igcHistoricoYRecalculado[6][1]);
        System.out.println(libro.igcHistoricoYRecalculado[7][0] + " -> " + libro.igcHistoricoYRecalculado[7][1]);
        System.out.println(libro.igcHistoricoYRecalculado[8][0] + " -> " + libro.igcHistoricoYRecalculado[8][1]);
        System.out.println(libro.igcHistoricoYRecalculado[9][0] + " -> " + libro.igcHistoricoYRecalculado[9][1]);
    }

    public int calcularIgc(int year, int base){
        int igc = 0;

        if(year == 2011){
            System.out.println(2011);
            igc = Funciones.calcularIGCAt2011(base);
        }else if(year == 2012){
            System.out.println(2012);
            igc = Funciones.calcularIGCAt2012(base);
        }else if(year == 2013){
            System.out.println(2013);
            igc = Funciones.calcularIGCAt2013(base);
        }else if(year == 2014){
            System.out.println(2014);
            igc = Funciones.calcularIGCAt2014(base);
        }else if(year == 2015){
            System.out.println(2015);
            igc = Funciones.calcularIGCAt2015(base);
        }else if(year == 2016){
            System.out.println(2016);
            igc = Funciones.calcularIGCAt2016(base);
        }else if(year == 2017){
            System.out.println(2017);
            igc = Funciones.calcularIGCAt2017(base);
        }else if(year == 2018){
            System.out.println(2018);
            igc = Funciones.calcularIGCAt2018(base);
        }else if(year == 2019){
            System.out.println(2019);
            igc = Funciones.calcularIGCAt2019(base);
        }else if(year == 2020){
            System.out.println(2020);
            igc = Funciones.calcularIGCAt2020(base);
        }else if(year == 2021){
            System.out.println(2021);
            igc = Funciones.calcularIGCAt2021(base);
        }else if(year == 2022){
            System.out.println(2022);
            igc = Funciones.calcularIGCAt2022(base);
        }
        return igc;
    }

    public void diferenciaDeIgc(Libro libro){

        int slot1 = libro.igcHistoricoYRecalculado[0][1] - libro.igcHistoricoYRecalculado[0][0];
        int slot2 = libro.igcHistoricoYRecalculado[1][1] - libro.igcHistoricoYRecalculado[1][0];
        int slot3 = libro.igcHistoricoYRecalculado[2][1] - libro.igcHistoricoYRecalculado[2][0];
        int slot4 = libro.igcHistoricoYRecalculado[3][1] - libro.igcHistoricoYRecalculado[3][0];
        int slot5 = libro.igcHistoricoYRecalculado[4][1] - libro.igcHistoricoYRecalculado[4][0];
        int slot6 = libro.igcHistoricoYRecalculado[5][1] - libro.igcHistoricoYRecalculado[5][0];
        int slot7 = libro.igcHistoricoYRecalculado[6][1] - libro.igcHistoricoYRecalculado[6][0];
        int slot8 = libro.igcHistoricoYRecalculado[7][1] - libro.igcHistoricoYRecalculado[7][0];
        int slot9 = libro.igcHistoricoYRecalculado[8][1] - libro.igcHistoricoYRecalculado[8][0];
        int slot10 =  libro.igcHistoricoYRecalculado[9][1] - libro.igcHistoricoYRecalculado[9][0];

        libro.diferenciaDeBases[0] = slot1;
        libro.diferenciaDeBases[1] = slot2;
        libro.diferenciaDeBases[2] = slot3;
        libro.diferenciaDeBases[3] = slot4;
        libro.diferenciaDeBases[4] = slot5;
        libro.diferenciaDeBases[5] = slot6;
        libro.diferenciaDeBases[6] = slot7;
        libro.diferenciaDeBases[7] = slot8;
        libro.diferenciaDeBases[8] = slot9;
        libro.diferenciaDeBases[9] = slot10;

        System.out.println("======== Diferencia===========");
        System.out.println(libro.diferenciaDeBases[0]);
        System.out.println(libro.diferenciaDeBases[1]);
        System.out.println(libro.diferenciaDeBases[2]);
        System.out.println(libro.diferenciaDeBases[3]);
        System.out.println(libro.diferenciaDeBases[4]);
        System.out.println(libro.diferenciaDeBases[5]);
        System.out.println(libro.diferenciaDeBases[6]);
        System.out.println(libro.diferenciaDeBases[7]);
        System.out.println(libro.diferenciaDeBases[8]);
        System.out.println(libro.diferenciaDeBases[9]);
    }

    public double whatUtmIs(int data){
        int utmCorrecta = 1;

        if(data != 0 ){
            if(data == 2011){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2010.getUtm();
            }
            if(data == 2012){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2011.getUtm();
            }
            if(data == 2013){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2012.getUtm();
            }
            if(data == 2014){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2013.getUtm();
            }
            if(data == 2015){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2014.getUtm();
            }
            if(data == 2016){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2015.getUtm();
            }
            if(data == 2017){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2016.getUtm();
            }
            if(data == 2018){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2017.getUtm();
            }
            if(data == 2019){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2018.getUtm();
            }
            if(data == 2020){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2019.getUtm();
            }
            if(data == 2021){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2020.getUtm();
            }
            if(data == 2022){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2021.getUtm();
            }
        }

        return utmCorrecta;
    }

}
