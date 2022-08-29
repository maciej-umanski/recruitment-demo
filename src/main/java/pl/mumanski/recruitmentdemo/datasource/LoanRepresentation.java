package pl.mumanski.recruitmentdemo.datasource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.mumanski.recruitmentdemo.analysis.Loan;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
class LoanRepresentation {
    @JsonProperty("regionname")
    private String regionName;
    @JsonProperty("lendprojectcost")
    private BigDecimal lendProjectCost;

    public Loan toDomain() {
        return Loan.of(this.regionName, this.lendProjectCost);
    }
}
