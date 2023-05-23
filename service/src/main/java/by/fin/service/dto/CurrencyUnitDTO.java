package by.fin.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CurrencyUnitDTO {
    private int Cur_ID;
    private LocalDateTime Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;
    private String Cur_Name;
    private double Cur_OfficialRate;

    public CurrencyUnitDTO(@JsonProperty("Cur_ID") int cur_ID,
                           @JsonProperty("Date") LocalDateTime date,
                           @JsonProperty("Cur_Abbreviation") String cur_Abbreviation,
                           @JsonProperty("Cur_Scale") int cur_Scale,
                           @JsonProperty("Cur_Name") String cur_Name,
                           @JsonProperty("Cur_OfficialRate") double cur_OfficialRate) {
        Cur_ID = cur_ID;
        Date = date;
        Cur_Abbreviation = cur_Abbreviation;
        Cur_Scale = cur_Scale;
        Cur_Name = cur_Name;
        Cur_OfficialRate = cur_OfficialRate;
    }

    public CurrencyUnitDTO() {
    }

    public int getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        Cur_ID = cur_ID;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        Cur_Abbreviation = cur_Abbreviation;
    }

    public int getCur_Scale() {
        return Cur_Scale;
    }

    public void setCur_Scale(int cur_Scale) {
        Cur_Scale = cur_Scale;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        Cur_Name = cur_Name;
    }

    public double getCur_OfficialRate() {
        return Cur_OfficialRate;
    }

    public void setCur_OfficialRate(double cur_OfficialRate) {
        Cur_OfficialRate = cur_OfficialRate;
    }
}
