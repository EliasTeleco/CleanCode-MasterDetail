package es.ulpgc.eite.cleancode.catalog.productoDos;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.ProductDosItem;

public interface ProductDosContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(ProductDosViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);


        void selectProductListData(ProductDosItem item);

        void fetchProductDosData();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        public List<ProductDosItem> fetchProductListData();
    }

}