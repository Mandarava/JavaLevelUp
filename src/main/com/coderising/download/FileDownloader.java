package com.coderising.download;

import com.coderising.download.api.Connection;
import com.coderising.download.api.ConnectionManager;
import com.coderising.download.api.DownloadListener;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CyclicBarrier;


public class FileDownloader {

    private static final int DOWNLOAD_TRHEAD_NUM = 5;
    private String url;
    private String localFile;
    private DownloadListener listener;
    private ConnectionManager cm;

    public FileDownloader(String _url, String localFile) {
        this.url = _url;
        this.localFile = localFile;
    }

    public void execute() {

        CyclicBarrier barrier = new CyclicBarrier(DOWNLOAD_TRHEAD_NUM, new Runnable() {
            public void run() {
                listener.notifyFinished();
            }
        });

        Connection conn = null;
        try {
            conn = cm.open(this.url);
            int length = conn.getContentLength();
            this.createPlaceHolderFile(this.localFile, length);
            int[][] ranges = allocateDownloadRange(DOWNLOAD_TRHEAD_NUM, length);
            for (int i = 0; i < DOWNLOAD_TRHEAD_NUM; i++) {
                DownloadThread thread = new DownloadThread(
                        cm.open(url), ranges[i][0], ranges[i][1], localFile, barrier);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    private void createPlaceHolderFile(String fileName, int contentLen) throws IOException {
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        for (int i = 0; i < contentLen; i++) {
            file.write(0);
        }
        file.close();
    }

    private int[][] allocateDownloadRange(int threadNum, int contentLen) {
        int[][] ranges = new int[threadNum][2];
        // 每个线程需要下载的文件大小
        int eachThreadSize = contentLen / threadNum;
        // 剩下的归最后一个线程来处理
        int left = contentLen % threadNum;
        for (int i = 0; i < threadNum; i++) {
            int startPos = i * eachThreadSize;
            int endPos = (i + 1) * eachThreadSize - 1;
            if ((i == (threadNum - 1))) {
                endPos += left;
            }
            ranges[i][0] = startPos;
            ranges[i][1] = endPos;
        }
        return ranges;
    }

    public void setConnectionManager(ConnectionManager ucm) {
        this.cm = ucm;
    }

    public DownloadListener getListener() {
        return this.listener;
    }

    public void setListener(DownloadListener listener) {
        this.listener = listener;
    }

}
