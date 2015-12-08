package com.ray.entity.mapper;

import com.ray.entity.Favorites;
import com.ray.entity.FavoritesCriteria;

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

public interface FavoritesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @SelectProvider(type=FavoritesSqlProvider.class, method="countByExample")
    int countByExample(FavoritesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @DeleteProvider(type=FavoritesSqlProvider.class, method="deleteByExample")
    int deleteByExample(FavoritesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @Delete({
        "delete from favorites",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @Insert({
        "insert into favorites (id, openid, ",
        "articleid, createtime)",
        "values (#{id,jdbcType=INTEGER}, #{openid,jdbcType=VARCHAR}, ",
        "#{articleid,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(Favorites record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @InsertProvider(type=FavoritesSqlProvider.class, method="insertSelective")
    int insertSelective(Favorites record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @SelectProvider(type=FavoritesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="articleid", property="articleid", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Favorites> selectByExample(FavoritesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, openid, articleid, createtime",
        "from favorites",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="articleid", property="articleid", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    Favorites selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @UpdateProvider(type=FavoritesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Favorites record, @Param("example") FavoritesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @UpdateProvider(type=FavoritesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Favorites record, @Param("example") FavoritesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @UpdateProvider(type=FavoritesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Favorites record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table favorites
     *
     * @mbggenerated
     */
    @Update({
        "update favorites",
        "set openid = #{openid,jdbcType=VARCHAR},",
          "articleid = #{articleid,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Favorites record);
    
    @Select({
    	"CALL `eyedata`.`add_favorites`(#{openid,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR});"
    })
    void insertFavorites(@Param("openid")String openid,@Param("url")String url);
    
    @SelectProvider(type=DynamicSql.class,method="getSql")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc1", property="desc1", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="param1", property="param1", jdbcType=JdbcType.VARCHAR)
    })
    List<Favorites> findByDynamic();
}