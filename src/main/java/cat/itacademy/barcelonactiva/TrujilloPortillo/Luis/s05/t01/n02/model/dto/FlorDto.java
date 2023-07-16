package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n02.model.dto;

import java.util.*;

public class FlorDto {


    private Integer pk_FlorId;


    private String nombreFlor;


    private  String paisFlor;

    private String tipoFlor;

    List<String> paisesUE = Arrays.asList(
            "Austria", "Bélgica", "Bulgaria", "Chipre", "Croacia",
            "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia",
            "Finlandia", "Francia", "Grecia", "Hungría", "Irlanda",
            "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta",
            "Holanda", "Polonia", "Portugal", "Rumania", "Suecia"
    );

    public FlorDto(){}

    public FlorDto(String nombreFlor, String paisFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
        tipoFlor = determinarTipoFlor(paisFlor);
    }

    public String getNombreFlor() {
        return nombreFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public String getTipoFlor() {
        return tipoFlor;
    }

    private String determinarTipoFlor(String pais) {
        if (paisesUE.contains(pais)) {
            return "UE";
        } else {
            return "Fuera UE";
        }
    }

}
