package com.trungtiendo.rulebookexample.rulebook;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import com.trungtiendo.rulebookexample.model.PropertyBean;

public class SimplePropertyRule {

    public static void runFirstPropertyRule() {
        RuleBook ruleBook = RuleBookBuilder
                .create()
                .addRule(rule -> rule
                            .withFactType(PropertyBean.class)
                            .when(facts -> facts.getOne().getName().length() > 10)
                            .then(f -> System.out.println("Name is longer than 10 characters"))
                )
                .build();
        NameValueReferableMap factMap = new FactMap();
        factMap.setValue("property", new PropertyBean("A long name", "George str", 20, 2));
        ruleBook.run(factMap);
    }
}
