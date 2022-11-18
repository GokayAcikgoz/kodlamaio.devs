package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concreates.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<GetAllProgrammingLanguageResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {

			GetAllProgrammingLanguageResponse programmingLanguageItem = new GetAllProgrammingLanguageResponse();

			programmingLanguageItem.setId(programmingLanguage.getId());
			programmingLanguageItem.setName(programmingLanguage.getName());
			
			programmingLanguageResponses.add(programmingLanguageItem);
		}
		return programmingLanguageResponses;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {

		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();

		GetByIdProgrammingLanguageResponse programmingLanguageResponse = new GetByIdProgrammingLanguageResponse();
		
		programmingLanguageResponse.setName(programmingLanguage.getName());

		return programmingLanguageResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (createProgrammingLanguageRequest.getName().equals(programmingLanguage.getName())) {
				System.out.println(createProgrammingLanguageRequest.getName() + " Bu programlama dili zaten mevcut.");
				return;
			}
		}

		if (createProgrammingLanguageRequest.getName().equals("")) {
			System.out.println("Programlama dili boş geçilemez!");
		}

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());

		this.programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

		programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		
		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());

	}

}
