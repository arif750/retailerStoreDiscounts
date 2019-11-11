package org.store.org.store.repository.bill;

import org.store.domain.Bill;

import java.util.List;
import java.util.Map;

public interface BillRepository {
    public Bill getBillById(int billId);
    public List<Bill> getAllBills();
    public Bill addBill(Bill bill);
    public Bill modifyBill(Bill bill);
}
