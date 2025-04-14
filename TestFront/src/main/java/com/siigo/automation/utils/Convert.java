package com.siigo.automation.utils;

import io.cucumber.datatable.DataTable;

import java.util.Map;

public class Convert {

    public static Map<String, String> mapOf(DataTable dataTable) {
        return dataTable.transpose().asMap();
    }

    public static Integer intOfType(String value) {
        return switch (value) {
            case "Es persona" -> 1;
            case "Empresa" -> 2;
            default -> 0;
        };
    }

    public static String document(String value) {
        int randomInt = (int) (Math.random() * 10000);
        return value + randomInt;
    }

    public static Integer intOfIVA(String value) {
        return switch (value) {
            case "No responsable de IVA" -> 2;
            case "Responsable de IVA" -> 3;
            default -> 0;
        };
    }

    public static Integer intOfTypeDocument(String value) {
        return switch (value) {
            case "Registro civil" -> 1;
            case "Tarjeta de identidad" -> 2;
            case "Cédula de ciudadanía" -> 3;
            case "Tarjeta de extranjería" -> 4;
            case "Cédula de extranjería" -> 5;
            case "NIT" -> 6;
            case "Pasaporte" -> 7;
            case "Documento de identificación extranjero" -> 8;
            case "NUIP" -> 9;
            case "Permiso especial de permanencia PEP" -> 10;
            case "Sin identificación del exterior o para uso definido por la DIAN" -> 11;
            case "Nit de otro país / Sin identificación del exterior (43 medios magnéticos)" -> 12;
            case "Salvoconducto de permanencia" -> 13;
            case "Permiso protección temporal PPT" -> 14;
            case "No obligado a registrarse en el RUT PN" -> 15;

            default -> 0;
        };
    }
}
