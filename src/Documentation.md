# Documentation
## CLI App para calcular la reliquidación del art. 38 bis L.I.R (Régimen general)

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


### Implementations

1. Ingreso de base de TG a reliquidar
2. Ingresar participación del socio o accionista, en la base
3. Ingresar periodos a reliquidar"
4. Ingresar bases IGC por año"
5. Reliquidar bases"
0. Salir de la aplicación"


## Option 1: "Ingreso de base de TG a reliquidar"

Input:\
base = 160.742.789

Output:\
--> 160.742.789


## Option 2: "Ingresar participación del socio o accionista, en la base"

Input:\

porcentajeDeParticipacion = 0.4

Output:\
baseProporcional = 64.297.116 = (160.742.789 x 0.4)

