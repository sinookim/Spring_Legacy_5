package com.iu.s5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.s5.transfer.Card;
import com.iu.s5.transfer.Transfer;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private Transfer transfer;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
				
		transfer.bus(1250);
		
		transfer.taxi();

		transfer.subway(1250, "6호선");
		
		return "index";
	}
	
}
