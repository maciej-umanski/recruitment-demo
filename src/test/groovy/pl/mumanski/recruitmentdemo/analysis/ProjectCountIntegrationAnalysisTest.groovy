package pl.mumanski.recruitmentdemo.analysis


import pl.mumanski.recruitmentdemo.datasource.LoanLoader
import pl.mumanski.recruitmentdemo.datasource.ResourceLoanLoader
import pl.mumanski.recruitmentdemo.repository.InMemoryLoanRepository
import pl.mumanski.recruitmentdemo.repository.LoanRepository
import spock.lang.Specification

class ProjectCountIntegrationAnalysisTest extends Specification {
    def "should retrieve analysis after parsing one json"() {
        given:
            String filename = "correct_one_data.json"

        when:
            LoanLoader loanLoader = new ResourceLoanLoader(filename)
            LoanRepository loanRepository = new InMemoryLoanRepository(loanLoader)
            Analysis analysis = new ProjectCountAnalysis(loanRepository)
            List<AnalysisResultDto> analysisResultDtoList = analysis.getAnalysedData()

        then:
            analysisResultDtoList.size() == 1
    }
}
