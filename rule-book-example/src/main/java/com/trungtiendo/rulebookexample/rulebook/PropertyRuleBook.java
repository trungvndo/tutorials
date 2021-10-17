package com.trungtiendo.rulebookexample.rulebook;

import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;
import com.trungtiendo.rulebookexample.model.PropertyBean;
import com.trungtiendo.rulebookexample.model.ValidationResult;

public class PropertyRuleBook extends CoRRuleBook<ValidationResult> {

    @Override
    public void defineRules() {
        // name cannot be longer than 50 characters
        addRule(RuleBuilder.create().withFactType(PropertyBean.class).withResultType(ValidationResult.class)
            .when(facts -> facts.getOne().getName().length() > 10)
                .then((facts, result) -> result.getValue().addViolation("Name cannot be longer than 10 characters"))
                .build());

        // location cannot be longer than 50 characters
        addRule(RuleBuilder.create().withFactType(PropertyBean.class).withResultType(ValidationResult.class)
                .when(facts -> facts.getOne().getLocation().length() > 50)
                .then((facts, result) -> result.getValue().addViolation("Location cannot be longer than 50 characters"))
                .build());

        // size cannot be negative
        addRule(RuleBuilder.create().withFactType(PropertyBean.class).withResultType(ValidationResult.class)
                .when(facts -> facts.getOne().getSize() <= 0)
                .then((facts, result) -> result.getValue().addViolation("Size cannot be negative"))
                .build());

        // size cannot be higher than 1000
        addRule(RuleBuilder.create().withFactType(PropertyBean.class).withResultType(ValidationResult.class)
                .when(facts -> facts.getOne().getSize() > 1000)
                .then((facts, result) -> result.getValue().addViolation("Size cannot be higher than 1000"))
                .build());

        // size cannot be higher than 1000
        addRule(RuleBuilder.create().withFactType(PropertyBean.class).withResultType(ValidationResult.class)
                .when(facts -> facts.getOne().getNumberOfBedRooms() > 10 || facts.getOne().getNumberOfBedRooms() < 0)
                .then((facts, result) -> result.getValue().addViolation("The number of bedrooms must be between 1 and 10"))
                .build());
    }
}
