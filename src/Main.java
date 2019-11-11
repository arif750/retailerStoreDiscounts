import org.store.domain.Bill;
import org.store.service.bill.BillService;
import org.store.service.bill.BillServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        BillService billService=new BillServiceImpl();
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer>itemQuantityMap=new HashMap<>();
        System.out.println("Please enter customerId in range[1 to 4] and discount are  30% for store employee, 10% for affiliated customer, 5% for loyal customber since 2yrs,0% for other customer");
        int customerId =scanner.nextInt();
        System.out.println("Enter Purchased Items:");
        while(true){
            System.out.println("Enter itemId in[1 to 4]");
            int itemId=scanner.nextInt();
            System.out.println("Enter item quantity any number");
            int quantity=scanner.nextInt();
            itemQuantityMap.put(itemId,quantity);
            System.out.println("Enter more item[Y/N/yes/no/n/y]?");
            String more=scanner.next();
            if(!more.equalsIgnoreCase("Y")&&!more.equalsIgnoreCase("Yes")){
                break;
            }

        }
        Bill bill=billService.prepareBill(customerId, itemQuantityMap);
        System.out.println("Customer Bill:"+bill);


    }


}