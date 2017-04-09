package coderising.download;

import com.coderising.download.api.Connection;
import com.coderising.download.api.ConnectionManager;
import com.coderising.download.impl.ConnectionManagerImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConnectionTest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testContentLength() throws Exception {
        ConnectionManager connectionManager = new ConnectionManagerImpl();
        Connection conn = connectionManager.open("http://www.hinews.cn/pic/0/13/91/26/13912621_821796.jpg");
        Assert.assertEquals(35470, conn.getContentLength());
    }

    @Test
    public void testRead() throws Exception {
        ConnectionManager connectionManager = new ConnectionManagerImpl();
        Connection conn = connectionManager.open("http://www.hinews.cn/pic/0/13/91/26/13912621_821796.jpg");

        byte[] data = conn.read(0, 35469);
        Assert.assertEquals(35470, data.length);

        data = conn.read(0, 1023);
        Assert.assertEquals(1024, data.length);

        data = conn.read(1024, 2023);
        Assert.assertEquals(1000, data.length);

    }

}
