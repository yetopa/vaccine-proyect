package pe.gob.minsa.vacuna.web.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.gob.minsa.vacuna.web.bean.CitaDTO;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	
	@Value("${service.core.vacuna.queue.citas.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${service.core.vacuna.queue.citas.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(CitaDTO cita) {
		rabbitTemplate.convertAndSend(exchange, routingkey, cita);
		System.out.println("Send msg = " + cita);
	    
	}
}
