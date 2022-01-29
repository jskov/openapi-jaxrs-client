package mada.fixture;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Copies bytes from one stream to another as a thread.
 */
class ByteDumper implements Runnable {
    private final InputStream in;
    private final OutputStream out;

    ByteDumper(InputStream in, OutputStream out) {
        this.in = new BufferedInputStream(in);
        this.out = out;
    }

    @Override
    public void run() {
        byte[] buf = new byte[8192];
        try {
            int next;
            while ((next = in.read(buf)) != -1) {
                out.write(buf, 0, next);
            }
        } catch (IOException e) {
            throw new IllegalStateException("exception while dumping process stream", e);
        }
    }
}
