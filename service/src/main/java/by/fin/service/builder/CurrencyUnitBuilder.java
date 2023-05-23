package by.fin.service.builder;

import by.fin.module.entity.CurrencyUnit;

import java.time.LocalDateTime;

public class CurrencyUnitBuilder {

    private Long id;
    private int idOnSite;
    private String nameOfUnit;
    private String AbbreviationOfUnit;
    private double officialRate;
    private LocalDateTime dtDayTime;

    public static CurrencyUnitBuilder create(){
        return new CurrencyUnitBuilder();
    }

    public CurrencyUnitBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public CurrencyUnitBuilder setIdOnSite(int idOnSite) {
        this.idOnSite = idOnSite;
        return this;
    }

    public CurrencyUnitBuilder setNameOfUnit(String nameOfUnit) {
        this.nameOfUnit = nameOfUnit;
        return this;
    }

    public CurrencyUnitBuilder setAbbreviationOfUnit(String abbreviationOfUnit) {
        AbbreviationOfUnit = abbreviationOfUnit;
        return this;
    }

    public CurrencyUnitBuilder setOfficialRate(double officialRate) {
        this.officialRate = officialRate;
        return this;
    }

    public CurrencyUnitBuilder setDtDayTime(LocalDateTime dtDayTime) {
        this.dtDayTime = dtDayTime;
        return this;
    }

    public  CurrencyUnit build(){
        return new CurrencyUnit(id,idOnSite,nameOfUnit,AbbreviationOfUnit,officialRate,dtDayTime);
    }
}
