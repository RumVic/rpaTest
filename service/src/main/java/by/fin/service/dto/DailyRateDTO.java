package by.fin.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class DailyRateDTO {


    private int Cur_ID;

    private double Cur_OfficialRate;

    private LocalDateTime Date;

    public DailyRateDTO(@JsonProperty ("Cur_ID") int cur_ID,
                        @JsonProperty ("Cur_OfficialRate") double cur_OfficialRate,
                        @JsonProperty ("Date")LocalDateTime date) {
        Cur_ID = cur_ID;
        Cur_OfficialRate = cur_OfficialRate;
        Date = date;
    }

    public int getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        Cur_ID = cur_ID;
    }

    public double getCur_OfficialRate() {
        return Cur_OfficialRate;
    }

    public void setCur_OfficialRate(double cur_OfficialRate) {
        Cur_OfficialRate = cur_OfficialRate;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }
}

