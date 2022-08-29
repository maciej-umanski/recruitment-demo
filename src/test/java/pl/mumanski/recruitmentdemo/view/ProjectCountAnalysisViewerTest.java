package pl.mumanski.recruitmentdemo.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mumanski.recruitmentdemo.analysis.Analysis;
import pl.mumanski.recruitmentdemo.analysis.ProjectCountAnalysis;
import pl.mumanski.recruitmentdemo.datasource.LoanLoader;
import pl.mumanski.recruitmentdemo.datasource.ResourceLoanLoader;
import pl.mumanski.recruitmentdemo.repository.InMemoryLoanRepository;
import pl.mumanski.recruitmentdemo.repository.LoanRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ProjectCountAnalysisViewerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void isViewPrintingOutput() {
        LoanLoader loanLoader = new ResourceLoanLoader("correct_data.json");
        LoanRepository loanRepository = new InMemoryLoanRepository(loanLoader);
        Analysis analysis = new ProjectCountAnalysis(loanRepository);
        AnalysisViewer analysisViewer = new ProjectCountAnalysisViewer(analysis);

        analysisViewer.view();

        assertFalse(outContent.toString().isBlank());
    }

}