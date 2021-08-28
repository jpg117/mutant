package com.mercadolibre.mutant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="human")
public class Human {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	
	@Column(name="dna")
	private String dna;
	
	@Column(name="mutant")
	private int mutant;
	
	public Human() {}

	public Human(String dna, boolean isMutant) {
		this.dna = dna;
		if (isMutant) {
			mutant = 1;
		} else {
			mutant = 0;
		}
	}

	public boolean isMutant() {
		return mutant == 1;
	}
}
