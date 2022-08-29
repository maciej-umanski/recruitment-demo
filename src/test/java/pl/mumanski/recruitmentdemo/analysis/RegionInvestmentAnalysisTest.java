package pl.mumanski.recruitmentdemo.analysis;

import org.junit.jupiter.api.Test;
import pl.mumanski.recruitmentdemo.datasource.LoanLoader;
import pl.mumanski.recruitmentdemo.datasource.ResourceLoanLoader;
import pl.mumanski.recruitmentdemo.repository.InMemoryLoanRepository;
import pl.mumanski.recruitmentdemo.repository.LoanRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegionInvestmentAnalysisTest {

    @Test
    public void isDescriptionRetrievingContent() {
        LoanLoader loanLoader = new ResourceLoanLoader("correct_data.json");
        LoanRepository loanRepository = new InMemoryLoanRepository(loanLoader);
        Analysis analysis = new RegionInvestmentAnalysis(loanRepository);

        assertNotNull(analysis.getDescription());
    }

    @Test
    public void isAnalysisRetrievingAnyData() {
        LoanLoader loanLoader = new ResourceLoanLoader("correct_data.json");
        LoanRepository loanRepository = new InMemoryLoanRepository(loanLoader);
        Analysis analysis = new RegionInvestmentAnalysis(loanRepository);

        assertTrue(analysis.getAnalysedData().size() > 0);
    }

}