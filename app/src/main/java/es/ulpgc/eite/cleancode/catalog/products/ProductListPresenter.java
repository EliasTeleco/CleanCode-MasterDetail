package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.ProductDosItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;


public class ProductListPresenter implements ProductListContract.Presenter {

  public static String TAG = ProductListPresenter.class.getSimpleName();

  private WeakReference<ProductListContract.View> view;
  private ProductListState state;
  private ProductListContract.Model model;
  //private ProductListContract.Router router;
  private CatalogMediator mediator;


  public ProductListPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getProductListState();
  }

//  public ProductListPresenter(ProductListState state) {
//    this.state = state;
//  }

  @Override
  public void injectView(WeakReference<ProductListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductListContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(ProductListContract.Router router) {
//    this.router = router;
//  }

  private void passDataToProductDetailScreen(ProductItem item) {
    mediator.setProduct(item);
  }

  @Override
  public void fetchProductListData() {
     Log.e(TAG, "fetchProductListData()");

    // call the model
    ProductDosItem productDos = getDataFromProductDos();
    Log.e(TAG, productDos.id + "");
    state.products = model.fetchProductListData();



    view.get().displayProductListData(state);

  }

  private ProductDosItem getDataFromProductDos() {
  ProductDosItem product = mediator.getProductDos();
    return product;
  }


  @Override
  public void selectProductListData(ProductItem item) {
    //router.passDataToProductDetailScreen(item);
    passDataToProductDetailScreen(item);
    //router.navigateToProductDetailScreen();
    view.get().navigateToProductDetailScreen();
  }

  @Override
  public String devolverProducto() {
    return model.devolverProducto();
  }


}
