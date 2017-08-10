package com.kodelabs.boilerplate.domain.interactors.impl;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.GetMessageByIdInteractor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;
import com.kodelabs.boilerplate.domain.model.Message;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;

public class GetMessageByIdInteractorImpl extends AbstractInteractor implements GetMessageByIdInteractor {

    private long mMessageId;
    private MessageRepository mMessageRepository;
    private GetMessageByIdInteractor.Callback mCallback;

    public GetMessageByIdInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                        long messageId, MessageRepository messageRepository,
                                        Callback callback) {
        super(threadExecutor, mainThread);
        mMessageId = messageId;
        mMessageRepository = messageRepository;
        mCallback = callback;
    }


    @Override
    public void run() {
        final Message message = mMessageRepository.get(mMessageId);

        // simulate delay
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (message == null) {
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.noMessageFound();
                }
            });
        } else {
            // found the message

            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onMessageRetrieved(message);
                }
            });
        }
    }
}
