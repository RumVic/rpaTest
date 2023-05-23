package by.fin.module;

import by.fin.module.entity.CurrencyUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurrencyUnitRepository extends JpaRepository<CurrencyUnit,Long> {
    CurrencyUnit findByIdOnSite(int idOnSite);

}
