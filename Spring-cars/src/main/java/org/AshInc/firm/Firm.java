package org.AshInc.firm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.AshInc.model.ModelCar;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "firm")
public class Firm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private String idSymbol;
    private String name;
    private String cyrillicName;
    private String className;
    private boolean popular;
    private String country;
    private Integer yearFrom;
    private Integer yearTo;
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<ModelCar> models;

}
