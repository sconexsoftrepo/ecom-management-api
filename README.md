ECommerceManagementAPI (management.joesphfireworks.com) 
------------------------------------------------------------------------
    (a) Admin
		1. System Configuarations
		2. Manage Operators (Types : Internal Users / Dealer Users)
		3. Manage Dealers along with the priorities
		4. Manage Products Catelog
		5. Manage Price List
		6. Freight Update per Zipcode
  
	(b) Operator 
		1. Dashboard (Last 10 days sales in bar graph, top 5 dealer sales in bar graph, etc)
		2. Manage Inventory (Individual Updates & csv Uploads) for specified Dealer
		3. Overide Order Allocation (Inventory updation for Dealer & Virtual Godown)
		4. Open Orders & Delivery Status update
		5. Closed Orders
		6. Other Reporting
 
	(c) Dealer 
		1. Manage Inventory (Individual Updates & csv Uploads) for logged in Dealer
		2. Orders specific to the logged in Dealer
		3. Reporting


    Order Allocation Algorithm

        for(item of cart){

            let dealers[] = getDealersInOrderOfPriorityAndStock(item);

            let requiredQty = item.qty;

            for(dealer of dealers)({
                let stock = getStock(dealer,item);

                let allocation = (stock>=requiredQty) ? requiredQty : stock;

                allocate(dealer,item,stock);

                requiredQty -= allocation;

                if(requiredQty==0) {
                    break;
                }
            }

        }


Product
    productId
    name
    price
    categoryId

Category
    categoryId
    name

EcomUser
    userId
    firstName
    lastName
    mobile
    mailId
    role        "DEALER | OPERATOR | ADMIN"

PriceLog
    logId
    productId    
    price
    updateDateTime  : LocalDateTime

Dealer  extends EcomUsers
    title
    priority

DealerPriorityLog
    logId
    userId
    priority
    updateDateTime  : LocalDateTime

ProductInStockTran
    tranId
    productId
    dealerId
    instock

ProductOutStockTran
    tranId
    productId
    dealerId
    outstock    
