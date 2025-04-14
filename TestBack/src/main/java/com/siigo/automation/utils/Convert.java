package com.siigo.automation.utils;

import io.cucumber.datatable.DataTable;

import java.util.Map;

public class Convert {

    public static Map<String, String> mapOf(DataTable dataTable) {
        return dataTable.transpose().asMap();
    }

}
