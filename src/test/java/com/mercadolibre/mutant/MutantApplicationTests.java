package com.mercadolibre.mutant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mercadolibre.mutant.service.HumanService;

public class MutantApplicationTests {

	private static HumanService mutant;
	
	@BeforeClass
	public static void initialize() {
		mutant = new HumanService();
	}

	@Test
	public void IsAMutant() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean isMutant = mutant.isMutant(dna);
        assertTrue(isMutant);
	}
	
	@Test
	public void IsNotAMutant() {
		String[] dna = {"CTGCGA","CAGTGC","TTATGT","AGAAGG","CCCGTA","TCACTG"};
        boolean isMutant = mutant.isMutant(dna);
        assertFalse(isMutant);
	}
	
	@Test
	public void IsAMutantRow() {
		String[] dna = {"AAAA","CCCC"};
        boolean isMutant = mutant.isMutant(dna);
        assertTrue(isMutant);
	}
	
	@Test
	public void IsAMutantColumn() {
		String[] dna = {"GT","GT","GT","GT"};
        boolean isMutant = mutant.isMutant(dna);
        assertTrue(isMutant);
	}
	
	@Test
	public void IsAMutantDiagonal() {
		String[] dna = {"ACGTA","TACGT","GTACG","CGTAC"};
        boolean isMutant = mutant.isMutant(dna);
        assertTrue(isMutant);
	}

}
