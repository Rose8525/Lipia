package com.crowdar.examples.Utils;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;

public class DataSearchFromDataTable {

    public static List<DataSearch> getSearchFromDataTable(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        List<DataSearch> dataSearchList = new ArrayList<DataSearch>();

        for (int i = 1; i < data.size(); i++) {

            DataSearch dataSearch = new DataSearch();
            dataSearch.setPickUp(data.get(i).get(0));
            dataSearch.setDropOff(data.get(i).get(1));
            dataSearch.setDepartDate(data.get(i).get(2));
            dataSearch.setReturnDate(data.get(i).get(3));
            int sise = data.get(i).get(4).trim().length();
            dataSearch.setDepartTime(data.get(i).get(4).trim());

            dataSearchList.add(dataSearch);
        }
        return dataSearchList;
    }

}
