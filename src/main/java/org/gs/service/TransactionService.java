package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.gs.dto.Trans;
import org.gs.dto.TransactionRequest;
import org.gs.dto.Transshapes;
import org.gs.entity.CustomerTbl;
import org.gs.entity.TransdtlshapesTbl;
import org.gs.entity.TranshdrTbl;
import org.gs.entity.TransdtlTbl;
import org.gs.repository.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TransactionService {

    @Inject
    IronshapesTblRepo ironshapesTblRepo;
    @Inject
    TranshdrTblRepo transhdrRepository;

    @Inject
    TransdtlRepository transdtlRepository;

    @Inject
    TransdtlshapesTblRepo transdtlshapesTblRepo;

    @Inject
    CustomerTblRepo customerTblRepo;
    @Inject
    IrondepthTblRepo irondepthTblRepo;

    @Inject
    IrontypesTblRepo irontypesTblRepo;

    @Inject
    ItemtypesTblRepo itemtypesTblRepo;

    @Transactional
    public String createTransaction(TransactionRequest request) {

        TranshdrTbl header = request.getHeader();

        List<Trans> details = request.getTransactions();


        BigDecimal nextVoucher = transhdrRepository.findNextVoucherNum();
        header.setIntVouchernum(nextVoucher);

        if (header.getTxtKey() == null || header.getTxtKey().isBlank()) {
            header.setTxtKey(UUID.randomUUID().toString());
        }

        header.setDatCreateddate(LocalDate.now());
        header.setDatDate(LocalDate.now());
        header.setDatStampdate(Instant.now());


        CustomerTbl customerTbl = customerTblRepo.findById(header.getTxtCustkey()+"");

        if (customerTbl != null) {

            System.out.println(customerTbl.getTxtName());

            header.setTxtCustname(customerTbl.getTxtName());
            header.setTxtCustkey(customerTbl.getTxtKey());
        }
        header.setIntStatus(BigDecimal.valueOf(1));
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Trans detail : details) {
            if(detail.getIntType()==BigDecimal.valueOf(0)) {
                TransdtlTbl transdtlTbl = new TransdtlTbl();
                transdtlTbl.setTxtKey(UUID.randomUUID().toString());
                Transshapes transdtlshapes = detail.getTransshapes();
                TransdtlshapesTbl transdtlshapesTbl = new TransdtlshapesTbl();
                transdtlshapesTbl.setTxtKey(UUID.randomUUID().toString());
                transdtlshapesTbl.setTxtTranskey(transdtlTbl.getTxtKey());
                transdtlshapesTbl.setDblTotlength(
                        transdtlshapes.getDblTotlength() != null ? transdtlshapes.getDblTotlength() : BigDecimal.ZERO
                );

                transdtlshapesTbl.setIntSides(transdtlshapes.getIntSides());


                transdtlshapesTbl.setTxtShapekey(transdtlshapes.getTxtShapekey());


                String sidesList = transdtlshapes.getTxt_side_list();
                String[] sides;
                if (sidesList != null && !sidesList.isBlank()) {
                    transdtlshapesTbl.setTxtSideslist(sidesList);
                    sides = sidesList.trim().split("#");
                } else {
                    sides = new String[0];
                }
                double total = 0;

                for (int i = 0; i < sides.length; i++) {
                    total += Double.valueOf(sides[i]);
                }
                System.out.println(total);
                transdtlshapesTbl.setDblTotlength(BigDecimal.valueOf(total));


                // transdtlshapesTbl.setTxtSideslist(transdtlshapes.getTxt_side_list());
                transdtlshapesTblRepo.persist(transdtlshapesTbl);
                transdtlTbl.setIntType(BigDecimal.ZERO);
                transdtlTbl.setDblIronlength(BigDecimal.ZERO);
                transdtlTbl.setDblTotal(detail.getDblTotal() != null ? detail.getDblTotal() : BigDecimal.ZERO);
                transdtlTbl.setTxtHdrkey(header.getTxtKey());
                transdtlTbl.setDblPrice(detail.getDblPrice() != null ? detail.getDblPrice() : BigDecimal.ZERO);
                transdtlTbl.setDblQty(detail.getDblQty() != null ? detail.getDblQty() : BigDecimal.ZERO);
                transdtlTbl.setDblTotalweight(detail.getDblTotalweight() != null ? detail.getDblTotalweight() : BigDecimal.ZERO);
                // transdtlTbl.setTxtIrondepthkey(irondepthTblRepo.findByReference(detail.getTxtIrondepthkey()).getTxtKey());
                transdtlTbl.setTxtIrondepthkey(detail.getTxtIrondepthkey());
                // transdtlTbl.setTxtIrontype(irontypesTblRepo.findByReference(detail.getTxtIrontype()).getTxtKey());
                transdtlTbl.setTxtIrontype(detail.getTxtIrontype());
                sum = sum.add(detail.getDblTotalweight());
                transdtlRepository.persist(transdtlTbl);


            }
            else{

                TransdtlTbl transdtlTbl = new TransdtlTbl();
                transdtlTbl.setTxtKey(UUID.randomUUID().toString());
                transdtlTbl.setIntType(BigDecimal.valueOf(1));
                transdtlTbl.setDblQty(detail.getDblQty() != null ? detail.getDblQty() : BigDecimal.ZERO);
                transdtlTbl.setDblPrice(detail.getDblPrice() != null ? detail.getDblPrice() : BigDecimal.ZERO);
                transdtlTbl.setTxtHdrkey(header.getTxtKey());
                transdtlTbl.setTxtStockcode(itemtypesTblRepo.findByKey(detail.getTxtItemKey()).getTxtReference());
                transdtlTbl.setDblTotalweight(detail.getDblTotal() != null ? detail.getDblPrice() : BigDecimal.ZERO);
                transdtlRepository.persist(transdtlTbl);
            }

        }
        header.setDblTotal(sum);
        transhdrRepository.persist(header);

        return "1";
    }

}