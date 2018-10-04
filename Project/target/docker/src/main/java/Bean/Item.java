package Bean;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.data.elasticsearch.core.query.UpdateQuery;

import connection.DAL;
import errors.InfoExcepion;


	public  class Item {
		private long Item_No;
		private String name;
		private int amount;
		private long inventory_Code;
		
		
		public Item(long Item_No, String name, int amount, long inventory_Code) {
			super();
		
			this.Item_No = Item_No;
			this.name = name;
			this.amount = amount;
			this.inventory_Code = inventory_Code;
		}
		
		public Item() {
			super();
		}
		public long getItemNo() {
			return Item_No;
		}
		public void setItemNo(long itemNo) {
			this.Item_No = itemNo;
		}
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}  
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public long getInventoryCode() {
			return inventory_Code;
		}
		public void setInventoryCode(long inventoryCode) {
			this.inventory_Code = inventoryCode;
		}
		@Override
		public String toString() {
			return "Inventory [itemNo=" + Item_No + ", name=" + name + ", amount=" + amount + ", inventoryCode="
					+ inventory_Code + "]";
		}
		
		
		
		
		
		//REMOVE ITEM FROM THE TABLE 
		public void removeItem()throws InfoExcepion {
			
			try {
				
				String sqlQuery = "DELETE FROM ITEM WHERE ITEM_NO=?";
				PreparedStatement preparedStatement = DAL.CreatSAtatement(sqlQuery);
				preparedStatement.setLong(1, this.Item_No);
				preparedStatement.executeUpdate();
			}catch(Exception e) {
				throw new InfoExcepion();
			}finally{
//				DAL.Instace.returnConnection(connection);
			}
		}
		
		public void AddItem() throws InfoExcepion{
			try {
				String sqlQuery = "INSERT INTO ITEM(ITEM_NO , NAME , AMOUNT , INVENTORY_CODE) VALUES (? , ? , ?, ?)";
				PreparedStatement preparedStatement = DAL.CreatSAtatement(sqlQuery);
				preparedStatement.setLong(1, this.Item_No);
				preparedStatement.setString(2, this.name);
				preparedStatement.setInt(3, this.amount);
				preparedStatement.setLong(4, this.inventory_Code);
				preparedStatement.executeUpdate();			
				
			}catch(Exception e) {
				throw new InfoExcepion();
				
			}
		}
		
		
		// will put all the items with the same Item number into array and display them
		public static Item ItemDetail(Long item_No)throws InfoExcepion {
			try {
				String sqlQuery = "SELECT * FROM ITEM WHERE iTEM_NO="+Long.toString(item_No)+"";
				ResultSet resultSet =DAL.ExecuteQuery(sqlQuery);
			    resultSet.next();
		     	
			    Item item =  new Item();
			    
			    item.setItemNo(resultSet.getLong("ITEM_NO"));
			    item.setName(resultSet.getString("NAME"));
			    item.setAmount(resultSet.getInt("AMOUNT"));
			    item.setInventoryCode(resultSet.getLong("INVENTORY_CODE"));
			    return item;
			    
			}catch(Exception e) {
				throw new  InfoExcepion();
			}
			
			
		}
		
		// deposit an item into the data base

		public void DepositItem(int amount) throws InfoExcepion {
		
	
			try {
				int currentAmount = ItemDetail(this.Item_No).getAmount();
				String sqlQuery  = " UPDATE ITEM SET AMOUNT = AMOUNT + ? WHERE ITEM_NO = ?";
				PreparedStatement preparedStatement = DAL.CreatSAtatement(sqlQuery);
				preparedStatement.setInt(1, amount);
				preparedStatement.setLong(2, this.Item_No);	
				preparedStatement.executeUpdate();
	     		
			}catch(Exception e) {
				throw new InfoExcepion();
				
			}
		}
		
			// take amount of an item from the data base
		public void ItemWithdrawal(int amount)throws InfoExcepion {
		
			try {
				
				int currentAmount = ItemDetail(this.Item_No).getAmount();
				if(currentAmount < amount ) {
					throw new Exception();
				}
				String sqlQuery = "UPDATE ITEM SET AMOUNT = AMOUNT - ? WHERE ITEM_NO = ?";			
				PreparedStatement preparedStatement = DAL.CreatSAtatement(sqlQuery);
				preparedStatement.setInt(1, amount);
				preparedStatement.setLong(2, this.Item_No);
				preparedStatement.executeUpdate();
			}catch(Exception e) {
				throw new InfoExcepion();
				
			}
		}
		
		
		


		
		


}
