package org.AshInc.order;

import org.AshInc.table.TableRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderRest, Long> {
} 