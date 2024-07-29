package org.AshInc;
/*
Код товара: Уникальный идентификатор товара (например, артикул или SKU).
Наименование: Название товара.
Описание: Подробное описание товара,
включая его характеристики и преимущества.
Цена: Стоимость товара.
Количество: Доступное количество товара на складе.
Категория: Группа, к которой принадлежит товар
(например, электроника, одежда и т.д.).
Бренд: Производитель или марка товара.
Вес: Физический вес товара.
Размеры: Габариты товара (длина, ширина, высота).
Цвет: Доступные цвета товара.
Изображение: Фотография товара.
Состояние: Новое, б/у или восстановленное.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code",length = 10, nullable = false, unique = true)
    private String code;

    private String name;

    private String description;

    private BigDecimal price;

    @Transient
    private double weight;

    @Lob
    private byte[] picture;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Temporal(TemporalType.DATE)
    private Date date;

    public enum Category {
        FRUITS, GRAINS, DAIRY, MEAT, FISH, SNACKS, BEVERAGES, OILS, SPICES, PREPARED
    }

    public enum Brand {
        NESTLE, PEPSI, UNILEVER, MILLS, HEINZ, DANONE, MARS, TYSON
    }
}
