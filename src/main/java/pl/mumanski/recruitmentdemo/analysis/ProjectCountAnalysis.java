package pl.mumanski.recruitmentdemo.analysis;

import pl.mumanski.recruitmentdemo.repository.LoanRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectCountAnalysis implements Analysis {
    private final LoanRepository loanRepository;

    public ProjectCountAnalysis(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<AnalysisResultDto> getAnalysedData() {
        Map<String, Long> parsedData = getRegionsWithProjectCount();

        return parsedData.entrySet()
                .stream()
                .map(entry -> AnalysisResultDto.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getDescription() {
        return "Projects count organised per region:";
    }

    private Map<String, Long> getRegionsWithProjectCount() {
        List<Loan> retrievedLoans = loanRepository.retrieveAll();

        return retrievedLoans.stream()
                .collect(Collectors.groupingBy(Loan::getRegionName, Collectors.counting()));
    }
}
