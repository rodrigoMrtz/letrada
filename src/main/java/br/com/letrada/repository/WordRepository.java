package br.com.letrada.repository;

import br.com.letrada.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {

    Optional<Word> findByWordIgnoreCaseAndActiveTrue(String word);
}