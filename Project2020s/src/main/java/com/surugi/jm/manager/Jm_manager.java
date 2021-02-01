package com.surugi.jm.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jmManager")
public class Jm_manager {

	@RequestMapping(value = ("/jm_manager"),method = RequestMethod.GET)
	public void jmManager ()throws Exception{
		
	}
}
