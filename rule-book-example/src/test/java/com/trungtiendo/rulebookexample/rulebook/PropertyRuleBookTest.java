package com.trungtiendo.rulebookexample.rulebook;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import com.trungtiendo.rulebookexample.model.PropertyBean;
import com.trungtiendo.rulebookexample.model.ValidationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PropertyRuleBookTest {

    @Test
    @DisplayName("Property Rule Book Chain test 1")
    public void propertyRuleBookChainTest1() {
        RuleBook propertyRuleBook = RuleBookBuilder
                .create(PropertyRuleBook.class)
                .withResultType(ValidationResult.class)
                .withDefaultResult(new ValidationResult())
                .build();

        NameValueReferableMap facts = new FactMap();
        PropertyBean propertyBean = new PropertyBean("a super long name", "George str", 2000, 20);
        facts.setValue("property", propertyBean);
        propertyRuleBook.run(facts);
        Result<ValidationResult> validationResult = (Result<ValidationResult>) propertyRuleBook.getResult().get();
        Assertions.assertEquals(validationResult.getValue().getViolations().size(),3);
    }

    @Test
    @DisplayName("Property Rule Book Chain test 2")
    public void propertyRuleBookChainTest2() {
        RuleBook propertyRuleBook = RuleBookBuilder
                .create(PropertyRuleBook.class)
                .withResultType(ValidationResult.class)
                .withDefaultResult(new ValidationResult())
                .build();

        NameValueReferableMap facts = new FactMap();
        PropertyBean propertyBean = new PropertyBean("a name", "George str", 2000, 10);
        facts.setValue("property", propertyBean);
        propertyRuleBook.run(facts);
        Result<ValidationResult> validationResult = (Result<ValidationResult>) propertyRuleBook.getResult().get();
        Assertions.assertEquals(validationResult.getValue().getViolations().size(),1);
    }
}
