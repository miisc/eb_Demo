package com.demo.eb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.demo.eb.entity.Document;
import com.demo.eb.entity.Item;
import com.demo.eb.entity.ItemAttribute;

@Mapper
public interface ItemDAO {

	// public Item findItemByUID(@Param("taggeditemUID") String taggeditemUID);

	public Item findItemByID(@Param("taggeditemID") String taggeditemID);

	public Item findParentItemByID(@Param("taggeditemID") String taggeditemID);

	public List<Item> findChildItemByID(@Param("taggeditemID") String taggeditemID);

	public List<Item> findConnectFromItemByID(@Param("taggeditemID") String taggeditemID);

	public List<Item> findConnectToItemByID(@Param("taggeditemID") String taggeditemID);

	public List<Document> findDocumentByItemID(@Param("taggeditemID") String taggeditemID);
	
	public Document findDocumentByID(@Param("docID") String docID);

	public List<ItemAttribute> findAttributeByItemID(@Param("taggeditemID") String taggeditemID);

	public Item findItemDetailsByID(@Param("taggeditemID") String taggeditemID);

	// @Select("select * from itemDetails where itemName like concat('%',
	// #{name},'%')")
	public List<Item> findItemByName(@Param("name") String name);

	public List<Item> findItemByKeyword(@Param("kword") String kword);

	public List<Item> searchByKword(@Param("kword") String kword, @Param("searchType") String searchType,
			@Param("IDOnly") boolean IDOnly, @Param("matchWholeWord") boolean matchWholeWord);

	public List<Item> searchItemIDByKword(@Param("kword") String kword, @Param("searchType") String searchType,
			@Param("matchWholeWord") boolean matchWholeWord);

	public List<Item> searchItemClassByKword(@Param("kword") String kword, @Param("searchType") String searchType,
			@Param("matchWholeWord") boolean matchWholeWord);

	public List<Item> searchItemNameByKword(@Param("kword") String kword, @Param("searchType") String searchType,
			@Param("matchWholeWord") boolean matchWholeWord);

	public List<Document> searchDocIDByKword(@Param("kword") String kword, @Param("matchWholeWord") boolean matchWholeWord);

	public List<Document> searchDocClassByKword(@Param("kword") String kword,
			@Param("matchWholeWord") boolean matchWholeWord);

	public List<Document> searchDocNameByKword(@Param("kword") String kword,
			@Param("matchWholeWord") boolean matchWholeWord);
}
