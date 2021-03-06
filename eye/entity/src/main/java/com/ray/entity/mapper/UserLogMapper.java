package com.ray.entity.mapper;

import com.ray.entity.UserLog;
import com.ray.entity.UserLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserLogSqlProvider.class, method="countByExample")
    int countByExample(UserLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @DeleteProvider(type=UserLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @Delete({
        "delete from userlog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @Insert({
        "insert into userlog (id, username, ",
        "logintime, ip, ",
        "issuccess)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{logintime,jdbcType=TIMESTAMP}, #{ip,jdbcType=VARCHAR}, ",
        "#{issuccess,jdbcType=INTEGER})"
    })
    int insert(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @InsertProvider(type=UserLogSqlProvider.class, method="insertSelective")
    int insertSelective(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="logintime", property="logintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="issuccess", property="issuccess", jdbcType=JdbcType.INTEGER)
    })
    List<UserLog> selectByExample(UserLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, username, logintime, ip, issuccess",
        "from userlog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="logintime", property="logintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="issuccess", property="issuccess", jdbcType=JdbcType.INTEGER)
    })
    UserLog selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "id, username, logintime, ip, issuccess",
        "from userlog",
        "order by logintime desc limit #{begin,jdbcType=INTEGER},#{rows,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="logintime", property="logintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="issuccess", property="issuccess", jdbcType=JdbcType.INTEGER)
    })
    List<UserLog> selectByPage(@Param("begin")int begin,@Param("rows")int rows);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlog
     *
     * @mbggenerated
     */
    @Update({
        "update userlog",
        "set username = #{username,jdbcType=VARCHAR},",
          "logintime = #{logintime,jdbcType=TIMESTAMP},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "issuccess = #{issuccess,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserLog record);
}