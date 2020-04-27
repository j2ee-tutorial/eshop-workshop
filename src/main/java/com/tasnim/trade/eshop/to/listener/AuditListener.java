package com.tasnim.trade.eshop.to.listener;

import com.tasnim.trade.eshop.dto.Principal;
import com.tasnim.trade.eshop.to.base.Audit;
import com.tasnim.trade.eshop.to.base.Auditable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AuditListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditListener.class);

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        LocalDateTime now = LocalDateTime.now();
        Date current = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        audit.setCreatedOn(current);
        audit.setCreatedBy(getLoggedInUser());
    }

    @PreUpdate
    public void setUpdatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        LocalDateTime now = LocalDateTime.now();
        Date current = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        audit.setUpdatedOn(current);
        audit.setUpdatedBy(getLoggedInUser());
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            if (authentication.getPrincipal() instanceof Principal) {
                Principal principal = (Principal) authentication.getPrincipal();
                return principal.getUsername();
            }
        }
        return null;
    }
}
