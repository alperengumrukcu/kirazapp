package com.kiraz.kirazapp.model;

import com.kiraz.kirazapp.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "adverts")
public class Adverts extends BaseEntity {
    @Column
    private String advertName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id",referencedColumnName = "id")
    private Categories categories;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "services_id",referencedColumnName = "id")
    private Services services;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;
    @Column
    private int score;
}
