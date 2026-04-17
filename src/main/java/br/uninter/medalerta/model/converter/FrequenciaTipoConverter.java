package br.uninter.medalerta.model.converter;

import br.uninter.medalerta.model.FrequenciaTipo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FrequenciaTipoConverter implements AttributeConverter<FrequenciaTipo, String> {

    @Override
    public String convertToDatabaseColumn(FrequenciaTipo attribute) {
        if (attribute == null) return null;
        return switch (attribute) {
            case HORAS -> "horas";
            case DIAS -> "dias";
            case SEMANAS -> "semanas";
            case DOSE_UNICA -> "dose única";
        };
    }

    @Override
    public FrequenciaTipo convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return switch (dbData) {
            case "horas" -> FrequenciaTipo.HORAS;
            case "dias" -> FrequenciaTipo.DIAS;
            case "semanas" -> FrequenciaTipo.SEMANAS;
            case "dose única" -> FrequenciaTipo.DOSE_UNICA;
            default -> throw new IllegalArgumentException("Valor desconhecido para FrequenciaTipo: " + dbData);
        };
    }
}
