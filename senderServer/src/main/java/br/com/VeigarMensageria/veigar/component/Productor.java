package br.com.VeigarMensageria.veigar.component;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.VeigarMensageria.veigar.domain.Tarefas;

@Component
public class Productor {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;
	
	
	
	public void produceMessenger(Tarefas tarefa) {
		try {
				
			ObjectMapper objectJSON = new ObjectMapper();
			String msg = objectJSON.writeValueAsString(tarefa);
			
			amqpTemplate.convertAndSend(exchange,routingKey,msg);
		
		}catch(AmqpException | JsonProcessingException excetion) {
			excetion.printStackTrace();
		}
	}
}