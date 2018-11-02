# params-parent
### 案例 Test
```java

    BaseJdbcRepository repository = new BaseJdbcRepository(FreightDaoParams.TABLE);
       //查询对象式
        FreightDaoParams params = new FreightDaoParams()
                .setCountry("中国", false)
                .setNameLK("铁塔", false)
                ;
        params.order(FreightDaoParams.Field.countryShortEn.getColumn(), params.alias());
        
        //查询获取sql
        repository.uniqueQuery(params);
        //重新设置表名
        repository.setTable("USER");
      
        //以某个列进行查询对应的实体
        repository.findByProperty("name", "张三");

        //以条件对象的形式
        Where where = new Where().where() ;
        where.setAlias("u");
        where.and("name", "李四")
        .and("age", new Long[]{12L, 24L}, Restriction.BW)
        .order("name")
        ;
        //查询获取sql
        repository.queryList(where, false);


        //以id进行删除
        repository.delete(1);

        //id集
        List ids = Arrays.asList(1,2,3);
        repository.delete(ids);

        //更新
        Map<String, Object> updateField = new HashMap<>(2);
        updateField.put("sex", "男");
        updateField.put("age", 24);
        where = new Where() ;
        where.setAlias("u");
        where.and("name", "李四")
        ;
        //更新获取sql
        repository.update(updateField, where);

        // 冒号代替形式
        Map<String, Object> values = new HashMap<>(2);
        values.put("ids", ids);
        //删除获取sql
        repository.delete(" delete from USER  where id in( :ids)", values);

```
### 执行结果

```html
sql: select * from freight  f  where  f.country= ?  and f.name like ?  Order by f.country_short_en DESC 
中国 %铁塔%

sql: select * from USER  z  where  z.name= ? 
张三 

sql: select * from USER  u  where  name= ?  and age between ? and ?  Order by name DESC 
[李四, 12, 24] 

sql: delete from USER  where id = ?
1 

sql: delete from USER  where id in( ?,?,?)
1 2 3 

sql: update USER u set u.age=?, u.sex=?  where  name= ? 
24 男 李四 

sql:  delete from USER  where id in( ?,?,?)
1 2 3
 

 


```
