package es.ulpgc.eite.cleancode.catalog.productoDos;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.ProductDosItem;

public class ProductDosPresenter implements ProductDosContract.Presenter {

    public static String TAG = ProductDosPresenter.class.getSimpleName();

    private WeakReference<ProductDosContract.View> view;
    private ProductDosState state;
    private ProductDosContract.Model model;
    private CatalogMediator mediator;

    public ProductDosPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getProductDosState();
    }





    @Override
    public void fetchProductDosData() {
        state.productDos =  model.fetchProductListData();

        view.get().onDataUpdated(state);

    }

    @Override
    public void selectProductListData(ProductDosItem item) {
        passDataToNextScreen(item);
        view.get().navigateToNextScreen();
    }



    private void passDataToNextScreen(ProductDosItem item) {
        
        mediator.setProductDos(item);
    }


    @Override
    public void injectView(WeakReference<ProductDosContract.View> view) {
        this.view = view;

    }

    @Override
    public void injectModel(ProductDosContract.Model model) {
        this.model = model;

    }


}