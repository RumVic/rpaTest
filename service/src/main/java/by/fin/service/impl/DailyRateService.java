package by.fin.service.impl;

import by.fin.module.entity.DailyRate;
import by.fin.service.DTO.DailyRateDTO;
import by.fin.service.IDailyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DailyRateImpl implements IDailyRateService {

    @Override
    public DailyRate create(DailyRateDTO dailyRateDTO) {
        return null;
    }

    @Override
    public DailyRate update() {
        return null;
    }

    @Override
    public DailyRate read() {
        return null;
    }

    @Override
    public void delete() {

    }
}
