package rty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bean.Item;
import errors.InfoExcepion;

@RestController
public class test2 {
//	@RequestMapping("/hello")
//	public String test22() {
//		return "hello";
//		
//	}
//	@RequestMapping("/ItemAmount")
//	public int ItmeDetail(@RequestParam Long item_no) throws InfoExcepion {
//		Item item = Item.ItemDetail(item_no);
//		return item.getAmount() ;
//		
//	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
	public String sayHello() {
		return "Swagger Hello World";
	}

	
	
//	@RequestMapping("/ItemDetail")
//	public int ItemDetail(@RequestParam Long item_no) throws InfoExcepion {
//		
//		return 1;
//	}
}
