package by.fin.service.impl;

import by.fin.module.entity.CurrencyUnit;
import by.fin.service.ICurrencyUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CurrencyUnitImpl implements ICurrencyUnitService {

    @Override
    public CurrencyUnit create() {
        return null;
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
