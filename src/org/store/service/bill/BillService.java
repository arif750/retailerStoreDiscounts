package org.store.service.bill;

import org.store.domain.Bill;

import java.util.List;
import java.util.Map;

public interface BillService {

    public Bill getBillById(int billId);
    public List<Bill> getAllBills();
    public Bill prepareBill(int custId, Map<Integer,Integer> items);
    public Bill modifyBill(int custId, int billId, Map<Integer,Integer> items);
}
