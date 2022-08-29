package pl.mumanski.recruitmentdemo.analysis;

import pl.mumanski.recruitmentdemo.repository.LoanRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegionInvestmentAnalysis implements Analysis {
    private final LoanRepository loanRepository;

    public RegionInvestmentAnalysis(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<AnalysisResultDto> getAnalysedData() {
        Map<String, BigDecimal> parsedData = getRegionsWithSumOfInvestment();

        return parsedData.entrySet()
                .stream()
                .map(entry -> AnalysisResultDto.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getDescription() {
        return "Amount of cash invested per region:";
    }

    private Map<String, BigDecimal> getRegionsWithSumOfInvestment() {
        List<Loan> retrievedLoans = loanRepository.retrieveAll();

        return retrievedLoans.stream()
                .collect(Collectors.groupingBy(Loan::getRegionName,
                        Collectors.reducing(BigDecimal.ZERO, Loan::getLendProjectCost, BigDecimal::add)));
    }
}
