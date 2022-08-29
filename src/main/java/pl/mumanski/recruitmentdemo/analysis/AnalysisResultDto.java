package pl.mumanski.recruitmentdemo.analysis;

import java.math.BigDecimal;

public class AnalysisResultDto {
    private final String region;
    private final Long projectCount;
    private final BigDecimal sumOfInvestment;

    private AnalysisResultDto(String region, Long projectCount, BigDecimal sumOfInvestment) {
        this.region = region;
        this.projectCount = projectCount;
        this.sumOfInvestment = sumOfInvestment;
    }

    public static AnalysisResultDto of(String region, Long projectCount) {
        return new AnalysisResultDto(region, projectCount, null);
    }

    public static AnalysisResultDto of(String region, BigDecimal sumOfInvestment) {
        return new AnalysisResultDto(region, null, sumOfInvestment);
    }

    public String getRegion() {
        return region;
    }

    public Long getProjectCount() {
        return projectCount;
    }

    public BigDecimal getSumOfInvestment() {
        return sumOfInvestment;
    }
}
