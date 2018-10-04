package Bean;

import errors.InfoExcepion;

public interface ItemInterface {

	Item ItemDetail(Long item_no)throws InfoExcepion;
	void ItemWithdrawal (int amount) throws InfoExcepion;
    void AddItem(Item item) throws InfoExcepion;
	void DepositItem(int amount) throws InfoExcepion;
	void removeItem(Item item) throws InfoExcepion;
}
