package com.tasnim.trade.eshop.to;

import com.tasnim.trade.eshop.to.base.Audit;
import com.tasnim.trade.eshop.to.base.Auditable;
import com.tasnim.trade.eshop.to.listener.AuditListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditListener.class)
public abstract class EntityBase implements Auditable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Embedded
    private final Audit audit;

    EntityBase() {
        audit = new Audit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Audit getAudit() {
        return audit;
    }
}
