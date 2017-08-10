package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.executor.impl.ThreadExecutor;
import com.kodelabs.boilerplate.domain.model.Message;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.impl.MainPresenterImpl;
import com.kodelabs.boilerplate.storage.MessageRepositoryImpl;
import com.kodelabs.boilerplate.threading.MainThreadImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.message_id_et)
    EditText mMessageIdEt;
    @BindView(R.id.message_id_tv)
    TextView mMessageIdTv;
    @BindView(R.id.message_recipient_tv)
    TextView mMessageRecipientTv;
    @BindView(R.id.message_title_tv)
    TextView mMessageTitleTv;
    @BindView(R.id.message_text_tv)
    TextView mMessageTextTv;
    @BindView(R.id.message_sender_tv)
    TextView mMessageSenderTv;
    @BindView(R.id.message_date_tv)
    TextView mMessageDateTv;

    private MainPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        init();
    }

    private void init() {
        mPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new MessageRepositoryImpl(this)
        );
    }

    // Override lifecycle methods to notify the presenter
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public void showProgress() {
        Timber.d("Showing progress");
    }

    @Override
    public void hideProgress() {
        Timber.d("Hiding progress");

    }

    @Override
    public void showError(String message) {
        Timber.d("Showing error: " + message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(Message message) {
        // TODO replace with ViewModel
        mMessageIdTv.setText("#" + message.getId() + "");
        mMessageRecipientTv.setText("To: " + message.getRecipient());
        mMessageTitleTv.setText(message.getTitle());
        mMessageTextTv.setText("\t" + message.getText());
        mMessageSenderTv.setText("From: " + message.getSender());
        mMessageDateTv.setText("Received at: " + message.getDate().toString());
    }

    public void onFindMessageByIdButtonClicked(View view) {
        long id = Long.parseLong(mMessageIdEt.getText().toString());
        Log.d(LOG_TAG, "onFindMessageByIdButtonClicjed() : " + id);
        mPresenter.findMessage(id);
    }
}
