package pl.mumanski.recruitmentdemo;

import pl.mumanski.recruitmentdemo.analysis.Analysis;
import pl.mumanski.recruitmentdemo.analysis.ProjectCountAnalysis;
import pl.mumanski.recruitmentdemo.analysis.RegionInvestmentAnalysis;
import pl.mumanski.recruitmentdemo.datasource.LoanLoader;
import pl.mumanski.recruitmentdemo.datasource.ResourceLoanLoader;
import pl.mumanski.recruitmentdemo.repository.InMemoryLoanRepository;
import pl.mumanski.recruitmentdemo.repository.LoanRepository;
import pl.mumanski.recruitmentdemo.view.AnalysisViewer;
import pl.mumanski.recruitmentdemo.view.ProjectCountAnalysisViewer;
import pl.mumanski.recruitmentdemo.view.RegionInvestmentAnalysisViewer;

public class RecruitmentDemoApplication {
    public static void main(String[] args) {
        LoanLoader loanLoader = new ResourceLoanLoader("world_bank.json");
        LoanRepository loanRepository = new InMemoryLoanRepository(loanLoader);

        Analysis projectCountAnalysis = new ProjectCountAnalysis(loanRepository);
        AnalysisViewer projectCountAnalysisViewer = new ProjectCountAnalysisViewer(projectCountAnalysis);
        projectCountAnalysisViewer.view();

        System.out.println();

        Analysis regionInvestmentAnalysis = new RegionInvestmentAnalysis(loanRepository);
        AnalysisViewer regionInvestmentAnalysisViewer = new RegionInvestmentAnalysisViewer(regionInvestmentAnalysis);
        regionInvestmentAnalysisViewer.view();
    }
}
