package com.nfinity.demo.petsdemotest.emailbuilder.restcontrollers;

import java.io.IOException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nfinity.demo.petsdemotest.commons.search.SearchCriteria;
import com.nfinity.demo.petsdemotest.commons.search.SearchUtils;
import com.nfinity.demo.petsdemotest.commons.application.OffsetBasedPageRequest;
import com.nfinity.demo.petsdemotest.emailbuilder.application.emailtemplate.EmailTemplateAppService;
import com.nfinity.demo.petsdemotest.emailbuilder.application.emailtemplate.dto.*;
import com.nfinity.demo.petsdemotest.emailbuilder.application.mail.EmailService;
import com.nfinity.demo.petsdemotest.commons.logging.LoggingHelper;
import com.nfinity.demo.petsdemotest.commons.domain.EmptyJsonResponse;

@RestController
@RequestMapping("/email")
public class EmailTemplateController {

	@Autowired
    private EmailTemplateAppService emailTemplateAppService;

	@Autowired
	private LoggingHelper logHelper;

	@Autowired
    private Environment env;
	    
	@Autowired
	private EmailService emailService;

	@PreAuthorize("hasAnyAuthority('EMAILENTITY_CREATE')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CreateEmailTemplateOutput> create(@RequestBody @Valid CreateEmailTemplateInput email) throws IOException {
		FindEmailTemplateByNameOutput foundEmail = emailTemplateAppService.findByName(email.getTemplateName());

		if (foundEmail != null) {
			logHelper.getLogger().error("There already exists a email with a name=%s", email.getTemplateName());
			throw new EntityExistsException(
				String.format("There already exists a user with email address=%s", email.getTemplateName()));
		}
		if(email.getContentJson() != null) {
	       String html= emailTemplateAppService.convertJsonToHtml(email.getContentJson());
		   email.setContentHtml(html);
		   //emailService.sendSimpleMessage(email.getTo(), email.getSubject(),html);
			
		}
	        return new ResponseEntity(emailTemplateAppService.create(email), HttpStatus.CREATED);
	    }

	    // ------------ Delete an email ------------
	@PreAuthorize("hasAnyAuthority('EMAILENTITY_DELETE')")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		FindEmailTemplateByIdOutput eo = emailTemplateAppService.findById(Long.valueOf(id));

		if (eo == null) {
		    logHelper.getLogger().error("There does not exist a email wth a id=%s", id);
			throw new EntityNotFoundException(
				String.format("There does not exist a email wth a id=%s", id));
			}
	        emailTemplateAppService.delete(Long.valueOf(id));
	    }
	    // ------------ Update an email ------------

	@PreAuthorize("hasAnyAuthority('EMAILENTITY_UPDATE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UpdateEmailTemplateOutput> update(@PathVariable String id, @RequestBody @Valid UpdateEmailTemplateInput email) {
		FindEmailTemplateByIdOutput currentEmail = emailTemplateAppService.findById(Long.valueOf(id));
	    if (currentEmail == null) {
	       logHelper.getLogger().error("Unable to update. Email with id {} not found.", id);
	       return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.NOT_FOUND);
	    }
	      return new ResponseEntity(emailTemplateAppService.update(Long.valueOf(id), email), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyAuthority('EMAILENTITY_READ')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FindEmailTemplateByIdOutput> findById(@PathVariable String id) {

		FindEmailTemplateByIdOutput eo = emailTemplateAppService.findById(Long.valueOf(id));

	    if (eo == null) {
	       return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.NOT_FOUND);
	    }
	      return new ResponseEntity(eo, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyAuthority('EMAILENTITY_READ')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity find(@RequestParam(value = "search", required=false) String search,@RequestParam(value = "offset", required=false) String offset, @RequestParam(value = "limit", required=false) String limit, Sort sort) throws Exception {
	   if (offset == null) { offset = env.getProperty("fastCode.offset.default"); }
	   if (limit == null) { limit = env.getProperty("fastCode.limit.default"); }
	      //if (sort.isUnsorted()) { sort = new Sort(Sort.Direction.fromString(env.getProperty("fastCode.sort.direction.default")), new String[]{env.getProperty("fastCode.sort.property.default")}); }

	      Pageable Pageable = new OffsetBasedPageRequest(Integer.parseInt(offset), Integer.parseInt(limit), sort);
	      SearchCriteria searchCriteria = SearchUtils.generateSearchCriteriaObject(search);
	      
	  	  return ResponseEntity.ok(emailTemplateAppService.find(searchCriteria,Pageable));
	  }
	
	
}
