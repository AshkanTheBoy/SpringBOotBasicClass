package org.AshInc.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.AshInc.AuditTrailListener;
import org.AshInc.order.OrderRest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditTrailListener.class)
@Table(name = "table_rest")
public class TableRest {
    private static Logger logger = Logger.getLogger(TableRest.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", length = 10, nullable = false, unique = true)
    private String number; //Номер столика
    private int count; //Количество мест
    private int hall; //Номер зала

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id")
    private Set<OrderRest> orderRests = new HashSet<>();

    public enum Category {
        PAIR, FAMILY, BAR, GROUP, TERRACE, CABIN, BUSINESS
    }

    @PrePersist
    public void logNewTable() {

        logger.info
                ("Attempting to add new table: " + number);
    }

    @PostPersist
    public void logNewTableAdded() {

        logger.info
                ("Added table '" + number + "' with ID: " + id);
    }

    @PreRemove
    public void logTableRemovalAttempt() {

        logger.info
                ("Attempting to delete table: " + number);
    }

    @PostRemove
    public void logTableRemoval() {

        logger.info
                ("Deleted table: " + number);
    }

    @PreUpdate
    public void logTableUpdateAttempt() {

        logger.info
                ("Attempting to update table: " + number);
    }

    @PostUpdate
    public void logTableUpdate() {

        logger.info
                ("Updated table: " + number);
    }

    @PostLoad
    public void logTableLoad() {

        logger.info
                ("Table loaded: " + number);
    }
}
