package com.kodelabs.boilerplate.domain.interactors.impl;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.WelcomingInteractor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;

// Extends the AbstractInteractor since it takes care of running on the background thread
public class WelcomingInteractorImpl extends AbstractInteractor implements WelcomingInteractor {

    private MessageRepository mMessageRepository;
    private Callback mCallback;

    public WelcomingInteractorImpl(Executor threadExecutor, MainThread mainThread) {
        super(threadExecutor, mainThread);
    }

    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                // Use callbacks to post to the UI on the Main thread
                mCallback.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    private void postMessage(final String msg) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onMessageRetrieved(msg);
            }

        });

    }

    // actual interactor logic
    @Override
    public void run() {
        // retrieve the message
//        final String message = mMessageRepository.get(1);
    }
}
