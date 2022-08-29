package pl.mumanski.recruitmentdemo.repository;

import org.junit.jupiter.api.Test;
import pl.mumanski.recruitmentdemo.analysis.Loan;
import pl.mumanski.recruitmentdemo.datasource.LoanLoader;
import pl.mumanski.recruitmentdemo.datasource.ResourceLoanLoader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoanRepositoryImplTest {
    @Test
    void areLoansRetrievedCorrectly() {
        LoanLoader loanLoader = new ResourceLoanLoader("world_bank.json");
        LoanRepository loanRepository = new InMemoryLoanRepository(loanLoader);
        List<Loan> loans = loanRepository.retrieveAll();
        assertNotNull(loans);
        assertEquals(loans.size(), 500);
    }
}