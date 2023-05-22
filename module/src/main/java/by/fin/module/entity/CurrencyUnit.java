package by.fin.module.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CurrencyUnit")
public class CurrencyUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_unit_id")
    private String id;
    @Column
    private int idOnSite;
    @Column
    private String nameOfUnit;
    @Column
    private String AbbreviationOfUnit;
    @Column
    private double officialRate;
    @Column
    private Long dtDayTime;
}
