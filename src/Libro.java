public class Libro {
    int base = 0;
    float porcentajeDeParticipacion = 0.00f;
    int baseProporcional = 0;
    int utmTG = 0;
    double baseProporcionalEnUtm = 0;
    int periodosAReliquidar = 0;
    int yearTG = 0;
    int yearInit = 0;
    double basePorYearToReliq = 0;
    int[][] basesAntiguas = new int [10][2];
    int[][] baseRecalculada = new int [10][2];

    int[][] igcHistoricoYRecalculado = new int [10][2];

    int[] diferenciaDeBases = new int[10];

    int[] diferenciaDeBasesEnUTMdelYear = new int[10];

    public void setBase(int base){
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setPorcentajeDeParticipacion(float porcentajeDeParticipacion) {
        this.porcentajeDeParticipacion = porcentajeDeParticipacion;
    }

    public float getPorcentajeDeParticipacion() {
        return porcentajeDeParticipacion;
    }

    public int getBaseProporcional() {
        return baseProporcional;
    }

    public double getBaseProporcionalEnUtm() {
        return baseProporcionalEnUtm;
    }

    public void setBaseProporcionalEnUtm(double baseProporcionalEnUtm) {
        this.baseProporcionalEnUtm = baseProporcionalEnUtm;
    }

    public int getUtmTG() {
        return utmTG;
    }

    public void setUtmTG(int utmTG) {
        this.utmTG = utmTG;
    }

    public void setBaseProporcional(int baseProporcional) {
        this.baseProporcional = baseProporcional;
    }

    public int getYearTG() {
        return yearTG;
    }

    public void setYearTG(int yearTG) {
        this.yearTG = yearTG;
    }

    public int getYearInit() {
        return yearInit;
    }

    public void setYearInit(int yearInit) {
        this.yearInit = yearInit;
    }

    public int getPeriodosAReliquidar() {
        return periodosAReliquidar;
    }

    public void setPeriodosAReliquidar(int periodosAReliquidar) {
        this.periodosAReliquidar = periodosAReliquidar;
    }

    public int[][] getBasesAntiguas() {
        return basesAntiguas;
    }

    public void setBasesAntiguas(int[][] basesAntiguas) {
        this.basesAntiguas = basesAntiguas;
    }

    public void resetBasesAntiguas(){
        this.basesAntiguas[0][0] = 0;
        this.basesAntiguas[1][0] = 0;
        this.basesAntiguas[2][0] = 0;
        this.basesAntiguas[3][0] = 0;
        this.basesAntiguas[4][0] = 0;
        this.basesAntiguas[5][0] = 0;
        this.basesAntiguas[6][0] = 0;
        this.basesAntiguas[7][0] = 0;
        this.basesAntiguas[8][0] = 0;
        this.basesAntiguas[9][0] = 0;

        this.basesAntiguas[0][1] = 0;
        this.basesAntiguas[1][1] = 0;
        this.basesAntiguas[2][1] = 0;
        this.basesAntiguas[3][1] = 0;
        this.basesAntiguas[4][1] = 0;
        this.basesAntiguas[5][1] = 0;
        this.basesAntiguas[6][1] = 0;
        this.basesAntiguas[7][1] = 0;
        this.basesAntiguas[8][1] = 0;
        this.basesAntiguas[9][1] = 0;
    }

    public void resetBasesRecalculadas(){
        this.baseRecalculada[0][0] = 0;
        this.baseRecalculada[1][0] = 0;
        this.baseRecalculada[2][0] = 0;
        this.baseRecalculada[3][0] = 0;
        this.baseRecalculada[4][0] = 0;
        this.baseRecalculada[5][0] = 0;
        this.baseRecalculada[6][0] = 0;
        this.baseRecalculada[7][0] = 0;
        this.baseRecalculada[8][0] = 0;
        this.baseRecalculada[9][0] = 0;

        this.baseRecalculada[0][1] = 0;
        this.baseRecalculada[1][1] = 0;
        this.baseRecalculada[2][1] = 0;
        this.baseRecalculada[3][1] = 0;
        this.baseRecalculada[4][1] = 0;
        this.baseRecalculada[5][1] = 0;
        this.baseRecalculada[6][1] = 0;
        this.baseRecalculada[7][1] = 0;
        this.baseRecalculada[8][1] = 0;
        this.baseRecalculada[9][1] = 0;
    }

    public int[][] getBaseRecalculada() {
        return baseRecalculada;
    }

    public void setBaseRecalculada(int[][] baseRecalculada) {
        this.baseRecalculada = baseRecalculada;
    }

    public double getBasePorYearToReliq() {
        return basePorYearToReliq;
    }

    public void setBasePorYearToReliq(double basePorYearToReliq) {
        this.basePorYearToReliq = basePorYearToReliq;
    }
}
