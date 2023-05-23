package by.fin.service.builder;

import by.fin.module.entity.DailyRate;

import java.time.LocalDateTime;

public class DailyRateBuilder {
    
    private Long id;
    private int idOnSite;
    private double officialRate;
    private LocalDateTime dtDayTime;
    
    public static DailyRateBuilder create() {
        return new DailyRateBuilder();
    }

    public DailyRateBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public DailyRateBuilder setIdOnSite(int idOnSite) {
        this.idOnSite = idOnSite;
        return this;
    }

    public DailyRateBuilder setOfficialRate(double officialRate) {
        this.officialRate = officialRate;
        return this;
    }

    public DailyRateBuilder setDtDayTime(LocalDateTime dtDayTime) {
        this.dtDayTime = dtDayTime;
        return this;
    }
    public  DailyRate build(){
        return new DailyRate(id,idOnSite,officialRate,dtDayTime);
    }
}

