package pe.gob.minsa.vacuna.web.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ResponseBaseBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Object data;
    private int code;
    private String message;

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
