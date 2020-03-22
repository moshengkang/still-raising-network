package com.keepstudy;

import com.keepstudy.bean.Emp;
import com.keepstudy.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: spring boot 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmpService empService;

    @Test
    public void getDataConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void getEmp() {
        List<Emp> emps = empService.selectAll();
        emps.stream().forEach(e -> {
            System.out.println(e);
        });
    }

}
