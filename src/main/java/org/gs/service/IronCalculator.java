package org.gs.service;

import org.gs.dto.IronCalculationRequest;
import org.gs.dto.IronCalculationResult;

public class IronCalculator {

    public IronCalculationResult calc(IronCalculationRequest req) {
        double totalWeight = 0;
        double totalPrice = 0;

        if (req.getType() == 1) {
            totalPrice = req.getQuantity() * req.getUnitPrice();

        }  else {
            totalWeight = req.getQuantity() * req.getLength() * req.getUnitWeight();
            totalPrice = totalWeight * req.getUnitPrice();
        }


        return new IronCalculationResult(totalWeight, totalPrice);
    }
}
