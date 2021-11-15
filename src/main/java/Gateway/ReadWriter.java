package Gateway;

import java.io.IOException;
import java.util.List;

public interface ReadWriter {

        <T> void updateInfo(List<T> serList, String fileName) throws IOException;


//        void readFromFile(String filepath) throws IOException, ClassNotFoundException;
}
