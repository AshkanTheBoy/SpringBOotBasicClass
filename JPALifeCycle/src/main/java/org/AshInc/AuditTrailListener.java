package org.AshInc;

import javax.persistence.*;

import org.AshInc.table.TableRest;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class AuditTrailListener {
    private static Log log = LogFactory.getLog(AuditTrailListener.class);
    
    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(TableRest tableRest) {
        if (tableRest.getId() == 0) {
            log.info("[TABLE AUDIT] About to add a table");
        } else {
            log.info("[TABLE AUDIT] About to update/delete user: " + tableRest.getId());
        }
    }
    
    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(TableRest tableRest) {
        log.info("[TABLE AUDIT] add/update/delete complete for user: " + tableRest.getId());
    }
    
    @PostLoad
    private void afterLoad(TableRest tableRest) {
        log.info("[TABLE AUDIT] table loaded from database: " + tableRest.getId());
    }
} 