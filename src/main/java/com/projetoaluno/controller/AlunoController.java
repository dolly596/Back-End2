package com.projetoaluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoaluno.entities.Aluno;
import com.projetoaluno.service.AlunoService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/aluno")
public class AlunoController {
		
		private final AlunoService alunoService;

		@Autowired
		public AlunoController(AlunoService alunoService) {
			this.alunoService = alunoService;
		}

		@GetMapping ("/{id}")

		public ResponseEntity<Aluno> buscaAlunoIdControlId (@ PathVariable Long id) {
			Aluno aluno = alunoService.buscaAlunoId(id);
			if (aluno != null) {
				return ResponseEntity.ok(aluno);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
		public ResponseEntity<List<Aluno>> buscaTodosAlunoControl(){
			List<Aluno> aluno = alunoService.buscaTodosAluno();
			return ResponseEntity.ok(aluno);
		}
		@PostMapping("/")
		public ResponseEntity<Aluno> salvaClienteControl(@RequestBody  Aluno aluno){
			Aluno salvaAluno= alunoService.salvaAluno(aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Aluno> alterarAlunoControl(@PathVariable Long id, @RequestBody Aluno aluno){
			Aluno alterarCliente = alunoService.alterarAluno(id, aluno);
			if(alterarCliente != null) {
				return ResponseEntity.ok(alterarCliente);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){
			boolean aluno = alunoService.apagarAluno(id);
			if (aluno) {
				return ResponseEntity.ok().body("O a foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}
