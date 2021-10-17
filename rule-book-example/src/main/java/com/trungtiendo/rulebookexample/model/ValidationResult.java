package com.trungtiendo.rulebookexample.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private List<String> violationList = new ArrayList<>();

    public void addViolation(String violation) {
        this.violationList.add(violation);
    }

    public List<String> getViolations() {
        return this.violationList;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "violationList=" + violationList +
                '}';
    }
}
