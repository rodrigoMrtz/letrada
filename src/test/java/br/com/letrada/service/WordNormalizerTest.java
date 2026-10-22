package br.com.letrada.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WordNormalizerTest {

    private final WordNormalizer wordNormalizer = new WordNormalizer();

    @Test 
    void shouldNormalizeWordToUpperCase(){
        String result = wordNormalizer.normalize("carro");

        assertThat(result).isEqualTo("CARRO");
    }

    @Test 
    void shouldRemoveSpacesBeforeAndAfterWord(){
        
        String result = wordNormalizer.normalize(" carro   ");

        assertThat(result).isEqualTo("CARRO");
    }

    @Test 
    void shouldNormalizeMixedCaseWord(){
        
        String result = wordNormalizer.normalize("CaRrO");

        assertThat(result).isEqualTo("CARRO");
    }
}
