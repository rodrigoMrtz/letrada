package br.com.letrada.service;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component 
public class WordNormalizer {
    public String normalize(String word){
        return word
                .trim()
                .toUpperCase(Locale.ROOT);
    }
}
