package pl.mumanski.recruitmentdemo.view;

import pl.mumanski.recruitmentdemo.analysis.Analysis;
import pl.mumanski.recruitmentdemo.analysis.AnalysisResultDto;

import java.util.Comparator;
import java.util.List;

public class ProjectCountAnalysisViewer implements AnalysisViewer {
    private final Analysis analysis;

    public ProjectCountAnalysisViewer(Analysis analysis) {
        this.analysis = analysis;
    }

    @Override
    public void view() {
        List<AnalysisResultDto> analysisResult = analysis.getAnalysedData();
        System.out.println(analysis.getDescription());
        analysisResult.stream()
                .sorted(Comparator.comparing(AnalysisResultDto::getProjectCount).reversed())
                .limit(10)
                .forEach(this::printEntry);
    }

    private void printEntry(AnalysisResultDto analysisResultDto) {
        System.out.println(analysisResultDto.getRegion() + " = " + analysisResultDto.getProjectCount());
    }
}
