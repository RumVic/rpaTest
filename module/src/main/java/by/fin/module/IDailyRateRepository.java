package by.fin.module;

import by.fin.module.entity.DailyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IDailyRateRepository extends JpaRepository<DailyRate,Long> {

    List<DailyRate> findAllByIdOnSite(int i);

    @Query("select d1_0.officialRate from DailyRate d1_0 where extract (month from d1_0.dtDayTime) = :month and extract(year from d1_0.dtDayTime) = :year and d1_0.idOnSite = :id_site")
    List<Double> findAllByDayTimeAndByYear(@Param("month") Integer month, @Param("year") Integer year, @Param("id_site") Integer id);

}
