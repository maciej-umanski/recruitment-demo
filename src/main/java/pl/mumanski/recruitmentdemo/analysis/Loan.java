package pl.mumanski.recruitmentdemo.analysis;

import java.math.BigDecimal;

public class Loan {
    private final String regionName;
    private final BigDecimal lendProjectCost;

    private Loan(String regionName, BigDecimal lendProjectCost) {
        this.regionName = regionName;
        this.lendProjectCost = lendProjectCost;
    }

    public static Loan of(String regionName, BigDecimal lendProjectCost) {
        Loan loan = new Loan(regionName, lendProjectCost);
        loan.validate();
        return loan;
    }

    private void validate() {
        if (this.regionName.isBlank())
            throw new DomainValidationException("RegionName cannot be empty");

        if (this.lendProjectCost.compareTo(BigDecimal.ZERO) < 0)
            throw new DomainValidationException("LendProjectCost cannot have negative value");
    }

    public String getRegionName() {
        return regionName;
    }

    public BigDecimal getLendProjectCost() {
        return lendProjectCost;
    }
}
