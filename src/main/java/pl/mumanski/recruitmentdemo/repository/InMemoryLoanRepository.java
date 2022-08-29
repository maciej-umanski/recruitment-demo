package pl.mumanski.recruitmentdemo.repository;

import pl.mumanski.recruitmentdemo.analysis.Loan;
import pl.mumanski.recruitmentdemo.datasource.LoanLoader;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLoanRepository implements LoanRepository {
    private final List<Loan> loanList;

    public InMemoryLoanRepository(LoanLoader loanLoader) {
        this.loanList = new ArrayList<>();
        this.loanList.addAll(loanLoader.load());
    }

    @Override
    public List<Loan> retrieveAll() {
        return loanList;
    }
}
