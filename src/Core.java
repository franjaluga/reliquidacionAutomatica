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
                    case5();
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

        int[][] bases = new int[libro.getPeriodosAReliquidar()][2];

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

    public void case5(){
        System.out.println("Reporte final de reliquidación");
        // TODO proceso 4 : Reliquidar bases

        /*
            3. La base de TG se convierte (aquella porción que me corresponde) a UTM, desde la fecha del TG
            4. Las UTMS/años reliqu. , se devengan parceladamente en cada año anterior "SE RETROTRAEN" a sus valores UTM de cierre de dicho año al cierre
            5. Recalculamos el IGC por año (anteriores), sin perder la huella anterior
            6. Se obtiene una diferencia histórica, por año, de la diferencia entre las bases
            7. Se lleva a la UTM actual y se suman todas para obtener la reliquidación
            8. Compone la sumatoria del punto 7, y se resta al % del crédito que le corresponde, solo aquel CD va a devolución, lo demás se pierde
         */


    }

    // OTRAS FUNCIONES, LA IDEA ES NO ANIDAR MÁS ELEMENTOS

}
