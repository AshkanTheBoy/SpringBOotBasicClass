package org.AshInc.firm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.AshInc.model.ModelCar;
import org.AshInc.model.ModelJson;
import org.AshInc.model.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FirmService {
    @Autowired
    private FirmRepository firmRepository;

    @Autowired
    private ModelRepository modelRepository;

    List<Firm> findAll() {
        return firmRepository.findAll();
    }

    Set<ModelCar> findModels(Long id) {
        Firm firm = firmRepository.findById(id).orElse(null);
        if (firm != null)
            return firm.getModels();
        else return null;
    }

    public void saveFirms() {
        ObjectMapper mapper = new ObjectMapper();
        FirmJson[] firms = null;
        try {
            firms = mapper.readValue(new File("C:\\Users\\gk\\Documents\\SpringbootBasic\\Spring-cars\\src\\main\\resources\\cars.JSON"), FirmJson[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.stream(firms)
                .forEach(firm -> {
                    Set<ModelJson> modelsJson = new HashSet<>(firm.getModels());
                    Set<ModelCar> models = new HashSet<>();
                    modelsJson.stream()
                            .forEach(model -> {
                                ModelCar modelNew = ModelCar.builder()
                                .idSymbol(model.getIdSymbol())
                                .name(model.getName())
                                .cyrillicName(model.getCyrillicName())
                                .className(model.getClassName())
                                .yearFrom(model.getYearFrom())
                                .yearTo(model.getYearTo())
                                .build();
                                modelRepository.save(modelNew);
                                models.add(modelNew);
                            });
                    Firm firmNew = Firm.builder()
                            .idSymbol(firm.getIdSymbol())
                            .name(firm.getName())
                            .cyrillicName(firm.getCyrillicName())
                            .popular(firm.isPopular())
                            .country(firm.getCountry())
                            .models(models)
                            .build();
                    firmRepository.save(firmNew);
                });
    }
} 