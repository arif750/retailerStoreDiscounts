package org.store.service.bill;

import org.store.domain.Bill;
import org.store.domain.Customer;
import org.store.domain.Item;
import org.store.org.store.repository.bill.BillRepository;
import org.store.org.store.repository.bill.BillRepositoryImpl;
import org.store.service.customer.CustomerService;
import org.store.service.customer.CustomerServiceImpl;
import org.store.service.item.ItemService;
import org.store.service.item.ItemServiceImpl;

import java.util.*;

public class BillServiceImpl implements BillService {
    private BillRepository billRepository;
    private CustomerService customerService;
    private ItemService itemService;
    public BillServiceImpl(){
        billRepository=new BillRepositoryImpl();
        customerService=new CustomerServiceImpl();
        itemService = new ItemServiceImpl();
    }
    @Override
    public Bill getBillById(int billId) {
        return billRepository.getBillById(billId);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.getAllBills();
    }

    @Override
    public Bill prepareBill(int custId, Map<Integer, Integer> items) {
        Bill bill = new Bill();
        try {
            Customer customer = customerService.getCustomerByCustId(custId);
            double discountRate=0;
            if(null!=customer) {
                discountRate = getDiscountType(customer);
            }
            bill.setDisRate(discountRate);
            bill.setCustId(custId);
            bill.setbId(custId);
            double grossPay = 0;
            double discount = 0;
            double netPay = 0;

            for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
                Item item = itemService.getItemByItemId(entry.getKey());
                grossPay = grossPay + item.getPrice() * entry.getValue();
                if (!item.getItemType().equals("grocery")) {
                    double perItemTotalCost=item.getPrice() * entry.getValue();
                    discount = discount + (perItemTotalCost * discountRate / 100);
                }
                item.setQuantity(entry.getValue());
                if(null==bill.getItems()){
                    bill.setItems(new ArrayList<>());
                }
                bill.getItems().add(item);
            }
            netPay = grossPay - discount;
            int promotionalDiscount=(int)netPay/100;
            netPay=netPay-5*promotionalDiscount;
            discount=discount+5*promotionalDiscount;
            bill.setDiscount(discount);
            bill.setGrossPay(grossPay);
            bill.setNetPay(netPay);
            billRepository.addBill(bill);
        }catch (Exception e){
            System.out.println("Exception while preparing bill, error message:"+e.getMessage());
        }
        return bill;
    }

    @Override
    public Bill modifyBill(int custType, int billId, Map<Integer, Integer> items) {
        return null;
    }

    private static double getDiscountType(Customer customer){
        double discount;
        switch (customer.getCustType()) {
            case 1:
                discount=30;
                break;
            case 2:
                discount=10;
                break;
            default:
                Calendar cal = Calendar.getInstance();

                cal.setTime(new Date());
                cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - 2);
                Date time2hrsback=cal.getTime();
                if(customer.getSignUpDate().before(time2hrsback)||customer.getSignUpDate().equals(time2hrsback)){
                    discount=5;
                }else{
                    discount=0;
                }
        }
        return discount;

    }
}
