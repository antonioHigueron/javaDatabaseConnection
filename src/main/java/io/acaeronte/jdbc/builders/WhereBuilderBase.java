package io.acaeronte.jdbc.builders;

import io.acaeronte.jdbc.common.Condition;
import io.acaeronte.jdbc.mapper.annotations.Column;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class WhereBuilderBase extends BuilderBase {

    private final List<Condition> conditions;
    private final Map<Column, Field> columnsFields;

    public WhereBuilderBase(Map<Column, Field> columnsFields){
        this.conditions = new ArrayList<>();
        this.columnsFields = columnsFields;
    }

    public void addCondition(Condition condition){
        this.conditions.add(condition);
    }

    public List<Condition> getConditions() {
        return this.conditions;
    }


}
