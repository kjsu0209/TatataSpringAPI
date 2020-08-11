package com.mvc.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
    @ResponseBody
    @RequestMapping(value="/device", method={ RequestMethod.GET, RequestMethod.POST })
    public String home( HttpServletRequest request ) throws Exception {
        JSONObject json = new JSONObject();
        
        json.put("success", true);
        json.put("data", 10);
        json.put("hello", 10);
                
        return json.toJSONString();
    }
    
    @ResponseBody
    @RequestMapping(value="/gps", method={ RequestMethod.GET, RequestMethod.POST })
    public String gps() throws Exception {
    	JSONObject json = new JSONObject();
        
        json.put("success", true);
        json.put("lat", 35.888263);
        json.put("lon", 128.609995);
                
        return json.toJSONString();
    }
	
}
