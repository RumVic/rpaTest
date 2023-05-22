package by.fin.service.impl;

import by.fin.module.ICurrencyUnitRepository;
import by.fin.module.entity.CurrencyUnit;
import by.fin.service.DTO.CurrencyUnitDTO;
import by.fin.service.ICurrencyUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CurrencyUnitImpl implements ICurrencyUnitService {

    @Autowired
    public final  ICurrencyUnitRepository repository;

    @Override
    public CurrencyUnit create(CurrencyUnitDTO currencyUnitDTO) {
        CurrencyUnit currencyUnit = CurrencyUnit.builder()
                .id(2l)
                .idOnSite(currencyUnitDTO.getCur_ID())
                .nameOfUnit(currencyUnitDTO.getCur_Name())
                .AbbreviationOfUnit(currencyUnitDTO.getCur_Abbreviation())
                .officialRate(currencyUnitDTO.getCur_OfficialRate())
                .dtDayTime(currencyUnitDTO.getDate())
                .build();
        CurrencyUnit unit = repository.save(currencyUnit);
        return unit;
    }

    @Override
    public CurrencyUnit update() {
        return null;
    }

    @Override
    public CurrencyUnit read() {
        return null;
    }

    @Override
    public void delete() {

    }
}
