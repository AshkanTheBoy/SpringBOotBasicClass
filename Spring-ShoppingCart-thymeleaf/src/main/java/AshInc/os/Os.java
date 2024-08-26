package AshInc.os;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Os {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String developer; //Разработчик ОС
}

//Android OS - Google Inc., Windows OS - Microsoft Corporation, iOS - Apple Inc., BlackBerry OS – BlackBerry Ltd. 