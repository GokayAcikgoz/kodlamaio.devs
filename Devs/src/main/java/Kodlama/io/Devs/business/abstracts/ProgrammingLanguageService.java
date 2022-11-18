package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	
	List<GetAllProgrammingLanguageResponse> getAll();
	GetByIdProgrammingLanguageResponse getById(int id);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);

}
