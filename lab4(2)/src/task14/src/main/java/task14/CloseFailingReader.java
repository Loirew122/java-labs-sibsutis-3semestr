package task14;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

class CloseFailingReader extends Reader{
    private final StringReader delegate;
    private boolean closed;
    CloseFailingReader(String content) {
        delegate = new StringReader(content);
    }
    @Override
    public int read(char[] buffer, int offset, 
    int length) throws IOException{
        return delegate.read(buffer, offset, length);
    }
    @Override 
    public void close() throws IOException{
        closed = true;
        delegate.close();
        throw new IOException("Reader close failed");
    }
    boolean closed(){ return closed;}
    
}