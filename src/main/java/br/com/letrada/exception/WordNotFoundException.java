package br.com.letrada.exception;

public class WordNotFoundException extends RuntimeException {
    public WordNotFoundException(Long id){
        super("Palavra nao encontrada com o id:" + id);
    }
}
