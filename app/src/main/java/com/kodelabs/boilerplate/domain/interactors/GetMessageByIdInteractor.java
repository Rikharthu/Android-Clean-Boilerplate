package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;
import com.kodelabs.boilerplate.domain.model.Message;


public interface GetMessageByIdInteractor extends Interactor {

    interface Callback {

        void onMessageRetrieved(Message message);

        void noMessageFound();
    }
}
