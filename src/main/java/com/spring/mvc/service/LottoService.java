package com.spring.mvc.service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class LottoService {
    
    public Set<Integer> getLotto() {
        Set<Integer> lotto = new LinkedHashSet<>();
        while(lotto.size() < 5) {
            lotto.add(new  Random().nextInt(39+1));
        }
        return lotto;
    }
}
