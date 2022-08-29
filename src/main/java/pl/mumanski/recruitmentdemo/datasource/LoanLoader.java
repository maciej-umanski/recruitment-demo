package pl.mumanski.recruitmentdemo.datasource;

import pl.mumanski.recruitmentdemo.analysis.Loan;

import java.util.List;

public interface LoanLoader {
    List<Loan> load();
}
