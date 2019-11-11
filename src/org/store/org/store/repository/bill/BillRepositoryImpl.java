package org.store.org.store.repository.bill;

import org.store.domain.Bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillRepositoryImpl implements BillRepository {
    private static Map<Integer,Bill> integerBillMap =new HashMap<>();
    @Override
    public Bill getBillById(int billId) {
        return integerBillMap.get(billId);
    }

    @Override
    public List<Bill> getAllBills() {
        return (List<Bill>)integerBillMap.values();
    }

    @Override
    public Bill addBill(Bill bill) {
        return integerBillMap.put(bill.getbId(),bill);
    }

    @Override
    public Bill modifyBill(Bill bill) {
        return null;
    }
}
