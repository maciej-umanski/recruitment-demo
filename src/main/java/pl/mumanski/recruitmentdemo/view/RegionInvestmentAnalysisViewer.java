package pl.mumanski.recruitmentdemo.view;

import pl.mumanski.recruitmentdemo.analysis.Analysis;
import pl.mumanski.recruitmentdemo.analysis.AnalysisResultDto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class RegionInvestmentAnalysisViewer implements AnalysisViewer {
    private final Analysis analysis;

    public RegionInvestmentAnalysisViewer(Analysis analysis) {
        this.analysis = analysis;
    }

    @Override
    public void view() {
        List<AnalysisResultDto> analysisResult = analysis.getAnalysedData();
        System.out.println(analysis.getDescription());
        analysisResult.stream()
                .sorted(Comparator.comparing(AnalysisResultDto::getSumOfInvestment).reversed())
                .limit(10)
                .forEach(this::printEntry);
    }

    private void printEntry(AnalysisResultDto analysisResultDto) {
        System.out.println(analysisResultDto.getRegion() + " = " + toReadableCash(analysisResultDto.getSumOfInvestment()));
    }

    private String toReadableCash(BigDecimal cash) {
        return new DecimalFormat("###,###.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(cash);
    }
}
