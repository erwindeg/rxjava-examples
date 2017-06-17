package nl.edegier.rxjava.filereader;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * Created by Erwin on 17/02/16.
 */
public class AsyncFileReader {

    private final String filePath;

    public AsyncFileReader(String filePath){
        this.filePath = filePath;
    }

    public void invoke(Consumer<String> consumer) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get(filePath);
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        channel.read(buffer, 0, buffer,
                new CompletionHandler<Integer, ByteBuffer>() {
                    public void completed(Integer result, ByteBuffer attachment) {
                        char c = 0;
                        byte b = (byte) c;

                        StringBuffer sb = new StringBuffer();

                        for (int i = 0; i < attachment.limit(); i++) {
                            char current = (char) attachment.get(i);

                            if(current == '\u0000'){
                                break;
                            }
                            sb.append(current);
                        }
                        consumer.accept(sb.toString());
                    }

                    public void failed(Throwable exception, ByteBuffer attachment) {
                        System.out.println(exception.getMessage());
                    }
                });
    }


}
