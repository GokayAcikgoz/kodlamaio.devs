package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("api/programmingLanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	
	@GetMapping("/getAll")
	public List<GetAllProgrammingLanguageResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public GetByIdProgrammingLanguageResponse getById(int id){
		return programmingLanguageService.getById(id);
	}
	
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }
}
