package app.dto;

import org.modelmapper.ModelMapper;


public class Konverzija {
	private static final ModelMapper modelMapper = new ModelMapper();
	
    public static <T, D> D konvertujUDTO(T entitet, Class<D> dtoClass) {
        return modelMapper.map(entitet, dtoClass);
    }

    public static <T, D> T konvertujUEntitet(D dto, Class<T> entitetClass) {
        return modelMapper.map(dto, entitetClass);
    }
	
	
}
