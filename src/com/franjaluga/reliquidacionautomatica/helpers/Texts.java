package com.franjaluga.reliquidacionautomatica.helpers;

public class Texts {

    public static void printMenu(){
        System.out.println("========== INICIO ==========\n"+
                "1....Ingresar base de TG a reliquidar\n"+
                "2....Ingresar participación del socio o accionista, en la base\n"+
                "3....Ingresar periodos a reliquidar\n"+
                "4....Ingresar bases IGC por año\n"+
                "5....Chequear Datos (Developer)\n"+
                "6....Reliquidar IGC por año (Developer)\n"+
                "7....Reporte de reliquidación (User)\n"+
                "0....Salir de la aplicación\n");
    }

    public static void printOption0(){
        System.out.println("Ha salido de la aplicación");
    }

    public static void printOption1(){
        System.out.println("Ingrese base de TG de la empresa (corresponde al 100%)");
    }


    public static void printOption2(){
        System.out.println("Ingrese el porcentaje de participación del socio o accionista"+
                "\nPor ejemplo: 40% debe anotarlo como 0.40");
    }

    public static void printOption5(){
        System.out.println("Reporte final de reliquidación");
    }
}
