import com.franjaluga.reliquidacionautomatica.constantes.UnidadesTributariasMensuales;
import com.franjaluga.reliquidacionautomatica.helpers.Texts;

import java.util.Scanner;

public class Core {

    public void runCore(){

        boolean exit = false;

        // TODO: Reemplazar hacia...
        BaseGeneral baseGeneral = new BaseGeneral();
        BaseYear baseYearAntigua = new BaseYear();
        BaseYear aditionByYearInClp = new BaseYear();
        BaseYear baseYearNueva = new BaseYear();


        // TODO: proveniente de...
        Libro libro = new Libro();

        do {
            Texts.printMenu();
            Scanner scanConsoleUserResponse = new Scanner(System.in);
            int consoleUserMenuResponse;

            consoleUserMenuResponse = Integer.parseInt(scanConsoleUserResponse.nextLine());

            switch (consoleUserMenuResponse) {
                case 0:
                    Texts.printOption0();
                    exit = true;
                    break;
                case 1:
                    case1(baseGeneral);
                    break;
                case 2:
                    case2(baseGeneral);
                    break;
                case 3:
                    case3(baseGeneral);
                    break;
                case 4:
                    case4(baseGeneral, baseYearAntigua);
                    break;
                case 5:
                    printUtmToTgDate( baseGeneral );
                    printUtmPerYearInUtm( baseGeneral );
                    printClpPerYearFromUtmPerYear ( baseGeneral, baseYearAntigua, baseYearNueva );

                case 6:

                    case5(baseGeneral,
                            aditionByYearInClp,
                            baseYearNueva);
                    break;
                default:
                    System.out.println("Vuelva a ingresar una opción válida");
                    break;
            }
        } while (exit != true);
    }


    public static void case1(BaseGeneral baseGeneral){
        Texts.printOption1();
        Scanner scanSubConsoleUserResponse = new Scanner(System.in);
        int subConsoleUserMenuResponse = Integer.parseInt(scanSubConsoleUserResponse.nextLine());

        baseGeneral.setBase(subConsoleUserMenuResponse);
        System.out.println("Ingresó una base: " + baseGeneral.getBase());

    }


    public void case2(BaseGeneral baseGeneral){
        Texts.printOption2();

        Scanner scanSubConsoleUserResponse = new Scanner(System.in);
        float subConsoleUserMenuResponse = Float.parseFloat(scanSubConsoleUserResponse.nextLine());

        baseGeneral.setPorcentajeDeParticipacion(subConsoleUserMenuResponse);
        System.out.println("Ingresó el siguiente decimal: " + baseGeneral.getPorcentajeDeParticipacion());

        baseGeneral.setBaseProporcional( (int) ( baseGeneral.getBase() * baseGeneral.getPorcentajeDeParticipacion() ) );

        System.out.println("Su proporción es " + baseGeneral.getBase() + " x " + baseGeneral.getPorcentajeDeParticipacion() + " = " + baseGeneral.getBaseProporcional());

    }

    public void case3(BaseGeneral baseGeneral){

        Scanner scanSubConsoleUserResponse = new Scanner(System.in);

        System.out.println("Ingrese el 'MES' de TERMINO DE GIRO\n (Ejemplo: Enero : 1 ; Febrero : 2, Diciembre: 12");
        baseGeneral.setTgMonth( Integer.parseInt( scanSubConsoleUserResponse.nextLine() ) );

        System.out.println("Ingrese el 'AÑO COMERCIAL' de TERMINO DE GIRO: ");
        baseGeneral.setTgYear( Integer.parseInt( scanSubConsoleUserResponse.nextLine() ) );

        System.out.println("Ingrese el 'MES' en que ADQUIRIÓ las acciones o derechos\n (Ejemplo: Enero : 1 ; Febrero : 2, Diciembre: 12");
        baseGeneral.setInitMonth( Integer.parseInt( scanSubConsoleUserResponse.nextLine() ) );

        System.out.println("Ingrese el 'AÑO COMERCIAL' en que ADQUIRIÓ las acciones o derechos:");
        baseGeneral.setInitYear( Integer.parseInt(scanSubConsoleUserResponse.nextLine()) );

        System.out.println("|---------------------------------------|");
        System.out.println("  se ocupará mes/año (inicial): " + baseGeneral.getInitMonth() + "/" + baseGeneral.getInitYear() );
        System.out.println("  se ocupará mes/año (final)  : " + baseGeneral.getTgMonth() + "/" + baseGeneral.getTgYear() );
        System.out.println("|---------------------------------------|");


        if( ( ( baseGeneral.getTgYear() - 1 ) - ( baseGeneral.getInitYear() + 1 ) ) > 10 ){
            baseGeneral.setYearsMaxToReliq(10);
            baseGeneral.setInitYear(baseGeneral.getTgYear()-10);
        }else{
            baseGeneral.setYearsMaxToReliq( ( baseGeneral.getTgYear() ) - ( baseGeneral.getInitYear() )  + 1 );
        }

        if(baseGeneral.getYearsMaxToReliq() <= 0){
            baseGeneral.setYearsMaxToReliq(0);
        }

        System.out.println("Eso significa que puedes reliquidar en: " + baseGeneral.getYearsMaxToReliq() + " años como máximo");
        System.out.println("Entonces, ¿en cuantos años quieres reliquidar?: ");

        int tryYearsToReliq = Integer.parseInt(scanSubConsoleUserResponse.nextLine());

        if( tryYearsToReliq > 0 && tryYearsToReliq <= baseGeneral.getYearsMaxToReliq() ){
            baseGeneral.setYearsToReliq(tryYearsToReliq);
        }else{
            System.out.println("No ingresó un dato válido");
        }

        System.out.println("Ingresó "+ baseGeneral.getYearsToReliq() + " años a reliquidar");
    }



    public void case4(BaseGeneral baseGeneral, BaseYear baseYearAntigua){

        Scanner scanSubConsoleUserResponse = new Scanner(System.in);

        int data = 0;

        for(int i = 0; i < baseGeneral.getYearsToReliq() ; i++ ){

            System.out.println("Ingrese Base imponible AT: "+ ( baseGeneral.getInitYear() + i + 1 ) );

            data =  Integer.parseInt( scanSubConsoleUserResponse.nextLine() );

            baseYearAntigua.setBySlot( i , 0 , data );
            baseYearAntigua.setBySlot( i , 1 , baseGeneral.getInitYear() + i );

            System.out.println("Ingresó:"+
                    baseYearAntigua.getBySlot( i , 0 )+"\n"+
                    baseYearAntigua.getBySlot( i ,1));
        }

        System.out.println("Se trabajarán con las siguientes bases por año");

        for( int i = 0; i < 10; i++){
            System.out.println( baseYearAntigua.getBySlot( i , 0 ) + ";" +  baseYearAntigua.getBySlot( i , 1 ) );
        }

    }


    public void printUtmToTgDate( BaseGeneral baseGeneral ){

        Texts.printOption5();
        System.out.println("La base convertida a UTM, al valor de la fecha de TG: " + baseToUtmInDateTg( baseGeneral ) );

    }


    public void printUtmPerYearInUtm( BaseGeneral baseGeneral ){

        double utmPerYearCalculated = howMuchUtmIsPerYear( baseGeneral );

        baseGeneral.setUtmPerYearCalculated(utmPerYearCalculated);
        System.out.println("La base que se agrega por año (en UTM) es: " + baseGeneral.getUtmPerYearCalculated() );


    }

    // TODO: DESDE AQUI HACIA ABAJO, DEBE REFACTORIZAR EN LAS CLASES NUEVAS


    public void printClpPerYearFromUtmPerYear( BaseGeneral baseGeneral,
                                               BaseYear baseYearAntigua,
                                               BaseYear baseYearNueva){

        int [] evaluatedUtm = new int [10];
        int yearInEvaluation = 0;

        double actualUtmPerYear = baseGeneral.getUtmPerYearCalculated();

        for( int i = 0; i < 10; i++){
            yearInEvaluation = baseYearAntigua.getBySlot( i , 1);
            evaluatedUtm[i] = whatUtmIs(yearInEvaluation);
        }

        for( int i = 0; i < 10; i++){

            int convertido = (int) ( ( evaluatedUtm[i] * actualUtmPerYear ) );

            int suma = convertido + baseYearAntigua.getBySlot( i , 0 );

            baseYearNueva.setBySlot( i , 0, suma );

        }

        for( int i = 0; i < 10 ; i++ ){

            System.out.println(baseYearNueva.getBySlot( i, 0) + "-> " + baseYearNueva.getBySlot( i , 1));

        }

    }







    public void setAditionByYearInClp( BaseGeneral baseGeneral,
                                       BaseYear aditionByYearInClp,
                                       BaseYear baseYearNueva) {


        // aditionByYearInUtm(baseGeneral.getUtmPerYearCalculated(), aditionByYearInClp, baseYearNueva);

    }






    public void case5(BaseGeneral baseGeneral,
                      BaseYear aditionByYearInClp,
                      BaseYear baseYearNueva){


        //addUtmToBaseRecalc( baseGeneral, baseYearAntigua, baseYearAntiguaPlusUtmInCLPOfYear );


        /****
         *

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

         *
         */


    }




    public double baseToUtmInDateTg(BaseGeneral baseGeneral){

        selectorDeUtm( baseGeneral );
        double basePp = baseGeneral.getBaseProporcional();

        //double utmTg = baseGeneral.getUtmTg();
        double utmTg = 52842;
        // TODO : para revisar con el ejercicio del profe double utmTg = 52842;
        // TODO : para revisar con el ejercicio del s.i.i double utmTg = 54171;

        baseGeneral.setBaseProporcionalEnUtm( basePp / utmTg );

        double utmTgReturn = baseGeneral.getBaseProporcionalEnUtm();

        return utmTgReturn;
    }


    public void selectorDeUtm(BaseGeneral baseGeneral){
         int yearTg = baseGeneral.getTgYear();

         switch (yearTg){
             case 2022:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2022.getUtm());
                 break;

             case 2021:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2021.getUtm());
                 break;

             case 2020:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2020.getUtm());
                 break;

             case 2019:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2019.getUtm());
                 break;

             case 2018:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2018.getUtm());
                 break;

             case 2017:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2017.getUtm());
                 break;

             case 2016:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2016.getUtm());
                 break;

             case 2015:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2015.getUtm());
                 break;

             case 2014:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2014.getUtm());
                 break;

             case 2013:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2013.getUtm());
                 break;

             case 2012:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2012.getUtm());
                 break;

             case 2011:
                 baseGeneral.setUtmTg(UnidadesTributariasMensuales.UTM_DIC_2011.getUtm());
                 break;

             default:
                 System.out.println("case default");
                 break;
         }
        System.out.println("SE USÓ UTM DE ---->" + baseGeneral.getUtmTg());
    }


    public void setAditionByYearInClp(double utmPerYearCalculated, BaseYear aditionByYearInUtm, BaseYear baseYearNueva) {

        setAditionByYearFromUtmToClp( utmPerYearCalculated , aditionByYearInUtm, baseYearNueva );

    }


    public void setAditionByYearFromUtmToClp( double utmPerYearCalculated, BaseYear aditionByYearInUtm, BaseYear baseYearNueva){

        int year = 2022;
        int aditionConvertedInClp = 0;
        int utmToUse = 0;

        for(int i = 0; i < 10; i++){

            year = aditionByYearInUtm.getBySlot( i, 1 );

            utmToUse = whatUtmIs(year);

            aditionConvertedInClp = (int) ( utmPerYearCalculated * utmToUse );

            aditionByYearInUtm.setBySlot( i, 0, baseYearNueva.getBySlot( i , 0) + aditionConvertedInClp);
            aditionByYearInUtm.setBySlot( i, 1, year);

        }

    }



    public double howMuchUtmIsPerYear(BaseGeneral baseGeneral){
        String data;

        // visualizar cuanto queda por año
        double basePorYearToReliq = baseToUtmInDateTg( baseGeneral ) / baseGeneral.getYearsToReliq();

        baseGeneral.setBaseproporcionalEnClp( basePorYearToReliq );

        return basePorYearToReliq;
    }


    public void addUtmToBaseRecalc(BaseGeneral baseGeneral,
                                   BaseYear baseYearAntigua,
                                   BaseYear baseYearAntiguaPlusUtmInCLPOfYear){

        for(int i = 0; i <10; i++){

            evaluarYearInitial( baseGeneral,
                                baseYearAntigua,
                                baseYearAntiguaPlusUtmInCLPOfYear,
                                i);
        }

    }


    public void evaluarYearInitial(BaseGeneral baseGeneral,
                                   BaseYear baseYearAntigua,
                                   BaseYear baseYearAntiguaPlusUtmInCLPOfYear,
                                   int indice){

        for(int i = 0; i < 10; i++){
            int yeartoValidate = baseYearAntigua.getBySlot( i , 1 );
            comprobar( yeartoValidate , baseGeneral, baseYearAntiguaPlusUtmInCLPOfYear, baseYearAntigua, i);
        }

        System.out.println( baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( 0, 0 ) +" , "+ baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( 0 , 1 ));
        System.out.println( baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( 1, 0 ) +" , "+ baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( 1 , 1 ));
        System.out.println( baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( 2, 0 ) +" , "+ baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( 2 , 1 ));


    }


    public void comprobar( int year,
                           BaseGeneral baseGeneral,
                           BaseYear baseYearAntiguaPlusUtmInCLPOfYear,
                           BaseYear baseYearAntigua,
                           int i){

        double convertido = 0;

        if(year == 2011){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2010.getUtm();
        }

        if(year == 2012){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2011.getUtm();
        }

        if(year == 2013){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2012.getUtm();
        }

        if(year == 2014){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2013.getUtm();
        }

        if(year == 2015){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2014.getUtm();
        }

        if(year == 2016){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2015.getUtm();
        }

        if(year == 2017){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2016.getUtm();
        }

        if(year == 2018){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2017.getUtm();
        }

        if(year == 2019){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2018.getUtm();
        }

        if(year == 2020){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2019.getUtm();
        }

        if(year == 2021){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2020.getUtm();
        }

        if(year == 2022){
            convertido = baseGeneral.getBaseProporcionalEnUtm() * UnidadesTributariasMensuales.UTM_DIC_2021.getUtm();
        }

        convertido = Math.round(convertido);
        System.out.println("convertido, " + year + "->" +  convertido);

        baseYearAntiguaPlusUtmInCLPOfYear.setBySlot(i, 0, baseYearAntigua.getBySlot(i,0) + (int) (convertido));
        baseYearAntiguaPlusUtmInCLPOfYear.setBySlot(i, 1, year);

    }



    public void printDataRecalc(BaseYear baseYearAntiguaPlusUtmInCLPOfYear){
        for( int i = 0; i < 10; i++){
            System.out.println( baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( i , 0 ) + ";" +  baseYearAntiguaPlusUtmInCLPOfYear.getBySlot( i , 1 ) );
        }


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

    public int whatUtmIs(int year){
        int utmCorrecta = 1;

        if(year != 0 ){
            if(year == 2011){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2010.getUtm();
            }
            if(year == 2012){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2011.getUtm();
            }
            if(year == 2013){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2012.getUtm();
            }
            if(year == 2014){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2013.getUtm();
            }
            if(year == 2015){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2014.getUtm();
            }
            if(year == 2016){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2015.getUtm();
            }
            if(year == 2017){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2016.getUtm();
            }
            if(year == 2018){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2017.getUtm();
            }
            if(year == 2019){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2018.getUtm();
            }
            if(year == 2020){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2019.getUtm();
            }
            if(year == 2021){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2020.getUtm();
            }
            if(year == 2022){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2021.getUtm();
            }
        }

        return utmCorrecta;
    }

}
