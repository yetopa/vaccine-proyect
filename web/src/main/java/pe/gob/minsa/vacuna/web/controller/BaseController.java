package pe.gob.minsa.vacuna.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pe.gob.minsa.vacuna.web.bean.ResponseBaseBean;
import pe.gob.minsa.vacuna.web.utils.Constants;

public class BaseController {

    final int CODE_ERROR = 400;
    static final int CODE_SUCCESS = 200;

    final int CODE_RESPONSE_SUCCESS = 200;
    final int CODE_RESPONSE_ERROR = 400;
    final int CODE_RESPONSE_NOT_COMPLETE = 500;

    final String KEY_MODEL = "modelView";

    /* KEY MODAL DASHBOARD */
    final String KEY_MODEL_DASHBOARD_PACIENTE = "dashboardPaciente";
    final String KEY_MODEL_DASHBOARD_PACIENTE_SIZE = "dashboardPacienteSize";

    @Autowired
    private ResponseBaseBean responseBaseBean;

    public ResponseBaseBean getResponseBaseBean() {
        return responseBaseBean;
    }

    public void setResponseBaseBean(ResponseBaseBean responseBaseBean) {
        this.responseBaseBean = responseBaseBean;
    }

    public void setCode(int code) {
        if (code == CODE_SUCCESS){
            this.getResponseBaseBean().setCode(Constants.CODE_RESPONSE_SUCCESS);
        }else {
            this.getResponseBaseBean().setCode(Constants.CODE_RESPONSE_NOT_COMPLETE);
        }
    }

}
