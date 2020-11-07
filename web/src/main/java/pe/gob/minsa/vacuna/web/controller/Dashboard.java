package pe.gob.minsa.vacuna.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pe.gob.minsa.vacuna.web.bean.PacienteDTO;
import pe.gob.minsa.vacuna.web.utils.ConfigurationProperties;
import pe.gob.minsa.vacuna.web.utils.RestUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Dashboard extends BaseController{

    private static final Logger LOGGER = LogManager.getLogger(Dashboard.class);

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private ConfigurationProperties configurationProperties;

    @RequestMapping("/")
    public String initial(){
        return "template/template_main";
    }

    @RequestMapping("/index")
    public String index(){
        return "view/index";
    }

    @RequestMapping("/main")
    public String cliente(){
        return "view/main";
    }

    @RequestMapping("/menu")
    public String menu(){
        return "template/menu";
    }

    @RequestMapping("/header")
    public String header(){
        return "template/header";
    }

    @RequestMapping("/footer")
    public String footer(){
        return "template/footer";
    }

    @RequestMapping(value="/dashboard", method= RequestMethod.GET)
    public ModelAndView dashboard () {
        LOGGER.info("load dashboard ... ");
        ModelAndView modelo = new ModelAndView("appview/dashboard");
        return modelo;
    }

    @RequestMapping(value="/dashboard/vacunacion/show", method=RequestMethod.GET)
    public ModelAndView showSearchCustomer(){
        LOGGER.info("load showSearchCustomer...");
        ModelAndView modelo = new ModelAndView("appview/vacunacion/dashboard-vacunacion");
        modelo.addObject("updatedate", Calendar.getInstance().getTime());
        return modelo;
    }

    @RequestMapping(value="/dashboard/vacunacion/show/vacunacionSearchTag", method=RequestMethod.GET)
    public String showDashBoardClient() {
        return "appview/vacunacion/dashboard-vacunacion-search-tag";
    }

    @RequestMapping (value = "/dashboard/vacunacion/show/searchTabs" , method = RequestMethod.GET)
    public String showTabsClient () {
        return "appview/vacunacion/dashboard-vacunacion-search-tabs";
    }

    @RequestMapping (value = "/dashboard/vacunacion/service/search" , method = RequestMethod.GET)
    public String searchCustomer (Model modelo, @RequestParam(value = "param",  required=false) String param) {
        LOGGER.info("load searchCustomer...");

        List<PacienteDTO> pacientes;
        try {
            Map<String, Object> pathVariable = new HashMap<>();
            pathVariable.put("dni",param);

            Map<String, String> header = new HashMap<>();

            pacientes = restUtils.callService(configurationProperties.url_reniec + "/paciente/{dni}/dni", List.class, HttpMethod.GET, null, pathVariable, null, null, header );
            modelo.addAttribute(KEY_MODEL_DASHBOARD_PACIENTE,pacientes);
            modelo.addAttribute(KEY_MODEL_DASHBOARD_PACIENTE_SIZE, pacientes.size());
            modelo.addAttribute("updatedate", Calendar.getInstance().getTime());
        }catch (Exception e) {
            this.getResponseBaseBean().setCode(CODE_RESPONSE_ERROR);
            LOGGER.error(e.getMessage(), e);
        }
        return "appview/vacunacion/dashboard-paciente-searh-result-tag";
    }
}
