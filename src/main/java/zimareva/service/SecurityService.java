package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import zimareva.exception.EntityNotFoundException;
import zimareva.model.Security;
import zimareva.repository.SecurityRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SecurityService {
    private final SecurityRepository securityRepository;

    @Autowired
    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    public Security addSecurity(Security security) {
        return securityRepository.save(security);
    }

    public Security getSecurityById(Long id) {
        return securityRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Security.class.getName(), id));
    }

    public List<Security> getSecurities() {
        return StreamSupport
                .stream(securityRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteSecurity(Long id) {
        securityRepository.deleteById(id);
    }

    @Transactional
    public Security editSecurity(Long id, Map<String, Object> securityDetails) {
        Security securityToEdit = getSecurityById(id);
        securityDetails.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Security.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, securityToEdit, value);
        });
        return securityToEdit;
    }
}
