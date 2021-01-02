package sample.payara.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.param.MyBatisUserSearchParam;

public interface AppleMyBatisMapper {

    /* SQL実行結果をオブジェクトにマッピングするための設定 */
    @Results(id = "findAllMybatisUser", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
    })
    /* select文 */
    @Select({
        "select *",
        "from sample_model",
    })
    public List<MyBatisUser> findAll();

    @Results(id = "findByMybatisUser", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
    })
    @Select({
        "select *",
        "from test_table s",
        "where s.id = #{id}"
    })
    public MyBatisUser findById(@Param("id") Long id);

    /* SQL文を動的に組み立てる */
    @SelectProvider(type = MyBatisMapperSqlBuilder.class, method = "findByParamSql")
    public List<MyBatisUser> findByParam(@Param("param") MyBatisUserSearchParam param);
}
