package com.ipi.jva350.model;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {
	// Implémenter un beforeEach pour remettre à jour les dates à chaque début de test (Setup et pas Given)
    private final LocalDate debutJanvier = LocalDate.of(2024, 1, 1);
    private final LocalDate finJanvier = LocalDate.of(2024, 1, 31);

    @Test
    void testDateDansLaPlageNominale() {
    	// Given
        LocalDate dateMilieu = LocalDate.of(2024, 1, 15);
        // When
        boolean resultat = Entreprise.estDansPlage(dateMilieu, debutJanvier, finJanvier);
        // Then
        assertTrue(resultat);
    }

    @Test
    void testDateAvantLaPlage() {
    	// Given
        LocalDate dateAvant = LocalDate.of(2023, 12, 31);
        // When
        boolean resultat = Entreprise.estDansPlage(dateAvant, debutJanvier, finJanvier);
        // Then
        assertFalse(resultat);
    }

    @Test
    void testDateApresLaPlage() {
    	// Given
        LocalDate dateApres = LocalDate.of(2024, 2, 1);
        // When
        boolean resultat = Entreprise.estDansPlage(dateApres, debutJanvier, finJanvier);
        // Then
        assertFalse(resultat);
    }

    @Test
    void testDateEgaleAuDebut() {
    	//Given
    	// When
        boolean resultat = Entreprise.estDansPlage(debutJanvier, debutJanvier, finJanvier);
        // Then
        assertTrue(resultat);
    }

    @Test
    void testDateEgaleALaFin() {
    	// Given
    	// When
        boolean resultat = Entreprise.estDansPlage(finJanvier, debutJanvier, finJanvier);
        // Then
        assertTrue(resultat);
    }

    @Test
    void testPlageUnSeulJour() {
    	// Given
        LocalDate dateCible = LocalDate.of(2024, 5, 5);
        LocalDate debut = LocalDate.of(2024, 5, 5);
        LocalDate fin = LocalDate.of(2024, 5, 5);
        // When
        boolean resultat = Entreprise.estDansPlage(dateCible, debut, fin);
        // Then
        assertTrue(resultat);
    }

    @Test
    void testPlageIncoherente() {
    	// Given
        LocalDate dateCible = LocalDate.of(2024, 1, 15);
        LocalDate debut = LocalDate.of(2024, 2, 1);
        LocalDate fin = LocalDate.of(2024, 1, 1);
        // When
        boolean resultat = Entreprise.estDansPlage(dateCible, debut, fin);
        // Then
        assertFalse(resultat);
    }

}
