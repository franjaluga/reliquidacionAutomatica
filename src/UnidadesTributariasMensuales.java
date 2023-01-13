public enum UnidadesTributariasMensuales {
    UTM_DIC_2022( 61157),
    UTM_DIC_2021(54171),
    UTM_DIC_2020( 51029),
    UTM_DIC_2019( 49623),
    UTM_DIC_2018( 48353),
    UTM_DIC_2017( 46972),
    UTM_DIC_2016(46183),
    UTM_DIC_2015( 44955),
    UTM_DIC_2014( 43198),
    UTM_DIC_2013( 40772),
    UTM_DIC_2012(40206);

    private final int utm;

    private UnidadesTributariasMensuales(int utm){
        this.utm = utm;
    }

    public int getUtm(){
        return utm;
    }

}
