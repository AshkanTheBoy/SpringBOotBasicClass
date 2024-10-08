package org.AshInc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25)
    @ColumnDefault("'Jane'")
    @Generated(GenerationTime.INSERT)
    private String firstName;

    @Column(length = 25)
    @ColumnDefault("'Doe'")
    @Generated(GenerationTime.INSERT)
    private String lastName;

    private String email="js@gmail.com";
    private String phoneNumber;
} 