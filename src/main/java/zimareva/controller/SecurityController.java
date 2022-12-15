package zimareva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zimareva.model.Security;
import zimareva.service.SecurityService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/securities")
public class SecurityController {
    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping
    public ResponseEntity<List<Security>> getSecurities() {
        List<Security> securities = securityService.getSecurities();
        return new ResponseEntity<>(securities, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Security> getSecurity(@PathVariable(value = "id") Long securityId) {
        Security security = securityService.getSecurityById(securityId);
        return new ResponseEntity<>(security, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Security> createSecurity(@RequestBody Security security) {
        Security createdSecurity = securityService.addSecurity(security);
        return new ResponseEntity<>(createdSecurity, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public void deleteSecurity(@PathVariable(value = "id") Long securityId) {
        securityService.deleteSecurity(securityId);
    }

    @PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Security> partialUpdateSecurity(@PathVariable("id") Long securityId,
                                                          @RequestBody Map<String, Object> securityDetails) {
        Security editedSecurity = securityService.editSecurity(securityId, securityDetails);
        return new ResponseEntity<>(editedSecurity, HttpStatus.OK);
    }
}
