import okhttp3.*;

import java.io.IOException;

public class Okhttp {

    final static String url = "https://api.coinmarketcap.com/v2/ticker/";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("bookName","name")
                .build();
        final Request request = new Request.Builder().url(url)
                .get().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {

            }

            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String responseBody = response.body().string();
                    System.out.println(responseBody);
                }
            }
        });
    }
}
