package io.acaeronte.jdbc.builders.delete;

import io.acaeronte.jdbc.builders.WhereBuilderBase;
import io.acaeronte.jdbc.mapper.annotations.Column;

import java.lang.reflect.Field;
import java.util.Map;

public class DeleteBuilder extends WhereBuilderBase {

    public DeleteBuilder(Map<Column, Field> columnsFields){
        super(columnsFields);
    }

    public String getSqlStatement(){
        StringBuilder sql = new StringBuilder();
        generateDelete(sql);
        generateWhere(sql);
        generateIsolation(sql);
        return sql.toString();
    }

    private void generateDelete(StringBuilder sql) {
        sql.append("DELETE FROM ");
        sql.append(this.table);
    }

}
