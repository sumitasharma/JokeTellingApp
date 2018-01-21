package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import com.example.sumitasharma.joketellingandroidlibrary.activity.JokeLibraryActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static com.udacity.gradle.builditbigger.MainActivityFragment.JOKES;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Integer, String> {
    private static MyApi myApiService = null;
    private final ProgressBar progressBar;
    private final TextView progressTextView;
    private Context mContext;

    public EndpointsAsyncTask(ProgressBar progressBar, TextView progressTextView) {
        this.progressBar = progressBar;
        this.progressTextView = progressTextView;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        mContext = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        progressBar.setVisibility(View.GONE);
        progressTextView.setVisibility(View.GONE);
        Intent intent = new Intent(mContext, JokeLibraryActivity.class);
        intent.putExtra(JOKES, result);
        mContext.startActivity(intent);
        Log.i("", "joke is : " + result);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressTextView.setText("Running..." + values[0]);
        progressBar.setProgress(values[0]);
    }

}
