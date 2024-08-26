package AshInc.firm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "firm")
public class Firm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY прочитать
    private Long id;
    @Column(name = "name")
    private String name;
}

//Apple, Samsung, Xiaomi, Huawei, Honor 