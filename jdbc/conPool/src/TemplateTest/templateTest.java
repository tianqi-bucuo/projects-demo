package TemplateTest;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.jdbcUtils;

public class templateTest {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(jdbcUtils.getDataSourse());
        String sql = "update users set pwd=456 where id =?";
        int count = template.update(sql, 2);
        System.out.println(count);
    }
}
