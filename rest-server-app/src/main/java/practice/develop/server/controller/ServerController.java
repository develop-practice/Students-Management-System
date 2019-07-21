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

import practice.develop.server.model.dto.SampleRequestBody;
import practice.develop.server.model.dto.SampleResponseBody;

@RestController
@Validated
public class ServerController {

	@Autowired
	private ServiceHelper helper;

	@RequestMapping(value = "/post-server", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public SampleResponseBody post(@RequestBody @Valid SampleRequestBody requestBody) {

		return helper.insert(requestBody);
	}
}