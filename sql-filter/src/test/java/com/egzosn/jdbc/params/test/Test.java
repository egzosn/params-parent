package com.egzosn.jdbc.params.test;

import com.egzosn.jdbc.params.Params;
import com.egzosn.jdbc.params.filter.SqlFilter;
import com.egzosn.jdbc.params.filter.SqlFilterRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by egan on 2018/11/1.
 * <a href="mailto:egzosn@gmail.com">郑灶生</a>
 * <br/>
 * email: egzosn@gmail.com
 */

public class Test {

    public static void main(String[] args) {
        Map<String, String[]> requests = new HashMap<String, String[]>();
        requests.put("Q^o#name^!|", new String[]{"egan"});
        requests.put("Q^o#follow_people_account^!|", new String[]{"^NNUL=1"});
        requests.put("Q^odOrderTmpSub#first_warning", new String[]{"!|^EQ^S=1"});
        Params params = new SqlFilter(new SqlFilterRequest(requests)).setAlias("o").getQueryParams();
        System.out.println(params.builderParas().getSqlString());
        System.out.println(params.getParas());

        requests.clear();
        requests.put("Q^o#login_name^!|^LK", new String[]{"zzs"});
        requests.put("Q^o#shipType^!|^IN^i", new String[]{"1","3"});
        requests.put("Q^o#orderCreateTime^!|^BW^D", new String[]{"2018-11-1,2018-11-2"});
        params = new SqlFilter(new SqlFilterRequest(requests), OdOrderDaoParams.FIELD_4_COLUMNS).setAlias("o").getQueryParams();
        System.out.println(params.builderParas().getSqlString());
        System.out.println(params.getParas());

        requests.put("sort", new String[]{"name"});
        requests.put("order", new String[]{"desc"});
        requests.put("page", new String[]{"1"});
        requests.put("rows", new String[]{"10"});
        params = new SqlFilter(new SqlFilterRequest(requests), OdOrderDaoParams.FIELD_4_COLUMNS).setAlias("o").setOrder().setPageing().getQueryParams();
        System.out.println(params.builderParas().getSqlString());
        System.out.println(params.getParas());
        System.out.println(String.format("分页信息：开始页%s, 每页%s行", params.getPage().getPageIndex(), params.getPage().getPageSize()));



    }

}
