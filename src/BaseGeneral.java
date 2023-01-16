import java.util.Date;

public class BaseGeneral {
    int base;
    float porcentajeDeParticipacion;
    int baseProporcional;
    int UtmTg;
    double baseProporcionalEnUtm;

    int tgMonth;
    int tgYear;
    int initMonth;
    int initYear;
    int yearsMaxToReliq;
    int yearsToReliq;

    public BaseGeneral() {
        this.base = 0;
        this.porcentajeDeParticipacion = 0;
        this.baseProporcional = 0;
        this.UtmTg = 0;
        this.baseProporcionalEnUtm = 0;
        this.tgMonth = 0;
        this.tgYear = 0;
        this.initMonth = 0;
        this.initYear = 0;
        this.yearsMaxToReliq = 0;
        this.yearsToReliq = 0;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public float getPorcentajeDeParticipacion() {
        return porcentajeDeParticipacion;
    }

    public void setPorcentajeDeParticipacion(float porcentajeDeParticipacion) {
        this.porcentajeDeParticipacion = porcentajeDeParticipacion;
    }

    public int getBaseProporcional() {
        return baseProporcional;
    }

    public void setBaseProporcional(int baseProporcional) {
        this.baseProporcional = baseProporcional;
    }

    public int getTgMonth() {
        return tgMonth;
    }

    public void setTgMonth(int tgMonth) {
        this.tgMonth = tgMonth;
    }

    public int getTgYear() {
        return tgYear;
    }

    public void setTgYear(int tgYear) {
        this.tgYear = tgYear;
    }

    public int getInitMonth() {
        return initMonth;
    }

    public void setInitMonth(int initMonth) {
        this.initMonth = initMonth;
    }

    public int getInitYear() {
        return initYear;
    }

    public void setInitYear(int initYear) {
        this.initYear = initYear;
    }

    public int getYearsMaxToReliq() {
        return yearsMaxToReliq;
    }

    public void setYearsMaxToReliq(int yearsMaxToReliq) {
        this.yearsMaxToReliq = yearsMaxToReliq;
    }

    public int getYearsToReliq() {
        return yearsToReliq;
    }

    public void setYearsToReliq(int yearsToReliq) {
        this.yearsToReliq = yearsToReliq;
    }
}
