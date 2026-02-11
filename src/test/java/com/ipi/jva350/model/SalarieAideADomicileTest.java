package com.ipi.jva350.model;
import org.junit.jupiter.api.Test;

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
	
	@Test
	public void testCalculeJoursDeCongeDecomptesPourPlageRight() {
		//Given
		SalarieAideADomicile unSalarie = new SalarieAideADomicile();
		LocalDate dateDebut = LocalDate.parse("2025-11-01");
		LocalDate dateFin = LocalDate.parse("2025-12-01");
		
		//When
		LinkedHashSet<LocalDate> joursDeConges = unSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
		//Then
		Assertions.assertEquals(24, joursDeConges.size());
	}
	
	@Test
	public void testCalculeJoursDeCongeDecomptesPourPlageWrong() {
		//Given
		SalarieAideADomicile unSalarie = new SalarieAideADomicile();
		LocalDate dateDebut = LocalDate.parse("2025-11-01");
		LocalDate dateFin = LocalDate.parse("2025-12-01");
		
		//When
		LinkedHashSet<LocalDate> joursDeConges = unSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
		//Then
		Assertions.assertNotEquals(20, joursDeConges.size());
	}
	
}
