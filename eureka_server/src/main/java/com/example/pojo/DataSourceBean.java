package com.example.pojo;

import com.example.config.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * description
 *
 * @author zb 2019/04/09 21:40
 */
@Lazy
public class DataSourceBean {

    @Autowired
    DataSourceProperties dataSourceProperties;

    public DataSourceBean() {
        System.out.println("DataSourceBean 被加载了！");
    }

}
