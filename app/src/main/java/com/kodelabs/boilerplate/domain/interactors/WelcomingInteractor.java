package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;

public interface WelcomingInteractor extends Interactor {
    /**
     * Responsible for talking to the UI on the <strong>main</strong> thread.
     */
    interface Callback {
        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);
    }

}
