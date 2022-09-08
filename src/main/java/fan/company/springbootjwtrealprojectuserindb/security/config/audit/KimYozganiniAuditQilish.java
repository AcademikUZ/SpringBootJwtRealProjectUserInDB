package fan.company.springbootjwtrealprojectuserindb.security.config.audit;

import fan.company.springbootjwtrealprojectuserindb.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;

public class KimYozganiniAuditQilish implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null &&
                authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.of(((User) authentication.getPrincipal()).getId());
        }

        return Optional.empty();
    }
}
