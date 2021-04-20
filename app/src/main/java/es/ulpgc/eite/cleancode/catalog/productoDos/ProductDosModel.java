package es.ulpgc.eite.cleancode.catalog.productoDos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.ProductDosItem;

public class ProductDosModel implements ProductDosContract.Model {

    public static String TAG = ProductDosModel.class.getSimpleName();

    private final List<ProductDosItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    private String data;

    public ProductDosModel() {
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }
    private void addProduct(ProductDosItem item) {
        itemList.add(item);
    }

    private ProductDosItem createProduct(int position) {
        String content = "ProductDos " + position;

        return new ProductDosItem(
                position, content, fetchProductDetails(position)
        );

    }
    @Override
    public List<ProductDosItem> fetchProductListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }

    private String fetchProductDetails(int position) {
        String content = "PRODUCTS:  " + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

        for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        return builder.toString();
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
