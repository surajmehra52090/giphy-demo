package xyz.lklinker.giphy_demo.task;

import android.os.AsyncTask;

import java.util.List;

import xyz.lklinker.giphy_api.Gif;
import xyz.lklinker.giphy_api.GiphyApi;

public class GiphyTask extends AsyncTask<Void, Void, List<Gif>> {

    public interface Callback {
        void onResponse(List<Gif> gifs);
    }

    private GiphyApi api;

    private String queryUri;
    private Callback callback;

    public GiphyTask(String queryUri, Callback callback) {
        this.queryUri = queryUri;
        this.callback = callback;
        this.api = new GiphyApi();
    }

    @Override
    protected List<Gif> doInBackground(Void... arg0) {
        return api.queryApi(queryUri);
    }

    @Override
    protected void onPostExecute(List<Gif> result) {
        callback.onResponse(result);
    }
}