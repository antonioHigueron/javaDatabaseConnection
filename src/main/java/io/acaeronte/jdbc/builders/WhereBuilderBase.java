package io.acaeronte.jdbc.builders;

import io.acaeronte.jdbc.common.Condition;
import io.acaeronte.jdbc.common.Parameter;
import io.acaeronte.jdbc.common.ParameterOperator;
import io.acaeronte.jdbc.mapper.annotations.Column;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.acaeronte.jdbc.common.ParameterOperator.*;

public abstract class WhereBuilderBase extends BuilderBase {

    private final List<Condition> conditions;
    private final Map<Column, Field> columnsFields;

    public WhereBuilderBase(Map<Column, Field> columnsFields) {
        this.conditions = new ArrayList<>();
        this.columnsFields = columnsFields;
    }

    public void addCondition(Condition condition) {
        this.conditions.add(condition);
    }

    public List<Condition> getConditions() {
        return this.conditions;
    }

    public void addCondition(String column, Object value) {
        Condition condition = new Condition();
        condition.createParameter(column, column, value);
        this.conditions.add(condition);
    }

    public void addCondition(String column, Object value, boolean isLiteral) {
        Condition condition = new Condition();
        condition.createParameter(column, column, value, isLiteral);
        this.conditions.add(condition);
    }

    public void addCondition(String column, ParameterOperator operator) {
        Condition condition = new Condition();
        condition.createParameter(column, operator, null);
        this.conditions.add(condition);
    }

    public void addCondition(String column, ParameterOperator operator, boolean isLiteral) {
        Condition condition = new Condition();
        condition.createParameter(column, operator, null,null,isLiteral);
        this.conditions.add(condition);
    }

    public void addCondition(String column, ParameterOperator operator, Object value) {
        Condition condition = new Condition();
        condition.createParameter(column, operator, value);
        this.conditions.add(condition);
    }

    public void addCondition(String column, ParameterOperator operator, Object value, boolean isLiteral) {
        Condition condition = new Condition();
        condition.createParameter(column, operator, value, isLiteral);
        this.conditions.add(condition);
    }

    public void addCondition(String column, ParameterOperator operator, String name, Object value) {
        Condition condition = new Condition();
        condition.createParameter(column, operator, name, value);
        this.conditions.add(condition);
    }
    public void addCondition(String column,ParameterOperator operator, String name,  Object value, boolean isLiteral) {
        Condition condition = new Condition();
        condition.createParameter(column, operator, name, value, isLiteral);
        this.conditions.add(condition);
    }

    public Map<String, Object> getValueMap(){
        return this.valueMap;
    }

    protected void generateWhere(StringBuilder sql){
        if(!this.conditions.isEmpty()){
            sql.append(" WHERE ");
            generateConditions(sql, this.conditions);
        }
    }

    private void generateConditions(StringBuilder sql, List<Condition> conditions) {
        for (int i = 0; i < conditions.size(); i++) {
            Condition condition = conditions.get(i);
            if(condition.getParameter() == null){
                if(!condition.getConditions().isEmpty()){
                    if(i > 0){
                        sql.append(" ").append(condition.getOperator()).append(" ");
                    }
                    if(!condition.getConditions().isEmpty()){
                        sql.append("(");
                        generateConditions(sql,condition.getConditions());
                        sql.append(")");
                    }
                }
            } else{
                String sqlParameter = generateParameter(condition.getParameter());
                if(i > 0 && StringUtils.isNotEmpty(sqlParameter)){
                    sql.append(" ").append(condition.getOperator()).append(" ");
                }
                sql.append(sqlParameter);
            }
        }
    }

    private String generateParameter(Parameter parameter){
        switch (parameter.getOperator()){
            case IN:
            case NOT_IN:
                return generateListCondition(parameter);
            case NULL:
            case NOT_NULL:
                return generateNullableCondition(parameter);
        }
        return generateDefaultCondition(parameter);
    }

    private String generateListCondition(Parameter parameter) {
        if (parameter.getValue() instanceof List){
            List<Object> parameterList =
        }


    }


}








































