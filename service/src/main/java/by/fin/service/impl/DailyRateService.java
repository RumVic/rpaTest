package by.fin.service.impl;

import by.fin.module.IDailyRateRepository;
import by.fin.module.entity.DailyRate;
import by.fin.service.dto.DailyRateDTO;
import by.fin.service.IDailyRateService;
import by.fin.service.builder.DailyRateBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DailyRateService implements IDailyRateService {

    @Autowired
    private final IDailyRateRepository repository;


    @Override
    @Transactional
    public List<DailyRate> create(DailyRateDTO[] dailyRateDTO) {

        for (DailyRateDTO drt: dailyRateDTO) {
            DailyRate rateBuilder = DailyRateBuilder
                    .create()
                    .setId(new Random().nextLong())
                    .setIdOnSite(drt.getCur_ID())
                    .setOfficialRate(drt.getCur_OfficialRate())
                    .setDtDayTime(drt.getDate())
                    .build();
            repository.save(rateBuilder);
        }
        return null;
    }

    @Override
    public DailyRate update() {
        return null;
    }

    @Override
    public List<DailyRate> read(int id, LocalDateTime startDate, LocalDateTime endDate) {

         List<DailyRate> list  = repository.findAllByIdOnSite(id);
         List<DailyRate> resultList = list.stream()
                 .sorted(Comparator.comparing(v-> v.getDtDayTime()))
                 .takeWhile(t-> (t.getDtDayTime().isEqual(startDate)||
                         t.getDtDayTime().isAfter(startDate))
                         && (t.getDtDayTime().isBefore(endDate)||
                         t.getDtDayTime().isEqual(endDate)))
                 .collect(Collectors.toList());
         return resultList;
    }

    @Override
    public List<DailyRate> readByCode(int code) {
        List<DailyRate> listRate = repository.findAllByIdOnSite(code);
        return listRate;
    }

    @Override
    public double readByMonthAndYear(int mouth, int year ,int id) {
        List<Double> list = repository.findAllByDayTimeAndByYear(mouth,year,id);
        double sum = 0;
        for (double i :list) {
            sum+=i;
        }
        double averageSum = sum/list.size();
        return averageSum;
    }

    @Override
    public void delete() {

    }
}
