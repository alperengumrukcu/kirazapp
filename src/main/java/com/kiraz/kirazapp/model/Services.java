package com.kiraz.kirazapp.model;

import com.kiraz.kirazapp.base.BaseEntity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "services")
public class Services extends BaseEntity {
    private String servicesName;
    @ManyToOne
    private Categories categories;
}
