package com.egzosn.jdbc.params.test;

import com.egzosn.jdbc.params.Where;
import com.egzosn.jdbc.params.enums.Restriction;
import com.egzosn.jdbc.params.utils.BaseJdbcRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by egan on 2018/10/25.
 */
public class Test {

    public static void main(String[] args) {
        BaseJdbcRepository repository = new BaseJdbcRepository("USER");
        repository.findByProperty("name", "张三");

        Where where = new Where().where() ;
        where.setAlias("u");
        where.and("name", "李四")
        .and("age", new Long[]{12L, 24L}, Restriction.BW)
        .order("name")
        ;
        repository.queryList(where, false);

        repository.delete(1);
        List ids = Arrays.asList(1,2,3);
        repository.delete(ids);

        Map<String, Object> updateField = new HashMap<>(2);
        updateField.put("sex", "男");
        updateField.put("age", 24);

        where = new Where() ;
        where.setAlias("u");
        where.and("name", "李四")
        ;
        repository.update(updateField, where);

        Map<String, Object> values = new HashMap<>(2);
        values.put("ids", ids);
        repository.delete(" delete from USER  where id in( :ids)", values);
    }

}
