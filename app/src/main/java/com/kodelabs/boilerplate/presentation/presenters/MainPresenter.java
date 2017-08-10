package com.kodelabs.boilerplate.presentation.presenters;

import com.kodelabs.boilerplate.domain.model.Message;
import com.kodelabs.boilerplate.presentation.presenters.base.BasePresenter;
import com.kodelabs.boilerplate.presentation.ui.BaseView;


public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        // TODO: Add your view methods
        // use model from Domain layer
        void showMessage(Message message);
    }

    // TODO: Add your presenter methods
    void findMessage(long messageId);

}
