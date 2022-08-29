package pl.mumanski.recruitmentdemo.datasource;

import org.junit.jupiter.api.Test;
import pl.mumanski.recruitmentdemo.analysis.Loan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoanLoaderTest {
    @Test
    void areLoansLoadedCorrectly() {
        LoanLoader loanLoader = new ResourceLoanLoader("correct_data.json");
        List<Loan> loans = loanLoader.load();
        assertNotNull(loans);
        assertEquals(loans.size(), 500);
    }

    @Test
    void whenMalformedDataThrownException() {
        LoanLoader loanLoader = new ResourceLoanLoader("malformed_data.json");
        assertThrowsExactly(DeserializationException.class, loanLoader::load);
    }
}