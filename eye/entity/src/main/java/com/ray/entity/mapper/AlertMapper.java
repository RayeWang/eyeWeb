package com.ray.entity.mapper;

import com.ray.entity.Alert;
import com.ray.entity.AlertCriteria;
import com.ray.entity.Css;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AlertMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @SelectProvider(type=AlertSqlProvider.class, method="countByExample")
    int countByExample(AlertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @DeleteProvider(type=AlertSqlProvider.class, method="deleteByExample")
    int deleteByExample(AlertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @Delete({
        "delete from alert",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @Insert({
        "insert into alert (id, title, ",
        "desc1, url, res_link_id, ",
        "res_id, atype_id, ",
        "hot, createtime, ",
        "img, alerttime, ",
        "param1, param2, ",
        "param3, param4, ",
        "param5, content)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{desc1,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{resLinkId,jdbcType=INTEGER}, ",
        "#{resId,jdbcType=INTEGER}, #{atypeId,jdbcType=INTEGER}, ",
        "0, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{img,jdbcType=VARCHAR}, #{alerttime,jdbcType=VARCHAR}, ",
        "#{param1,jdbcType=VARCHAR}, #{param2,jdbcType=VARCHAR}, ",
        "#{param3,jdbcType=VARCHAR}, #{param4,jdbcType=VARCHAR}, ",
        "#{param5,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Alert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @InsertProvider(type=AlertSqlProvider.class, method="insertSelective")
    int insertSelective(Alert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @SelectProvider(type=AlertSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc1", property="desc1", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_link_id", property="resLinkId", jdbcType=JdbcType.INTEGER),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.INTEGER),
        @Result(column="atype_id", property="atypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="hot", property="hot", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="alerttime", property="alerttime", jdbcType=JdbcType.VARCHAR),
        @Result(column="param1", property="param1", jdbcType=JdbcType.VARCHAR),
        @Result(column="param2", property="param2", jdbcType=JdbcType.VARCHAR),
        @Result(column="param3", property="param3", jdbcType=JdbcType.VARCHAR),
        @Result(column="param4", property="param4", jdbcType=JdbcType.VARCHAR),
        @Result(column="param5", property="param5", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Alert> selectByExampleWithBLOBs(AlertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @SelectProvider(type=AlertSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc1", property="desc1", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_link_id", property="resLinkId", jdbcType=JdbcType.INTEGER),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.INTEGER),
        @Result(column="atype_id", property="atypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="hot", property="hot", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="alerttime", property="alerttime", jdbcType=JdbcType.VARCHAR),
        @Result(column="param1", property="param1", jdbcType=JdbcType.VARCHAR),
        @Result(column="param2", property="param2", jdbcType=JdbcType.VARCHAR),
        @Result(column="param3", property="param3", jdbcType=JdbcType.VARCHAR),
        @Result(column="param4", property="param4", jdbcType=JdbcType.VARCHAR),
        @Result(column="param5", property="param5", jdbcType=JdbcType.VARCHAR)
    })
    List<Alert> selectByExample(AlertCriteria example);
    
    @SelectProvider(type=DynamicSql.class,method="getSql")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc1", property="desc1", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_link_id", property="resLinkId", jdbcType=JdbcType.INTEGER),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.INTEGER),
        @Result(column="atype_id", property="atypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="hot", property="hot", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="alerttime", property="alerttime", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="param1", jdbcType=JdbcType.VARCHAR),
        @Result(column="url1", property="param2", jdbcType=JdbcType.VARCHAR),
        @Result(column="param3", property="param3", jdbcType=JdbcType.VARCHAR),
        @Result(column="param4", property="param4", jdbcType=JdbcType.VARCHAR),
        @Result(column="param5", property="param5", jdbcType=JdbcType.VARCHAR)
    })
    List<Alert> selectByExamplePage(@Param("key")String key,@Param("type")int type);

    
    @SelectProvider(type=DynamicSql.class,method="getSql")
    int countByDynamicSQL(String key);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, title, desc1, url, res_link_id, res_id, atype_id, hot, createtime, img, ",
        "alerttime, param1, param2, param3, param4, param5, CAST(content AS CHAR CHARACTER SET utf8) AS content",
        "from alert ",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc1", property="desc1", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_link_id", property="resLinkId", jdbcType=JdbcType.INTEGER),
        @Result(column="res_id", property="resId", jdbcType=JdbcType.INTEGER),
        @Result(column="atype_id", property="atypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="hot", property="hot", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="alerttime", property="alerttime", jdbcType=JdbcType.VARCHAR),
        @Result(column="param1", property="param1", jdbcType=JdbcType.VARCHAR),
        @Result(column="param2", property="param2", jdbcType=JdbcType.VARCHAR),
        @Result(column="param3", property="param3", jdbcType=JdbcType.VARCHAR),
        @Result(column="param4", property="param4", jdbcType=JdbcType.VARCHAR),
        @Result(column="param5", property="param5", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="res_link_id",property="csss",javaType=List.class,many=@Many(select="selectByReslinId"))
    })
    
    Alert selectByPrimaryKey(Integer id);
    
    @Select("select csslink from css where res_link_id=#{id}")
    @Results({
    	@Result(column="csslink",property="csslink",jdbcType=JdbcType.VARCHAR)
    })
    List<Css> selectByReslinId(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @UpdateProvider(type=AlertSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Alert record, @Param("example") AlertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @UpdateProvider(type=AlertSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Alert record, @Param("example") AlertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @UpdateProvider(type=AlertSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Alert record, @Param("example") AlertCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @UpdateProvider(type=AlertSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Alert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @Update({
        "update alert",
        "set title = #{title,jdbcType=VARCHAR},",
          "desc1 = #{desc1,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "res_link_id = #{resLinkId,jdbcType=INTEGER},",
          "res_id = #{resId,jdbcType=INTEGER},",
          "atype_id = #{atypeId,jdbcType=INTEGER},",
          "hot = #{hot,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "img = #{img,jdbcType=VARCHAR},",
          "alerttime = #{alerttime,jdbcType=VARCHAR},",
          "param1 = #{param1,jdbcType=VARCHAR},",
          "param2 = #{param2,jdbcType=VARCHAR},",
          "param3 = #{param3,jdbcType=VARCHAR},",
          "param4 = #{param4,jdbcType=VARCHAR},",
          "param5 = #{param5,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Alert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alert
     *
     * @mbggenerated
     */
    @Update({
        "update alert",
        "set title = #{title,jdbcType=VARCHAR},",
          "desc1 = #{desc1,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "res_link_id = #{resLinkId,jdbcType=INTEGER},",
          "res_id = #{resId,jdbcType=INTEGER},",
          "atype_id = #{atypeId,jdbcType=INTEGER},",
          "hot = #{hot,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "img = #{img,jdbcType=VARCHAR},",
          "alerttime = #{alerttime,jdbcType=VARCHAR},",
          "param1 = #{param1,jdbcType=VARCHAR},",
          "param2 = #{param2,jdbcType=VARCHAR},",
          "param3 = #{param3,jdbcType=VARCHAR},",
          "param4 = #{param4,jdbcType=VARCHAR},",
          "param5 = #{param5,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Alert record);
    
    
    @Update({
        "update alert",
        "set title = #{title,jdbcType=VARCHAR},",
          "desc1 = #{desc1,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "res_link_id = #{resLinkId,jdbcType=INTEGER},",
          "res_id = #{resId,jdbcType=INTEGER},",
          "atype_id = #{atypeId,jdbcType=INTEGER},",
          "img = #{img,jdbcType=VARCHAR}, ",
          "content = #{content,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int update(Alert record);
    
    @Select({"call alertPro(#{title,jdbcType=VARCHAR},#{desc1,jdbcType=VARCHAR},#{content,jdbcType=VARCHAR},",
    		"#{url,jdbcType=VARCHAR},#{resLinkId,jdbcType=INTEGER},#{resId,jdbcType=INTEGER},",
    		"#{atypeId,jdbcType=INTEGER},#{img,jdbcType=VARCHAR},#{alerttime,jdbcType=VARCHAR})"})
    String insertByProcedure(Alert alert);
}