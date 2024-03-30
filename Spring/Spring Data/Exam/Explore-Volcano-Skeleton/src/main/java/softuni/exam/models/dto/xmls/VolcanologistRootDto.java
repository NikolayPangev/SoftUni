package softuni.exam.models.dto.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "volcanologists")
@XmlAccessorType(XmlAccessType.FIELD)
public class VolcanologistRootDto implements Serializable {

    @XmlElement(name = "volcanologist")
    private List<VolcanologistSeedDto> volcanologistSeedDtos;

    public List<VolcanologistSeedDto> getVolcanologistSeedDtos() {
        return volcanologistSeedDtos;
    }

    public void setVolcanologistSeedDtos(List<VolcanologistSeedDto> volcanologistSeedDtos) {
        this.volcanologistSeedDtos = volcanologistSeedDtos;
    }
}
