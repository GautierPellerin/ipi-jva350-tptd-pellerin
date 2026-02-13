package com.ipi.jva350.repository;
import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private SalarieAideADomicileRepository SalarieAideADomicileRepository;

    @BeforeEach
    public void before() {
    	SalarieAideADomicileRepository.deleteAll();
    }
    
    @Test
    public void testFindByNomRight() {

        // GIVEN
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setNom("Dupont");

        SalarieAideADomicileRepository.save(salarie);

        // WHEN
        SalarieAideADomicile result = SalarieAideADomicileRepository.findByNom("Dupont");

        // THEN
        Assertions.assertNotNull(result); // Je teste le cas où je trouve un salarié
    }

    @Test
    public void testFindByNomWrong() {

        // GIVEN
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setNom("Guetôme");

        SalarieAideADomicileRepository.save(salarie);

        // WHEN
        SalarieAideADomicile result = SalarieAideADomicileRepository.findByNom("Gautier");

        // THEN
        Assertions.assertNull(result); // Je teste le cas où je ne trouve pas de salarié
    }
}