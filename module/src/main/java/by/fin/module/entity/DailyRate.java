package by.fin.module.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DailyRate")
public class DailyRate implements Comparable<DailyRate> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_rate_id")
    private Long id;
    @Column
    private int idOnSite;
    @Column
    private double officialRate;
    @Column
    private LocalDateTime dtDayTime;



    @Override
    public int compareTo(DailyRate o) {
        return dtDayTime.compareTo(o.getDtDayTime());
    }
}
