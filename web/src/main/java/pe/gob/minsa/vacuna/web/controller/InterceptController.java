package pe.gob.minsa.vacuna.web.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pe.gob.minsa.vacuna.web.bean.ResponseBaseBean;

@Aspect
@Component
public class InterceptController {

    final int CODE_RESPONSE_SUCCESS = 200;
    final int CODE_RESPONSE_ERROR = 400;
    final int CODE_RESPONSE_NOT_COMPLETE = 500;

    final String MESSAGE_SUCCESS = "[SUCCESS] Proceso exitoso";
    final String MESSAGE_ERROR = "[ERROR]: Proceso con fallido";
    final String MESSAGE_NOT_SUCCESS = "[WARNING] Proceso no completado";

    @AfterReturning(
            pointcut = "execution(* pe.gob.minsa.vacuna.web*Controller.*(..))",
            returning = "objReturn"
    )
    public void setMessageResult(JoinPoint joinPoint, Object objReturn){
        if (objReturn instanceof ResponseBaseBean){
            int code = ((ResponseBaseBean) objReturn).getCode();
            String message = ((ResponseBaseBean) objReturn).getMessage();
            if (message==null || message.equals("")){
                if (code == CODE_RESPONSE_SUCCESS) {
                    ((ResponseBaseBean) objReturn).setMessage(MESSAGE_SUCCESS);
                } else if (code == CODE_RESPONSE_ERROR) {
                    ((ResponseBaseBean) objReturn).setMessage(MESSAGE_ERROR);
                } else if (code == CODE_RESPONSE_NOT_COMPLETE) {
                    ((ResponseBaseBean) objReturn).setMessage(MESSAGE_NOT_SUCCESS);
                }
            }
        }
    }
}
