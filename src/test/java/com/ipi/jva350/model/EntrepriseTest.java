package com.ipi.jva350.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({
            "2023-01-01,true", // Jour de l’an
            "2023-04-10,true", // Lundi de Pâques
            "2023-05-01,true", // Fête du Travail
            "2023-05-08,true", // Victoire 1945
            "2023-05-19,true", // Ascension
            "2023-05-29,true", // Lundi de Pentecôte
            "2023-07-14,true", // Fête nationale
            "2023-08-15,true", // Assomption
            "2023-11-01,true", // Toussaint
            "2023-11-11,true", // Armistice
            "2023-12-25,true", // Noël
            "2023-01-02,false",
            "2023-04-11,false",
            "2023-05-02,false",
            "2023-07-15,false",
            "2023-08-16,false",
            "2023-11-02,false"
    })
    public void testEstJourFerie(String dateStr, boolean attendu) {
        // Given
        LocalDate date = LocalDate.parse(dateStr);
        //When
        boolean resultat = Entreprise.estJourFerie(date);
        //Then
        Assertions.assertEquals(attendu, resultat);
    }

}
