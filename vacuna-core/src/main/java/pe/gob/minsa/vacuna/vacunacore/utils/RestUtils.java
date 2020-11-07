package pe.gob.minsa.vacuna.vacunacore.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
public class RestUtils {

    private static final Logger LOGGER = LogManager.getLogger(RestUtils.class);

    private RestTemplate restTemplate;

    public RestUtils(){
        this.restTemplate = new RestTemplate();
    }

    public <T> T callServiceForObject(String url, Class<T> responseType) throws Exception {
        URI uri = URI.create(url);
        restTemplate = new RestTemplate();
        T responseOject = restTemplate.getForObject(uri, responseType);
        return responseOject;
    }

    public <T, E> T callService(String url, Class<T> responseType, HttpMethod method, E request, Map<String, Object> pathVariables) throws Exception {
        LOGGER.debug("ApiRestServiceUtils callService");
        ResponseEntity<String> responseEntity= executeMethod(url, String.class, method, request, pathVariables);
        T responseOject= null;
        if (responseEntity != null && HttpStatus.OK.equals(responseEntity.getStatusCode()) && responseEntity.getBody() != null) {
            ObjectMapper mapper= new ObjectMapper();
            try {
                if (responseType == String.class) {
                    return (T) responseEntity.getBody();
                }
                responseOject = mapper.readValue(responseEntity.getBody(), responseType);
            } catch (JsonParseException e) {
                throw new Exception("Error parsing response", e);
            } catch (JsonMappingException e) {
                throw new Exception("Error parsing response", e);
            } catch (IOException e) {
                throw new Exception("Error parsing response", e);
            }
        } else {
            throw new Exception("Error calling web service");
        }
        return responseOject;
    }

    public <T,E> ResponseEntity<T> executeMethod(String url, Class<T> responseType,
                                                 HttpMethod method, E request, Map<String, Object> pathVariables) {
        LOGGER.debug("ApiRestServiceUtils executeMethod");
        ResponseEntity<T> responseEntity = null;
        HttpHeaders headers= new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<E> requestEntity= new HttpEntity<E>(request, headers);
        if (pathVariables != null) {
            responseEntity = restTemplate.exchange(url, method, requestEntity, responseType, pathVariables);
        } else {
            responseEntity = restTemplate.exchange(url, method, requestEntity, responseType);
        }
        return responseEntity;
    }

    public <T, E> T callService(String url, Class<T> responseType, HttpMethod method, E request, Map<String, Object> pathVariables , List<MediaType> acceptableMediaTypes , MediaType contentType ,  Map<String, String> header  ) throws Exception {
        LOGGER.debug("ApiRestServiceUtils callService");
        ResponseEntity<String> responseEntity= executeMethod(url, String.class, method, request, pathVariables , acceptableMediaTypes , contentType , header );
        T responseOject= null;
        if (responseEntity != null && HttpStatus.OK.equals(responseEntity.getStatusCode()) && responseEntity.getBody() != null) {
            ObjectMapper mapper= new ObjectMapper();
            try {
                if (responseType == String.class) {
                    return (T) responseEntity.getBody();
                }
                responseOject = mapper.readValue(responseEntity.getBody(), responseType);
            } catch (JsonParseException e) {
                throw new Exception("Error parsing response", e);
            } catch (JsonMappingException e) {
                throw new Exception("Error parsing response", e);
            } catch (IOException e) {
                throw new Exception("Error parsing response",e);
            }
        } else {
            throw new Exception("Error calling web service");
        }
        return responseOject;
    }

    public <T,E> ResponseEntity<T> executeMethod(String url, Class<T> responseType,
                                                 HttpMethod method, E request, Map<String, Object> pathVariables, List<MediaType> acceptableMediaTypes, MediaType contentType, Map<String, String> appHeaders) throws Exception {
        LOGGER.debug("ApiRestServiceUtils executeMethod");
        ResponseEntity<T> responseEntity = null;
        HttpHeaders headers= new HttpHeaders();
        if(contentType != null){
            headers.setContentType(contentType);
        }
        if(acceptableMediaTypes != null){
            headers.setAccept(acceptableMediaTypes);
        }
        headers.setAll(appHeaders);
        HttpEntity<E> requestEntity= new HttpEntity<E>(request, headers);
        try{
            if (pathVariables != null) {
                responseEntity = restTemplate.exchange(url, method, requestEntity, responseType, pathVariables);
            } else {
                responseEntity = restTemplate.exchange(url, method, requestEntity, responseType);
            }
        }catch (RestClientException e) {
            throw new Exception("Error to execute restTemplate.exchange");
        }
        return responseEntity;
    }
}
