package practice.develop.server.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import practice.develop.server.model.dto.InsertRequestBody;
import practice.develop.server.model.dto.InsertResponseBody;
import practice.develop.server.model.dto.SelectRequestBody;
import practice.develop.server.model.dto.SelectResponseBody;

@RestController
@Validated
public class ServerController {

	@Autowired
	private ServiceHelper helper;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InsertResponseBody insert(@RequestBody @Valid InsertRequestBody requestBody) {

		return helper.insert(requestBody);
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public SelectResponseBody select(@RequestBody @Valid SelectRequestBody requestBody) {

		return helper.select(requestBody);
	}
}