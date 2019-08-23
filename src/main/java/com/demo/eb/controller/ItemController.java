package com.demo.eb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.eb.dao.ItemDAO;
import com.demo.eb.entity.Document;
import com.demo.eb.entity.Item;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller

public class ItemController {

	private static final Logger log = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	ItemDAO itemDao;

	@GetMapping(value = "/findItemByID/{taggeditemID}")
	// @ResponseBody
	public String findItemByID(@PathVariable String taggeditemID, ModelMap model) throws JsonProcessingException {
		Item item = itemDao.findItemByID(taggeditemID);
		if (item == null)
			log.debug("no result found");
		model.addAttribute("item", item);
		return "item";
	}

	@GetMapping(value = "/findParentItemByID/{taggeditemID}")
	// @ResponseBody
	public String findParentItemByID(@PathVariable String taggeditemID, ModelMap model) throws JsonProcessingException {
		Item item = itemDao.findParentItemByID(taggeditemID);
		if (item == null)
			log.debug("no result found");
		model.addAttribute("item", item);
		return "item";
	}

	@GetMapping(value = "/findChildItemByID/{taggeditemUID}")
	@ResponseBody
	public String findChildItemByID(@PathVariable String taggeditemUID, ModelMap model) throws JsonProcessingException {
		List<Item> item = itemDao.findChildItemByID(taggeditemUID);

		if (item == null)
			log.debug("no result found");

		return item.toString();
	}

	@GetMapping(value = "/findConnectFromItemByID/{taggeditemUID}")
	@ResponseBody
	public List<Item> findConnectFromItemByID(@PathVariable String taggeditemUID, ModelMap model) {
		List<Item> item = itemDao.findConnectFromItemByID(taggeditemUID);
		model.addAttribute("item", item.get(0));
		return item;
	}

	@GetMapping(value = "/findConnectToItemByID/{taggeditemUID}")
	@ResponseBody
	public String findConnectToItemByID(@PathVariable String taggeditemUID, ModelMap model)
			throws JsonProcessingException {
		List<Item> item = itemDao.findConnectToItemByID(taggeditemUID);
		if (item == null)
			log.debug("no result found");
		return item.toString();
	}

	@GetMapping(value = "/findItemDetailsByID/{taggeditemID}")
	// @ResponseBody
	public String findItemDetailsByID(@PathVariable String taggeditemID, ModelMap model)
			throws JsonProcessingException {
		Item item = itemDao.findItemDetailsByID(taggeditemID);
		if (item == null)
			log.debug("no result found");
		model.addAttribute("item", item);
		return "item";
	}

	@GetMapping(value = "/findItemByName/{name}")
	@ResponseBody
	public String findItemByName(@PathVariable String name, ModelMap model) {
		List<Item> items = itemDao.findItemByName(name);
		if (items == null || items.size() == 0)
			log.debug("no result found");
		else {
			log.info("" + items.size());
			model.addAttribute("items", items);
			for (Item item : items) {
				log.info(item.getName());
			}
		}
		return "";
	}

	@GetMapping(value = "/searchKeyword")
	// @ResponseBody
	public String search(@RequestParam String kword, @RequestParam(defaultValue = "all") String searchType,
			@RequestParam(defaultValue = "false") boolean IDOnly,
			@RequestParam(defaultValue = "false") boolean matchWholeWord, ModelMap model) {

		int recordCount = 0;
		if (IDOnly == true) {
			if (searchType.equals("document")) {
				List<Document> t = itemDao.searchDocIDByKword(kword, matchWholeWord);
				model.addAttribute("docID", t);
				recordCount += t.size();
			} else if (searchType.equals("all")) {
				List<Document> t = itemDao.searchDocIDByKword(kword, matchWholeWord);
				model.addAttribute("docID", t);
				recordCount += t.size();

				List<Item> t1 = itemDao.searchItemIDByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemID", t1);
				recordCount += t1.size();
			} else {
				List<Item> t = itemDao.searchItemIDByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemID", t);
				recordCount += t.size();
			}
		} else {
			if (searchType.equals("equipment") || searchType.equals("line")) {
				List<Item> t = itemDao.searchItemIDByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemID", t);
				recordCount += t.size();

				t = itemDao.searchItemClassByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemClass", t);
				recordCount += t.size();

				t = itemDao.searchItemNameByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemName", t);
				recordCount += t.size();
			} else if (searchType.equals("document")) {
				List<Document> t = itemDao.searchDocIDByKword(kword, matchWholeWord);
				model.addAttribute("docID", t);
				recordCount += t.size();

				t = itemDao.searchDocClassByKword(kword, matchWholeWord);
				model.addAttribute("docClass", t);
				recordCount += t.size();

				t = itemDao.searchDocNameByKword(kword, matchWholeWord);
				model.addAttribute("docName", t);
				recordCount += t.size();
			} else if (searchType.equals("all")) {
				List<Document> t = itemDao.searchDocIDByKword(kword, matchWholeWord);
				model.addAttribute("docID", t);
				recordCount += t.size();

				t = itemDao.searchDocClassByKword(kword, matchWholeWord);
				model.addAttribute("docClass", t);
				recordCount += t.size();

				t = itemDao.searchDocNameByKword(kword, matchWholeWord);
				model.addAttribute("docName", t);
				recordCount += t.size();

				List<Item> ti = itemDao.searchItemIDByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemID", ti);
				recordCount += ti.size();

				ti = itemDao.searchItemClassByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemClass", ti);
				recordCount += ti.size();

				ti = itemDao.searchItemNameByKword(kword, searchType, matchWholeWord);
				model.addAttribute("itemName", ti);
				recordCount += ti.size();
			}

		}
		log.debug(" record count = " + recordCount);
		model.addAttribute("recordCount", recordCount);
		return "search";
	}

}
