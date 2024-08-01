package org.AshInc.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.AshInc.table.TableRest;

import java.util.Date;

import javax.persistence.*;

/*
Заказ столика в кафе
Возможные статусы заказа столика в ресторане:

Забронирован (Booked) - Столик успешно забронирован.
Подтвержден (Confirmed) - Заказ подтвержден рестораном.
Ожидание (Pending) - Ожидает подтверждения со стороны ресторана.
Отменен (Canceled) - Заказ был отменен клиентом или рестораном.
Завершен (Completed) - Заказ выполнен, столик использован.
Неявка (No-show) - Клиент не пришел на резерв.
Изменен (Modified) - Заказ был изменен (например, время или количество человек).
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_rest")
public class OrderRest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin; //or start/finish

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        BOOKED, CONFIRMED, PENDING, CANCELED, COMPLETED, NOSHOW, MODIFIED
    }

    @ManyToOne
    //@JoinColumn(name = "table_id")
    private TableRest tableRest;
} 