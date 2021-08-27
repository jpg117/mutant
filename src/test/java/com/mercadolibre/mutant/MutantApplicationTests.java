package com.mercadolibre.mutant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mercadolibre.mutant.service.MutantService;

public class MutantApplicationTests {

	private static MutantService mutant;
	
	@BeforeClass
	public static void initialize() {
		mutant = new MutantService();
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

}
