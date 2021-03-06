package coderising.download;

import com.coderising.download.FileDownloader;
import com.coderising.download.api.DownloadListener;
import com.coderising.download.impl.ConnectionManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileDownloaderTest {

    private boolean downloadFinished = false;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testDownload() {
        String url = "http://images2015.cnblogs.com/blog/610238/201604/610238-20160421154632101-286208268.png";
        FileDownloader downloader = new FileDownloader(url, "G:\\test.jpg");
        downloader.setConnectionManager(new ConnectionManagerImpl());
        downloader.setListener(new DownloadListener() {
            @Override
            public void notifyFinished() {
                downloadFinished = true;
            }
        });
        downloader.execute();

        // 等待多线程下载程序执行完毕
        while (!downloadFinished) {
            try {
                System.out.println("还没有下载完成，休眠五秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("下载完成！");
    }

}
