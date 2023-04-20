package io.acaeronte.jdbc.dao;

import javax.enterprise.inject.Vetoed;
import java.util.ArrayList;

//@VetoedForWAS855
@Vetoed
public class JdbcHealthConfiguration extends DefaultHealthConfiguration {

    public List<DataBaseStatus> dataBaseStatus(){
        List<DataBaseStatus> results = new ArrayList<>();
        for (IBaseDao instance:CdiUtils.getAll(IBaseDao.class)) {
            DataBaseStatus result = new DataBaseStatus();
            DaoStatus daoStatus = instance.check();
            result.setTable(daoStatus.getTable());
            result.setMessage(daoStatus.getMessage());
            result.setEntity(daoStatus.getEntity());
            result.setRows(daoStatus.getRows());
            results.add(result);
        }
        return results;
    }

}
