package com.kodelabs.boilerplate.presentation.presenters.impl;

import android.util.Log;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.GetMessageByIdInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.GetMessageByIdInteractorImpl;
import com.kodelabs.boilerplate.domain.model.Message;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.base.AbstractPresenter;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        GetMessageByIdInteractor.Callback {
    public static final String LOG_TAG = MainPresenterImpl.class.getSimpleName();

    private MainPresenter.View mView;
    private MessageRepository mMessageRepository;

    public MainPresenterImpl(Executor executor,
                             MainThread mainThread,
                             View view,
                             MessageRepository messageRepository) {
        super(executor, mainThread);
        mView = view;
        mMessageRepository = messageRepository;
    }

    @Override
    public void resume() {
        Log.d(LOG_TAG, "resume()");
    }

    @Override
    public void pause() {
        Log.d(LOG_TAG, "pause()");

    }

    @Override
    public void stop() {
        Log.d(LOG_TAG, "stop()");

    }

    @Override
    public void destroy() {
        Log.d(LOG_TAG, "destroy()");

    }

    @Override
    public void onError(String message) {
        mView.showError(message);
    }

    @Override
    public void findMessage(long messageId) {
        Log.d(LOG_TAG, "findMessage() : " + messageId);
        // Use interactors to access inner/core layer
        GetMessageByIdInteractor getMessageByIdInteractor = new GetMessageByIdInteractorImpl(
                mExecutor, mMainThread, messageId, mMessageRepository, this);
        getMessageByIdInteractor.execute();
    }

    @Override
    public void onMessageRetrieved(Message message) {
        mView.showMessage(message);
    }

    @Override
    public void noMessageFound() {
        mView.showError("No Message found :(");
    }
}
