package pl.mumanski.recruitmentdemo.repository


import pl.mumanski.recruitmentdemo.datasource.LoanLoader
import pl.mumanski.recruitmentdemo.datasource.ResourceLoanLoader
import spock.lang.Specification

class InMemoryLoanRepositoryTest extends Specification {
    def "should retrieve analysis after parsing one json"() {
        given:
        String filename = "correct_one_data.json"

        when:
        LoanLoader loanLoader = new ResourceLoanLoader(filename)
        LoanRepository loanRepository = new InMemoryLoanRepository(loanLoader)

        then:
        loanRepository.retrieveAll().size() == 1
    }
}
