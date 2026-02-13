package com.ipi.jva350.service;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class SalarieAideADomicileServiceTest {
    @Autowired
    private SalarieAideADomicileService service;
    @Autowired
    private SalarieAideADomicileRepository repository;
    @Test
    void testCalculeLimiteEntrepriseCongesPermis() {
        // GIVEN : un salarié existant avec congés acquis
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setNom("TestSal");
        s.setMoisDebutContrat(LocalDate.of(2020, 6, 1));
        s.setCongesPayesAcquisAnneeNMoins1(25);
        s.setMoisEnCours(LocalDate.of(2025, 7, 1));
        repository.save(s);
        // WHEN
        long limite = service.calculeLimiteEntrepriseCongesPermis(
                LocalDate.of(2025, 7, 1),
                25,
                s.getMoisDebutContrat(),
                LocalDate.of(2025, 7, 15),
                LocalDate.of(2025, 7, 20)
        );
        // THEN
        assertTrue(limite > 0, "La limite de congés calculée doit être positive");
    }
}
