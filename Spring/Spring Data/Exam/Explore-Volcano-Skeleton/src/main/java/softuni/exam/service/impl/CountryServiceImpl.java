package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.jsons.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importCountries() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        CountrySeedDto[] countrySeedDtos = this.gson.fromJson(
                new FileReader(FILE_PATH), CountrySeedDto[].class);

        for (CountrySeedDto countrySeedDto : countrySeedDtos) {
            Optional<Country> optionalCountry = this.countryRepository.findByName(countrySeedDto.getName());

            if (!this.validationUtil.isValid(countrySeedDto) || optionalCountry.isPresent()) {
                stringBuilder.append("Invalid country\n");
                continue;
            }

            Country country = this.modelMapper.map(countrySeedDto, Country.class);
            this.countryRepository.saveAndFlush(country);
            stringBuilder.append(String.format("Successfully imported country %s - %s\n", country.getName(), country.getCapital()));
        }

        return stringBuilder.toString();
    }

    @Override
    public Optional<Country> getCountryById(Long countryId) {
        return Optional.empty();
    }

    @Override
    public void saveAddedVolcanoInCountry(Country country) {

    }
}
