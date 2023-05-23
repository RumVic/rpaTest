package by.fin.service;

import by.fin.module.entity.CurrencyUnit;
import by.fin.service.dto.CurrencyUnitDTO;



public interface ICurrencyUnitService {

   CurrencyUnit create(CurrencyUnitDTO currencyUniDTO);
   CurrencyUnit update();
   CurrencyUnit read(int idOnSite);
   void delete();


}
