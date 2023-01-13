public class Funciones {
    public static int calcularIGCAt2022(int base){

        int t_1Superior = Tramos2022.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2022.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2022.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2022.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2022.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2022.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2022.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2022.TASA_1.getTasa();
        float t2_tasa = Tasas2022.TASA_2.getTasa();
        float t3_tasa = Tasas2022.TASA_3.getTasa();
        float t4_tasa = Tasas2022.TASA_4.getTasa();
        float t5_tasa = Tasas2022.TASA_5.getTasa();
        float t6_tasa = Tasas2022.TASA_6.getTasa();
        float t7_tasa = Tasas2022.TASA_7.getTasa();
        float t8_tasa = Tasas2022.TASA_8.getTasa();

        double t1_rebaja = Rebajas2022.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2022.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2022.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2022.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2022.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2022.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2022.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2022.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2022 = new DataYear();

        $2022.setTramos(tramos);
        $2022.setTasas(tasas);
        $2022.setRebajas(rebajas);

        int[] trSuperior = $2022.getTramos();
        float[] tasa = $2022.getTasas();
        double[] rebaja = $2022.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2021(int base){

        int t_1Superior = Tramos2021.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2021.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2021.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2021.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2021.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2021.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2021.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2021.TASA_1.getTasa();
        float t2_tasa = Tasas2021.TASA_2.getTasa();
        float t3_tasa = Tasas2021.TASA_3.getTasa();
        float t4_tasa = Tasas2021.TASA_4.getTasa();
        float t5_tasa = Tasas2021.TASA_5.getTasa();
        float t6_tasa = Tasas2021.TASA_6.getTasa();
        float t7_tasa = Tasas2021.TASA_7.getTasa();
        float t8_tasa = Tasas2021.TASA_8.getTasa();

        double t1_rebaja = Rebajas2021.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2021.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2021.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2021.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2021.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2021.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2021.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2021.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2021 = new DataYear();

        $2021.setTramos(tramos);
        $2021.setTasas(tasas);
        $2021.setRebajas(rebajas);


        int[] trSuperior = $2021.getTramos();
        float[] tasa = $2021.getTasas();
        double[] rebaja = $2021.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;

    }

    public static int calcularIGCAt2020(int base){

        int t_1Superior = Tramos2020.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2020.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2020.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2020.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2020.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2020.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2020.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2020.TASA_1.getTasa();
        float t2_tasa = Tasas2020.TASA_2.getTasa();
        float t3_tasa = Tasas2020.TASA_3.getTasa();
        float t4_tasa = Tasas2020.TASA_4.getTasa();
        float t5_tasa = Tasas2020.TASA_5.getTasa();
        float t6_tasa = Tasas2020.TASA_6.getTasa();
        float t7_tasa = Tasas2020.TASA_7.getTasa();
        float t8_tasa = Tasas2020.TASA_8.getTasa();

        double t1_rebaja = Rebajas2020.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2020.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2020.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2020.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2020.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2020.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2020.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2020.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2020 = new DataYear();

        $2020.setTramos(tramos);
        $2020.setTasas(tasas);
        $2020.setRebajas(rebajas);


        int[] trSuperior = $2020.getTramos();
        float[] tasa = $2020.getTasas();
        double[] rebaja = $2020.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;

    }

    public static int calcularIGCAt2019(int base){

        int t_1Superior = Tramos2019.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2019.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2019.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2019.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2019.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2019.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2019.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2019.TASA_1.getTasa();
        float t2_tasa = Tasas2019.TASA_2.getTasa();
        float t3_tasa = Tasas2019.TASA_3.getTasa();
        float t4_tasa = Tasas2019.TASA_4.getTasa();
        float t5_tasa = Tasas2019.TASA_5.getTasa();
        float t6_tasa = Tasas2019.TASA_6.getTasa();
        float t7_tasa = Tasas2019.TASA_7.getTasa();
        float t8_tasa = Tasas2019.TASA_8.getTasa();

        double t1_rebaja = Rebajas2019.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2019.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2019.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2019.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2019.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2019.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2019.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2019.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2019 = new DataYear();

        $2019.setTramos(tramos);
        $2019.setTasas(tasas);
        $2019.setRebajas(rebajas);


        int[] trSuperior = $2019.getTramos();
        float[] tasa = $2019.getTasas();
        double[] rebaja = $2019.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2018(int base){

        int t_1Superior = Tramos2018.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2018.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2018.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2018.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2018.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2018.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2018.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2018.TASA_1.getTasa();
        float t2_tasa = Tasas2018.TASA_2.getTasa();
        float t3_tasa = Tasas2018.TASA_3.getTasa();
        float t4_tasa = Tasas2018.TASA_4.getTasa();
        float t5_tasa = Tasas2018.TASA_5.getTasa();
        float t6_tasa = Tasas2018.TASA_6.getTasa();
        float t7_tasa = Tasas2018.TASA_7.getTasa();
        float t8_tasa = Tasas2018.TASA_8.getTasa();

        double t1_rebaja = Rebajas2018.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2018.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2018.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2018.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2018.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2018.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2018.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2018.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2018 = new DataYear();

        $2018.setTramos(tramos);
        $2018.setTasas(tasas);
        $2018.setRebajas(rebajas);


        int[] trSuperior = $2018.getTramos();
        float[] tasa = $2018.getTasas();
        double[] rebaja = $2018.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2017(int base){

        int t_1Superior = Tramos2017.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2017.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2017.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2017.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2017.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2017.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2017.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2017.TASA_1.getTasa();
        float t2_tasa = Tasas2017.TASA_2.getTasa();
        float t3_tasa = Tasas2017.TASA_3.getTasa();
        float t4_tasa = Tasas2017.TASA_4.getTasa();
        float t5_tasa = Tasas2017.TASA_5.getTasa();
        float t6_tasa = Tasas2017.TASA_6.getTasa();
        float t7_tasa = Tasas2017.TASA_7.getTasa();
        float t8_tasa = Tasas2017.TASA_8.getTasa();

        double t1_rebaja = Rebajas2017.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2017.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2017.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2017.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2017.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2017.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2017.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2017.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2017 = new DataYear();

        $2017.setTramos(tramos);
        $2017.setTasas(tasas);
        $2017.setRebajas(rebajas);


        int[] trSuperior = $2017.getTramos();
        float[] tasa = $2017.getTasas();
        double[] rebaja = $2017.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2016(int base){

        int t_1Superior = Tramos2016.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2016.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2016.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2016.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2016.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2016.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2016.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2016.TASA_1.getTasa();
        float t2_tasa = Tasas2016.TASA_2.getTasa();
        float t3_tasa = Tasas2016.TASA_3.getTasa();
        float t4_tasa = Tasas2016.TASA_4.getTasa();
        float t5_tasa = Tasas2016.TASA_5.getTasa();
        float t6_tasa = Tasas2016.TASA_6.getTasa();
        float t7_tasa = Tasas2016.TASA_7.getTasa();
        float t8_tasa = Tasas2016.TASA_8.getTasa();

        double t1_rebaja = Rebajas2016.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2016.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2016.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2016.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2016.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2016.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2016.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2016.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2016 = new DataYear();

        $2016.setTramos(tramos);
        $2016.setTasas(tasas);
        $2016.setRebajas(rebajas);


        int[] trSuperior = $2016.getTramos();
        float[] tasa = $2016.getTasas();
        double[] rebaja = $2016.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2015(int base){

        int t_1Superior = Tramos2015.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2015.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2015.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2015.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2015.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2015.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2015.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2015.TASA_1.getTasa();
        float t2_tasa = Tasas2015.TASA_2.getTasa();
        float t3_tasa = Tasas2015.TASA_3.getTasa();
        float t4_tasa = Tasas2015.TASA_4.getTasa();
        float t5_tasa = Tasas2015.TASA_5.getTasa();
        float t6_tasa = Tasas2015.TASA_6.getTasa();
        float t7_tasa = Tasas2015.TASA_7.getTasa();
        float t8_tasa = Tasas2015.TASA_8.getTasa();

        double t1_rebaja = Rebajas2015.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2015.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2015.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2015.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2015.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2015.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2015.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2015.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2015 = new DataYear();

        $2015.setTramos(tramos);
        $2015.setTasas(tasas);
        $2015.setRebajas(rebajas);


        int[] trSuperior = $2015.getTramos();
        float[] tasa = $2015.getTasas();
        double[] rebaja = $2015.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2014(int base){

        int t_1Superior = Tramos2014.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2014.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2014.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2014.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2014.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2014.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2014.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2014.TASA_1.getTasa();
        float t2_tasa = Tasas2014.TASA_2.getTasa();
        float t3_tasa = Tasas2014.TASA_3.getTasa();
        float t4_tasa = Tasas2014.TASA_4.getTasa();
        float t5_tasa = Tasas2014.TASA_5.getTasa();
        float t6_tasa = Tasas2014.TASA_6.getTasa();
        float t7_tasa = Tasas2014.TASA_7.getTasa();
        float t8_tasa = Tasas2014.TASA_8.getTasa();

        double t1_rebaja = Rebajas2014.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2014.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2014.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2014.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2014.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2014.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2014.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2014.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2014 = new DataYear();

        $2014.setTramos(tramos);
        $2014.setTasas(tasas);
        $2014.setRebajas(rebajas);


        int[] trSuperior = $2014.getTramos();
        float[] tasa = $2014.getTasas();
        double[] rebaja = $2014.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2013(int base){

        int t_1Superior = Tramos2013.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2013.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2013.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2013.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2013.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2013.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2013.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2013.TASA_1.getTasa();
        float t2_tasa = Tasas2013.TASA_2.getTasa();
        float t3_tasa = Tasas2013.TASA_3.getTasa();
        float t4_tasa = Tasas2013.TASA_4.getTasa();
        float t5_tasa = Tasas2013.TASA_5.getTasa();
        float t6_tasa = Tasas2013.TASA_6.getTasa();
        float t7_tasa = Tasas2013.TASA_7.getTasa();
        float t8_tasa = Tasas2013.TASA_8.getTasa();

        double t1_rebaja = Rebajas2013.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2013.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2013.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2013.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2013.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2013.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2013.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2013.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2013 = new DataYear();

        $2013.setTramos(tramos);
        $2013.setTasas(tasas);
        $2013.setRebajas(rebajas);


        int[] trSuperior = $2013.getTramos();
        float[] tasa = $2013.getTasas();
        double[] rebaja = $2013.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2012(int base){

        int t_1Superior = Tramos2012.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2012.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2012.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2012.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2012.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2012.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2012.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2012.TASA_1.getTasa();
        float t2_tasa = Tasas2012.TASA_2.getTasa();
        float t3_tasa = Tasas2012.TASA_3.getTasa();
        float t4_tasa = Tasas2012.TASA_4.getTasa();
        float t5_tasa = Tasas2012.TASA_5.getTasa();
        float t6_tasa = Tasas2012.TASA_6.getTasa();
        float t7_tasa = Tasas2012.TASA_7.getTasa();
        float t8_tasa = Tasas2012.TASA_8.getTasa();

        double t1_rebaja = Rebajas2012.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2012.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2012.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2012.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2012.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2012.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2012.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2012.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2012 = new DataYear();

        $2012.setTramos(tramos);
        $2012.setTasas(tasas);
        $2012.setRebajas(rebajas);


        int[] trSuperior = $2012.getTramos();
        float[] tasa = $2012.getTasas();
        double[] rebaja = $2012.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularIGCAt2011(int base){

        int t_1Superior = Tramos2011.TRAMO_1_SUPERIOR.getTramo();
        int t_2Superior = Tramos2011.TRAMO_2_SUPERIOR.getTramo();
        int t_3Superior = Tramos2011.TRAMO_3_SUPERIOR.getTramo();
        int t_4Superior = Tramos2011.TRAMO_4_SUPERIOR.getTramo();
        int t_5Superior = Tramos2011.TRAMO_5_SUPERIOR.getTramo();
        int t_6Superior = Tramos2011.TRAMO_6_SUPERIOR.getTramo();
        int t_7Superior = Tramos2011.TRAMO_7_SUPERIOR.getTramo();

        float t1_tasa = Tasas2011.TASA_1.getTasa();
        float t2_tasa = Tasas2011.TASA_2.getTasa();
        float t3_tasa = Tasas2011.TASA_3.getTasa();
        float t4_tasa = Tasas2011.TASA_4.getTasa();
        float t5_tasa = Tasas2011.TASA_5.getTasa();
        float t6_tasa = Tasas2011.TASA_6.getTasa();
        float t7_tasa = Tasas2011.TASA_7.getTasa();
        float t8_tasa = Tasas2011.TASA_8.getTasa();

        double t1_rebaja = Rebajas2011.REBAJA_TRAMO_1.getRebaja();
        double t2_rebaja = Rebajas2011.REBAJA_TRAMO_2.getRebaja();
        double t3_rebaja = Rebajas2011.REBAJA_TRAMO_3.getRebaja();
        double t4_rebaja = Rebajas2011.REBAJA_TRAMO_4.getRebaja();
        double t5_rebaja = Rebajas2011.REBAJA_TRAMO_5.getRebaja();
        double t6_rebaja = Rebajas2011.REBAJA_TRAMO_6.getRebaja();
        double t7_rebaja = Rebajas2011.REBAJA_TRAMO_7.getRebaja();
        double t8_rebaja = Rebajas2011.REBAJA_TRAMO_8.getRebaja();

        int[] tramos = {t_1Superior,t_2Superior,t_3Superior,t_4Superior,t_5Superior,t_6Superior,t_7Superior};
        float[] tasas = {t1_tasa,t2_tasa,t3_tasa,t4_tasa,t5_tasa,t6_tasa,t7_tasa,t8_tasa};
        double[] rebajas = {t1_rebaja,t2_rebaja,t3_rebaja,t4_rebaja,t5_rebaja,t6_rebaja,t7_rebaja,t8_rebaja};

        DataYear $2011 = new DataYear();

        $2011.setTramos(tramos);
        $2011.setTasas(tasas);
        $2011.setRebajas(rebajas);


        int[] trSuperior = $2011.getTramos();
        float[] tasa = $2011.getTasas();
        double[] rebaja = $2011.getRebajas();

        int igc = calcularGlobal(base, trSuperior, tasa, rebaja);

        return igc;
    }

    public static int calcularGlobal(int base, int[] tramoSuperior, float[] tasa, double[] rebaja){

        int igc = 0;

        int t1Superior = tramoSuperior[0];
        int t2Superior = tramoSuperior[1];
        int t3Superior = tramoSuperior[2];
        int t4Superior = tramoSuperior[3];
        int t5Superior = tramoSuperior[4];
        int t6Superior = tramoSuperior[5];
        int t7Superior = tramoSuperior[6];

        float tasa1 = tasa[0];
        float tasa2 = tasa[1];
        float tasa3 = tasa[2];
        float tasa4 = tasa[3];
        float tasa5 = tasa[4];
        float tasa6 = tasa[5];
        float tasa7 = tasa[6];
        float tasa8 = tasa[7];

        double rebaja1 = rebaja[0];
        double rebaja2 = rebaja[1];
        double rebaja3 = rebaja[2];
        double rebaja4 = rebaja[3];
        double rebaja5 = rebaja[4];
        double rebaja6 = rebaja[5];
        double rebaja7 = rebaja[6];
        double rebaja8 = rebaja[7];

        if( base >= 0 && base <= t1Superior ){
            igc = (int) Math.round((base * tasa1) - rebaja1);
            System.out.println(base +";"+ tasa1+";"+ rebaja1+";"+igc);

        }else if( base > t1Superior && base <= t2Superior){
            igc = (int) Math.round((base * tasa2) - rebaja2);
            System.out.println(base +";"+ tasa2+";"+ rebaja2+";"+igc);

        }else if( base > t2Superior && base <= t3Superior){
            igc = (int) Math.round((base * tasa3) - rebaja3);
            System.out.println(base +";"+ tasa3+";"+ rebaja3+";"+igc);

        }else if( base > t3Superior && base <= t4Superior){
            igc = (int) Math.round((base * tasa4) - rebaja4);
            System.out.println(base +";"+ tasa4+";"+ rebaja4+";"+igc);

        }else if( base > t4Superior && base <= t5Superior){
            igc = (int) Math.round((base * tasa5) - rebaja5);
            System.out.println(base +";"+ tasa5+";"+ rebaja5+";"+igc);

        }else if( base > t5Superior && base <= t6Superior){
            igc = (int) Math.round((base * tasa6) - rebaja6);
            System.out.println(base +";"+ tasa6+";"+ rebaja6+";"+igc);

        }else if( base > t6Superior && base <= t7Superior){
            igc = (int) Math.round((base * tasa7) - rebaja7);
            System.out.println(base +";"+ tasa7+";"+ rebaja7+";"+igc);

        }else if( base > t7Superior){
            igc = (int) Math.round((base * tasa8) - rebaja8);
            System.out.println(base +";"+ tasa8+";"+ rebaja8+";"+igc);

        }
        return igc;
    }
}


