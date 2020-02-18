package com.example.simplerequestbio.ws;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.simplerequestbio.MainActivity;
import com.example.simplerequestbio.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestServerAsyncTask extends AsyncTask<String, Void, String> {
    TextView txt_response;
    AlertDialog alertDialog;
    Context context;
    public RequestServerAsyncTask(Context context, TextView textView){
        this.context = context;
        this.txt_response = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... adress) {
        HttpURLConnection httpURLConnection=null;
        BufferedReader reader = null;
        try {
            URL url = new URL(adress[0]);
            Log.d("URL",""+url);
            httpURLConnection =(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            Log.d("METHOD",httpURLConnection.getRequestMethod());
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            Log.d("RESPONSE CODE",""+httpURLConnection.getResponseCode());
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            StringBuffer buffer = new StringBuffer();

            while ( (line = reader.readLine()) != null)
            {
                buffer.append(line);
                buffer.append("\n");
            }
            return  buffer.toString();

        }catch (Exception e){
            e.printStackTrace();
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
            if(reader != null){
                try {
                    reader.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute( response);
        AlertDialog.Builder goLogin = new AlertDialog.Builder(context);
        goLogin.setMessage("Response\n"+response);
        goLogin.setCancelable(false);
        goLogin.setPositiveButton("FECHAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alertLogin = goLogin.create();
        alertLogin.show();
    }
}
