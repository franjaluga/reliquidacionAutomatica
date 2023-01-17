import com.franjaluga.reliquidacionautomatica.constantes.UnidadesTributariasMensuales;
import com.franjaluga.reliquidacionautomatica.helpers.Texts;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Core {

    public void runCore(){

        boolean exit = false;

        // TODO: Reemplazar hacia...
        BaseGeneral baseGeneral = new BaseGeneral();

        BaseYear baseYearAntigua = new BaseYear();
        BaseYear recalculatedOldIgcByYear = new BaseYear();

        BaseYear baseYearNueva = new BaseYear();
        BaseYear recalculatedNewIgcByYear = new BaseYear();

        BaseYear diferenceOfIgcBetweentNewAndOldYearInClp = new BaseYear();

        BaseYear ActualValueFinalInClp = new BaseYear();


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
                    break;
                case 6:
                    System.out.println("OLD BASES");
                    calcIgcByYear( baseYearAntigua , recalculatedOldIgcByYear );
                    printIgcByYear( recalculatedOldIgcByYear );

                    System.out.println("NEW BASES");
                    calcIgcByYear( baseYearNueva , recalculatedNewIgcByYear );
                    printIgcByYear( recalculatedNewIgcByYear );

                    System.out.println("DIFS IN BASES");
                    calcDiferenceOfIgcBetweenNewAndOldBaseYear( recalculatedNewIgcByYear, recalculatedOldIgcByYear, diferenceOfIgcBetweentNewAndOldYearInClp );
                    printDiferenceOfIgcByYearCalculated( diferenceOfIgcBetweentNewAndOldYearInClp );
                    break;
                case 7:
                    bringOldUtmToNewUtmValuedInCLP( diferenceOfIgcBetweentNewAndOldYearInClp, baseGeneral, ActualValueFinalInClp );
                    printClpActualByYear(ActualValueFinalInClp);
                    break;
                default:
                    System.out.println("Vuelva a ingresar una opción válida");
                    break;
            }
        } while (exit != true);
    }


    public void bringOldUtmToNewUtmValuedInCLP(BaseYear diferenceOfIgcBetweentNewAndOldYearInClp, BaseGeneral baseGeneral, BaseYear ActualValueFinalInClp ){

        int oldClp = 0;
        double oldUtm = 0;
        double oldValueInOldUtm = 0;
        double actualBaseInClpValuedAtTGYear = 0;


        for( int  i = 0; i < 10; i++){

            oldClp = diferenceOfIgcBetweentNewAndOldYearInClp.getBySlot( i , 0);
            oldUtm = whatUtmIs( diferenceOfIgcBetweentNewAndOldYearInClp.getBySlot( i,1));
            oldValueInOldUtm = oldClp / oldUtm;

            actualBaseInClpValuedAtTGYear = oldValueInOldUtm * baseGeneral.getUtmTg();

            ActualValueFinalInClp.setBySlot( i,0, (int) (actualBaseInClpValuedAtTGYear) );
            ActualValueFinalInClp.setBySlot( i,1, ActualValueFinalInClp.getBySlot(i,1) );
        }
    }

    public void printClpActualByYear( BaseYear ActualValueFinalInClp){

        for( int i = 0; i < 10 ; i++ ){
            System.out.println(ActualValueFinalInClp.getBySlot( i, 0) + " ; " + ActualValueFinalInClp.getBySlot( i , 1));
        }
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

        for( int i = 0 ; i < 10 ; i++ ){
            int year = baseYearAntigua.getBySlot( i, 1);
            baseYearNueva.setBySlot( i , 1, year );
        }

        for( int i = 0; i < 10 ; i++ ){
            System.out.println(baseYearNueva.getBySlot( i, 0) + " ; " + baseYearNueva.getBySlot( i , 1));
        }
    }


    public void calcIgcByYear( BaseYear baseYearNueva, BaseYear recalculatedNewIgcByYear ){

        int actualIgc = 0;

        for(int i = 0; i < 10 ; i++){

            int year = baseYearNueva.getBySlot(i,1);
            int base = baseYearNueva.getBySlot(i,0);

            actualIgc = calcularIgc( year, base );

            recalculatedNewIgcByYear.setBySlot(i , 0, actualIgc);
            recalculatedNewIgcByYear.setBySlot(i , 1, year);
        }
    }


    public void printIgcByYear( BaseYear recalculatedNewIgcByYear){

        for( int i = 0; i < 10 ; i++ ){
            System.out.println(recalculatedNewIgcByYear.getBySlot( i, 0) + " ; " + recalculatedNewIgcByYear.getBySlot( i , 1));
        }
    }


    public void calcDiferenceOfIgcBetweenNewAndOldBaseYear( BaseYear recalculatedNewIgcByYear, BaseYear recalculatedOldIgcByYear, BaseYear diferenceOfIgcBetweentNewAndOldYear ){

        int diferenceOfIgcCalculated = 0;

        for( int i = 0; i < 10; i++){

            diferenceOfIgcCalculated = recalculatedNewIgcByYear.getBySlot( i ,0) - recalculatedOldIgcByYear.getBySlot( i ,0);

            diferenceOfIgcBetweentNewAndOldYear.setBySlot( i,0, diferenceOfIgcCalculated );
            diferenceOfIgcBetweentNewAndOldYear.setBySlot( i,1, recalculatedOldIgcByYear.getBySlot( i,1 ) );

        }

    }

    public void printDiferenceOfIgcByYearCalculated( BaseYear diferenceOfIgcBetweentNewAndOldYear){

        for( int i = 0; i < 10 ; i++ ){
            System.out.println(diferenceOfIgcBetweentNewAndOldYear.getBySlot( i, 0) + " ; " + diferenceOfIgcBetweentNewAndOldYear.getBySlot( i , 1));
        }
    }


    public double baseToUtmInDateTg(BaseGeneral baseGeneral){

        // TODO : para revisar con el ejercicio del profe double utmTg = 52842;

        double utmTg = 0;
        int yearTG = baseGeneral.getTgYear();

        //int utmInTgYear = whatUtmIs( yearTG );
        baseGeneral.setUtmTg(52842);
        int utmInTgYear = baseGeneral.getUtmTg();

        int baseTgInClp = baseGeneral.getBase();

        int baseTgInUtm = baseTgInClp / utmInTgYear;

        return baseTgInUtm;
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
    }



    public double howMuchUtmIsPerYear(BaseGeneral baseGeneral){
        String data;

        // visualizar cuanto queda por año
        double basePorYearToReliq = baseToUtmInDateTg( baseGeneral ) / baseGeneral.getYearsToReliq();

        baseGeneral.setBaseproporcionalEnClp( basePorYearToReliq );

        return basePorYearToReliq;
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


    public int calcularIgc(int year, int base){
        int igc = 0;

        if(year == 2011){
            System.out.println("AT2012");
            igc = Funciones.calcularIGCAt2012(base);
        }else if(year == 2012){
            System.out.println("AT2013");
            igc = Funciones.calcularIGCAt2013(base);
        }else if(year == 2013){
            System.out.println("AT2014");
            igc = Funciones.calcularIGCAt2014(base);
        }else if(year == 2014){
            System.out.println("AT2015");
            igc = Funciones.calcularIGCAt2015(base);
        }else if(year == 2015){
            System.out.println("AT2016");
            igc = Funciones.calcularIGCAt2016(base);
        }else if(year == 2016){
            System.out.println("AT2017");
            igc = Funciones.calcularIGCAt2017(base);
        }else if(year == 2017){
            System.out.println("AT2018");
            igc = Funciones.calcularIGCAt2018(base);
        }else if(year == 2018){
            System.out.println("AT2019");
            igc = Funciones.calcularIGCAt2019(base);
        }else if(year == 2019){
            System.out.println("AT2020");
            igc = Funciones.calcularIGCAt2020(base);
        }else if(year == 2020){
            System.out.println("AT2021");
            igc = Funciones.calcularIGCAt2021(base);
        }else if(year == 2021){
            System.out.println("AT2022");
            igc = Funciones.calcularIGCAt2022(base);
        }else{
            System.out.println("error de año");
        }
        return igc;
    }


    public int whatUtmIs(int year){
        int utmCorrecta = 1;

        if(year != 0 ){
            if(year == 2011){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2011.getUtm();
            }
            if(year == 2012){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2012.getUtm();
            }
            if(year == 2013){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2013.getUtm();
            }
            if(year == 2014){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2014.getUtm();
            }
            if(year == 2015){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2015.getUtm();
            }
            if(year == 2016){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2016.getUtm();
            }
            if(year == 2017){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2017.getUtm();
            }
            if(year == 2018){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2018.getUtm();
            }
            if(year == 2019){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2019.getUtm();
            }
            if(year == 2020){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2020.getUtm();
            }
            if(year == 2021){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2021.getUtm();
            }
            if(year == 2022){
                utmCorrecta = UnidadesTributariasMensuales.UTM_DIC_2022.getUtm();
            }
        }

        return utmCorrecta;
    }

}
