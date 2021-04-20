package es.ulpgc.eite.cleancode.catalog.productoDos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.ProductDosItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;

public class ProductDosActivity
        extends AppCompatActivity implements ProductDosContract.View {

    public static String TAG = ProductDosActivity.class.getSimpleName();

    private ProductDosContract.Presenter presenter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productodos_list);
        //Log.e(TAG,"LLEGO");



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.productoDos_title));
        }

        listView = findViewById(R.id.product_list);

    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */

        // do the setup
        ProductDosScreen.configure(this);

        // do some work
        presenter.fetchProductDosData();
    }



    @Override
    public void onDataUpdated(ProductDosViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        listView.setAdapter(new ProductDosAdapter(
                        this, viewModel.productDos, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        ProductDosItem item = (ProductDosItem) view.getTag();
                        presenter.selectProductListData(item);
                    }
                })
        );
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(ProductDosContract.Presenter presenter) {
        this.presenter = presenter;
    }
}