package com.zhidisoft.blog.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhidisoft.blog.admin.entity.Article;

public interface ArticleMapper {

	@Select("SELECT * FROM article WHERE id = #{id}")
	Article findById(@Param("id") Long id);

	@Delete("delete from article where id = #{id}")
	int deleteById(@Param("id") int id);

	@Select("select * from article limit #{startIndex},#{pageSize}")
	List<Article> pageList(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

	@Select("SELECT count(id) FROM article")
	Long totalCount();
	/*
	 * @Update("update article set username = #{username} where id = #{id}")
	 * public int update(@Param("username") String username, @Param("id") String
	 * id);
	 * 
	 * @Insert("insert into article(username) values(#{username})") public int
	 * save(@Param("username") String username);
	 */

	@Insert("insert into article(id,title,info_title,info,user_id,type_id) values(#{id},#{title},#{infoTitle},#{info},#{userId},#{typeId})")
	public int save(@Param("id") String id
			,@Param("title") String title
			,@Param("infoTitle") String infoTitle
			,@Param("info") String info
			,@Param("userId") String userId
			,@Param("typeId") String typeId);
}
