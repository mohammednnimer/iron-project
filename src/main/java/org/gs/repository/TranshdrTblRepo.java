package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.dto.TransactionFiltering;
import org.gs.entity.TranshdrTbl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TranshdrTblRepo implements PanacheRepository<TranshdrTbl> {


    public java.math.BigDecimal findNextVoucherNum() {
         java.math.BigDecimal max = find("select max(intVouchernum) from TranshdrTbl")
                .project(java.math.BigDecimal.class)
                .firstResult();
        if (max == null) {
            return java.math.BigDecimal.ONE;
        }
        return max.add(java.math.BigDecimal.ONE);
    }


    public TranshdrTbl updateStatus( int Vouchernum , int status) {



       return  find("intVouchernum = ?1", BigDecimal.valueOf(Vouchernum)).firstResult();

    }


    public List<TranshdrTbl> findAll(int limit, int page) {
            int offset = (page - 1) * limit;
            return find("ORDER BY intVouchernum DESC")
                    .range(offset, offset + limit - 1)
                    .list();
        }

    public List<TranshdrTbl> findFiltering(int limit, int page, TransactionFiltering transactionFiltering) {
        StringBuilder query = new StringBuilder("1 = 1");
        Map<String, Object> params = new HashMap<>();

        if (transactionFiltering.getFromDate() != null) {
            query.append(" AND datDate >= :fromDate");
            params.put("fromDate", transactionFiltering.getFromDate());
        }

        if (transactionFiltering.getToDate() != null) {
            query.append(" AND datDate <= :toDate");
            params.put("toDate", transactionFiltering.getToDate());
        }

        if (transactionFiltering.getCustomerName() != null && !transactionFiltering.getCustomerName().trim().isEmpty()) {
            query.append(" AND LOWER(txtCustname) LIKE :customerName");
            params.put("customerName", "%" + transactionFiltering.getCustomerName().toLowerCase() + "%");
        }
        if (transactionFiltering.getUsername() != null && !transactionFiltering.getUsername().trim().isEmpty()) {
            query.append(" AND LOWER(txtUsercode) LIKE :username");
            params.put("username", "%" + transactionFiltering.getUsername().toLowerCase() + "%");
        }
        if (transactionFiltering.getStatus() != null) {
            query.append(" AND intStatus = :status");
            params.put("status", transactionFiltering.getStatus());
        }
        if (transactionFiltering.getFromOrderNumber() != null) {
            query.append(" AND intVouchernum >= :fromOrder");
            params.put("fromOrder", transactionFiltering.getFromOrderNumber());
        }

        if (transactionFiltering.getToOrderNumber() != null) {
            query.append(" AND intVouchernum <= :toOrder");
            params.put("toOrder", transactionFiltering.getToOrderNumber());
        }

        query.append(" ORDER BY datDate DESC");

        int offset = (page - 1) * limit;

        PanacheQuery<TranshdrTbl> panacheQuery = find(query.toString(), params);
        return panacheQuery.range(offset, offset + limit - 1).list();
    }

}
