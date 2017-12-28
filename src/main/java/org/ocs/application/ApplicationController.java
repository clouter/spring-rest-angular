package org.ocs.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Redirects to index - easy and clean configuration.
 * 
 * @author rpila
 * @version 1.0 - 28/12/2017
 *
 */
@Controller
public class ApplicationController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "index";
    }
	
}