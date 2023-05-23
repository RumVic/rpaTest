package by.fin.service;

import by.fin.module.entity.DailyRate;
import by.fin.service.dto.DailyRateDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface IDailyRateService {
    
    List<DailyRate> create(DailyRateDTO[] dailyRateDTO);
    DailyRate update();
    List<DailyRate> read(int id, LocalDateTime startDate, LocalDateTime endDate);
    List<DailyRate> readByCode(int code);
    double readByMonthAndYear(int mouth,int year,int code);
    void delete();

}
