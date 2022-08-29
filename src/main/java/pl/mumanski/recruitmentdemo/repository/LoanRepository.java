package pl.mumanski.recruitmentdemo.repository;

import pl.mumanski.recruitmentdemo.analysis.Loan;

import java.util.List;

public interface LoanRepository {
    List<Loan> retrieveAll();
}
