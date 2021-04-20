package es.ulpgc.eite.cleancode.catalog.app;

import es.ulpgc.eite.cleancode.catalog.product.ProductDetailState;
import es.ulpgc.eite.cleancode.catalog.productoDos.ProductDosState;
import es.ulpgc.eite.cleancode.catalog.products.ProductListState;

public class CatalogMediator {

  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();
  private ProductDosState productDosState = new ProductDosState();
  private ProductDosItem  productDosItem;

  private ProductItem product;


  private static CatalogMediator INSTANCE;

  private CatalogMediator() {

  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static CatalogMediator getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }


  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }
  public ProductDosItem getProductDos() {
    ProductDosItem item = productDosItem;
    //product = null;
    return item;
  }


  public void setProduct(ProductItem item) {
    product = item; }

    public ProductDosState getProductDosState() {

    return productDosState; }

  public void setProductDos(ProductDosItem item) {
    productDosItem = item;  }


}
