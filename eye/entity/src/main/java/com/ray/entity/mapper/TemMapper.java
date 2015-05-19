package com.ray.entity.mapper;

import com.ray.entity.Tem;
import com.ray.entity.TemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tem
     *
     * @mbggenerated
     */
    @SelectProvider(type=TemSqlProvider.class, method="countByExample")
    int countByExample(TemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tem
     *
     * @mbggenerated
     */
    @DeleteProvider(type=TemSqlProvider.class, method="deleteByExample")
    int deleteByExample(TemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tem
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tem (id)",
        "values (#{id,jdbcType=INTEGER})"
    })
    int insert(Tem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tem
     *
     * @mbggenerated
     */
    @InsertProvider(type=TemSqlProvider.class, method="insertSelective")
    int insertSelective(Tem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tem
     *
     * @mbggenerated
     */
    @SelectProvider(type=TemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER)
    })
    List<Tem> selectByExample(TemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tem
     *
     * @mbggenerated
     */
    @UpdateProvider(type=TemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Tem record, @Param("example") TemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tem
     *
     * @mbggenerated
     */
    @UpdateProvider(type=TemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Tem record, @Param("example") TemCriteria example);
}