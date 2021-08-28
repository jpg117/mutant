package com.mercadolibre.mutant.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.mutant.dao.HumanDAO;
import com.mercadolibre.mutant.entity.Human;

@Service
public class HumanService {
	
    @Autowired
    private HumanDAO humanDAO;

    public boolean isMutant(String[] dna) {
        int sequences = 0;
        int M = dna.length;
        int N = dna[0].length();
        Pattern pattern = Pattern.compile("[A]{4}|[C]{4}|[G]{4}|[T]{4}");
        if (M >= 4 || N >= 4) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (i <= M - 4) {
                        sequences += countSequences(dna[i].charAt(j), dna[i + 1].charAt(j), dna[i + 2].charAt(j), dna[i + 3].charAt(j));
                    }
                    if (j <= N - 4) {
                        sequences += countSequences(dna[i].charAt(j), dna[i].charAt(j + 1), dna[i].charAt(j + 2), dna[i].charAt(j + 3));
                        if (i <= M - 4) {
                            sequences += countSequences(dna[i].charAt(j), dna[i + 1].charAt(j + 1), dna[i + 2].charAt(j + 2), dna[i + 3].charAt(j + 3));
                        }
                    }
                    if (sequences > 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int countSequences(char firstLetter, char secondLetter, char thirdLetter, char fourthLetter) {
        if (firstLetter == secondLetter && secondLetter == thirdLetter
                && thirdLetter == fourthLetter) {
            return 1;
        }
        return 0;
    }
    
    public void save(Human human) {
        humanDAO.save(human);
    }

}
