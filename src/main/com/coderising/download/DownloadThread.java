package com.coderising.download;

import com.coderising.download.api.Connection;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CyclicBarrier;

public class DownloadThread extends Thread {

    private Connection conn;
    private int startPos;
    private int endPos;
    private CyclicBarrier barrier;
    private String localFile;

    public DownloadThread(Connection conn, int startPos, int endPos, String localFile, CyclicBarrier barrier) {
        this.conn = conn;
        this.startPos = startPos;
        this.endPos = endPos;
        this.localFile = localFile;
        this.barrier = barrier;
    }

    public void run() {
        RandomAccessFile file = null;
        try {
            System.out.println("Begin to read [" + startPos + "-" + endPos + "]");
            byte[] data = conn.read(startPos, endPos);
            file = new RandomAccessFile(localFile, "rw");
            file.seek(startPos);
            file.write(data);
            // 等待别的线程完成
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO 通知主线程重试
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
