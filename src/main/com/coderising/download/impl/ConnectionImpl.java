package com.coderising.download.impl;

import com.coderising.download.api.Connection;
import com.coderising.download.api.ConnectionException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class ConnectionImpl implements Connection {

    private static final int BUFFER_SIZE = 1024;
    private URL url;

    public ConnectionImpl(String _url) throws ConnectionException {
        try {
            url = new URL(_url);
        } catch (MalformedURLException e) {
            throw new ConnectionException(e);
        }
    }

    @Override
    public byte[] read(int startPos, int endPos) throws IOException {
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestProperty("Range", "bytes=" + startPos + "-" + endPos);
        InputStream is = httpConnection.getInputStream();

        byte[] buff = new byte[BUFFER_SIZE];
        int totalLen = endPos - startPos + 1;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (baos.size() < totalLen) {
            int len = is.read(buff);
            if (len < 0) {
                break;
            }
            baos.write(buff, 0, len);
        }
        if (baos.size() > totalLen) {
            byte[] data = baos.toByteArray();
            return Arrays.copyOf(data, totalLen);
        }
        return baos.toByteArray();
    }

    @Override
    public int getContentLength() {
        URLConnection con;
        try {
            con = url.openConnection();
            return con.getContentLength();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void close() {

    }

}
