package pl.mumanski.recruitmentdemo.analysis;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class LoanTest {

    @Test
    void whenBlankNameLoanExceptionThrown() {
        assertThrowsExactly(DomainValidationException.class,
                () -> Loan.of(" ", BigDecimal.valueOf(300000)));
    }

    @Test
    void whenNegativeLendProjectCostExceptionThrown() {
        assertThrowsExactly(DomainValidationException.class,
                () -> Loan.of("Test", BigDecimal.valueOf(-3000)));
    }
}