package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xmls.VolcanologistRootDto;
import softuni.exam.models.dto.xmls.VolcanologistSeedDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {

    private static final String FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";

    private final VolcanologistRepository volcanologistRepository;
    private final VolcanoRepository volcanoRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, VolcanoRepository volcanoRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.volcanologistRepository = volcanologistRepository;
        this.volcanoRepository = volcanoRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {

        StringBuilder stringBuilder = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(VolcanologistRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        VolcanologistRootDto volcanologistRootDto = (VolcanologistRootDto) unmarshaller.unmarshal(new File(FILE_PATH));

        for (VolcanologistSeedDto volcanologistSeedDto : volcanologistRootDto.getVolcanologistSeedDtos()) {
            Optional<Volcanologist> optionalVolcanologist = this.volcanologistRepository
                    .findByFirstNameAndLastName(volcanologistSeedDto.getFirstName(), volcanologistSeedDto.getLastName());

            Optional<Volcano> optionalVolcano = this.volcanoRepository.findById(volcanologistSeedDto.getVolcano());

            if (!this.validationUtil.isValid(volcanologistSeedDto) || optionalVolcanologist.isPresent() || optionalVolcano.isEmpty()) {
                stringBuilder.append("Invalid volcanologist\n");
                continue;
            }

            Volcanologist volcanologist = this.modelMapper.map(volcanologistSeedDto, Volcanologist.class);
            volcanologist.setVolcano(optionalVolcano.get());
            this.volcanologistRepository.saveAndFlush(volcanologist);

            stringBuilder.append(String.format("Successfully imported volcanologist %s %s\n", volcanologist.getFirstName(), volcanologist.getLastName()));
        }

        return stringBuilder.toString();
    }
}