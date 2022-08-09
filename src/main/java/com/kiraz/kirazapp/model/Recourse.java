package com.kiraz.kirazapp.model;

import com.kiraz.kirazapp.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "recourse",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","adverts_id"})})
public class Recourse extends BaseEntity {
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Adverts adverts;
}
