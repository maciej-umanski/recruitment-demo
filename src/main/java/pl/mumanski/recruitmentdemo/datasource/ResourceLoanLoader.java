package pl.mumanski.recruitmentdemo.datasource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mumanski.recruitmentdemo.analysis.Loan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceLoanLoader implements LoanLoader {
    private final String propertyFilename;

    public ResourceLoanLoader(String propertyFilename) {
        this.propertyFilename = propertyFilename;
    }

    public List<Loan> load() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            try (InputStream inputStream = classLoader.getResourceAsStream(this.propertyFilename)) {
                if (inputStream == null) return Collections.emptyList();
                try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                     BufferedReader reader = new BufferedReader(inputStreamReader)) {
                    return reader.lines()
                            .map(this::deserialize)
                            .map(LoanRepresentation::toDomain)
                            .collect(Collectors.toList());
                }
            }
        } catch (IOException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    private LoanRepresentation deserialize(String json) {
        try {
            return new ObjectMapper().readValue(json, LoanRepresentation.class);
        } catch (JsonProcessingException e) {
            throw new DeserializationException(LoanRepresentation.class, json);
        }
    }
}
