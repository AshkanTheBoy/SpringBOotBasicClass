package org.AshInc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "model")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelCar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private String idSymbol;
    private String name;
    private String cyrillicName;
    private String className;
    private Integer yearFrom;
    private Integer yearTo;
} 