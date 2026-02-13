package com.ipi.jva350.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Assertions;


public class SalarieAideADomicileTest {
	@Test
	public void testALegalementDroitADesCongesPayesRight() {
		//Given
		SalarieAideADomicile unSalarie = new SalarieAideADomicile();
		unSalarie.setJoursTravaillesAnneeNMoins1(11);
		Assertions.assertNotNull(unSalarie);
		//When
		Boolean droitCongesPayesTrue = unSalarie.aLegalementDroitADesCongesPayes();
		//Then
		Assertions.assertEquals(true, droitCongesPayesTrue);
	}
	
	@Test
	public void testALegalementDroitADesCongesPayesWrong() {
		//Given
		SalarieAideADomicile unSalarie = new SalarieAideADomicile();
		unSalarie.setJoursTravaillesAnneeNMoins1(9);
		Assertions.assertNotNull(unSalarie);
		//When
		Boolean droitCongesPayesTrue = unSalarie.aLegalementDroitADesCongesPayes();
		//Then
		Assertions.assertEquals(false, droitCongesPayesTrue);
	}
	
	@ParameterizedTest
	@CsvSource({
	    "2025-11-01,2025-12-01"
	})
	public void testCalculeJoursDeCongeDecomptesPourPlageRight(String debut, String fin) {
	    // Given
	    SalarieAideADomicile unSalarie = new SalarieAideADomicile();
	    LocalDate dateDebut = LocalDate.parse(debut);
	    LocalDate dateFin = LocalDate.parse(fin);

	    // When
	    LinkedHashSet<LocalDate> joursDeConges = unSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);

	    // Then
	    Assertions.assertEquals(24, joursDeConges.size());
	}

	
	@ParameterizedTest
	@CsvSource({
	    "2025-11-01,2025-12-01",
	    "2025-11-01,2025-12-01"
	})
	public void testCalculeJoursDeCongeDecomptesPourPlageWrong(String debut, String fin) {
	    // Given
	    SalarieAideADomicile unSalarie = new SalarieAideADomicile();
	    LocalDate dateDebut = LocalDate.parse(debut);
	    LocalDate dateFin = LocalDate.parse(fin);

	    // When
	    LinkedHashSet<LocalDate> joursDeConges = unSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);

	    // Then
	    Assertions.assertNotEquals(20, joursDeConges.size());
	}
	
	//Methode correction du prof
	@ParameterizedTest
	@CsvSource({
	    "2025-11-01,2025-12-01,24",
	    "2025-11-01,2025-12-01,24"
	})
	public void testCalculeJoursDeCongeDecomptesPourPlage(String debut, String fin, int nbJoursDeConges) {
	    // Given
	    SalarieAideADomicile unSalarie = new SalarieAideADomicile();
	    LocalDate dateDebut = LocalDate.parse(debut);
	    LocalDate dateFin = LocalDate.parse(fin);

	    // When
	    LinkedHashSet<LocalDate> joursDeConges = unSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);

	    // Then
	    Assertions.assertEquals(nbJoursDeConges, joursDeConges.size());
	}
	
	@Test
	public void testFindByNom() {
		// Given
		
		// When
		
		// Then
		
	}
	
	
}
