package main;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bean.Item;
import errors.InfoExcepion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/item")
public class ItemControllers {

	@ApiOperation(value = "remove item to the data base")
	@RequestMapping(value = "/removeItem", method = RequestMethod.GET, produces = "application/json")
	public void removeItem(@RequestParam long item_no) throws InfoExcepion {
		Item item = Item.ItemDetail(item_no);
		item.removeItem();
	}
	@ApiOperation(value = "Add new item to the data base")
	@RequestMapping(value = "/AddItem", method = RequestMethod.GET, produces = "application/json")
	public void AddItem(@RequestParam Long item_no , @RequestParam String name ,@RequestParam int amount , @RequestParam Long inventory_code ) throws InfoExcepion {
		Item item = new Item(item_no, name, amount, inventory_code);
		item.AddItem();
	}
	@ApiOperation(value = "information about item")
	@RequestMapping(value = "/itemDetail", method = RequestMethod.GET, produces = "application/json")
	public Item ItemDetail(@RequestParam Long item_no) throws InfoExcepion {
		return Item.ItemDetail(item_no);
	}
	@ApiOperation(value = "add more items to existing item")
	@RequestMapping(value = "/depositItem", method = RequestMethod.GET, produces = "application/json")
	public void  DepositItem(@RequestParam int amount, @RequestParam Long item_no) throws InfoExcepion {
		Item item = Item.ItemDetail(item_no);
		item.DepositItem(amount);
	}
	
	@ApiOperation(value = "take from the amount of existing item")
	@RequestMapping(value = "/ItemWithdrawal", method = RequestMethod.GET, produces = "application/json")
	public void  ItemWithdrawal(@RequestParam int amount,@RequestParam Long item_no) throws InfoExcepion {
		Item item = Item.ItemDetail(item_no);
		item.ItemWithdrawal(amount);
		
	}
}
