package br.com.veigarReceiver.consumer;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.veigarReceiver.domain.Tarefas;
import br.com.veigarReceiver.repositories.TarefasRepository;

@Component
public class Consumer {
	
	@Autowired
	private TarefasRepository tarefasRepository;
    
	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(String msg) {
		ObjectMapper mapper = new ObjectMapper();
    	try {
    		Tarefas tarefas = mapper.readValue(msg, Tarefas.class);
    		tarefasRepository.save(tarefas);
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
