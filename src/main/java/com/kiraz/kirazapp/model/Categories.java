package com.kiraz.kirazapp.model;

import com.kiraz.kirazapp.base.BaseEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Categories extends BaseEntity {
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "row_status")
    private Boolean rowStatus=true;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id")
    private List<Services> servicesList;
}
