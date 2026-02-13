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

    @Test
    public void testPartCongesPrisTotauxAnneeNMoins1() {
        // GIVEN
        SalarieAideADomicile salarie1 = new SalarieAideADomicile();
        salarie1.setNom("Dupont");
        salarie1.setCongesPayesPrisAnneeNMoins1(10.0);
        salarie1.setCongesPayesAcquisAnneeNMoins1(20.0);
        SalarieAideADomicile salarie2 = new SalarieAideADomicile();
        salarie2.setNom("Durand");
        salarie2.setCongesPayesPrisAnneeNMoins1(5.0);
        salarie2.setCongesPayesAcquisAnneeNMoins1(15.0);
        SalarieAideADomicileRepository.save(salarie1);
        SalarieAideADomicileRepository.save(salarie2);
        // WHEN
        Double result =
                SalarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1();
        // THEN
        // Le résultat attendu est un nombre à virgule ;
        // donc comme les calculs peuvent produire de légères imprécisions,
        // j'utilise une tolérance (delta : 0.0001) pour la comparaison
        Double attendu = 15.0 / 35.0;
        Assertions.assertEquals(attendu, result, 0.0001);
    }

}