package org.AshInc.smart;

import org.AshInc.firm.Firm;
import org.AshInc.os.Os;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Smart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST)//почитать почему этот каскад используется
    @JoinColumn(name = "firm_id", referencedColumnName = "id")
    private Firm firm;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "os_id", referencedColumnName = "id")
    private Os os; //Operating system
    private double size; //Размер экрана
    private String color; //Цвет смартфона
} 