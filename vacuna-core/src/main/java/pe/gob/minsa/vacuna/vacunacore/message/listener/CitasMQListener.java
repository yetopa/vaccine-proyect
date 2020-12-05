package pe.gob.minsa.vacuna.vacunacore.message.listener;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.minsa.vacuna.vacunacore.dto.CitaDTO;
import pe.gob.minsa.vacuna.vacunacore.service.VacunaService;

@Component
public class CitasMQListener implements MessageListener{

	
	private static VacunaService vacunaService;  
	
	public static final Logger LOGGER = LogManager.getLogger(CitasMQListener.class);
	
	@Autowired
	public void setVacunaService(VacunaService vacunaService) {
		CitasMQListener.vacunaService = vacunaService;
	}
	
	
	@Override
	public void onMessage(Message message) {
		CitasMQListener.LOGGER.info("Mensaeje Recibido: {}", message.getBody());
		ObjectMapper mapper = new ObjectMapper();
		try {
			CitaDTO cita = mapper.readValue(message.getBody(), CitaDTO.class);
			vacunaService.saveCita(cita);
			CitasMQListener.LOGGER.info("Mensaeje enviado a Vacuna DAO: ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	

}
