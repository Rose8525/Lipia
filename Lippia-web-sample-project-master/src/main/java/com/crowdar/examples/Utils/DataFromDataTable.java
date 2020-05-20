package com.crowdar.examples.Utils;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;

public class DataFromDataTable {

    public static List<DataPayment> GetFromDataTable(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        List<DataPayment> dataPaymentList = new ArrayList<DataPayment>();

        for (int i = 1; i < data.size(); i++) {

            DataPayment dataPayment = new DataPayment();
            dataPayment.setCardNumber(data.get(i).get(0));
            dataPayment.setCardHolderName(data.get(i).get(1));
            dataPayment.setExpiryDateMonth(data.get(i).get(2));
            dataPayment.setExpiryDateYear(data.get(i).get(3));
            dataPayment.setSeriesCode(data.get(i).get(4));

            dataPaymentList.add(dataPayment);
        }
        return dataPaymentList;

    }

}
