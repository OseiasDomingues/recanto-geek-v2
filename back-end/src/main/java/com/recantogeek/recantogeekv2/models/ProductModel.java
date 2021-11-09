package com.recantogeek.recantogeekv2.models;

import com.recantogeek.recantogeekv2.enums.RatingEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tb_Products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description", nullable = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @NotBlank
    @ToString.Exclude
    private String description;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "installments", nullable = false)
    private Double installments;

    @NotNull
    @JoinColumn(name = "category_id")
    @ManyToOne
    private CategoryModel category;

    public ProductModel(Long id, String name, Double price, String description, RatingEnum rating, Integer quantity,CategoryModel category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.rating = rating.getValue();
        this.quantity = quantity;
        this.installments = calcInstallment();
        this.category = category;
    }

    private Double calcInstallment() {
        return (price < 30) ? price / 5 : price / 10;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel that = (ProductModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
