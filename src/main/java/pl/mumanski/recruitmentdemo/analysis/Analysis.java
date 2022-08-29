package pl.mumanski.recruitmentdemo.analysis;

import java.util.List;

public interface Analysis {
    List<AnalysisResultDto> getAnalysedData();

    String getDescription();
}
