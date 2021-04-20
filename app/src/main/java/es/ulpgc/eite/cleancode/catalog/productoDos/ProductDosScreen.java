package es.ulpgc.eite.cleancode.catalog.productoDos;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;

public class ProductDosScreen {

    public static void configure(ProductDosContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);



        CatalogMediator mediator = CatalogMediator.getInstance();



        ProductDosContract.Presenter presenter = new ProductDosPresenter(mediator);
        ProductDosContract.Model model = new ProductDosModel();
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}