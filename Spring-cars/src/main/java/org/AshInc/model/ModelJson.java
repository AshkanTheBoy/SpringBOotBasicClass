package org.AshInc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModelJson {
    @JsonProperty("id")
    public String idSymbol;
    public String name;
    @JsonProperty("cyrillic-name")
    public String cyrillicName;
    @JsonProperty("class")
    public String className;
    @JsonProperty("year-from")
    public int yearFrom;
    @JsonProperty("year-to")
    public int yearTo;
}
