package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.model.Security;
import zimareva.repository.SecurityRepository;

@Service
public class SecurityService {
    private final SecurityRepository securityRepository;

    @Autowired
    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    public Security addSecurity(Security security){
        return securityRepository.save(security);
    }
}
