package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concreates.ProgrammingLanguage;
import Kodlama.io.Devs.entities.concreates.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private ProgrammingLanguageService programmingLanguageService;
	private TechnologyRepository technologyRepository;

	public TechnologyManager(ProgrammingLanguageService programmingLanguageService,
			TechnologyRepository technologyRepository) {
		super();
		this.programmingLanguageService = programmingLanguageService;
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {

		List<Technology> technologies = technologyRepository.findAll();

		List<GetAllTechnologyResponse> getAllTechnologyResponses = new ArrayList<GetAllTechnologyResponse>();

		for (Technology technology : technologies) {
			GetAllTechnologyResponse technologyItem = new GetAllTechnologyResponse();

			technologyItem.setName(technology.getName());

			getAllTechnologyResponses.add(technologyItem);
		}

		return getAllTechnologyResponses;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {

		Technology technology = technologyRepository.findById(id).get();
		GetByIdTechnologyResponse technologyItem = new GetByIdTechnologyResponse();

		technologyItem.setId(technology.getId());
		technologyItem.setName(technology.getName());

		return technologyItem;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {

		Technology technology = new Technology();
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = programmingLanguageService
				.getById(createTechnologyRequest.getProgrammingLanguageId());
		programmingLanguage.setId(getByIdProgrammingLanguageResponse.getId());
		programmingLanguage.setName(getByIdProgrammingLanguageResponse.getName());

		technology.setName(createTechnologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguage);

		technologyRepository.save(technology);

	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {

		Technology technology = new Technology();
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = programmingLanguageService
				.getById(updateTechnologyRequest.getProgrammingLanguageId());
		programmingLanguage.setId(getByIdProgrammingLanguageResponse.getId());
		programmingLanguage.setName(getByIdProgrammingLanguageResponse.getName());

		technology.setName(updateTechnologyRequest.getName());
		technology.setId(updateTechnologyRequest.getId());
		technology.setProgrammingLanguage(programmingLanguage);

		technologyRepository.save(technology);

	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {

		technologyRepository.deleteById(deleteTechnologyRequest.getId());

	}

}
