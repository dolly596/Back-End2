package com.projetoaluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoaluno.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
