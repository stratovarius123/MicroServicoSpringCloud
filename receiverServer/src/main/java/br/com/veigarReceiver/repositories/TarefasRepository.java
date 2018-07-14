package br.com.veigarReceiver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.veigarReceiver.domain.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Integer> {

}
